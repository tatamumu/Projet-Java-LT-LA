package com.cinema.cinema.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Films {

    private @Id
    @GeneratedValue Long id;

    private String nom;

    private Date date;

    private String genre;

    private int budget;

    private List<Long> idActeurs;

    // Constructeurs

    public Films() {
    }

    public Films(String nom, Date date, String genre, int budget,List<Long> idActeurs) {
        this.nom = nom;
        this.date = date;
        this.genre = genre;
        this.budget = budget;
        this.idActeurs = idActeurs;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Long> getActeurs() {
        return idActeurs;
    }
    
    public void setActeurs(List<Long> acteurs) {
        this.idActeurs = acteurs;
    }
    
    // toString, equals, and hashCode (optionnel)

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", date=" + date +
                ", genre='" + genre + '\'' +
                ", budget=" + budget +
                '}';
    }
}
