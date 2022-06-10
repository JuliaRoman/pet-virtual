package com.example.petvirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private ImageView btnVoltar;
    private ImageView btnIdioma;

    private TextView btnLogin;
    private Button btnCadastroPet;

    private EditText campoEmail;
    private EditText campoNome;
    private EditText campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnVoltar = findViewById(R.id.btnVoltarActivityCadastro);
        btnLogin = findViewById(R.id.btnLoginFromCadastro);
        btnCadastroPet = findViewById(R.id.btnCadastrar);
        btnIdioma = findViewById(R.id.btnIdiomaCadastro);
        campoEmail = findViewById(R.id.campoEmailCadastro);
        campoNome = findViewById(R.id.campoNomeCadastro);
        campoSenha = findViewById(R.id.campoSenhaCadastro);

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
                if(campoEmail.getText().toString().equals("") || campoNome.getText().toString().equals("") || campoSenha.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Complete todos os campos!", Toast.LENGTH_LONG).show();
                }else{
                    Usuario usuario = new Usuario();
                    usuario.setEmail(campoEmail.getText().toString());
                    usuario.setNome(campoNome.getText().toString());
                    usuario.setSenha(campoSenha.getText().toString());

                    BancoDeDados banco = new BancoDeDados(getApplicationContext());
                    if(banco.cadastrarUsuario(usuario)){
                        Toast.makeText(getApplicationContext(), "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT);
                        Intent i = new Intent(getApplicationContext(), CadastroPetActivity.class);
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
                i.putExtra("TelaAnterior", "Cadastro");
                startActivity(i);
                finish();
            }
        });


    }
}