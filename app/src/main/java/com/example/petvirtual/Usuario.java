package com.example.petvirtual;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String email;
    private String nome;
    private String senha;

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
