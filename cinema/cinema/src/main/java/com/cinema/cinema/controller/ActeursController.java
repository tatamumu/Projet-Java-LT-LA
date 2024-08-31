package com.cinema.cinema.controller;

import java.util.List;

import com.cinema.cinema.model.Acteurs;
import com.cinema.cinema.repository.ActeursRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.cinema.model.Films;
import com.cinema.cinema.repository.FilmsRepository;


@RestController
public class ActeursController {

    
private final ActeursRepository acteursrepository;

  ActeursController(ActeursRepository repository) {
    this.acteursrepository = repository;
  }


    @PostMapping("/acteurs")
    public ResponseEntity<Acteurs> createFilm(@RequestBody Acteurs newActeurs) {
        Acteurs acteurs = acteursrepository.save(newActeurs);
        return new ResponseEntity<>(acteurs, HttpStatus.CREATED);
    }

 
    @GetMapping("/acteurs")
    public List<Acteurs> getAllActeurs() {
        return acteursrepository.findAll();
    }

    @GetMapping("/acteurs/{id}")
    public ResponseEntity<Acteurs> getActeursById(@PathVariable Long id) {
        java.util.Optional<Acteurs> film = acteursrepository.findById(id);
        return film.map(ResponseEntity::ok)
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/acteurs/{id}")
    public ResponseEntity<Acteurs> updateActeurs(@RequestBody Acteurs updatedActeurs, @PathVariable Long id) {
      java.util.Optional<Acteurs> optionalActeurs = acteursrepository.findById(id);

        if (optionalActeurs.isPresent()) {
            Acteurs acteurs = optionalActeurs.get();
            acteurs.setNom(updatedActeurs.getNom());
            acteurs.setPrenom(updatedActeurs.getPrenom());
            acteurs.setPays(updatedActeurs.getPays());
            acteurs.setContact(updatedActeurs.getContact());
            acteursrepository.save(acteurs);
            return new ResponseEntity<>(acteurs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/acteurs/{id}")
    public ResponseEntity<Void> deleteActeurs(@PathVariable Long id) {
        if (acteursrepository.existsById(id)) {
            acteursrepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
