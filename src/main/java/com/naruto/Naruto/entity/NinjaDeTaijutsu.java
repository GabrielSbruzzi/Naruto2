package com.naruto.Naruto.entity;

import jakarta.persistence.Entity;

@Entity
public class NinjaDeTaijutsu extends Personagem implements Ninja {

    public NinjaDeTaijutsu(String nome, int idade, String aldeia, int chakara) {
        super(nome, idade, aldeia, chakara);
    }

    @Override
    public void atacar(Personagem inimigo, String nomeJutsu) {
        System.out.println(getNome() + " é especializado em Taijutsu!");
    }

    @Override
    public void defender(Jutsu jutsu) {
        System.out.println(getNome() + " usa agilidade para tentar desviar!");
    }

    public void usarJutsu() {
        System.out.println(getNome() + " está usando um jutsu de Taijutsu!");
    }

    public void desviar() {
        System.out.println(getNome() + " está desviando de um ataque usando sua habilidade em Taijutsu!");
    }
}
