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

import com.cinema.cinema.model.Employes;
import com.cinema.cinema.model.Films;
import com.cinema.cinema.repository.EmployesRepository;
import com.cinema.cinema.repository.FilmsRepository;

@RestController
public class EmployesController {
  private final EmployesRepository repository;

  EmployesController(EmployesRepository repository) {
    this.repository = repository;
  }

    @PostMapping("/employes")
    public ResponseEntity<Employes> createEmp(@RequestBody Employes newEmployes) {
        Employes employes = repository.save(newEmployes);
        return new ResponseEntity<>(employes, HttpStatus.CREATED);
    }

    @GetMapping("/employes")
    public List<Employes> getAllEmployes() {
        return repository.findAll();
    }

    @GetMapping("/employes/{id}")
    public ResponseEntity<Employes> getEmployesById(@PathVariable Long id) {
        java.util.Optional<Employes> employes = repository.findById(id);
        return employes.map(ResponseEntity::ok)
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/employes/{id}")
    public ResponseEntity<Employes> updateEmp(@RequestBody Employes updatedEmployes, @PathVariable Long id) {
      java.util.Optional<Employes> optionalEmployes = repository.findById(id);

        if (optionalEmployes.isPresent()) {
            Employes employes = optionalEmployes.get();
            employes.setNom(updatedEmployes.getNom());
            employes.setPrenom(updatedEmployes.getPrenom());
            employes.setPays(updatedEmployes.getPays());
            employes.setContact(updatedEmployes.getContact());
            employes.setPoste(updatedEmployes.getPoste());
            employes.setIdEntreprise(updatedEmployes.getIdEntreprise());

            repository.save(employes);
            return new ResponseEntity<>(employes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employes/{id}")
    public ResponseEntity<Void> deleteEmployes(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
