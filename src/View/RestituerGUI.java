package View;

import Controller.AccueilController;
import Model.SqlConnector;
import Model.StyleController;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class RestituerGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel titre;
    private JLabel isbnLabel;
    private JTextField isbnTextField;
    private JLabel idLabel;
    private JTextField idTextField;
    private JButton btnRestituer;
    private JPanel bottomPanel;
    private JButton btnRetour;


    public RestituerGUI() {
        StyleController styleController = new StyleController();

        frame = new JFrame("Bibliotheque - Restituer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(30, 58, 95));

        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 30, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(60,20,40,20));
        panel.setBackground(new Color(30, 58, 95));

        titre = new JLabel("Restituer un livre", SwingConstants.CENTER);
        styleController.addStyleToTitle(titre);
        frame.add(titre,BorderLayout.NORTH);

        isbnLabel = new JLabel("ISBN du livre :",  SwingConstants.CENTER);
        styleController.addStyleToLabel(isbnLabel);
        panel.add(isbnLabel);

        isbnTextField = new JTextField();
        styleController.addStyleToTextField(isbnTextField);
        panel.add(isbnTextField);
        styleController.addStyleToTextField(isbnTextField);

        idLabel = new JLabel("Identifiant de l'adhérant :",  SwingConstants.CENTER);
        styleController.addStyleToLabel(idLabel);
        panel.add(idLabel);
        styleController.addStyleToLabel(idLabel);

        idTextField = new JTextField();
        styleController.addStyleToTextField(idTextField);
        panel.add(idTextField);

        btnRestituer = new JButton("Confirmer");
        styleController.addStyleToButton(btnRestituer);
        btnRestituer.setPreferredSize(new Dimension(220,70));

        btnRetour = new JButton("Retour");
        btnRetour.addActionListener(e -> {
            try {
                new AccueilController(new AccueilGUI(), new SqlConnector());
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            frame.dispose();
        });
        styleController.addStyleToButton(btnRetour);
        btnRetour.setPreferredSize(new Dimension(180,70));

        bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(30, 58, 95));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        bottomPanel.add(btnRestituer);
        bottomPanel.add(btnRetour);

        panel.add(isbnLabel);
        panel.add(isbnTextField);
        panel.add(idLabel);
        panel.add(idTextField);

        frame.add(panel,BorderLayout.CENTER);
        frame.add(bottomPanel,BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public JTextField getIsbnTextField() {
        return isbnTextField;
    }

    public void setIsbnTextField(JTextField isbnTextField) {
        this.isbnTextField = isbnTextField;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    public JButton getBtnRetour() {
        return btnRetour;
    }

    public void setBtnRetour(JButton btnRetour) {
        this.btnRetour = btnRetour;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(JPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }

    public JButton getBtnRestituer() {
        return btnRestituer;
    }

    public void setBtnRestituer(JButton btnRestituer) {
        this.btnRestituer = btnRestituer;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JLabel getIsbnLabel() {
        return isbnLabel;
    }

    public void setIsbnLabel(JLabel isbnLabel) {
        this.isbnLabel = isbnLabel;
    }

    public JLabel getTitre() {
        return titre;
    }

    public void setTitre(JLabel titre) {
        this.titre = titre;
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
}
