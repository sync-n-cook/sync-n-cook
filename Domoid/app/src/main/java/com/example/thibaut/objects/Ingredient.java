package com.example.thibaut.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by thibaut on 06/01/2015.
 */
public class Ingredient implements Parcelable {

    private int _id;
    private String _nom;
    private int _categorie;
    private int _quantite;

    public Ingredient(int id, int cat, String nom, int quantite) {
        _id = id;
        _nom = nom;
        _categorie = cat;
        _quantite = quantite;
    }

    public String getNom() {
        return _nom;
    }

    public int getQuantite() {
        return _quantite;
    }

    public int getCat() {
        return _categorie;
    }

    public int getId() {
        return _id;
    }


    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeInt(_id);
        dest.writeString(_nom);
        dest.writeInt(_categorie);
        dest.writeInt(_quantite);

    }

    public static final Parcelable.Creator<Ingredient> CREATOR = new Parcelable.Creator<Ingredient>()
    {
        @Override
        public Ingredient createFromParcel(Parcel source)
        {
            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int size)
        {
            return new Ingredient[size];
        }
    };

    public Ingredient(Parcel in) {
        this._id = in.readInt();
        this._nom = in.readString();
        this._categorie = in.readInt();
        this._quantite = in.readInt();
    }

}
