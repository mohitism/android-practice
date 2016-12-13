package com.example.achilles.myapplication;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Achilles on 11/20/2016.
 */

public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
