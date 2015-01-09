package com.example.thibaut.domoid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thibaut.library.DialogCreater;
import com.example.thibaut.library.SingletonConf;

/**
 * Created by thibaut on 08/01/2015.
 */
public class ActivityConfig extends Activity {

    public DialogCreater _dc;
    public SingletonConf _sc;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        _dc = new DialogCreater(this);

        Dialog conf = _dc.dialogConfig();
        conf.show();

        final EditText rasp = (EditText)conf.findViewById(R.id.ip_rasp);
        final EditText serv = (EditText)conf.findViewById(R.id.ip_serveur);

        Button valid = (Button)conf.findViewById(R.id.valid_ip);
        valid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View b) {

                _sc = SingletonConf.getInstance(rasp.getText().toString(), serv.getText().toString());

                Intent i = new Intent(b.getContext(), MainActivity.class);
                startActivity(i);


            }
        });
    }


}
