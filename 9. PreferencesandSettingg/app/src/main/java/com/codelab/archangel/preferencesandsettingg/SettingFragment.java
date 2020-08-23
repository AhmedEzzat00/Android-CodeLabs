package com.codelab.archangel.preferencesandsettingg;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;


public class SettingFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

}