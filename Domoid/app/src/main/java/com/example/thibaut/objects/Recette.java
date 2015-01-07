package com.example.thibaut.objects;

/**
 * Created by thibaut on 06/01/2015.
 */
public class Recette {

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

}
