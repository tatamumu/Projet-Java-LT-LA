package com.cinema.cinema.controller;
import java.util.List;

import org.apache.el.stream.Optional;
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
class FilmsController {

  private final FilmsRepository repository;

  FilmsController(FilmsRepository repository) {
    this.repository = repository;
  }

    @PostMapping("/films")
    public ResponseEntity<Films> createFilm(@RequestBody Films newFilm) {
        Films film = repository.save(newFilm);
        return new ResponseEntity<>(film, HttpStatus.CREATED);
    }

    @GetMapping("/films")
    public List<Films> getAllFilms() {
        return repository.findAll();
    }

    @GetMapping("/films/{id}")
    public ResponseEntity<Films> getFilmById(@PathVariable Long id) {
        java.util.Optional<Films> film = repository.findById(id);
        return film.map(ResponseEntity::ok)
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/films/{id}")
    public ResponseEntity<Films> updateFilm(@RequestBody Films updatedFilm, @PathVariable Long id) {
      java.util.Optional<Films> optionalFilm = repository.findById(id);

        if (optionalFilm.isPresent()) {
            Films film = optionalFilm.get();
            film.setNom(updatedFilm.getNom());
            film.setDate(updatedFilm.getDate());
            film.setGenre(updatedFilm.getGenre());
            film.setBudget(updatedFilm.getBudget());
            repository.save(film);
            return new ResponseEntity<>(film, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/films/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}