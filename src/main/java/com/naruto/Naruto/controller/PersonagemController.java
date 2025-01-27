package com.naruto.Naruto.controller;

import com.naruto.Naruto.entity.Personagem;
import com.naruto.Naruto.entity.Jutsu;
import com.naruto.Naruto.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping("/personagens")
    public ResponseEntity<Personagem> adicionarPersonagem(@RequestBody Personagem personagem) {
        Personagem novoPersonagem = personagemService.adicionarPersonagem(personagem);
        return new ResponseEntity<>(novoPersonagem, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Personagem>> listarPersonagens() {
        return ResponseEntity.ok(personagemService.listarPersonagens());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Personagem> buscarPersonagem(@PathVariable String nome) {
        Personagem personagem = personagemService.buscarPersonagem(nome);
        if (personagem != null) {
            return ResponseEntity.ok(personagem);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{nome}/adicionarJutsu")
    public ResponseEntity<Void> adicionarJutsu(@PathVariable String nome, @RequestBody Jutsu jutsu) {
        personagemService.adicionarJutsu(nome, jutsu.getNome());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{nome}/aumentarChakra")
    public ResponseEntity<Void> aumentarChakra(@PathVariable String nome, @RequestBody int quantidade) {
        personagemService.aumentarChakra(nome, quantidade);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

}
