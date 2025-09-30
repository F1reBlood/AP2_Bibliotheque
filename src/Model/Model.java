package Model;

import java.util.ArrayList;

public class Model {
    private ArrayList<Auteur> listAuteurs;
    private ArrayList<Livre> listLivres;
    private ArrayList<Adherant> listAdherants;

    public Model() {

    }

    public ArrayList<Auteur> getListAuteurs() {
        return listAuteurs;
    }
    public void setListAuteurs(ArrayList<Auteur> listAuteurs) {
        this.listAuteurs = listAuteurs;
    }

    public ArrayList<Livre> getListLivres() {
        return listLivres;
    }
    public void setListLivres(ArrayList<Livre> listLivres) {
        this.listLivres = listLivres;
    }

    public ArrayList<Adherant> getListAdherants() {
        return listAdherants;
    }
    public void setListAdherants(ArrayList<Adherant> listAdherants) {
        this.listAdherants = listAdherants;
    }
}
