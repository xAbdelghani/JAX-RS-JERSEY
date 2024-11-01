package net.abdelghani.jaxrx_tp;

import net.abdelghani.jaxrx_tp.entities.Compte;
import net.abdelghani.jaxrx_tp.entities.TypeCompte;
import net.abdelghani.jaxrx_tp.repositry.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JaxRxTpApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaxRxTpApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner(CompteRepository compteRepository) {
        return args -> {

            compteRepository.save(Compte.builder().prix(Math.random()*8000).dateCreation(new Date()).type(TypeCompte.COURANT).build());
            compteRepository.save(Compte.builder().prix(Math.random()*8000).dateCreation(new Date()).type(TypeCompte.EPARGNE).build());
            compteRepository.save(Compte.builder().prix(Math.random()*8000).dateCreation(new Date()).type(TypeCompte.COURANT).build());


            compteRepository.findAll().forEach(System.out::println);
        };
    }
}
