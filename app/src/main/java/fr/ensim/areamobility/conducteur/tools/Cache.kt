package fr.ensim.areamobility.conducteur.tools

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener

import android.preference.PreferenceManager
import androidx.loader.content.AsyncTaskLoader

internal class Cache(context: Context?) :
    AsyncTaskLoader<SharedPreferences?>(context!!), OnSharedPreferenceChangeListener {
    private var prefs: SharedPreferences? = null

    companion object {
        fun persist(editor: SharedPreferences.Editor) {
            editor.apply()
        }
    }

    // Charge les données de façon asynchrone
    override fun loadInBackground(): SharedPreferences? {
        prefs = PreferenceManager.getDefaultSharedPreferences(getContext())
        prefs!!.registerOnSharedPreferenceChangeListener(this)
        return prefs
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        // notifier le chargeur que le contenu a changé
        onContentChanged()
    }

    /**
     * lance le chargement des données
     * une fois que le résultat est prêt, la méthode onLoadFinished est appelée.
     * dans le fil principal. Si le chargeur a été lancé plus tôt, le résultat
     * est renvoyé directement
     *
     * doit être appelée depuis le fil principal.
     */
    override fun onStartLoading() {
        if (prefs != null) {
            deliverResult(prefs)
        }
        if (takeContentChanged() || prefs == null) {
            forceLoad()
        }
    }
}