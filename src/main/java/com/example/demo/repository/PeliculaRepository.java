package com.example.demo.repository;

import com.example.demo.model.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends MongoRepository<Pelicula, String> {

}
