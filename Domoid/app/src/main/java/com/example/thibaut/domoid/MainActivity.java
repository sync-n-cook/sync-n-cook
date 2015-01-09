package com.example.thibaut.domoid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.io.*;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private GridView _grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Rajout des boutons pour les pièces
        //on teste la présence de nouvelles pièces dans notre fichier
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

        ImageButton bParking=(ImageButton)findViewById(R.id.b_parking);
        bParking.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {

                Intent parking = new Intent(b.getContext(), ActivityParking.class);
                startActivity(parking);
            }
        });

        Button bAddPieces=(Button)findViewById(R.id.b_add_pieces);

        bAddPieces.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {

                Intent pieces = new Intent(b.getContext(), ActivityAdd_pieces.class);
                startActivity(pieces);
                /*LinearLayout l=(LinearLayout)findViewById(R.id.layout_global);
                float ws=l.getWeightSum();*/
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
