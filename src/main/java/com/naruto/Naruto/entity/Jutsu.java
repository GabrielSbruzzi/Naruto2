package com.naruto.Naruto.entity;

public class Jutsu {

    private String nome;
    private String descricao;
    private int dano;
    private int consumoDeChakra;

    // Construtor padrão
    public Jutsu() {
    }

    // Construtor completo
    public Jutsu(String nome, String descricao, int dano, int consumoDeChakra) {
        this.nome = nome;
        this.descricao = descricao;
        this.dano = dano;
        this.consumoDeChakra = consumoDeChakra;
    }

    public Jutsu(String rasengan, String jutsuDeChakraEmEspiral) {
    }

    public Jutsu(String chidori, int i, int dano, String s) {
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getConsumoDeChakra() {
        return consumoDeChakra;
    }

    public void setConsumoDeChakra(int consumoDeChakra) {
        this.consumoDeChakra = consumoDeChakra;
    }
}
