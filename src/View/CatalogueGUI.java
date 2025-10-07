package View;

import Model.Livre;
import Model.StyleController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class CatalogueGUI {
    private JLabel titre;
    private JButton btnRetour;
    private JList<Livre> listLivre;
    private JFrame frame;
    private JPanel panel;
    private JPanel btnPanel;

    public CatalogueGUI() {
        StyleController styleController = new StyleController();

        frame = new JFrame("Catalogue");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(30, 58, 95));

        btnPanel = new JPanel();
        btnPanel.setBackground(new Color(30, 58, 95));
        panel = new JPanel();
        panel.setBackground(new Color(30, 58, 95));

        frame.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        btnPanel.setLayout(new FlowLayout());

        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));

        titre = new JLabel("Catalogue", SwingConstants.CENTER);
        styleController.addStyleToTitle(titre);
        titre.setPreferredSize(new Dimension(120,100));

        listLivre = new JList<Livre>();
        styleController.addStyleToList(listLivre);

        btnRetour = new JButton("Retour");
        styleController.addStyleToButton(btnRetour);
        btnRetour.setFont(new Font("Segoe UI", Font.BOLD, 24));
        btnRetour.setPreferredSize(new Dimension(150,40));
        btnRetour.addActionListener(e -> {
            new AccueilGUI();
            frame.dispose();
        });

        frame.add(titre, BorderLayout.NORTH);
        frame.add(panel);
        frame.add(btnPanel, BorderLayout.SOUTH);

        panel.add(listLivre, BorderLayout.CENTER);

        btnPanel.add(btnRetour);

        frame.setVisible(true);
    }

    public JPanel getBtnPanel() {
        return btnPanel;
    }

    public void setBtnPanel(JPanel btnPanel) {
        this.btnPanel = btnPanel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JList<Livre> getListLivre() {
        return listLivre;
    }

    public void setListLivre(JList<Livre> listLivre) {
        this.listLivre = listLivre;
    }

    public JButton getBtnRetour() {
        return btnRetour;
    }

    public void setBtnRetour(JButton btnRetour) {
        this.btnRetour = btnRetour;
    }

    public JLabel getTitre() {
        return titre;
    }

    public void setTitre(JLabel titre) {
        this.titre = titre;
    }
}
