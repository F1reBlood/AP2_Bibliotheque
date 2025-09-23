package Model;

public class Auteur {
    private String id;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String description;

    public Auteur(String id, String nom, String prenom, String date_naissance, String description) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.description = description;

    }
}
