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

public class Registro_C extends Activity {

    Button aceptar;

    EditText txtId, txtNombre, txtTelefono;

    private final BD_Helper helper = new BD_Helper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__c);

        inicializaPantalla();

    }

    public void inicializaPantalla() {

        aceptar = (Button) findViewById(R.id.btnAceptar);

        txtId = (EditText) findViewById(R.id.idC);
        txtNombre = (EditText) findViewById(R.id.nombreC);
        txtTelefono = (EditText) findViewById(R.id.telefonoC);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }

    public void validar(){
        if(txtNombre.getText().toString().isEmpty() || txtId.getText().toString().isEmpty() || txtTelefono.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Hay espacios vacios", Toast.LENGTH_LONG).show();
            //startActivity(new Intent(Registro_C.this,Registro_C.class));
        }else{
            SQLiteDatabase db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Estructura_BD.ClienteInfo.ID, txtId.getText().toString());
            values.put(Estructura_BD.ClienteInfo.NAME, txtNombre.getText().toString());
            values.put(Estructura_BD.ClienteInfo.PHONE_NUMBER, txtTelefono.getText().toString());

            long newRowId = db.insert(Estructura_BD.ClienteInfo.TABLE_NAME, null, values);

            txtId.setText("");
            txtNombre.setText("");
            txtTelefono.setText("");

            //retorna -1 en caso de error.
            if(newRowId != -1){
                Toast.makeText(getApplicationContext(), "Los datos se han guardado correctamente con el id " + newRowId, Toast.LENGTH_LONG).show();
                startActivity(new Intent(Registro_C.this,Clientes.class));
                finish();
            }
            else
            {
                if(ExisteID(txtId)){Toast.makeText(getApplicationContext(), "El ID ya existe.", Toast.LENGTH_LONG).show();}
            }

        }
    }

    public boolean ExisteID(EditText txtId){
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] projection = {
                Estructura_BD.ClienteInfo.ID
        };
        try {
            String selection = Estructura_BD.ClienteInfo.ID + " = ?";
            String[] selectionArgs = {txtId.getText().toString()};
            Cursor cursor = db.query(
                    Estructura_BD.ClienteInfo.TABLE_NAME        // The table to query
                    , projection                    // The array of columns to return (pass null to get all)
                    , selection                     // The columns for the WHERE clause
                    , selectionArgs                 // The values for the WHERE clause
                    , null                 // don't group the rows
                    , null                  // don't filter by row groups
                    , null//sortOrder      // The sort order
            );
            cursor.moveToFirst();
            if(cursor.getString(0).equalsIgnoreCase(txtId.getText().toString())){
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
