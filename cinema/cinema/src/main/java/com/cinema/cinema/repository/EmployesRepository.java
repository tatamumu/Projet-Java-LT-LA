package com.cinema.cinema.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinema.model.Employes;

public interface EmployesRepository extends JpaRepository<Employes, Long> {

}