package com.cinema.cinema.model;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.JoinColumns;

import java.util.List;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "realisateurs")
public class Realisateurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "pays", nullable = false)
    private String pays;

    @Column(name = "contact", nullable = false)
    private String contact;
 
    private List<Long> idRecompenses;

    // Constructeurs

    public Realisateurs() {
    }

    public Realisateurs(String nom, String prenom, String pays, String contact){
        // List<String> recompenses) {
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.contact = contact;
        //this.recompenses = recompenses;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Long> getRecompenses() {
        return idRecompenses;
    }
    
    public void setRecompenses(List<Long> idRecompenses) {
        this.idRecompenses = idRecompenses;
    }
    

    @Override
    public String toString() {
        return "Realisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", pays='" + pays + '\'' +
                ", contact='" + contact + '\'' +
                //", recompenses=" + recompenses +
                '}';
    }
}