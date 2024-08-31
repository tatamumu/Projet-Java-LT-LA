package com.cinema.cinema.model;

    import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "compagnies")
public class Compagnies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "pays", nullable = false)
    private String pays;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "activite", nullable = false)
    private String activite;

    private List<Long> listeEmployes;

    // Constructeurs

    public Compagnies() {
    }

    public Compagnies(String nom, String pays, String adresse, String contact, String activite, List<Long>  listeEmployes) {
        this.nom = nom;
        this.pays = pays;
        this.adresse = adresse;
        this.contact = contact;
        this.activite = activite;
        this.listeEmployes = listeEmployes;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public List<Long> getListeEmployes() {
        return listeEmployes;
    }
    
    public void setListeEmployes(List<Long> listeEmployes) {
        this.listeEmployes = listeEmployes;
    }
    // toString, equals, and hashCode (optionnel)

    @Override
    public String toString() {
        return "Compagnie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                ", adresse='" + adresse + '\'' +
                ", contact='" + contact + '\'' +
                ", activite='" + activite + '\'' +
                '}';
    }

}
