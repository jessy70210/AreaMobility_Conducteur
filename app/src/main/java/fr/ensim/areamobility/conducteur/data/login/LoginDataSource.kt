package fr.ensim.areamobility.conducteur.data.login


import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.Log.d
import com.google.gson.Gson
import fr.ensim.areamobility.conducteur.data.login.model.DataSearchUser
import fr.ensim.areamobility.conducteur.data.login.model.LoggedInUser
import fr.ensim.areamobility.conducteur.service.UserService
import fr.ensim.areamobility.conducteur.tools.Hash
import okhttp3.*
import java.io.*
import java.net.URLEncoder


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    companion object {
        private const val TAG = "LoginDataSource"
        fun searchUser(username: String, password: String, callback: CallSearchUser) {
            d(TAG, ">>searchUser $username")

            val surl = "https://machine.jessy-lebrun.fr/AreaMobility/user/"+URLEncoder.encode(username)+"/"+
                    URLEncoder.encode(password)+"/user.json"
            d(TAG, "surl $surl")

            val request: Request = Request.Builder().url(surl).build()
            val client = OkHttpClient()

            client.newCall(request).enqueue(callback)

            d(TAG, "<<searchUser")
        }
    }

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
//            searchUser(username, password, object : CallSearchUser() {
//                override fun fireOnResponseOk(data: DataSearchUser) {
//                    if (data.id == null) {
//                        d(TAG, "if data.id")
//                    }else{
//                        d(TAG, "else data.id")
//                    }
//                }
//
//            })
//            var json : String? = assets.open(fileName).bufferedReader().use { it.readText() }

            for (user in UserService.Users) {
                if (user.email == username && user.password == Hash.md5(password)){
                    return Result.Success(LoggedInUser(java.util.UUID.randomUUID().toString() ,user))
                }
            }
            return Result.Error(Exception("Identification failure"))
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

abstract class CallSearchUser: Callback {

    companion object {
        private const val TAG = "CallSearchUser"
    }

    abstract fun fireOnResponseOk(data: DataSearchUser)

    override fun onFailure(call : Call, e: IOException) {
        Log.d(TAG, ">>onFailure", e)
    }

    override  fun onResponse(call: Call, response: Response) {
        Log.d(TAG, ">>onResponse")

        val responseData = response.body!!.string()
//        Log.d(TAG, "onResponse: $responseData")


        val data: DataSearchUser = Gson().fromJson(responseData, DataSearchUser::class.java)

        runOnUiThread(Runnable { fireOnResponseOk(data) })
    }

    private fun runOnUiThread(task: Runnable) {
        Handler(Looper.getMainLooper()).post(task)
    }
}