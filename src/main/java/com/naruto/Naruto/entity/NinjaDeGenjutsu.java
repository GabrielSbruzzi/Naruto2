package com.naruto.Naruto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NinjaDeGenjutsu extends Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public NinjaDeGenjutsu(String nome, int idade, String aldeia, int chakra) {
        super(nome, idade, aldeia, chakra);
    }

    @Override
    public void atacar(Personagem inimigo, String nomeJutsu) {
        System.out.println(getNome() + " usa Genjutsu para confundir o inimigo!");
    }

    @Override
    public void defender(Jutsu jutsu) {
        System.out.println(getNome() + " tenta manipular a percepção do inimigo para evitar o ataque!");
    }

    public void usarJutsu() {
        System.out.println(getNome() + " está usando um jutsu de Genjutsu!");
    }

    public void desviar() {
        System.out.println(getNome() + " está desviando de um ataque usando sua habilidade em Genjutsu!");
    }
}
