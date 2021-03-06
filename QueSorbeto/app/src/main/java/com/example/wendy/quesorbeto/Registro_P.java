package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Data.BD_Helper;
import Data.Estructura_BD;

public class Registro_P extends Activity{

    Button aceptar;

    EditText txtCodigo, txtNombreP, txtPrecio;

    private final BD_Helper helper = new BD_Helper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__p);

        inicializaPantalla();

    }

    public void inicializaPantalla() {

        aceptar = (Button) findViewById(R.id.btnAceptarP);

        txtCodigo = (EditText) findViewById(R.id.txtCodigoP);
        txtNombreP = (EditText) findViewById(R.id.txtNombreP);
        txtPrecio = (EditText) findViewById(R.id.txtPrecioP);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }

    public void validar(){
        if(txtNombreP.getText().toString().isEmpty() || txtCodigo.getText().toString().isEmpty() || txtPrecio.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Hay espacios vacios", Toast.LENGTH_LONG).show();

        }else{
            SQLiteDatabase db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Estructura_BD.ProductosInfo.COD_P, txtCodigo.getText().toString());
            values.put(Estructura_BD.ProductosInfo.NAME_P, txtNombreP.getText().toString());
            values.put(Estructura_BD.ProductosInfo.PRECIO_VENTA, txtPrecio.getText().toString());

            long newRowId = db.insert(Estructura_BD.ProductosInfo.TABLE_NAME, null, values);

            txtCodigo.setText("");
            txtNombreP.setText("");
            txtPrecio.setText("");

            //retorna -1 en caso de error.3
            if(newRowId != -1){
                Toast.makeText(getApplicationContext(), "Los datos se han guardado correctamente con el id " + newRowId, Toast.LENGTH_LONG).show();
                startActivity(new Intent(Registro_P.this,Articulos.class));
                finish();
            }
            else {
                if (ExisteID(txtCodigo)) {
                    Toast.makeText(getApplicationContext(), "El ID ya existe.", Toast.LENGTH_LONG).show();
                }
            }

        }
    }

    public boolean ExisteID(EditText txtCodigo){
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] projection = {
                Estructura_BD.ProductosInfo.COD_P
        };
        try {
            String selection = Estructura_BD.ProductosInfo.COD_P + " = ?";
            String[] selectionArgs = {txtCodigo.getText().toString()};
            Cursor cursor = db.query(
                    Estructura_BD.ProductosInfo.TABLE_NAME       // The table to query
                    , projection                    // The array of columns to return (pass null to get all)
                    , selection                     // The columns for the WHERE clause
                    , selectionArgs                 // The values for the WHERE clause
                    , null                 // don't group the rows
                    , null                  // don't filter by row groups
                    , null//sortOrder      // The sort order
            );
            cursor.moveToFirst();
            if(cursor.getString(0).equalsIgnoreCase(txtCodigo.getText().toString())){
                cursor.close();
                return true;
            }else{
                cursor.close();
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}

