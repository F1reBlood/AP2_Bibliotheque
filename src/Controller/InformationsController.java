package Controller;

import Model.Adherant;
import Model.Livre;
import Model.SqlConnector;
import View.InformationsGUI;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InformationsController {
    private InformationsGUI view;
    private SqlConnector model;
    private Adherant currentAdherant;
    private ArrayList<Adherant> listAdherant;
    private ArrayList<Livre> listLivre;

    public InformationsController(InformationsGUI InformationsGUI, SqlConnector model) {
        this.view = InformationsGUI;
        this.model = model;

        listAdherant = model.getListAdherants();
        listLivre = model.getListLivres();


        view.getBtnConfirmer().addActionListener(e -> {
            for (Adherant adherant : listAdherant) {
                if (view.getIdTextField().getText().equals(adherant.getIdentifiant())){
                    currentAdherant = adherant;
                }
            }

            if (currentAdherant != null){
                view.getFrame().dispose();
                view.InformationGUI_Page2();

                view.getIdTextField().setText(currentAdherant.getIdentifiant());
                view.getPrenomTextField().setText(currentAdherant.getPrenom());
                view.getNomTextField().setText(currentAdherant.getNom());
                view.getEmailTextField().setText(currentAdherant.getEmail());

                for (Livre livre : listLivre) {
                    if (currentAdherant.equals(livre.getAdherant())) {
                        view.getListElements().addElement(livre.getISBN() + " | " + livre.getTitre() + ", " + livre.getAuteur().getPrenom() + " " + livre.getAuteur().getNom());
                    }
                }

                view.getBtnModifier().addActionListener(e2 -> {
                    try {
                        Statement stmt = model.getConnection().createStatement();
                        stmt.executeUpdate("update adherant set nom = '"+ view.getNomTextField().getText() +"' where adherant.identifiant = " + "'" + currentAdherant.getIdentifiant() + "'");
                        stmt.executeUpdate("update adherant set prenom = '"+ view.getPrenomTextField().getText() +"' where adherant.identifiant = " + "'" + currentAdherant.getIdentifiant() + "'");
                        stmt.executeUpdate("update adherant set email = '"+ view.getEmailTextField().getText() +"' where adherant.identifiant = " + "'" + currentAdherant.getIdentifiant() + "'");
                        JOptionPane.showMessageDialog(view.getFrame(), "Les modifications ont bien été appliquées", "Information", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
            else{
                JOptionPane.showMessageDialog(view.getFrame(), "L'identifiant de l'adhérant est invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

    }
}
