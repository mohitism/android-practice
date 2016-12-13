package com.example.achilles.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Achilles on 11/16/2016.
 */

public class Camera extends Activity implements View.OnClickListener {

    Button setwall;
    ImageView getpic;
    ImageButton ibtakepic;
    final static int cameracode = 0;
    Intent cameraIntent;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cam);
        initializevars();
        InputStream is = getResources().openRawResource(R.drawable.splashbg);
        bmp = BitmapFactory.decodeStream(is);
        ibtakepic.setOnClickListener(this);
        setwall.setOnClickListener(this);

    }

    private void initializevars() {
        setwall = (Button) findViewById(R.id.setwall);
        getpic = (ImageView) findViewById(R.id.ivgetpic);
        ibtakepic = (ImageButton) findViewById(R.id.ibtakepic);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.ibtakepic :
                cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,cameracode);
                break;
            case R.id.setwall :
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            getpic.setImageBitmap(bmp);
        }

    }
}
