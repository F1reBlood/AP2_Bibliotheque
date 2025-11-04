package Controller;

import Model.Livre;
import Model.SqlConnector;
import View.CatalogueGUI;

import javax.swing.*;
import java.util.ArrayList;

public class CatalogueController {
    private CatalogueGUI view;
    private SqlConnector model;
    private ArrayList<Livre> livres;
    private DefaultListModel<String> listElements;

    public CatalogueController(CatalogueGUI view, SqlConnector model) {
        livres = model.getListLivres();
        listElements = view.getListElements();
        for (Livre livre : livres) {
            if (livre.isDispo()){
                listElements.addElement(livre.getISBN() + " | " + livre.getTitre() + ", " + livre.getAuteur().getPrenom() + " " + livre.getAuteur().getNom() + " | Disponible");
            }
            else{
                listElements.addElement(livre.getISBN() + " | " + livre.getTitre() + ", " + livre.getAuteur().getPrenom() + " " + livre.getAuteur().getNom() + " | Indisponible");
            }

        }
    }
}
