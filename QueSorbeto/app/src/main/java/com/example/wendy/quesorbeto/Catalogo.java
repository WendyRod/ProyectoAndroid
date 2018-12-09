package com.example.wendy.quesorbeto;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Catalogo extends Activity {

    Button BotonM;
    Button BotonC;
    Button BotonP;
    Button BotonG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

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
                Toast.makeText(getApplicationContext(), "Ir a Facturación", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Catalogo.this,Menu_Cliente.class));
            }
        });

        BotonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ir a Facturación", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Catalogo.this,Menu_Cliente.class));
            }
        });

        BotonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ir a Facturación", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Catalogo.this,Menu_Cliente.class));
            }
        });

        BotonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ir a Facturación", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Catalogo.this,Menu_Cliente.class));
            }
        });

    }

}
