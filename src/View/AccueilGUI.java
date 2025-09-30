package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AccueilGUI {
    public AccueilGUI() {
        JFrame frame = new JFrame("Bibliotheque - Accueil");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        frame.setResizable(false);

        // Faire un borderLayout + un grid layout avec les bouttons sur les emplacements 0/0 1/0 2/0 et 1/1
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));

        JLabel titre = new JLabel("Bibliotheque", SwingConstants.CENTER);
        frame.add(titre,BorderLayout.NORTH);

        ArrayList<JButton> buttons = new ArrayList<JButton>();

        JButton btnEmprunter = new JButton("Emprunter");
        buttons.add(btnEmprunter);
        JButton btnRestituer = new JButton("Restituer");
        buttons.add(btnRestituer);
        JButton btnInformations = new JButton("Informations");
        buttons.add(btnInformations);
        JButton btnCatalogue = new JButton("Catalogue");
        buttons.add(btnCatalogue);



        frame.setVisible(true);



    }
}
