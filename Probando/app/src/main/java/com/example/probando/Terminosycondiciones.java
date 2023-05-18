package com.example.cultupaz3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Terminosycondiciones extends AppCompatActivity {
    Button btn_acepta_terminos;
    Button btn_cancelar_terminos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminosycondiciones);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btn_acepta_terminos = findViewById(R.id.btn_acepta_terminos);
        btn_cancelar_terminos=findViewById(R.id.btn_cancelar_terminos);


        btn_acepta_terminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente=new Intent(Terminosycondiciones.this,vistaprincipal.class);
                startActivity(irsiguiente);
            }
        });
        btn_cancelar_terminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irsiguiente=new Intent(Terminosycondiciones.this,Bienvenido.class);
                startActivity(irsiguiente);
            }
        });
    }


}


