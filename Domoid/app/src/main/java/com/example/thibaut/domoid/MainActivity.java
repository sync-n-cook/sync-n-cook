package com.example.thibaut.domoid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;


public class MainActivity extends ActionBarActivity {

    private GridView _grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button bKitchen = (Button)findViewById(R.id.b_kitchen);
        bKitchen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {

                Intent i = new Intent(b.getContext(), ActivityKitchen.class);
                startActivity(i);
            }
        });

    }
}
