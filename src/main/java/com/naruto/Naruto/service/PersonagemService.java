package com.naruto.Naruto.service;

import com.naruto.Naruto.entity.Personagem;
import com.naruto.Naruto.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    private final PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public Personagem adicionarPersonagem(Personagem personagem) {
        try {
            return personagemRepository.save(personagem);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar personagem: " + e.getMessage(), e);
        }
    }

    public List<Personagem> listarPersonagens() {
        try {
            return personagemRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar personagens: " + e.getMessage(), e);
        }
    }

    public Personagem buscarPersonagem(String nome) {
        return Optional.ofNullable(personagemRepository.findByNome(nome))
                .orElseThrow(() -> new RuntimeException("Personagem com nome '" + nome + "' não encontrado."));
    }

    public void adicionarJutsu(String nomePersonagem, String nomeJutsu) {
        try {
            Personagem personagem = buscarPersonagem(nomePersonagem);
            personagem.adicionarJutsu(nomeJutsu);
            personagemRepository.save(personagem);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar jutsu para o personagem: " + e.getMessage(), e);
        }
    }

    public void aumentarChakra(String nomePersonagem, int quantidade) {
        try {
            Personagem personagem = buscarPersonagem(nomePersonagem);
            personagem.aumentarChakra(quantidade);
            personagemRepository.save(personagem);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao aumentar chakra para o personagem: " + e.getMessage(), e);
        }
    }
}
