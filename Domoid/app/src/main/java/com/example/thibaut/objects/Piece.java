package com.example.thibaut.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eude on 08/01/2015.
 */
public class Piece implements Parcelable {

    private int _id;
    private String _nom;
    private int _categorie;

    public Piece(int id, int cat, String nom) {
        _id = id;
        _nom = nom;
        _categorie = cat;
    }

    public String getNom() {
        return _nom;
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

    }

    public static final Parcelable.Creator<Piece> CREATOR = new Parcelable.Creator<Piece>()
    {
        @Override
        public Piece createFromParcel(Parcel source)
        {
            return new Piece(source);
        }

        @Override
        public Piece[] newArray(int size)
        {
            return new Piece[size];
        }
    };

    public Piece(Parcel in) {
        this._id = in.readInt();
        this._nom = in.readString();
        this._categorie = in.readInt();
    }

}

