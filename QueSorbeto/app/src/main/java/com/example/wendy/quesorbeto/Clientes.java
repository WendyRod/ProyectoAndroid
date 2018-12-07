package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Clientes extends Activity implements View.OnClickListener{

    Button botonConsultaC;
    Button botonRegC;
    Button botonActC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        inicializaPantalla();
    }

    public void inicializaPantalla(){
        botonConsultaC=(Button) findViewById(R.id.btn_consultaC);
        botonRegC=(Button) findViewById(R.id.btn_registroC);
        botonActC=(Button) findViewById(R.id.btn_actualizacionC);

        botonConsultaC.setOnClickListener(this);
        botonRegC.setOnClickListener(this);
        botonActC.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_consultaC:
                startActivity(new Intent(Clientes.this,Consulta_C.class));
                break;
            case R.id.btn_registroC:
                startActivity(new Intent(Clientes.this,Registro_C.class));
                break;
            case R.id.btn_actualizacionC:
                startActivity(new Intent(Clientes.this,Actualizacion_C.class));
                break;
        }
    }
}
