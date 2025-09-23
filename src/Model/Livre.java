package Model;

public class Livre {
    private String ISBN;
    private String titre;
    private float prix;
    private String adherantId;
    private Auteur auteur;

    public Livre(String ISBN, String titre, float prix, String adherantId, Auteur auteur) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.prix = prix;
        this.adherantId = adherantId;
        this.auteur = auteur;

    }
}
