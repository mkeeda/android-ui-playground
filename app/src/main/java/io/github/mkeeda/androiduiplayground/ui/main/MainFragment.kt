package io.github.mkeeda.androiduiplayground.ui.main

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import io.github.mkeeda.androiduiplayground.R

class MainFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_playground, rootKey)

        findPreference<Preference>("imagePreview")?.setOnPreferenceClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_imagePreviewFragment)
            true
        }

        findPreference<Preference>("youtubePlayerAnimation")?.setOnPreferenceClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_youtubeFragment)
            true
        }
    }
}
