package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Articulos extends Activity implements View.OnClickListener{

    Button botonConsultaP;
    Button botonRegP;
    Button botonActP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);
        inicializaPantalla();
    }

    public void inicializaPantalla(){
        botonConsultaP=(Button) findViewById(R.id.btn_consultaP);
        botonRegP=(Button) findViewById(R.id.btn_registroP);
        botonActP=(Button) findViewById(R.id.btn_actualizacionP);

        botonConsultaP.setOnClickListener(this);
        botonRegP.setOnClickListener(this);
        botonActP.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_consultaP:
                startActivity(new Intent(Articulos.this,Consulta_P.class));
                break;
            case R.id.btn_registroP:
                startActivity(new Intent(Articulos.this,Registro_P.class));
                break;
            case R.id.btn_actualizacionP:
                startActivity(new Intent(Articulos.this,Actualizacion_P.class));
                break;
        }
    }
}
