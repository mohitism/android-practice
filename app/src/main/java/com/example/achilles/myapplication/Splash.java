package com.example.achilles.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by Achilles on 11/13/2016.
 */

public class Splash extends Activity{

    MediaPlayer oursong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);
        oursong = MediaPlayer.create(this,R.raw.moore);
        SharedPreferences getprefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean music = getprefs.getBoolean("checkbox",true);
        if(music)
        oursong.start();

        
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openMainAvtivity = new Intent("com.example.achilles.myapplication.MENU");
                    startActivity(openMainAvtivity);
                }
            }
        };

        timer.start();
    };

    @Override
    protected void onPause() {
        super.onPause();
        oursong.release();
        finish();
    }
}
