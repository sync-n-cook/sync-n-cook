package com.example.thibaut.library;

import android.app.Dialog;
import android.content.Context;

import com.example.thibaut.domoid.R;

/**
 * Created by thibaut on 08/01/2015.
 */
public class DialogCreater {

    protected final Context _c;

    public DialogCreater(Context c) {
        _c = c;
    }

    /**
     * Create a new Dialog for a user who want to buy a product/resource
     *
     * @param i the item that the user wants to buy
     * @return the created dialog window
     */

    public Dialog dialogConfig() {

        Dialog d = new Dialog(_c);
        d.setTitle("Configuration réseau");
        d.setContentView(R.layout.conf_dialog);

        return d;
    }

}
