package View;

import Model.StyleController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AccueilGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel titre;
    private JButton btnEmprunter;
    private JButton btnRestituer;
    private JButton btnInformations;
    private JButton btnCatalogue;
    private ArrayList<JButton> buttons;

    public AccueilGUI() {
        StyleController styleController = new StyleController();

        frame = new JFrame("Bibliotheque - Accueil");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(30, 58, 95));

        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,2, 30, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(40,20,20,20));
        panel.setBackground(new Color(30, 58, 95));

        titre = new JLabel("Bibliotheque", SwingConstants.CENTER);
        styleController.addStyleToTitle(titre);
        frame.add(titre,BorderLayout.NORTH);

        buttons = new ArrayList<JButton>();

        btnEmprunter = new JButton("Emprunter");
        buttons.add(btnEmprunter);

        btnRestituer = new JButton("Restituer");
        buttons.add(btnRestituer);

        btnInformations = new JButton("Informations");
        buttons.add(btnInformations);

        btnCatalogue = new JButton("Catalogue");
        buttons.add(btnCatalogue);

        for (JButton btn : buttons) {
            styleController.addStyleToButton(btn);
        }

        panel.add(btnEmprunter);
        panel.add(new JLabel(""));
        panel.add(btnRestituer);
        panel.add(btnCatalogue);
        panel.add(btnInformations);

        frame.add(panel,BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getBtnEmprunter() {
        return btnEmprunter;
    }
    public void setBtnEmprunter(JButton btnEmprunter) {
        this.btnEmprunter = btnEmprunter;
    }

    public JButton getBtnRestituer() {
        return btnRestituer;
    }
    public void setBtnRestituer(JButton btnRestituer) {
        this.btnRestituer = btnRestituer;
    }

    public JButton getBtnInformations() {
        return btnInformations;
    }
    public void setBtnInformations(JButton btnInformations) {
        this.btnInformations = btnInformations;
    }

    public JButton getBtnCatalogue() {
        return btnCatalogue;
    }
    public void setBtnCatalogue(JButton btnCatalogue) {
        this.btnCatalogue = btnCatalogue;
    }

    public JLabel getTitre() {
        return titre;
    }
    public void setTitre(JLabel titre) {
        this.titre = titre;
    }
}
