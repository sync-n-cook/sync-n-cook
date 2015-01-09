package com.example.thibaut.domoid;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.thibaut.adapter.IngredientsAdapter;
import com.example.thibaut.adapter.PiecesAdapter;
import com.example.thibaut.adapter.RecetteAdapter;
import com.example.thibaut.objects.Ingredient;
import com.example.thibaut.objects.Piece;
import com.example.thibaut.objects.Recette;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class ActivityAdd_pieces extends ActionBarActivity {
    private ListView _lvp;
    private HashMap<Integer, String> _selectionnes;
    private ArrayList<Piece> _lpieces;
    private int _count;
    private PiecesAdapter _pa;
    protected int _orientation;
    private ArrayList<Piece> _pieceSelectionne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pieces);

        if(savedInstanceState != null) {
            _lpieces = savedInstanceState.getParcelableArrayList("pieces");
            _count = savedInstanceState.getInt("count");
            Serializable hashmap = savedInstanceState.getSerializable("hashmap");
            _selectionnes = (HashMap<Integer, String>)hashmap;
        } else {
            _count = 0;
            _lpieces = new ArrayList<Piece>();
            _pieceSelectionne=new ArrayList<Piece>();
            _selectionnes = new HashMap<Integer, String>();
        }

        _lvp = (ListView)findViewById(R.id.list_pieces);

        _pa = new PiecesAdapter(this, _lpieces);
        _lvp.setAdapter(_pa);
        /**Rajout de pieces dans notre room store**/
        Piece test=new Piece(1,1,"living Room");
        _lpieces.add(test);
         test=new Piece(2,2,"Porte d'Entrée");
        _lpieces.add(test);
        test=new Piece(3,3,"Salle de Bain");
        _lpieces.add(test);

        //_orientation = getResources().getConfiguration().orientation;

        _lvp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Piece p = _lpieces.get(position);
                if (_selectionnes.containsKey(p.getId())) {
                    _selectionnes.remove(p.getId());
                    _pieceSelectionne.remove(p);
                    _count--;
                } else {
                    _selectionnes.put(p.getId(), p.getNom());
                    _pieceSelectionne.add(p);
                    _count++;
                }
                    Log.e("nbre_element_selectionne",Integer.toString(_count));
             }
        });

        Button valid = (Button) findViewById(R.id.valid_pieces);
        valid.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                /*Intent webview = new Intent(v.getContext(), ActivityTestWebView.class);
                startActivity(webview);*/

                File myFile = new File(Environment.getExternalStorageDirectory() +
                        File.separator + "domoid","pieces.txt"); //on déclare notre futur fichier

                File myDir = new File(Environment.getExternalStorageDirectory() +
                        File.separator + "domoid"); //pour créer


                        // le repertoire dans lequel on va mettre notre fichier
                Boolean success=true;
                if (!myDir.exists()) {
                    success = myDir.mkdir(); //On crée le répertoire (s'il n'existe pas!!)
                }
                if (success){

                    //String data= "Ce que je veux ecrire dans mon fichier \r\n";

                    FileOutputStream output = null; //le true est pour écrire en fin de fichier, et non l'écraser
                    try {
                        output = new FileOutputStream(myFile,true);
                        for(Piece p:_pieceSelectionne){
                            String data=p.getCat()+"\r\n";
                            output.write(data.getBytes());
                        }

                    } catch (FileNotFoundException e) {
                        System.err.println("fICHiER INDISPONIBLE");
                    } catch (IOException e) {
                        System.err.println("Erreur de données");
                    }

                }
                else {
                    Log.e("TEST1", "ERREUR DE CREATION DE DOSSIER");}

                    Intent mainview = new Intent(v.getContext(), MainActivity.class);
                    startActivity(mainview);
                /*File f = new File(Environment.getExternalStorageDirectory(), "Android/data/"+"Domoid"+"/hello_file");
                try{
                    FileWriter writer = new FileWriter(f);
                }catch(Exception e){
                    System.err.println("erreur d'ouverture");
                }*/
            }
        });
           /* _lvp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Piece p = _lpieces.get(position);
                    if (_selectionnes.containsKey(p.getId())) {
                        _selectionnes.remove(p.getId());
                        _count--;
                    } else {
                        _selectionnes.put(p.getId(), p.getNom());
                        _count++;
                    }
                }
            });*/

        //final RelativeLayout layoutIngredients = (RelativeLayout) findViewById(R.id.layout_ingredient);

        /*ObtenirIngredients oi = new ObtenirIngredients();
        oi.execute();*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_pieces, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
