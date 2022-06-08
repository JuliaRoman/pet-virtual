package com.example.petvirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {

    private ImageView btnVoltar;
    private TextView btnLogin;
    private Button btnCadastroPet;
    private ImageView btnIdioma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnVoltar = findViewById(R.id.btnVoltarActivityCadastro);
        btnLogin = findViewById(R.id.btnLoginFromCadastro);
        btnCadastroPet = findViewById(R.id.btnCadastrar);
        btnIdioma = findViewById(R.id.btnIdiomaCadastro);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnCadastroPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CadastroPetActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnIdioma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IdiomaActivity.class);
                i.putExtra("TelaAnterior", "Cadastro");
                startActivity(i);
                finish();
            }
        });

    }
}