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
import com.example.thibaut.objects.Piece;

import java.util.ArrayList;

/**
 * Created by Eude on 08/01/2015.
 */
public class PiecesAdapter extends BaseAdapter {

    private Context _context;
    private ArrayList<Piece> _lpieces;

    public PiecesAdapter(Context context, ArrayList<Piece> lPieces) {
        _context = context;
        _lpieces = lPieces;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

    	/* if the view is null, it means that this view has not been used for the moment, we have to create a new view */
        if (convertView == null) {
            gridView = new View(_context);
            gridView = inflater.inflate(R.layout.piece,null);
    	/* else, we have to recycle this view to avoid memory loss */
        } else {
            gridView = (View) convertView;
            gridView = inflater.inflate(R.layout.piece,null);
        }

        TextView name = (TextView)gridView.findViewById(R.id.nom_piece);
        ImageView icon = (ImageView) gridView.findViewById(R.id.icon_piece);

        Piece p = _lpieces.get(position);
        name.setText(p.getNom());

        /* on récupere pour l'instant une image random, a remplacer par l'image catégorie plus tard */
        Drawable d;
        if(p.getCat()==1){
            d = _context.getResources().getDrawable(R.drawable.syh_logo_app_canap);
        }
        else if(p.getCat()==2){
            d=_context.getResources().getDrawable(R.drawable.syh_logo_app_all);
        }
        else{
            d = _context.getResources().getDrawable(R.drawable.syh_logo_app_bath);
        }
        icon.setImageDrawable(d);
        return gridView;
    }

    @Override
    public int getCount() {
        if(_lpieces != null)
            return _lpieces.size();
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

    public void swapItems(ArrayList<Piece> a) {
        _lpieces.clear();
        if(a != null)
            _lpieces.addAll(a);
        notifyDataSetChanged();
    }
}

