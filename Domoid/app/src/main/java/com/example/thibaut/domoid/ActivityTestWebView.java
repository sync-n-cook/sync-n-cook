package com.example.thibaut.domoid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class ActivityTestWebView extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_test_web_view);
        WebView wvSite = (WebView)findViewById(R.id.webview);

        //...on active JavaScript...
        WebSettings webSettings = wvSite.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //...et on charge la page
        wvSite.loadUrl("https://www.youtube.com/watch?v=IoRstHMSesw");
    }

}
