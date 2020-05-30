package io.github.mkeeda.androiduiplayground.ui.main

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import io.github.mkeeda.androiduiplayground.R

class MainFragment : PreferenceFragmentCompat() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_playground, rootKey)
    }
}
