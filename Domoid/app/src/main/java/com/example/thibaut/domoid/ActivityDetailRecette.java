package com.example.thibaut.domoid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.thibaut.objects.Recette;

/**
 * Created by thibaut on 08/01/2015.
 */
public class ActivityDetailRecette extends Activity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_recette);

        Intent i = getIntent();
        Recette current = (Recette) i.getParcelableExtra("current");

        TextView nom = (TextView)findViewById(R.id.nom);
        TextView duree = (TextView)findViewById(R.id.duree);
        TextView description = (TextView)findViewById(R.id.description);

        nom.setText(current.getNom());
        duree.setText(current.getDuree());
        description.setText(current.getDescription());

    }
}
