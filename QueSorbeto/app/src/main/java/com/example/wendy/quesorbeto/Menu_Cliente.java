package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Cliente extends Activity {

    Button BotonQ;
    Button BotonS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__cliente);

        inicializaPantalla();
    }

    public void inicializaPantalla(){
        BotonQ=(Button) findViewById(R.id.btn_quesos);
        BotonS=(Button) findViewById(R.id.btn_sorbetos);

        BotonQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Cliente.this,Quesos.class));
            }
        });

        BotonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Cliente.this,Sorbetos.class));
            }
        });
    }
}
