package com.example.thibaut.domoid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by thibaut on 06/01/2015.
 */
public class ActivityKitchen extends FragmentActivity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        if (findViewById(R.id.frame_kitchen) != null) {
            final IngredientFragment ingredients = new IngredientFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_kitchen, ingredients).commit();
        }

    }
}

