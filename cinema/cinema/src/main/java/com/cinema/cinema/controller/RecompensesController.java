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

import com.cinema.cinema.model.Realisateurs;
import com.cinema.cinema.model.Recompenses;
import com.cinema.cinema.repository.RealisateursRepository;
import com.cinema.cinema.repository.RecompensesRepository;

@RestController
public class RecompensesController {
  private final RecompensesRepository recompensesRepository;

  RecompensesController(RecompensesRepository recompensesRepository) {
    this.recompensesRepository = recompensesRepository;
  }

    @PostMapping("/recompenses")
    public ResponseEntity<Recompenses> createRealisateurs(@RequestBody Recompenses newRecompenses) {
        Recompenses recompenses = recompensesRepository.save(newRecompenses);
        return new ResponseEntity<>(recompenses, HttpStatus.CREATED);
    }

    @GetMapping("/recompenses")
    public List<Recompenses> getAllRealisateurs() {
        return recompensesRepository.findAll();
    }

    @GetMapping("/recompenses/{id}")
    public ResponseEntity<Recompenses> getFilmById(@PathVariable Long id) {
        java.util.Optional<Recompenses> recompenses = recompensesRepository.findById(id);
        return recompenses.map(ResponseEntity::ok)
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/recompenses/{id}")
    public ResponseEntity<Recompenses> updateFilm(@RequestBody Recompenses updatedRecompenses, @PathVariable Long id) {
      java.util.Optional<Recompenses> optionalRecompenses = recompensesRepository.findById(id);

        if (optionalRecompenses.isPresent()) {
            Recompenses recompenses = optionalRecompenses.get();
            recompenses.setNom(updatedRecompenses.getNom());
            recompenses.setDate(updatedRecompenses.getDate());        
            
            recompensesRepository.save(recompenses);
            return new ResponseEntity<>(recompenses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/recompenses/{id}")
    public ResponseEntity<Void> deleteRecompenses(@PathVariable Long id) {
        if (recompensesRepository.existsById(id)) {
            recompensesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
