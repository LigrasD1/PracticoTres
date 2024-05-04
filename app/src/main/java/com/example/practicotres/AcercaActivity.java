package com.example.practicotres;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
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

import org.w3c.dom.Text;

public class AcercaActivity extends AppCompatActivity {
    TextView EnviarMensaje;
    TextView EnviarMail;
    Button Volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acerca);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.Acciones();
    }

    private void Acciones(){
        EnviarMensaje=findViewById(R.id.TxTelefono);
        EnviarMail=findViewById(R.id.TxTMail);
        Volver=findViewById(R.id.BtnVolverAcerca);
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),PrincipalActivity.class);
                startActivity(intent);
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(AcercaActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        

        EnviarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Llamar = new Intent();
                Llamar.setAction(Intent.ACTION_DIAL);
                Llamar.setData((Uri.parse("tel:" + "2954 777555")));
                try {
                    startActivity(Llamar);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(AcercaActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        String Asunto="Asunto de prueba";
        String MailDePrueba="example@gmail.com";
        String Contenido="Contenido de prueba";
        EnviarMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Mail=new Intent();
                Mail.setAction(Intent.ACTION_SEND);
                Mail.setType("message/rfc822");
                Mail.putExtra(Intent.EXTRA_EMAIL, new String[]{MailDePrueba});
                Mail.putExtra(Intent.EXTRA_SUBJECT, Asunto);
                Mail.putExtra(Intent.EXTRA_TEXT, Contenido);
                if (Mail.resolveActivity(getPackageManager()) != null) {
                    try {
                        startActivity(Mail);
                    } catch (Exception e) {
                        Toast.makeText(AcercaActivity.this, "Error al intentar enviar", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AcercaActivity.this, "No se encontró una aplicación para enviar correos electrónicos.", Toast.LENGTH_SHORT).show();
                }
            }


        });


    }
}