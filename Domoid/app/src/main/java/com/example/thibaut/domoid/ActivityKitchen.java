package com.example.thibaut.domoid;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.thibaut.adapter.IngredientsAdapter;
import com.example.thibaut.adapter.RecetteAdapter;
import com.example.thibaut.library.HttpHandler;
import com.example.thibaut.objects.Ingredient;
import com.example.thibaut.objects.Recette;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by thibaut on 06/01/2015.
 */
public class ActivityKitchen extends ActionBarActivity {


    private HttpHandler _httpHandler;
    private ArrayList<Ingredient> _lIngredients;
    private ArrayList<Recette> _lRecettes;

    private ListView _lvi;
    private ListView _lvr;

    private int _count;

    private IngredientsAdapter _ia;
    private RecetteAdapter _ra;


    protected int _orientation;

    private HashMap<Integer, String> _selectionnes;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        _httpHandler = new HttpHandler(this);



        if(savedInstanceState != null) {
            _lIngredients = savedInstanceState.getParcelableArrayList("ingredients");
            _count = savedInstanceState.getInt("count");
            Serializable hashmap = savedInstanceState.getSerializable("hashmap");
            _selectionnes = (HashMap<Integer, String>)hashmap;
        } else {
            _count = 0;
            _lIngredients = new ArrayList<Ingredient>();
            _selectionnes = new HashMap<Integer, String>();
        }

        _lvi = (ListView)findViewById(R.id.list_ingredients);

        _lRecettes = new ArrayList<Recette>();
        _ia = new IngredientsAdapter(this, _lIngredients);
        _lvi.setAdapter(_ia);

        _lvr = (ListView)findViewById(R.id.list_recipe);
        _ra = new RecetteAdapter(this, _lRecettes);
        _lvr.setAdapter(_ra);

        ObtenirIngredients oi = new ObtenirIngredients();
        oi.execute();


        _orientation = getResources().getConfiguration().orientation;

        /** mode portrait **/
        if(_orientation == 1) {
            _lvi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Ingredient i = _lIngredients.get(position);
                    if (_selectionnes.containsKey(i.getId())) {
                        _selectionnes.remove(i.getId());
                        _count --;
                    } else {
                        _selectionnes.put(i.getId(), i.getNom());
                        _count ++;
                    }
                }
            });

            final RelativeLayout layoutIngredients = (RelativeLayout) findViewById(R.id.layout_ingredient);
            final RelativeLayout layoutRecettes = (RelativeLayout) findViewById(R.id.layout_recettes);
            Button valid = (Button) findViewById(R.id.valid);
            valid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutIngredients.setVisibility(View.INVISIBLE);
                    layoutRecettes.setVisibility(View.VISIBLE);

                    if(_count != 0) {
                        ObtenirRecettes or = new ObtenirRecettes();
                        or.execute();
                    } else {
                        _ra.swapItems(new ArrayList<Recette>());
                    }
                }
            });

        /** mode paysage **/
        } else if(_orientation == 2) {

            Log.d("COUNT", ""+_count);

            if(_count != 0) {
                ObtenirRecettes or = new ObtenirRecettes();
                or.execute();
            } else {
                _ra.swapItems(new ArrayList<Recette>());
            }

            _lvi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Ingredient i = _lIngredients.get(position);
                    if (_selectionnes.containsKey(i.getId())) {
                        _selectionnes.remove(i.getId());
                        _count --;
                    } else {
                        _selectionnes.put(i.getId(), i.getNom());
                        _count ++;
                    }

                    if(_count != 0) {
                        ObtenirRecettes or = new ObtenirRecettes();
                        or.execute();
                    } else {
                        _ra.swapItems(new ArrayList<Recette>());
                    }

                }
            });
        }

        _lvr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Recette r = _lRecettes.get(position);
                Intent i = new Intent(getApplicationContext(), ActivityDetailRecette.class);
                i.putExtra("current", r);
                startActivity(i);

            }
        });


    }

    private class ObtenirIngredients extends AsyncTask<Void, Void, ArrayList<Ingredient>> {

        protected ArrayList<Ingredient> doInBackground(Void... args) {
            return _httpHandler.getListIngredients();
        }

        protected void onPostExecute(ArrayList<Ingredient> list) {
            _ia.swapItems(list);
        }
    }

    private class ObtenirRecettes extends AsyncTask<Void, Void, ArrayList<Recette>> {

        protected ArrayList<Recette> doInBackground(Void... args) {
            ArrayList<String> _idIngredients = new ArrayList<String>();
            _idIngredients.addAll(_selectionnes.values());

            ArrayList<Integer> id = new ArrayList<Integer>();
            Iterator iterator = _selectionnes.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                Integer key = (Integer) entry.getKey();
                id.add(key);
            }
            //_httpHandler.updateScreen(id);

            return _httpHandler.getListRecettes(_idIngredients);
        }

        protected void onPostExecute(ArrayList<Recette> list) {
            _ra.swapItems(list);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("count", _count);
        outState.putSerializable("hashmap", _selectionnes);
        outState.putParcelableArrayList("ingredients", _lIngredients);
        super.onSaveInstanceState(outState);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_kitchen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                ObtenirIngredients oi = new ObtenirIngredients();
                oi.execute();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

