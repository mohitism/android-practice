package com.example.achilles.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

/**
 * Created by Achilles on 11/26/2016.
 */

public class GFX extends Activity {


    Mybringback ourview;
    PowerManager.WakeLock wl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PowerManager pM = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pM.newWakeLock(PowerManager.FULL_WAKE_LOCK,"whatever");
        wl.acquire();
        ourview = new Mybringback(this);
        setContentView(ourview);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wl.release();
    }
}
