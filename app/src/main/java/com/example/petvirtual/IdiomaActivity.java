package com.example.petvirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

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

    };

    public void idiomaPT(View v){
        Locale idioma = new Locale("pt-rBR");
        Locale.setDefault(idioma);

        Context context = this;
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());

        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("idioma","pt-rBR");
        dados.commit();

        recreate();
    }

    public void idiomaEN(View v){
        Locale idioma = new Locale("en");
        Locale.setDefault(idioma);

        Context context = this;
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());

        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("idioma","en");
        dados.commit();

        recreate();
    }

    public void idiomaES(View v){
        Locale idioma = new Locale("es");
        Locale.setDefault(idioma);

        Context context = this;
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());

        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("idioma","es");
        dados.commit();

        recreate();
    }

    public void idiomaFR(View v){
        Locale idioma = new Locale("fr");
        Locale.setDefault(idioma);

        Context context = this;
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());

        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("idioma","fr");
        dados.commit();

        recreate();
    }

    public void idiomaIT(View v){
        Locale idioma = new Locale("it");
        Locale.setDefault(idioma);

        Context context = this;
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());

        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("idioma","it");
        dados.commit();

        recreate();
    }

}