package com.example.demo;

import com.example.demo.controller.PeliculaController;
import com.example.demo.model.Pelicula;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class PeliculaApp {

    public static void main(String[] args) {
        SpringApplication.run(PeliculaApp.class, args);
    }

    @Bean
    CommandLineRunner runner(PeliculaController repository) {
        return args -> {

            //creamos una serie de arraylist para los actores de las peliculas de ejemplo
            ArrayList<String> actoresTitanic = new ArrayList<>();
            actoresTitanic.add("Leonardo DiCaprio");
            actoresTitanic.add("Kate Winslet");

            ArrayList<String> actoresPulpFiction = new ArrayList<>();
            actoresPulpFiction.add("John Travolta");
            actoresPulpFiction.add("Samuel L Jackson");
            actoresPulpFiction.add("Uma Thurman");

            ArrayList<String> actoresOUATIH = new ArrayList<>();
            actoresOUATIH.add("Leonardo DiCaprio");
            actoresOUATIH.add("Brad Pitt");
            actoresOUATIH.add("Margot Robbie");

            //creamos algunas peliculas de muestra para comprobar que funciona y se guarda en la base de datos
            Pelicula pelicula = new Pelicula("Titanic", actoresTitanic, "Drama", 1997);
            Pelicula pelicula2 = new Pelicula("Pulp Fiction", actoresPulpFiction, "Crimen, Comedia Negra", 1994);
            Pelicula pelicula3 = new Pelicula("Once Upon A Time In Hollywood", actoresOUATIH, "Crimen, Comedia Negra, Drama", 2019);

            //comprobamos que funciona la llamada POST
            repository.create(pelicula);
            repository.create(pelicula2);
            repository.create(pelicula3);

        };


    }
}
