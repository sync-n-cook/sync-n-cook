package com.example.thibaut.library;

import android.content.ComponentName;
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

    private String _shutterUp = ":8080/api?api_number=1";
    private String _shutterDown = ":8080/api?api_number=2";

    private String _camera = ":8081";


    //private String _checkForIngredients = "http://192.168.43.158:8086/PI/webapi/ingredient/";
    //private String _checkForRecettes = "http://192.168.43.158:8086/PI/webapi/recette/ingredient/";

    //private String _checkForIngredients = "http://serveur-apprentissage.ensicaen.fr:8080/ProjetIntensif/webapi/ingredient/";
    //private String _checkForIngredients = "http://192.168.43.158:8086/PI/webapi/ingredient/";
    private String _checkForIngredients = "/ProjetIntensif/webapi/ingredient/";

    private SingletonConf _sc;

    public HttpHandler(Context c) {
        _context = c;
        _jHandler = new JSONHandler(c);
        _sc = SingletonConf.getInstance();
    }

    public void handleShutters(boolean b) {

        if (b) {
            _jHandler.sendHttpRequest(_sc.getIpRasp()+_shutterUp);
        } else {
            _jHandler.sendHttpRequest(_sc.getIpRasp()+_shutterDown);
        }
    }

    public void startCamera() {
        Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(_sc.getIpRasp()+_camera) );
        intent.setComponent(new ComponentName("org.mozilla.firefox", "org.mozilla.firefox.App"));
        _context.startActivity(intent);
    }

    public ArrayList<Ingredient> getListIngredients() {

        JSONArray array = _jHandler.getJSONFromServer(_sc.getIpServ()+_checkForIngredients, null);

        Log.d("SIZE ARRAY", ""+array.length());
        //JSONArray array = _jHandler.getJSONFromServer(_checkForIngredients, null);

        return _jHandler.jsonToListIngredients(array);

    }

    public ArrayList<Recette> getListRecettes(ArrayList<String> a) {

        String checkForRecettes = "http://serveur-apprentissage.ensicaen.fr:8080/ProjetIntensif/webapi/recette/ingredients/";
        //String checkForRecettes = "http://192.168.43.158:8086/PI/webapi/recette/ingredients/";
        //String checkForRecettes = _sc.getIpServ()+"/ProjetIntensif/webapi/recette/ingredients/";

        for(int i = 0; i < a.size(); i++) {
            String nom = a.get(i);
            nom = nom.replaceAll("\\s", "-");
            if(i != a.size() -1) {
                checkForRecettes = checkForRecettes + nom + "-";
            } else {
                checkForRecettes = checkForRecettes + nom;
            }
        }

        JSONArray array = _jHandler.getJSONFromServer(checkForRecettes, null);
        return _jHandler.jsonToListRecettes(array);

    }

    public void updateScreen(ArrayList<Integer> a) {


        String updateScreen = _sc.getIpRasp()+":8080/cook?ids=";
        for(int i = 0; i < a.size(); i++) {

            if(i != a.size() -1) {
                updateScreen = updateScreen + a.get(i) + "_";
            } else {
                updateScreen = updateScreen + a.get(i);
            }
        }

        Log.d("URL SCREEN", updateScreen);
        _jHandler.sendHttpRequest(updateScreen);

    }

}
