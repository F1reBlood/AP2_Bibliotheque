package Model;

public class Adherant {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;

    public Adherant(String identifiant, String nom, String prenom, String email) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
}
