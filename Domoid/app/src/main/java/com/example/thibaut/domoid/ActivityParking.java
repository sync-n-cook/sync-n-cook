package com.example.thibaut.domoid;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.thibaut.library.HttpHandler;


public class ActivityParking extends ActionBarActivity {

    private HttpHandler _httpHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);

        _httpHandler = new HttpHandler(this);

        PorteGarage pg = new PorteGarage();
        pg.execute(true);
        /*ImageButton doorUp = (ImageButton)findViewById(R.id.parking_door_up);
        ImageButton doorDown = (ImageButton)findViewById(R.id.parking_door_down);

        doorUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {
                PorteGarage pg = new PorteGarage();
                pg.execute(true);
            }
        });

        doorDown.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {
                PorteGarage pg= new PorteGarage();
                pg.execute(false);
            }
        });*/

    }


    private class PorteGarage extends AsyncTask<Boolean, Void, Void> {

        @Override
        protected Void doInBackground(Boolean... state) {
            _httpHandler.handleShutters(state[0]);
            return null;
        }

    }
}
