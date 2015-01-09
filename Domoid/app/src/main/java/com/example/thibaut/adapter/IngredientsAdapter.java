package com.example.thibaut.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thibaut.domoid.R;
import com.example.thibaut.objects.Ingredient;

import java.util.ArrayList;

/**
 * Created by thibaut on 06/01/2015.
 */
public class IngredientsAdapter extends BaseAdapter {

    private Context _context;
    private ArrayList<Ingredient> _lIngredients;

    public IngredientsAdapter(Context context, ArrayList<Ingredient> lIngredients) {
        _context = context;
        _lIngredients = lIngredients;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

    	/* if the view is null, it means that this view has not been used for the moment, we have to create a new view */
        if (convertView == null) {
            gridView = new View(_context);

    		/* two differents layouts for odd and even rows */
            if (position % 2 == 0) {
                gridView = inflater.inflate(R.layout.ingredient_odd, null);
            } else {
                gridView = inflater.inflate(R.layout.ingredient_even, null);
            }
    	/* else, we have to recycle this view to avoid memory loss */
        } else {
            gridView = (View) convertView;
            if (position % 2 == 0) {
                gridView = inflater.inflate(R.layout.ingredient_odd, null);
            } else {
                gridView = inflater.inflate(R.layout.ingredient_even, null);
            }
        }

        TextView name = (TextView)gridView.findViewById(R.id.nom);
        TextView quantity = (TextView)gridView.findViewById(R.id.quantite);
        ImageView icon = (ImageView) gridView.findViewById(R.id.icon);
        TextView dateper = (TextView)gridView.findViewById(R.id.dateper);

        Ingredient i = _lIngredients.get(position);
        name.setText(i.getNom());
        quantity.setText("Quantité : "+i.getQuantite());
        dateper.setText("Date limite : "+i.getDate());

        Drawable d;

        switch (i.getCat()) {
            case 1:
                d = _context.getResources().getDrawable(R.drawable.logo_lait);
                break;
            case 2:
                d = _context.getResources().getDrawable(R.drawable.logo_viande);
                break;
            case 3:
                d = _context.getResources().getDrawable(R.drawable.logo_legumes);
                break;
            case 4:
                d = _context.getResources().getDrawable(R.drawable.logo_boisson);
                break;
            case 5:
                d = _context.getResources().getDrawable(R.drawable.logo_sauce);
                break;
            case 6:
                d = _context.getResources().getDrawable(R.drawable.logo_fruit);
                break;
            default:
                d = _context.getResources().getDrawable(R.drawable.logo_fruit);
                break;
        }

        icon.setImageDrawable(d);
        return gridView;
    }

    @Override
    public int getCount() {
        if(_lIngredients != null)
            return _lIngredients.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void swapItems(ArrayList<Ingredient> a) {
        _lIngredients.clear();
        if(a != null)
            _lIngredients.addAll(a);
        notifyDataSetChanged();
    }
}
