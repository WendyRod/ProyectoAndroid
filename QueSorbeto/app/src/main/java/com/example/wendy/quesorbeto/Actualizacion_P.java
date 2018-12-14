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

public class Actualizacion_P extends Activity {

    EditText codigo, nombre, precio;
    Button actualizar;

    private final BD_Helper helper = new BD_Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizacion__p);

        codigo = findViewById(R.id.txtCodigo);
        nombre = findViewById(R.id.txtNombreP);
        precio = findViewById(R.id.txtPrecio);

        actualizar = findViewById(R.id.btnActualizar);
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualiza(codigo);

            }
        });
    }

    public void actualiza(EditText codigo){
        SQLiteDatabase db = helper.getWritableDatabase();

        String name = nombre.getText().toString();
        String tel = precio.getText().toString();

        ContentValues values = new ContentValues();
        values.put(Estructura_BD.ProductosInfo.NAME_P, name);
        values.put(Estructura_BD.ProductosInfo.PRECIO_VENTA, tel);


        String selection = Estructura_BD.ProductosInfo.COD_P + " LIKE ?";
        String[] selectionArgs = { codigo.getText().toString()};

        int count = db.update(
                Estructura_BD.ClienteInfo.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        Toast.makeText(getApplicationContext(), "Se actualizaron los datos con éxito!", Toast.LENGTH_LONG).show();

    }

}
