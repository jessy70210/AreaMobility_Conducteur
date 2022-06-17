package fr.ensim.areamobility.conducteur.data.login

import fr.ensim.areamobility.conducteur.data.login.model.LoggedInUser
import java.io.IOException
import java.io.InputStream


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.lang.Exception
import java.sql.Types.NULL
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.gson.Gson
import fr.ensim.areamobility.conducteur.data.login.model.DataSearchUser
import okhttp3.*
import java.net.URLEncoder
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.FileChannel.open

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

            var user: LoggedInUser;
            if (username == "daniele.durpoix@gmail.com" && password == "ensim1995") {
                user = LoggedInUser(java.util.UUID.randomUUID().toString(), "Daniele Durpoix")
            }else return Result.Error(Exception("Identification failure"))

            return Result.Success(user)
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