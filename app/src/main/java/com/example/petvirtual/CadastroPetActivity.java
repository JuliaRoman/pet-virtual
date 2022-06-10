package com.example.petvirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CadastroPetActivity extends AppCompatActivity {

    private ImageView btnVoltar;
    private Button btnMenuPrincipal;
    private ImageView btnIdioma;
    private EditText campoNomePet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);

        btnVoltar = findViewById(R.id.btnVoltarMainFromPet);
        btnMenuPrincipal = findViewById(R.id.btnCadastraPet);
        btnIdioma = findViewById(R.id.btnIdiomaCadastroPet);
        campoNomePet = findViewById(R.id.campoNomePet);

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
                if(campoNomePet.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Adicione um nome!", Toast.LENGTH_LONG).show();
                }else{
                    Pet pet = new Pet();
                    pet.setNome(campoNomePet.getText().toString());
                    pet.setDiversao(100);
                    pet.setFome(100);
                    pet.setLimpeza(100);
                    pet.setSono(100);

                    BancoDeDados banco = new BancoDeDados(getApplicationContext());
                    if(banco.cadastrarPet(pet)){
                        Toast.makeText(getApplicationContext(), "Pet cadastrado com sucesso!", Toast.LENGTH_SHORT);
                        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Erro ao cadastrar usuário", Toast.LENGTH_SHORT);
                    }

                }
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