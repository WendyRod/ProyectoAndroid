package com.example.wendy.quesorbeto;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Data.BD_Helper;
import Data.Estructura_BD;

public class Facturacion extends Activity {

    Button Pagar;
    TextView txtCantidad, txtNombreP, txtTotal, txtNombreC, txtCedula;

    private final BD_Helper helper = new BD_Helper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturacion);

        inicializaPantalla();
    }

    public void inicializaPantalla() {

        txtCantidad = (TextView) findViewById(R.id.Cantidad);

        txtNombreP = (TextView) findViewById(R.id.NombreP);
        txtTotal = (TextView) findViewById(R.id.Total);

        txtNombreC = (TextView) findViewById(R.id.NombreC);
        txtCedula = (TextView) findViewById(R.id.Cedula);


        Pagar = (Button) findViewById(R.id.btnPagar);

        Pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Compra realizada!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Facturacion.this, Menu_Cliente.class));
            }
        });

    }

    public void mostrarDatos() {

        SQLiteDatabase db = helper.getReadableDatabase();



        }



}
