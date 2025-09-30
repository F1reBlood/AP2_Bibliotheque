package Model;

public class Livre {
    private String ISBN;
    private String titre;
    private float prix;
    private Adherant adherant;
    private Auteur auteur;

    public Livre(String ISBN, String titre, float prix, Adherant adherant, Auteur auteur) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.prix = prix;
        this.adherant = adherant;
        this.auteur = auteur;
    }

    public Auteur getAuteur() {
        return auteur;
    }
    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public Adherant getAdherant() {
        return adherant;
    }
    public void setAdherant(Adherant adherant) {
        this.adherant = adherant;
    }

    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
