package com.example.thibaut.domoid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity {

    private GridView _grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton bKitchen = (ImageButton)findViewById(R.id.b_kitchen);
        bKitchen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {

                Intent i = new Intent(b.getContext(), ActivityKitchen.class);
                startActivity(i);
            }
        });

        ImageButton bLivingroom = (ImageButton)findViewById(R.id.b_livingroom);
        bLivingroom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {

                Intent i = new Intent(b.getContext(), ActivitySalon.class);
                startActivity(i);
            }
        });

<<<<<<< HEAD
        Button bEntrance = (Button)findViewById(R.id.b_entrance);
        bEntrance.setOnClickListener(new View.OnClickListener() {
=======
        ImageButton bParking=(ImageButton)findViewById(R.id.b_parking);
        bParking.setOnClickListener(new View.OnClickListener() {
>>>>>>> bc38f0d29ab72a469ad62c24c8449369cfbc8726

            @Override
            public void onClick(View b) {

<<<<<<< HEAD
                Intent i = new Intent(b.getContext(), ActivityEntrance.class);
                startActivity(i);
=======
                Intent parking = new Intent(b.getContext(), ActivitySalon.class);
                startActivity(parking);
>>>>>>> bc38f0d29ab72a469ad62c24c8449369cfbc8726
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

}
