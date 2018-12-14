package com.example.wendy.quesorbeto;

import android.app.Activity;
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

public class Consulta_C extends Activity {

    Button consultarbtn;
    EditText txtID;
    TextView labelID, labelNombre, labelTelefono;

    private final BD_Helper helper = new BD_Helper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta__c);

        txtID = findViewById(R.id.idC);
        consultarbtn = findViewById(R.id.btnConsultar);
        labelID = findViewById(R.id.lblID);
        labelNombre = findViewById(R.id.lblNombre);
        labelTelefono = findViewById(R.id.lblTelefono);


        consultarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }
        });

    }

    public void consultar(){

                SQLiteDatabase db = helper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
                String[] projection = {
                        Estructura_BD.ClienteInfo.ID,
                        Estructura_BD.ClienteInfo.NAME,
                        Estructura_BD.ClienteInfo.PHONE_NUMBER
                };

// Filter results WHERE "title" = 'My Title'

                String selection = Estructura_BD.ClienteInfo.ID + " = ?";
                String[] selectionArgs = { txtID.getText().toString() };

// How you want the results sorted in the resulting Cursor
                /*String sortOrder =
                        Estructura_BD.ProductosInfo.ID_P + " DESC";*/
                try {
                    Cursor cursor = db.query(
                            Estructura_BD.ClienteInfo.TABLE_NAME,   // The table to query
                            projection,             // The array of columns to return (pass null to get all)
                            selection,              // The columns for the WHERE clause
                            selectionArgs,          // The values for the WHERE clause
                            null,                   // don't group the rows
                            null,                   // don't filter by row groups
                            null//sortOrder               // The sort order
                    );

                    //El cursor avanza
                    cursor.moveToFirst();

                    labelID.setText(cursor.getString(0));
                    labelNombre.setText(cursor.getString(1));
                    labelTelefono.setText(cursor.getString(2));

                    cursor.close();

                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "¡El ID " + txtID.getText().toString() + " no existe!", Toast.LENGTH_LONG).show();
                }
    }
}