package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Data.BD_Helper;
import Data.Estructura_BD;

public class Actualizacion_C extends Activity {

    EditText id, nombre, telefono;
    Button actualizar;

    private final BD_Helper helper = new BD_Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizacion__c);

        id = findViewById(R.id.et_miembro_id);
        nombre = findViewById(R.id.et_miembro_nombre);
        telefono = findViewById(R.id.et_miembro_telefono);

        actualizar = findViewById(R.id.btnActualizar);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualiza();
            }
        });
    }


    public void actualiza (){

        SQLiteDatabase db = helper.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(Estructura_BD.ClienteInfo.NAME, nombre.getText().toString());
        values.put(Estructura_BD.ClienteInfo.PHONE_NUMBER, telefono.getText().toString());


        String selection = Estructura_BD.ClienteInfo.ID+ "LIKE ?";
        String[] selectionArgs = { id.getText().toString()};

        int count = db.update(
                Estructura_BD.ClienteInfo.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        Toast.makeText(getApplicationContext(), "Se actualizaron los datos con éxito!", Toast.LENGTH_LONG).show();

    }

}