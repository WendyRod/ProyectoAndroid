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

        id = findViewById(R.id.txtId);
        nombre = findViewById(R.id.txtNombre);
        telefono = findViewById(R.id.txtTel);

        actualizar = findViewById(R.id.btnActualizar);
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualiza(id);

            }
        });
    }

    public void actualiza(EditText id){
        SQLiteDatabase db = helper.getWritableDatabase();

        String name = nombre.getText().toString();
        String tel = telefono.getText().toString();

        ContentValues values = new ContentValues();
        values.put(Estructura_BD.ClienteInfo.NAME, name);
        values.put(Estructura_BD.ClienteInfo.PHONE_NUMBER, tel);


        String selection = Estructura_BD.ClienteInfo.ID + " LIKE ?";
        String[] selectionArgs = { id.getText().toString()};

        int count = db.update(
                Estructura_BD.ClienteInfo.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        Toast.makeText(getApplicationContext(), "Se actualizaron los datos con éxito!", Toast.LENGTH_LONG).show();

    }

}

