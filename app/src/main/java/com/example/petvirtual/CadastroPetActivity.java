package com.example.petvirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CadastroPetActivity extends AppCompatActivity {

    private ImageView btnVoltar;
    private Button btnMenuPrincipal;
    private ImageView btnIdioma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);

        btnVoltar = findViewById(R.id.btnVoltarMainFromPet);
        btnMenuPrincipal = findViewById(R.id.btnCadastraPet);
        btnIdioma = findViewById(R.id.btnIdiomaCadastroPet);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CadastroActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnIdioma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IdiomaActivity.class);
                i.putExtra("TelaAnterior", "CadastroPet");
                startActivity(i);
                finish();
            }
        });
    }
}