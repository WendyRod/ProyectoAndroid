package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Data.BD_Helper;
import Data.Cliente;
import Data.ClienteBD;

public class Consulta_C extends Activity {

    Button consultar;
    EditText txtID;

    final BD_Helper helper = new BD_Helper((this));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta__c);
    }

    public void consultar(){
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
                String[] projection = {
                        BaseColumns._ID,
                        ClienteBD.ProductosInfo.ID_P,
                        ClienteBD.ProductosInfo.NAME_P,
                        ClienteBD.ProductosInfo.PRECIO_VENTA
                };

// Filter results WHERE "title" = 'My Title'
                String selection = ClienteBD.ProductosInfo.ID_P + " = ?";
                String[] selectionArgs = { "ID" };

// How you want the results sorted in the resulting Cursor
                String sortOrder =
                        ClienteBD.ProductosInfo.ID_P + " DESC";

                Cursor cursor = db.query(
                        ClienteBD.ProductosInfo.TABLE_NAME,   // The table to query
                        projection,             // The array of columns to return (pass null to get all)
                        selection,              // The columns for the WHERE clause
                        selectionArgs,          // The values for the WHERE clause
                        null,                   // don't group the rows
                        null,                   // don't filter by row groups
                        sortOrder               // The sort order
                );
            }
        });
    }
}
