package com.example.thibaut.domoid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.thibaut.adapter.IngredientsAdapter;
import com.example.thibaut.library.HttpHandler;
import com.example.thibaut.objects.Ingredient;

import java.util.ArrayList;

/**
 * Created by thibaut on 06/01/2015.
 */
public class ActivityKitchen extends FragmentActivity {


    private HttpHandler _httpHandler;
    private ArrayList<Ingredient> _lIngredients;
    private ListView _lv;
    private IngredientsAdapter _ia;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);


        _httpHandler = new HttpHandler(this);

        _lIngredients = new ArrayList<Ingredient>();
        _lv = (ListView)findViewById(R.id.list_ingredients);


        _ia = new IngredientsAdapter(this, _lIngredients);
        _lv.setAdapter(_ia);

        _lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }

        });

        ObtenirIngredients oi = new ObtenirIngredients();
        oi.execute();

    }

    private class ObtenirIngredients extends AsyncTask<Void, Void, ArrayList<Ingredient>> {

        protected ArrayList<Ingredient> doInBackground(Void... args) {
            Log.d("JSON 2", _httpHandler.getListIngredients().toString());
            return _httpHandler.getListIngredients();
        }

        protected void onPostExecute(ArrayList<Ingredient> list) {

            _ia.swapItems(list);
        }
    }

}

