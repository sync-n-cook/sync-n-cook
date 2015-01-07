package com.example.thibaut.domoid;

import android.app.Activity;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.thibaut.library.HttpHandler;

/**
 * Created by thibaut on 06/01/2015.
 */
public class ActivitySalon extends Activity {

    private HttpHandler _httpHandler;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);

        _httpHandler = new HttpHandler(this);


        ImageButton up = (ImageButton)findViewById(R.id.volet_up);
        ImageButton down = (ImageButton)findViewById(R.id.volet_down);

        up.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {
                CommandeVolet cv = new CommandeVolet();
                cv.execute(true);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {
                CommandeVolet cv = new CommandeVolet();
                cv.execute(false);
            }
        });

    }


    private class CommandeVolet extends AsyncTask<Boolean, Void, Void> {

        @Override
        protected Void doInBackground(Boolean... state) {
            _httpHandler.handleShutters(state[0]);
            return null;
        }

    }
}
