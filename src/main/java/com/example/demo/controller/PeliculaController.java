package com.example.demo.controller;

import com.example.demo.model.Pelicula;
import com.example.demo.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/film-app")
public class PeliculaController {

    @Autowired
    private PeliculaRepository repository; //llamamos al repositorio

    //crear una nueva pelicula en la base de datos
    @PostMapping("/peliculas")
    public Pelicula create(@Validated @RequestBody Pelicula p) {

        for(Pelicula pelicula : repository.findAll()){

            if(pelicula.getTitulo().equals(p.getTitulo())){
                
                return null;
            }
        }

        return repository.insert(p);
    }

    //mostrar todas las peliculas
    @GetMapping("/peliculas")
    public List<Pelicula> readAll() {
        return repository.findAll();
    }

    //mostrar la pelicula con el id en el path
    @GetMapping("/peliculas/{id}")
    public Optional<Pelicula> readFilmById(@PathVariable String id) {

        return repository.findById(id);
    }

    //mostrar la pelicula con el titulo en el path
    @GetMapping("/peliculas/titulo/{titulo}")
    public Pelicula readFilmByTitle(@PathVariable String titulo){

        for (Pelicula pelicula : repository.findAll()) {
            if (pelicula.getTitulo().equals(titulo)) {
                return pelicula;

            }
        }
        return null;
    }

    //mostrar las peliculas donde aparece un actor en concreto
    @GetMapping("/peliculas/actor/{actor}")
    public List<Pelicula> readFilmByActor(@PathVariable String actor) {
        List<Pelicula> filmList = new ArrayList<>();
        for (Pelicula pelicula : repository.findAll()) {
            for (String a : pelicula.getActores()) {
                if (a.equals(actor)) {
                    filmList.add(pelicula);
                }
            }
        }

        if (filmList.isEmpty()) //si la lista esta vacia retornamos null
            return null;
        else
            return filmList;

    }

    //eliminar una pelicula por su id
    @DeleteMapping("/peliculas/{id}")
    public void delete(@PathVariable String id) {

        repository.deleteById(id);
    }


}
