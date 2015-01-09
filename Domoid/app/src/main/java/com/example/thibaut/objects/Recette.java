package com.example.thibaut.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by thibaut on 06/01/2015.
 */
public class Recette implements Parcelable {

    private String _description;
    private int _id;
    private String _name;
    private String _duree;

    public Recette(int id, String name, String desc, String duree) {
        _id = id;
        _name = name;
        _description = desc;
        _duree = duree;
    }

    public String getNom() {
        return _name;
    }

    public String getDescription() {
        return _description;
    }

    public String getDuree() {
        return _duree;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeInt(_id);
        dest.writeString(_name);
        dest.writeString(_description);
        dest.writeString(_duree);

    }
    @Override
    public int describeContents()
    {
        return 0;
    }

    
    public static final Parcelable.Creator<Recette> CREATOR = new Parcelable.Creator<Recette>()
    {
        @Override
        public Recette createFromParcel(Parcel source)
        {
            return new Recette(source);
        }

        @Override
        public Recette[] newArray(int size)
        {
            return new Recette[size];
        }
    };

    public Recette(Parcel in) {
        this._id = in.readInt();
        this._name = in.readString();
        this._description = in.readString();
        this._duree = in.readString();
    }
}
