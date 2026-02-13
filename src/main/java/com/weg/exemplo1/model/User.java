package com.weg.exemplo1.model;

public class User {

    private int id;
    private String nome;


    public User(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
