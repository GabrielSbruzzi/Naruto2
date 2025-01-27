package com.naruto.Naruto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String aldeia;

    // Lista de jutsus do personagem
    @ElementCollection
    @CollectionTable(
            name = "personagem_jutsus",
            joinColumns = @JoinColumn(name = "personagem_id")
    )
    @Column(name = "jutsu")
    private List<String> jutsus;

    private int chakra;
    private int vida;

    // Construtores
    public Personagem() {
        this.jutsus = new ArrayList<>();
    }

    public Personagem(String nome, int idade, String aldeia, int chakra, int vida) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.jutsus = new ArrayList<>();
        this.chakra = chakra;
        this.vida = vida;
    }

    public Personagem(String nome, int idade, String aldeia, int chakra) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.jutsus = new ArrayList<>();
        this.chakra = chakra;
        this.vida = 100; // Valor default para vida
    }

    // Métodos
    public void adicionarJutsu(String jutsu) {
        if (!jutsus.contains(jutsu)) {
            jutsus.add(jutsu);
            System.out.println(jutsu + " foi adicionado ao personagem " + nome);
        } else {
            System.out.println(nome + " já conhece o jutsu " + jutsu + "!");
        }
    }

    public void aumentarChakra(int quantidade) {
        if (quantidade > 0) {
            this.chakra += quantidade;
            System.out.println(nome + " aumentou seu chakra em " + quantidade + ". Chakra atual: " + chakra);
        } else {
            System.out.println("A quantidade para aumentar o chakra deve ser positiva.");
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Aldeia: " + aldeia);
        System.out.println("Jutsus: " + jutsus);
        System.out.println("Chakra: " + chakra);
        System.out.println("Vida: " + vida);
    }

    public String getNome() {
        return nome;
    }

    public abstract void atacar(Personagem inimigo, String nomeJutsu);

    public abstract void defender(Jutsu jutsu);
}
