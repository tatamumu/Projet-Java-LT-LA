package com.cinema.cinema.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "acteurs")
public class Acteurs {

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

   
    private List<Long> recompenses;

    @Column(name = "cachet", nullable = false)
    private BigDecimal cachet;

    // Constructeurs

    public Acteurs() {
    }

    public Acteurs(String nom, String prenom, String pays, String contact, List<Long> recompenses, BigDecimal cachet) {
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.contact = contact;
        this.recompenses = recompenses;
        this.cachet = cachet;
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
        return recompenses;
    }

    public void setRecompenses(List<Long> recompenses) {
        this.recompenses = recompenses;
    }

    public BigDecimal getCachet() {
        return cachet;
    }

    public void setCachet(BigDecimal cachet) {
        this.cachet = cachet;
    }

    // toString, equals, and hashCode (optionnel)

    @Override
    public String toString() {
        return "Acteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", pays='" + pays + '\'' +
                ", contact='" + contact + '\'' +
                ", recompenses=" + recompenses +
                ", cachet=" + cachet +
                '}';
    }
}
