package com.example.achilles.myapplication;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Achilles on 12/7/2016.
 */
public class Viewwebclient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
