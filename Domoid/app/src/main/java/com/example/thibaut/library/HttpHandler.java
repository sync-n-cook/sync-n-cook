package com.example.thibaut.library;

import android.content.Context;

import com.example.thibaut.objects.Ingredient;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by thibaut on 06/01/2015.
 */
public class HttpHandler {


    private JSONHandler _jHandler;

    private String _shutterUp = "http://192.168.43.249:8080/api?api_number=1";
    private String _shutterDown = "http://192.168.43.249:8080/api?api_number=2";
    private String _checkForIngredients = "http://192.168.43.158:8086/PI/webapi/ingredient/";

    public HttpHandler(Context c) {
        _jHandler = new JSONHandler(c);
    }

    public void handleShutters(boolean b) {

        if (b) {
            _jHandler.sendHttpRequest(_shutterUp);
        } else {
            _jHandler.sendHttpRequest(_shutterDown);
        }
    }

    public ArrayList<Ingredient> getListIngredients() {
        JSONArray array = _jHandler.getJSONFromServer(_checkForIngredients, null);
        return _jHandler.jsonToListIngredients(array);

    }


}
