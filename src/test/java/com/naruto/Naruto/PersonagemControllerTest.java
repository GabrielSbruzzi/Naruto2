package com.naruto.Naruto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naruto.Naruto.entity.Personagem;
import com.naruto.Naruto.entity.Jutsu;
import com.naruto.Naruto.service.PersonagemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonagemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonagemService personagemService;

    private ObjectMapper objectMapper;
    private Personagem personagem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();

        // Criando um personagem genérico para os testes
        personagem = new Personagem("Naruto", 16, "Aldeia da Folha", 100, 100) {
            @Override
            public void atacar(Personagem inimigo, String nomeJutsu) {
                // Implementação mockada para o teste
            }

            @Override
            public void defender(Jutsu jutsu) {
                // Implementação mockada para o teste
            }
        };
    }

    @Test
    void testarListarPersonagens() throws Exception {
        when(personagemService.listarPersonagens()).thenReturn(Collections.singletonList(personagem));

        mockMvc.perform(get("/personagens"))
                .andExpect(status().isOk())  // Verifica se o status é 200 (OK)
                .andExpect(jsonPath("$[0].nome").value("Naruto"));  // Verifica o nome do primeiro personagem

        verify(personagemService, times(1)).listarPersonagens();
    }

    @Test
    void testarListarPersonagensVazio() throws Exception {
        when(personagemService.listarPersonagens()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/personagens"))
                .andExpect(status().isOk())  // Verifica se o status é 200 (OK)
                .andExpect(jsonPath("$").isEmpty());  // Verifica se a lista está vazia

        verify(personagemService, times(1)).listarPersonagens();
    }

    @Test
    void testarBuscarPersonagem() throws Exception {
        when(personagemService.buscarPersonagem("Naruto")).thenReturn(personagem);

        mockMvc.perform(get("/personagens/Naruto"))
                .andExpect(status().isOk())  // Verifica se o status é 200 (OK)
                .andExpect(jsonPath("$.nome").value("Naruto"));  // Verifica o nome do personagem

        verify(personagemService, times(1)).buscarPersonagem("Naruto");
    }

    @Test
    void testarBuscarPersonagemNaoEncontrado() throws Exception {
        when(personagemService.buscarPersonagem("Sasuke")).thenReturn(null);

        mockMvc.perform(get("/personagens/Sasuke"))
                .andExpect(status().isNotFound());  // Espera o status 404 (Not Found)

        verify(personagemService, times(1)).buscarPersonagem("Sasuke");
    }

    @Test
    void testarAdicionarJutsu() throws Exception {
        Jutsu jutsu = new Jutsu("Rasengan", "Jutsu de chakra em espiral", 50, 20);

        doNothing().when(personagemService).adicionarJutsu(eq("Naruto"), eq("Rasengan"));

        mockMvc.perform(post("/personagens/Naruto/adicionarJutsu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jutsu)))  // Passando o objeto Jutsu corretamente
                .andExpect(status().isOk());  // Espera o status 200 (OK)

        verify(personagemService, times(1)).adicionarJutsu(eq("Naruto"), eq("Rasengan"));
    }


    @Test
    void testarAdicionarJutsuPersonagemNaoEncontrado() throws Exception {
        Jutsu jutsu = new Jutsu("Chidori", "Jutsu relâmpago", 50, 20);

        doThrow(new RuntimeException("Personagem não encontrado")).when(personagemService).adicionarJutsu(eq("Sasuke"), eq("Chidori"));

        mockMvc.perform(post("/personagens/Sasuke/adicionarJutsu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jutsu)))
                .andExpect(status().isInternalServerError());  // Espera o erro 500 (Internal Server Error)

        verify(personagemService, times(1)).adicionarJutsu(eq("Sasuke"), eq("Chidori"));
    }

    @Test
    void testarAumentarChakra() throws Exception {
        doNothing().when(personagemService).aumentarChakra(eq("Naruto"), eq(50));

        mockMvc.perform(post("/personagens/Naruto/aumentarChakra")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("50"))
                .andExpect(status().isOk());  // Espera o status 200 (OK)

        verify(personagemService, times(1)).aumentarChakra(eq("Naruto"), eq(50));
    }
}
