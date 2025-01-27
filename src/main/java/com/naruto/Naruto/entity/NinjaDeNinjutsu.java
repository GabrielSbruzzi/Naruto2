package com.naruto.Naruto.entity;

import jakarta.persistence.Entity;

@Entity
public class NinjaDeNinjutsu extends Personagem implements Ninja {

    public NinjaDeNinjutsu(String nome, int idade, String aldeia, int chakra) {
        super(nome, idade, aldeia, chakra);
    }

    @Override
    public void atacar(Personagem inimigo, String nomeJutsu) {
        System.out.println(getNome() + " é especializado em Ninjutsu, atacando com precisão!");
    }

    @Override
    public void defender(Jutsu jutsu) {
        System.out.println(getNome() + " usa técnicas ninjutsu defensivas para tentar desviar!");
    }

    public void usarJutsu() {
        System.out.println(getNome() + " está usando um jutsu de Ninjutsu!");
    }

    public void desviar() {
        System.out.println(getNome() + " está desviando de um ataque usando sua habilidade em Ninjutsu!");
    }
}
