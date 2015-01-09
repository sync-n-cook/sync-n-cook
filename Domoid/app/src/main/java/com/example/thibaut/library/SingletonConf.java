package com.example.thibaut.library;

/**
 * Created by thibaut on 08/01/2015.
 */
public class SingletonConf {

    private String _ipRasp;
    private String _ipServeur;

    private static SingletonConf INSTANCE = null;

    private SingletonConf(String rasp, String serv) {
        _ipRasp = rasp;
        _ipServeur = serv;
    }

    private SingletonConf() {
        _ipRasp = "sympa";
        _ipServeur = "sympa";
    }

    public static SingletonConf getInstance(String rasp, String serv) {
        if (INSTANCE == null) {
            INSTANCE = new SingletonConf(rasp, serv);
        }
        return INSTANCE;
    }

    public static SingletonConf getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonConf();
        }
        return INSTANCE;
    }

    public String getIpRasp() {
        return _ipRasp;
    }

    public String getIpServ() {
        return _ipServeur;
    }
}
