package Model;

public class Livre {
    private String ISBN;
    private String titre;
    private float prix;
    private String adherantId;
    private String auteurId;

    public Livre(String ISBN, String titre, float prix, String adherantId, String auteurId) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.prix = prix;
        this.adherantId = adherantId;
        this.auteurId = auteurId;
    }

    public String getAuteurId() {
        return auteurId;
    }
    public void setAuteurId(String auteurId) {
        this.auteurId = auteurId;
    }

    public String getAdherantId() {
        return adherantId;
    }
    public void setAdherantId(String adherantId) {
        this.adherantId = adherantId;
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
