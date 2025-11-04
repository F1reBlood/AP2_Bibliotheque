package Controller;

import Model.Adherant;
import Model.Livre;
import Model.SqlConnector;
import View.RestituerGUI;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RestituerController {
    private RestituerGUI view;
    private SqlConnector model;
    private ArrayList<Livre> listLivre;
    private ArrayList<Adherant> listAdherant;
    private Livre currentLivre;
    private Adherant currentAdherant;


    public RestituerController(RestituerGUI view, SqlConnector model) {
        this.view = view;
        this.model = model;

        listAdherant = model.getListAdherants();
        listLivre =  model.getListLivres();

        view.getBtnRestituer().addActionListener(e -> {
            for (Adherant adherant : listAdherant) {
                if (view.getIdTextField().getText().equals(adherant.getIdentifiant())){
                    currentAdherant = adherant;
                    System.out.println("ok");
                }
            }
            for  (Livre livre : listLivre) {
                if (view.getIsbnTextField().getText().equals(livre.getISBN())){
                    currentLivre = livre;
                }
            }

            if (currentAdherant != null){
                if (currentLivre != null){
                    if (!currentLivre.isDispo()) {
                        if (currentLivre.getAdherant().equals(currentAdherant)) {
                            currentLivre.setAdherant(currentAdherant);
                            currentAdherant.getListLivres().add(currentLivre);

                            try {
                                Statement stmt = model.getConnection().createStatement();
                                stmt.executeUpdate("update livre set adherantId = null" + " where ISBN like '" + currentLivre.getISBN() + "'");
                                currentAdherant = null;
                                currentLivre = null;
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                            JOptionPane.showMessageDialog(null, "Le livre a bien été restitué", "Information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Le livre est emprunté par un autre adhérant", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Le livre n'est pas emprunté", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "L'ISBN du livre est invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "L'identifiant de l'adhérant est invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
