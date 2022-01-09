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
            actoresPulpFiction.add("Bruce Willis");

            ArrayList<String> actoresELDWS= new ArrayList<>();
            actoresELDWS.add("Leonardo DiCaprio");
            actoresELDWS.add("Jonah Hill");
            actoresELDWS.add("Margot Robbie");
            
            ArrayList<String> actoresESDLC= new ArrayList<>();
            actoresESDLC.add("Anthony Hopkins");
            actoresESDLC.add("Jodi Foster");
            

            //creamos algunas peliculas de muestra para comprobar que funciona y se guarda en la base de datos
            Pelicula pelicula = new Pelicula("Titanic", actoresTitanic, "Drama", 1997);
            Pelicula pelicula2 = new Pelicula("Pulp Fiction", actoresPulpFiction, "Crimen, Comedia Negra", 1994);
            Pelicula pelicula3 = new Pelicula("El Lobo de Wall Street", actoresELDWS, "Biografica, Comedia Negra", 2013);
            Pelicula pelicula4 = new Pelicula("El Silencio de los Corderos", actoresESDLC, "Thriller, Terror, Drama", 1991);
            

            //comprobamos que funciona la llamada POST
            repository.create(pelicula);
            repository.create(pelicula2);
            repository.create(pelicula3);
            repository.create(pelicula4);
            
            

        };


    }
}
