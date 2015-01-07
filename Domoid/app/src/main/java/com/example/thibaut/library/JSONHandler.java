package com.example.thibaut.library;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.thibaut.objects.Ingredient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * A class used to handle JSON responses from the server.
 * JSON is standard format used to represent datas.
 * @author thibaut chamoux
 * @version 1.0
 */
public class JSONHandler {

    static private Context _context;

    public JSONHandler(Context c) {
        _context = c;
    }

    public void sendHttpRequest(String uri) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(uri);
            HttpResponse httpResponse = httpClient.execute(httpGet);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public JSONArray getJSONFromServer(String url, List<NameValuePair> params) {

        InputStream is = null;

    	/* test if the server is reachable */
        /*if(!isServerReachable()) {
            Log.d("---- LOG URL ----", "SERVER UNREACHABLE");
            JSONArray fail = new JSONArray();
            JSONObject jo = new JSONObject();
            try {

                jo.accumulate("server", true);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            fail.put(jo);
            return fail;
        } else {
            Log.d("---- LOG URL ----", "SERVER REACHABLE");
        }

        /* Create the http request */
        try {

            /* create a GET request from the params */
            DefaultHttpClient httpClient = new DefaultHttpClient();
            if(params != null) {
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url += "?" + paramString;
            }
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return getResponse(is);
    }






    public JSONArray getResponse(InputStream is) {

        JSONArray jArray = null;
        String json = "";

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();

            Log.d("JSON", json);
            /* if the answer from the server is not good, we return null */
            if(json.compareTo("{\"echec\":\"fail\"}") == 1) {

                return null;
            }

        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        /* parse the string to a JSON array */
        try {
            jArray = new JSONArray(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        /* return JSON String */

        return jArray;
    }

    /**
     * Create a list of Items from a JSONArray
     * @param a the JSONArray
     * @return the list
     */
    public ArrayList<Ingredient> jsonToListIngredients(JSONArray a) {
        ArrayList<Ingredient> list = new ArrayList<Ingredient>();
        JSONObject j;

        if(a != null) {
                for(int i = 0; i < a.length(); i++) {
                    try {
                        j = a.getJSONObject(i);
                        list.add(new Ingredient(j.getInt("ingredientId"), j.getString("ingredientNom"), j.getInt("ingredientCategorieId"), j.getInt("ingredientQuantite")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
        }

        return list;
    }

    /**
     * test if the server is reachable
     *
     * @return
     */

    static public boolean isServerReachable() {
        ConnectivityManager cm = (ConnectivityManager)_context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            try {
                URL url = new URL("adresse serveur");
                HttpURLConnection urlc = (HttpURLConnection)url.openConnection();
                urlc.setConnectTimeout(10 * 1000);          // 10 s.
                urlc.connect();
                if (urlc.getResponseCode() == 200) {        // 200 = "OK" code (http connection is fine).
                    return true;
                } else {
                    return false;
                }
            } catch (MalformedURLException e1) {
                return false;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }
}
