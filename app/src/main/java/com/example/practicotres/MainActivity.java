package com.example.practicotres;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button BtnInico;
    EditText TxtNombre;
    EditText TxtContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.generarUI();
    }

    private void generarUI(){
        TxtContraseña=findViewById(R.id.editTextTextPassword);
        TxtNombre =findViewById(R.id.EditTextName);
        BtnInico=findViewById(R.id.BtnIniciar);
        BtnInico.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String nombre = TxtNombre.getText().toString();
                String contraseña = TxtContraseña.getText().toString();

                if(nombre.equals("Alumno") && contraseña.equals("1234")){
                    Intent intent = new Intent(getBaseContext(), PrincipalActivity.class);
                    try {
                        startActivity(intent);
                    }catch (ActivityNotFoundException e){
                        Toast.makeText(MainActivity.this, "Se produjo un error", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "CREDENCIALES INVALIDAS", Toast.LENGTH_SHORT).show();
                }

            }


        } );
    }
}