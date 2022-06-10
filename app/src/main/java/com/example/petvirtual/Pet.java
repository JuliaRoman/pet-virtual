package com.example.petvirtual;

public class Pet {
    private int id, sono, fome, diversao, limpeza, fkUsuario;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSono() {
        return sono;
    }

    public void setSono(int sono) {
        this.sono = sono;
    }

    public int getFome() {
        return fome;
    }

    public void setFome(int fome) {
        this.fome = fome;
    }

    public int getDiversao() {
        return diversao;
    }

    public void setDiversao(int diversao) {
        this.diversao = diversao;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(int limpeza) {
        this.limpeza = limpeza;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

