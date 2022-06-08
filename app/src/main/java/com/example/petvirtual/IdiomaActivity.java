package com.example.petvirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class IdiomaActivity extends AppCompatActivity {

    private ImageView btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma);

        String pageAnterior = getIntent().getStringExtra("TelaAnterior");

        btnVoltar = findViewById(R.id.btnVoltarActivityLanguage);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (pageAnterior){
                    case "Main":
                        Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        finish();
                        break;
                    case "Cadastro":
                        Intent cadastro = new Intent(getApplicationContext(), CadastroActivity.class);
                        startActivity(cadastro);
                        finish();
                        break;
                    case "CadastroPet":
                        Intent cadastropet = new Intent(getApplicationContext(), CadastroPetActivity.class);
                        startActivity(cadastropet);
                        finish();
                        break;
                    case "Login":
                        Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(login);
                        finish();
                        break;
                    case "Menu":
                        Intent menu = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(menu);
                        finish();
                        break;
                }


            }
        });

    }
}