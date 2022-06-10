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

public class LoginActivity extends AppCompatActivity {

    private ImageView btnVoltar;
    private ImageView btnIdioma;

    private TextView btnCadastro;
    private Button btnMenuPrincipal;

    private EditText campoEmail;
    private EditText campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnVoltar = findViewById(R.id.btnVoltarActivityLogin);
        btnCadastro = findViewById(R.id.btnCadastroFromLogin);
        btnMenuPrincipal= findViewById(R.id.btnLogin);
        btnIdioma = findViewById(R.id.btnIdiomaLogin);
        campoEmail = findViewById(R.id.campoEmailLogin);
        campoSenha = findViewById(R.id.campoSenhaLogin);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnCadastro.setOnClickListener(new View.OnClickListener() {
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
                if(campoEmail.getText().toString().equals("") || campoSenha.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Complete todos os campos!", Toast.LENGTH_LONG).show();
                }else{
                    Usuario usuario = new Usuario();
                    usuario.setEmail(campoEmail.getText().toString());
                    usuario.setSenha(campoSenha.getText().toString());

                    BancoDeDados banco = new BancoDeDados(getApplicationContext());
                    if(banco.loginUsuario(usuario)){
                        Toast.makeText(getApplicationContext(), "Login realizado com sucesso!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Email ou senha incorretos!", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        btnIdioma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IdiomaActivity.class);
                i.putExtra("TelaAnterior", "Login");
                startActivity(i);
                finish();
            }
        });
    }
}