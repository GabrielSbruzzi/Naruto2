package com.naruto.Naruto;

import com.naruto.Naruto.entity.NinjaDeGenjutsu;
import com.naruto.Naruto.entity.NinjaDeNinjutsu;
import com.naruto.Naruto.entity.NinjaDeTaijutsu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.naruto.Naruto.entity")
public class NarutoApplication {
    public static void main(String[] args) {
        SpringApplication.run(NarutoApplication.class, args);

        NinjaDeTaijutsu ninjaTaijutsu = new NinjaDeTaijutsu("Rock Lee", 16, "Aldeia da Folha", 100);
        ninjaTaijutsu.adicionarJutsu("Lariato");
        ninjaTaijutsu.aumentarChakra(20);
        ninjaTaijutsu.exibirInformacoes();
        ninjaTaijutsu.usarJutsu();
        ninjaTaijutsu.desviar();

        NinjaDeNinjutsu ninjaNinjutsu = new NinjaDeNinjutsu("Naruto Uzumaki", 17, "Aldeia da Folha", 100);
        ninjaNinjutsu.adicionarJutsu("Rasengan");
        ninjaNinjutsu.aumentarChakra(50);
        ninjaNinjutsu.exibirInformacoes();
        ninjaNinjutsu.usarJutsu();
        ninjaNinjutsu.desviar();

        NinjaDeGenjutsu ninjaGenjutsu = new NinjaDeGenjutsu("Itachi Uchiha", 21, "Aldeia da Folha", 100);
        ninjaGenjutsu.adicionarJutsu("Tsukuyomi");
        ninjaGenjutsu.aumentarChakra(30);
        ninjaGenjutsu.exibirInformacoes();
        ninjaGenjutsu.usarJutsu();
        ninjaGenjutsu.desviar();
    }
}