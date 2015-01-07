package com.example.thibaut.library;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.example.thibaut.objects.Ingredient;
import com.example.thibaut.objects.Recette;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by thibaut on 06/01/2015.
 */
public class HttpHandler {

    private Context _context;

    private JSONHandler _jHandler;

    private String _shutterUp = "http://192.168.43.249:8080/api?api_number=1";
    private String _shutterDown = "http://192.168.43.249:8080/api?api_number=2";

    private String _camera = "http://192.168.43.157:8081";

    //private String _checkForIngredients = "http://192.168.43.158:8086/PI/webapi/ingredient/";
    //private String _checkForRecettes = "http://192.168.43.158:8086/PI/webapi/recette/ingredient/";

    private String _checkForIngredients = "http://serveur-apprentissage.ensicaen.fr:8080/ProjetIntensif/webapi/ingredient/";
    private String _checkForRecettes = "http://serveur-apprentissage.ensicaen.fr:8080/ProjetIntensif/webapi/recette/ingredient/";

    public HttpHandler(Context c) {
        _context = c;
        _jHandler = new JSONHandler(c);
    }

    public void handleShutters(boolean b) {

        if (b) {
            _jHandler.sendHttpRequest(_shutterUp);
        } else {
            _jHandler.sendHttpRequest(_shutterDown);
        }
    }

    public void startCamera() {
        Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(_camera) );
        _context.startActivity(intent);
    }

    public ArrayList<Ingredient> getListIngredients() {
        JSONArray array = _jHandler.getJSONFromServer(_checkForIngredients, null);
        return _jHandler.jsonToListIngredients(array);

    }

    public ArrayList<Recette> getListRecettes(ArrayList<Integer> a) {

        /*for(int i = 0; i < a.size(); i++) {
            if(i != a.size() -1) {
                _checkForRecettes = _checkForRecettes + a.get(i) + "-";
            } else {
                _checkForRecettes = _checkForRecettes + a.get(i);
            }
        }*/

        Log.d("ID INGREDIENTS SELECTIONNES", "" + a.toString());

        _checkForRecettes = "http://serveur-apprentissage.ensicaen.fr:8080/ProjetIntensif/webapi/recette/ingredient/3";
        JSONArray array = _jHandler.getJSONFromServer(_checkForRecettes, null);
        return _jHandler.jsonToListRecettes(array);

    }


}
