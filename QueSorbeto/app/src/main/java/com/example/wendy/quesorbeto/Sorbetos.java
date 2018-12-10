package com.example.wendy.quesorbeto;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Sorbetos extends Activity {

    Button BotonV;
    Button BotonF;
    Button BotonC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorbetos);

        inicializaPantalla();
    }

    public void inicializaPantalla(){
        BotonV=(Button) findViewById(R.id.btnVainilla);
        BotonF=(Button) findViewById(R.id.btnFresa);
        BotonC=(Button) findViewById(R.id.btnChocolate);

        BotonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sorbetos.this,Facturacion.class));
            }
        });

        BotonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sorbetos.this,Facturacion.class));
            }
        });

        BotonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sorbetos.this,Facturacion.class));
            }
        });



    }

}
