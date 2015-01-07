package com.example.thibaut.domoid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        Button b = (Button)findViewById(R.id.b_cam);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {
                _httpHandler.startCamera();
            }
        });

    }

}
