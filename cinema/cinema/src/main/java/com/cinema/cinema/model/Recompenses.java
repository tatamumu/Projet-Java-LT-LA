package com.cinema.cinema.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "recompenses")
public class Recompenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "date_recompense", nullable = false)
    @Temporal(TemporalType.DATE)
    private int date;


    // Constructeurs

    public Recompenses() {
    }

    public Recompenses(String nom, int date) {
        this.nom = nom;
        this.date = date;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

   
    // toString, equals, and hashCode (optionnel)

    @Override
    public String toString() {
        return "Recompense{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", date=" + date +
                '}';
    }

}
