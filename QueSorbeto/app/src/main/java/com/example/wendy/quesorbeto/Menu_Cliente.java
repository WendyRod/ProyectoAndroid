package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Cliente extends Activity {

    Button BotonT;
    Button BotonV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__cliente);

        inicializaPantalla();
    }

    public void inicializaPantalla(){
        BotonT=(Button) findViewById(R.id.btn_tienda);
        BotonV=(Button) findViewById(R.id.btn_volver);

        BotonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Cliente.this,Quesos.class));
            }
        });

        BotonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Cliente.this,Login.class));
            }
        });
    }
}
