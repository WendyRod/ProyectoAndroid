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

public class Consulta_P extends Activity {

    Button consultarbtn;
    EditText txtCod;
    TextView labelCod, labelNombre, labelPrecio;

    private final BD_Helper helper = new BD_Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta__p);

        txtCod = findViewById(R.id.txtCodigoP);
        consultarbtn = findViewById(R.id.btnConsultarP);
        labelCod = findViewById(R.id.lblCodigoP);
        labelNombre = findViewById(R.id.lblNombreP);
        labelPrecio = findViewById(R.id.lblPrecioP);


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
                Estructura_BD.ProductosInfo.COD_P,
                Estructura_BD.ProductosInfo.NAME_P,
                Estructura_BD.ProductosInfo.PRECIO_VENTA
        };

// Filter results WHERE "title" = 'My Title'

        String selection = Estructura_BD.ProductosInfo.COD_P + " = ?";
        String[] selectionArgs = { txtCod.getText().toString() };

// How you want the results sorted in the resulting Cursor
                /*String sortOrder =
                        Estructura_BD.ProductosInfo.ID_P + " DESC";*/
        try {
            Cursor cursor = db.query(
                    Estructura_BD.ProductosInfo.TABLE_NAME,   // The table to query
                    projection,             // The array of columns to return (pass null to get all)
                    selection,              // The columns for the WHERE clause
                    selectionArgs,          // The values for the WHERE clause
                    null,                   // don't group the rows
                    null,                   // don't filter by row groups
                    null//sortOrder               // The sort order
            );

            //El cursor avanza
            cursor.moveToFirst();

            labelCod.setText(cursor.getString(0));
            labelNombre.setText(cursor.getString(1));
            labelPrecio.setText(cursor.getString(2));

            cursor.close();

        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "¡El ID " + txtCod.getText().toString() + " no existe!", Toast.LENGTH_LONG).show();
        }
    }
}
