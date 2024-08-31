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

import com.cinema.cinema.model.Acteurs;
import com.cinema.cinema.model.Compagnies;
import com.cinema.cinema.repository.ActeursRepository;
import com.cinema.cinema.repository.CompagniesRepository;

@RestController
public class CompagniesController {

private final CompagniesRepository compagniesRepository;

CompagniesController(CompagniesRepository compagniesRepository) {
    this.compagniesRepository = compagniesRepository;
  }


    @PostMapping("/compagnies")
    public ResponseEntity<Compagnies> createCompagnies(@RequestBody Compagnies newCompagnies) {
        Compagnies compagnies = compagniesRepository.save(newCompagnies);
        return new ResponseEntity<>(compagnies, HttpStatus.CREATED);
    }

 
    @GetMapping("/compagnies")
    public List<Compagnies> getAllCompagnies() {
        return compagniesRepository.findAll();
    }

    @GetMapping("/compagnies/{id}")
    public ResponseEntity<Compagnies> getCompagniesById(@PathVariable Long id) {
        java.util.Optional<Compagnies> compagnies = compagniesRepository.findById(id);
        return compagnies.map(ResponseEntity::ok)
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PutMapping("/compagnies/{id}")
    public ResponseEntity<Compagnies> updateCompagnies(@RequestBody Compagnies updatedCompagnies, @PathVariable Long id) {
      java.util.Optional<Compagnies> optionalCompagnies = compagniesRepository.findById(id);

        if (optionalCompagnies.isPresent()) {
            Compagnies compagnies = optionalCompagnies.get();
            compagnies.setNom(updatedCompagnies.getNom());
            compagnies.setAdresse(updatedCompagnies.getAdresse());
            compagnies.setPays(updatedCompagnies.getPays());
            compagnies.setContact(updatedCompagnies.getContact());
            compagnies.setActivite(updatedCompagnies.getActivite());
            compagnies.setListeEmployes(updatedCompagnies.getListeEmployes());

            compagniesRepository.save(compagnies);
            return new ResponseEntity<>(compagnies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/compagnies/{id}")
    public ResponseEntity<Void> deleteCompagnies(@PathVariable Long id) {
        if (compagniesRepository.existsById(id)) {
            compagniesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
