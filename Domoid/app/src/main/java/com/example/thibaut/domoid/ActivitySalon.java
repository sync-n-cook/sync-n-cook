package com.example.thibaut.domoid;

import android.app.Activity;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.thibaut.library.HttpHandler;

/**
 * Created by thibaut on 06/01/2015.
 */
public class ActivitySalon extends Activity {

    private HttpHandler _httpHandler;
    final String uri_up = "http://192.168.43.249:8080/api?api_number=1";
    final String uri_down = "http://192.168.43.249:8080/api?api_number=2";

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);

        _httpHandler = new HttpHandler();


        ImageButton up = (ImageButton)findViewById(R.id.volet_up);
        ImageButton down = (ImageButton)findViewById(R.id.volet_down);

        up.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {
                CommandeVolet cv = new CommandeVolet();
                cv.execute(uri_up);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {
                CommandeVolet cv = new CommandeVolet();
                cv.execute(uri_down);
            }
        });

    }


    private class CommandeVolet extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... uri) {
            Log.d("TEST", uri[0]);
            _httpHandler.sendHttpRequest(uri[0]);
            return null;
        }

    }
}
