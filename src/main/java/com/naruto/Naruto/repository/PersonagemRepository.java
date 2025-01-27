package com.naruto.Naruto.repository;

import com.naruto.Naruto.entity.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    Personagem findByNome(String nome);
}
