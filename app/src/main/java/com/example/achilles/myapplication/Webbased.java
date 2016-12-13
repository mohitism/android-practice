package com.example.achilles.myapplication;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Achilles on 12/6/2016.
 */

public class Webbased extends Activity implements View.OnClickListener{
    WebView webs;
    Button go,back,forward,refresh,clear;
    EditText et;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        int width = getWindowManager().getDefaultDisplay().getWidth();
        et = (EditText) findViewById(R.id.ettop);
        go = (Button) findViewById(R.id.bgo);
        back = (Button) findViewById(R.id.bback);
        forward = (Button) findViewById(R.id.bforward);
        refresh = (Button) findViewById(R.id.brefresh);
        clear = (Button) findViewById(R.id.bclear);
        et.setWidth(width-100);
        webs = (WebView) findViewById(R.id.webview);
        webs.getSettings().setJavaScriptEnabled(true);
        webs.getSettings().setDatabaseEnabled(true);
        webs.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webs.getSettings().setLoadsImagesAutomatically(true);
        webs.getSettings().setLoadWithOverviewMode(true);
        webs.getSettings().setUseWideViewPort(true);
        webs.setWebViewClient(new Viewwebclient());
        webs.loadUrl("https://www.tutorialspoint.com/");
        go.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.bgo :
                String str = et.getText().toString();
                webs.loadUrl(str);
                InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(et.getWindowToken(),0);
                break;
            case R.id.bback :
                if(webs.canGoBack())
                    webs.goBack();
                break;
            case R.id.bforward :
                if(webs.canGoForward())
                    webs.goForward();
                break;
            case R.id.brefresh :
                webs.reload();
                break;
            case R.id.bclear :
                webs.clearHistory();

                break;
        }
    }
}
