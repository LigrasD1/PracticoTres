package com.example.practicotres;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {
    Button Acerca;
    Button Salir;
    TextView Error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.FNBotones();
        this.CambiarAcereca();

    }
    private void FNBotones(){

        Salir=findViewById(R.id.BtnSalirPrincipal);

        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(PrincipalActivity.this, "Se produjo un error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void CambiarAcereca(){
        Acerca=findViewById(R.id.BtnAcerca);
        Acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),AcercaActivity.class);
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(PrincipalActivity.this, "Se produjo un error", Toast.LENGTH_SHORT).show();
                }            }
        });
    }

}