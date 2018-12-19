package com.example.wendy.quesorbeto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import Data.BD_Helper;
import Data.Estructura_BD;

public class Quesos extends Activity {

    Button BotonM;
    Button BotonC;
    Button BotonP;
    Button BotonG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quesos);

        inicializaPantalla();
    }

    public void inicializaPantalla(){

        BotonM=(Button) findViewById(R.id.btnMozarrella);
        BotonC=(Button) findViewById(R.id.btnCheddar);
        BotonP=(Button) findViewById(R.id.btnParmesano);
        BotonG=(Button) findViewById(R.id.btnGouda);

        BotonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quesos.this,Facturacion.class));
            }
        });

        BotonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quesos.this,Facturacion.class));
            }
        });

        BotonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quesos.this,Facturacion.class));
            }
        });

        BotonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quesos.this,Facturacion.class));
            }
        });

    }

}
