package Model;

import java.util.ArrayList;

public class Adherant {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private ArrayList<Livre> listLivres;

    public Adherant(String identifiant, String nom, String prenom, String email) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.listLivres = new ArrayList<Livre>();
    }

    public String getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Livre> getListLivres() {
        return listLivres;
    }
    public void setListLivres(ArrayList<Livre> listLivres) {
        this.listLivres = listLivres;
    }
}
