/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.entites;

/**
 *
 * @author etudiant
 */
public class Visiteur {
    private  String matricule;
    private String nom;
    private String prenom;

    public Visiteur(String matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public Visiteur() {
        
    }
    
    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    @Override
    public String toString() {
        return "Matricule:"+this.matricule+"nom:"+this.nom+"prenom"+this.prenom;
    }
    
    
    
    
    
}
