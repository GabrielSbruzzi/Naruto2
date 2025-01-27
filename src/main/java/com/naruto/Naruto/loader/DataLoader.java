package com.naruto.Naruto.loader;

import com.naruto.Naruto.entity.Personagem;
import com.naruto.Naruto.entity.Jutsu;
import com.naruto.Naruto.repository.PersonagemRepository;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private PersonagemRepository personagemRepository;

    public void loadData() {
        Jutsu jutsu1 = new Jutsu("Rasengan", 50, 20, "Jutsu de chakra concentrado em forma esférica.");
        Jutsu jutsu2 = new Jutsu("Chidori", 60, 25, "Jutsu de ataque com chakra concentrado no braço.");

        Personagem personagem1 = new Personagem("Naruto", 17, "Aldeia da Folha", 100) {
            @Override
            public void atacar(Personagem inimigo, String nomeJutsu) {

            }

            @Override
            public void defender(Jutsu jutsu) {

            }
        };
        personagem1.adicionarJutsu(jutsu1.getNome());
        personagem1.adicionarJutsu(jutsu2.getNome());

        personagemRepository.save(personagem1);
    }
}
