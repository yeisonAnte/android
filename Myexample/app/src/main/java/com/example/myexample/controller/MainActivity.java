package com.example.myexample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myexample.controller.MainActivity2;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText txtnombre;
    private Button button;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("messages");

        referenciar();
    }

    private void referenciar() {
        txtnombre = findViewById(R.id.txtnombre);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtnombre.getText().toString(); // Obtener el valor ingresado en la caja de texto
                // Generar una nueva clave única para el mensaje
                String key = databaseReference.push().getKey();
                // Guardar el mensaje como un hijo de la referencia "messages" en la base de datos
                databaseReference.child(key).setValue(nombre);
                // Ir a la siguiente actividad
                Intent intent = new Intent(MainActivity2.MainActivity.this, MainActivity2.class);
                intent.putExtra("name", nombre);
                startActivity(intent);
            }
        });
    }
}
