package com.example.wendy.quesorbeto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Classes.User;

public class Login extends Activity{

    private EditText Email;
    private EditText Password;
    private Button   Acceder;

    Context miContexto;
    private SharedPreferences PreferenciasConfiguracion;
    private SharedPreferences.Editor editorPreConfig;

    public Login(Context elContexto) {
        miContexto = elContexto;
        PreferenciasConfiguracion = miContexto.getSharedPreferences("PreConfig",miContexto.MODE_PRIVATE);
        editorPreConfig = PreferenciasConfiguracion.edit();
    }

    public void GuardaPrefConfig(String email, String pass){
        editorPreConfig.putString("email",email);
        editorPreConfig.putString("pass",pass);
        editorPreConfig.commit();
    }

    public String CargaPref_Configuracion(){
        User user = new User();
        String email="";
        String pass="";
        SharedPreferences prefs=miContexto.getSharedPreferences("PreConfig",miContexto.MODE_PRIVATE);
        email = prefs.getString("email", user.Mail);
        return email;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Acceder = (Button) findViewById(R.id.BtnIngresar);

        Acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ingresar();

            }
        });

        String mensaje="";
        Bundle extras=getIntent().getExtras();
        if (extras != null){
            mensaje = extras.getString("saludo");
        }
        Toast.makeText(Login.this,""+ mensaje, Toast.LENGTH_LONG).show();
    }


    private void Ingresar()
    {
        //Set Variables
        Email = findViewById(R.id.TxtEmail);
        Password = findViewById(R.id.TxtPassword);
        String _Mail = Email.getText().toString();
        String _Pass = Password.getText().toString();
        try {
            //Check
            if (ValidateMail(_Mail) && ValidatePassword(_Pass)) {
                if((_Mail.equals("wendy@mail.com") && _Pass.equals("admin123"))){
                    //Crear objeto (User).
                    User user = new User(_Mail, _Pass);
                    //Mostrar el mensaje.
                    Toast.makeText(getApplicationContext(), user.toString(), Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(Login.this,Menu_Admin.class));

                    Intent myIntent=new Intent(getApplicationContext(),Menu_Admin.class);
                    myIntent.putExtra("saludo","Bienvenido!");
                    startActivity(myIntent);

                    //Simular conexion a base de datos.
                    /*
                     * Logic de acceso AQUI.
                     */
                }else if (_Mail.equals("fernanda@mail.com") && _Pass.equals("admin123")) {
                    //Crear objeto (User).
                    User user = new User(_Mail, _Pass);
                    //Mostrar el mensaje.
                    Toast.makeText(getApplicationContext(), user.toString(), Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(Login.this, Menu_Cliente.class));

                    Intent myIntent=new Intent(getApplicationContext(),Menu_Cliente.class);
                    myIntent.putExtra("saludo","Bienvenido!");
                    startActivity(myIntent);

                }else {
                    Toast.makeText(getApplicationContext(), "El usuario o la contraseña no son correctos", Toast.LENGTH_SHORT).show();
                }

            }
        }catch (Exception e){
            //Error al crear el hilo.
        }

    }

    private boolean ValidateMail(String AuthMail)
    {
        if(!AuthMail.contains("@") || !AuthMail.contains("."))
        {
            Toast.makeText(this, "El Mail no es correcto", Toast.LENGTH_LONG).show();
            return false;
        }
        else
        {
            return true;
        }
    }
    private boolean ValidatePassword(String AuthPass)
    {
        if(AuthPass.length() < 6){
            Toast.makeText(this, "La contraseña no es correcta", Toast.LENGTH_LONG).show();
            return false;
        }
        else
        {
            return true;
        }
    }
}
