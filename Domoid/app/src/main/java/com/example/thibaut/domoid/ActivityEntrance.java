package com.example.thibaut.domoid;

import android.app.Activity;
import android.os.Bundle;

import com.example.thibaut.library.HttpHandler;

/**
 * Created by thibaut on 07/01/2015.
 */
public class ActivityEntrance extends Activity {

    public HttpHandler _httpHandler;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        _httpHandler = new HttpHandler(this);
        _httpHandler.startCamera();
    }

}
