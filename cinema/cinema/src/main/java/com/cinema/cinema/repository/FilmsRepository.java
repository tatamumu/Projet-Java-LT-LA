package com.cinema.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinema.model.Films;

public interface FilmsRepository extends JpaRepository<Films, Long> {

}

