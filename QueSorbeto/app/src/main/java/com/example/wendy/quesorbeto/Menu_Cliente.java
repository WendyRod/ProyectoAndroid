package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Cliente extends Activity {

    Button BotonF;
    Button BotonC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__cliente);

        inicializaPantalla();
    }

    public void inicializaPantalla(){
        BotonF=(Button) findViewById(R.id.btn_facturacion);
        BotonC=(Button) findViewById(R.id.btn_catalogo);

        BotonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Cliente.this,Facturacion.class));
            }
        });

        BotonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Cliente.this,Catalogo.class));
            }
        });
    }
}
