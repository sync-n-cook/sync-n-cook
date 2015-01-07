package com.example.thibaut.domoid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.thibaut.adapter.IngredientsAdapter;
import com.example.thibaut.library.HttpHandler;
import com.example.thibaut.objects.Ingredient;

import java.util.ArrayList;

/**
 * Created by thibaut on 06/01/2015.
 */
public class IngredientFragment extends Fragment {

    private HttpHandler _httpHandler;
    private ArrayList<Ingredient> _lIngredients;
    private ListView _lv;
    private IngredientsAdapter _ia;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        _httpHandler = new HttpHandler(getActivity());

        _lIngredients = new ArrayList<Ingredient>();
        _lv = (ListView)view.findViewById(R.id.list_ingredients);

        _ia = new IngredientsAdapter(getActivity(), _lIngredients);
        _lv.setAdapter(_ia);

        _lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }

        });

        ObtenirIngredients oi = new ObtenirIngredients();
        oi.execute();


        return view;
    }

    private class ObtenirIngredients extends AsyncTask<Void, Void, ArrayList<Ingredient>> {

        protected ArrayList<Ingredient> doInBackground(Void... args) {
            return _httpHandler.getListIngredients();
        }

        protected void onPostExecute(ArrayList<Ingredient> list) {

            _ia.swapItems(list);
        }
    }
}
