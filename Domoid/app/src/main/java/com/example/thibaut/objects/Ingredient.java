package com.example.thibaut.objects;

/**
 * Created by thibaut on 06/01/2015.
 */
public class Ingredient {

    private int _id;
    private String _nom;
    private int _categorie;
    private int _quantite;

    public Ingredient(int id, String nom, int cat, int quantite) {
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


}
