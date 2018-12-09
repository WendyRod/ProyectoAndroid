package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Facturacion extends Activity {

    Button BotonP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturacion);

        inicializaPantalla();
    }

    public void inicializaPantalla(){
        BotonP=(Button) findViewById(R.id.btnPagar);

        BotonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Compra realizada!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Facturacion.this,Menu_Cliente.class));
            }
        });

    }
}
