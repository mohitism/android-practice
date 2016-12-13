package com.example.achilles.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Achilles on 12/10/2016.
 */

public class Music extends Activity implements View.OnClickListener {

    Button btnmusic;
    private MediaPlayer mPlayer;
    // Progress Dialog Object
    private ProgressDialog prgDialog;
    // Progress Dialog type (0 - for Horizontal progress bar)
    public static final int progress_bar_type = 0;
    public static String file_url = "http://programmerguru.com/android-tutorial/wp-content/uploads/2014/01/jai_ho.mp3"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        btnmusic = (Button) findViewById(R.id.bdownload);
        btnmusic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        btnmusic.setEnabled(false);
        File file = new File(Environment.getExternalStorageDirectory().getPath()+'/jaiho.mp3');

        if(file.exists())
        {
            Toast.makeText(getApplicationContext(),"File Already Exists",Toast.LENGTH_SHORT);
            playmusic();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Downloading mp3 fro internet",Toast.LENGTH_SHORT);

            new Downloadfrominternet().execute(file_url);
        }
    }

    private void playmusic() {
    }

    private class Downloadfrominternet extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Shows Progress Bar Dialog and then call doInBackground method
            showDialog(progress_bar_type);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                URLConnection connect = url.openConnection();
                int count=0;
                int lenghtOfFile = connect.getContentLength();
                // input stream to read file - with 8k buffer
                InputStream input = new BufferedInputStream(url.openStream(),10*1024);
                // Output stream to write file in SD card
                OutputStream output = new FileOutputStream(Environment.getExternalStorageDirectory().getPath()+"/jai_ho.mp3");
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    // Publish the progress which triggers onProgressUpdate method
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    // Write data to file
                    output.write(data, 0, count);
                }
                // Flush output
                output.flush();
                // Close streams
                output.close();
                input.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
