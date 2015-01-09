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

        /*_httpHandler = new HttpHandler(this);

        Button b = (Button)findViewById(R.id.b_cam);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {
                _httpHandler.startCamera();
            }
        });*/

        /*WebView vidView = (WebView)findViewById(R.id.myVideo);
        vidView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        vidView.loadUrl("http://192.168.43.157:8081");*/

        _httpHandler = new HttpHandler(this);
        _httpHandler.startCamera();
    }

}
