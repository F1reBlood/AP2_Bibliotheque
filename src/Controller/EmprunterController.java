package Controller;

import Model.Adherant;
import Model.Livre;
import Model.SqlConnector;
import View.EmprunterGUI;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmprunterController {
    private EmprunterGUI view;
    private SqlConnector model;
    private ArrayList<Adherant> listAdherant;
    private ArrayList<Livre> listLivre;
    private Adherant currentAdherant;
    private Livre currentLivre;

    public EmprunterController(EmprunterGUI view, SqlConnector model) {
        this.view = view;
        this.model = model;

        listAdherant = model.getListAdherants();
        listLivre =  model.getListLivres();

        view.getBtnEmprunter().addActionListener(e -> {
            for (Adherant adherant : listAdherant) {
                if (view.getIdTextField().getText().equals(adherant.getIdentifiant())){
                    currentAdherant = adherant;
                }
            }
            for  (Livre livre : listLivre) {
                if (view.getIsbnTextField().getText().equals(livre.getISBN())){
                    currentLivre = livre;
                }
            }

            if (currentAdherant != null){
                if (currentLivre != null){
                    if (currentLivre.isDispo()){
                        currentLivre.setAdherant(currentAdherant);
                        currentAdherant.getListLivres().add(currentLivre);

                        try {
                            Statement stmt = model.getConnection().createStatement();
                            stmt.executeUpdate("update livre set adherantId = '" + currentAdherant.getIdentifiant() + "'" + " where ISBN like '" + currentLivre.getISBN()+"'");
                            currentAdherant = null;
                            currentLivre = null;
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                        JOptionPane.showMessageDialog(null, "Le livre a bien été emprunté", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Le livre est déjà emprunté", "Erreur", JOptionPane.ERROR_MESSAGE);
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
