package com.example.thibaut.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thibaut.domoid.R;
import com.example.thibaut.objects.Recette;

import java.util.ArrayList;

/**
 * Created by thibaut on 06/01/2015.
 */
public class RecetteAdapter extends BaseAdapter {

    private Context _context;
    private ArrayList<Recette> _lRecettes;

    public RecetteAdapter(Context context, ArrayList<Recette> lRecettes) {
        _context = context;
        _lRecettes = lRecettes;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

    	/* if the view is null, it means that this view has not been used for the moment, we have to create a new view */
        if (convertView == null) {
            gridView = new View(_context);
            gridView = inflater.inflate(R.layout.recette, null);

    	/* else, we have to recycle this view to avoid memory loss */
        } else {
            gridView = (View) convertView;
            gridView = inflater.inflate(R.layout.recette, null);
        }

        TextView name = (TextView)gridView.findViewById(R.id.nom);
        TextView duree = (TextView)gridView.findViewById(R.id.duree);

        Recette r = _lRecettes.get(position);
        name.setText(r.getNom());
        duree.setText("Durée : "+r.getDuree() + " min");

        return gridView;
    }

    @Override
    public int getCount() {
        if(_lRecettes != null)
            return _lRecettes.size();
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

    public void swapItems(ArrayList<Recette> a) {
        _lRecettes.clear();
        if(a != null)
            _lRecettes.addAll(a);
        notifyDataSetChanged();
    }
}
