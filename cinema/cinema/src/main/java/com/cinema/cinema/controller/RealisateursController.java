package com.cinema.cinema.controller;
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
import org.springframework.web.bind.annotation.RestController;

import com.cinema.cinema.model.Films;
import com.cinema.cinema.model.Realisateurs;
import com.cinema.cinema.repository.FilmsRepository;
import com.cinema.cinema.repository.RealisateursRepository;

@RestController
public class RealisateursController {
  private final RealisateursRepository realisateursRepository;

  RealisateursController(RealisateursRepository realisateursRepository) {
    this.realisateursRepository = realisateursRepository;
  }

    @PostMapping("/realisateurs")
    public ResponseEntity<Realisateurs> createRealisateurs(@RequestBody Realisateurs newRealisateurs) {
        Realisateurs realisateurs = realisateursRepository.save(newRealisateurs);
        return new ResponseEntity<>(realisateurs, HttpStatus.CREATED);
    }

    @GetMapping("/realisateurs")
    public List<Realisateurs> getAllRealisateurs() {
        return realisateursRepository.findAll();
    }

    @GetMapping("/realisateurs/{id}")
    public ResponseEntity<Realisateurs> getFilmById(@PathVariable Long id) {
        java.util.Optional<Realisateurs> realisateurs = realisateursRepository.findById(id);
        return realisateurs.map(ResponseEntity::ok)
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/realisateurs/{id}")
    public ResponseEntity<Realisateurs> updateFilm(@RequestBody Realisateurs updatedRealisateurs, @PathVariable Long id) {
      java.util.Optional<Realisateurs> optionalRealisateurs = realisateursRepository.findById(id);

        if (optionalRealisateurs.isPresent()) {
            Realisateurs realisateurs = optionalRealisateurs.get();
            realisateurs.setNom(updatedRealisateurs.getNom());
            realisateurs.setPrenom(updatedRealisateurs.getPrenom());
            realisateurs.setPays(updatedRealisateurs.getPays());
            realisateurs.setContact(updatedRealisateurs.getContact());
            realisateurs.setRecompenses(updatedRealisateurs.getRecompenses());

            realisateursRepository.save(realisateurs);
            return new ResponseEntity<>(realisateurs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/realisateurs/{id}")
    public ResponseEntity<Void> deleteRealisateurs(@PathVariable Long id) {
        if (realisateursRepository.existsById(id)) {
            realisateursRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
