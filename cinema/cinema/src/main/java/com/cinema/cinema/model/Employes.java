package com.cinema.cinema.model;


import jakarta.persistence.*;

@Entity
@Table(name = "employes")
public class Employes {

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

    @Column(name = "poste", nullable = false)
    private String poste;

    private int idEntreprise;
    // Constructeurs

    public Employes() {
    }

    public Employes(String nom, String prenom, String pays, String contact, String poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.contact = contact;
        this.poste = poste;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }
    
    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
    

    // toString, equals, and hashCode (optionnel)

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", pays='" + pays + '\'' +
                ", contact='" + contact + '\'' +
                ", poste='" + poste + '\'' +
                '}';
    }
}

