package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Admin extends Activity{

    Button BotonC;
    Button BotonP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__admin);

        inicializaPantalla();
    }

    public void inicializaPantalla(){
        BotonC=(Button) findViewById(R.id.btn_cliente);
        BotonP=(Button) findViewById(R.id.btn_productos);

        BotonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Admin.this,Clientes.class));
            }
        });

        BotonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_Admin.this,Articulos.class));
            }
        });
    }

}
