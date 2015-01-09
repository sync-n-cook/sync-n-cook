package com.example.thibaut.domoid;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thibaut.library.HttpHandler;
import com.example.thibaut.objects.Recette;

/**
 * Created by thibaut on 08/01/2015.
 */
public class ActivityDetailRecette extends Activity {

    private HttpHandler _httpHandler;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_recette);

        Intent i = getIntent();
        Recette current = (Recette) i.getParcelableExtra("current");

        _httpHandler = new HttpHandler(this);

        TextView nom = (TextView)findViewById(R.id.nom);
        TextView duree = (TextView)findViewById(R.id.duree);
        TextView description = (TextView)findViewById(R.id.description);

        nom.setText(current.getNom());
        duree.setText(current.getDuree());
        description.setText(current.getDescription());

        Button b = (Button)findViewById(R.id.launch_recette);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {
                //VideoKitchen vk = new VideoKitchen();
                //vk.execute();
            }

        });

    }


    private class VideoKitchen extends AsyncTask<Void, Void, Void> {

        protected Void doInBackground(Void... args) {
            _httpHandler.startVideoKitchen();
            return null;
        }
    }

}
