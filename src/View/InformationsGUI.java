package View;

import Controller.AccueilController;
import Model.Livre;
import Model.SqlConnector;
import Model.StyleController;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class InformationsGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel titre;
    private JLabel idLabel;
    private JTextField idTextField;
    private JButton btnConfirmer;
    private JPanel bottomPanel;
    private StyleController styleController = new StyleController();

    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel prenomLabel;
    private JTextField prenomTextField;
    private JLabel nomLabel;
    private JTextField nomTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel livreLabel;
    private JList<String> listLivre;
    private JButton btnRetour;
    private JButton btnModifier;
    private DefaultListModel<String> listElements;

    public InformationsGUI() {

        frame = new JFrame("Bibliotheque - Informations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(30, 58, 95));

        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(1,1, 30, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(140,20,120,20));
        panel.setBackground(new Color(30, 58, 95));

        titre = new JLabel("Mes informations", SwingConstants.CENTER);
        styleController.addStyleToTitle(titre);
        frame.add(titre,BorderLayout.NORTH);

        idLabel = new JLabel("Identifiant de l'adhérant :",  SwingConstants.CENTER);
        styleController.addStyleToLabel(idLabel);
        panel.add(idLabel);

        idTextField = new JTextField();
        styleController.addStyleToTextField(idTextField);
        panel.add(idTextField);

        btnConfirmer = new JButton("Confirmer");
        styleController.addStyleToButton(btnConfirmer);
        btnConfirmer.setPreferredSize(new Dimension(220,70));


        bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(30, 58, 95));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        bottomPanel.add(btnConfirmer);

        panel.add(idLabel);
        panel.add(idTextField);

        frame.add(panel,BorderLayout.CENTER);
        frame.add(bottomPanel,BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void InformationGUI_Page2(){

        frame = new JFrame("Bibliotheque - Informations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(30, 58, 95));

        frame.setLayout(new BorderLayout());

        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(30, 58, 95));
        leftPanel.setLayout(new GridLayout(4, 2, 15, 10));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(75,50,50,0));
        frame.add(leftPanel,BorderLayout.WEST);

        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(30, 58, 95));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20,75,50,50));
        rightPanel.setLayout(new BorderLayout());
        frame.add(rightPanel,BorderLayout.CENTER);

        titre = new JLabel("Mes informations", SwingConstants.CENTER);
        styleController.addStyleToTitle(titre);
        frame.add(titre,BorderLayout.NORTH);

        idLabel = new JLabel("Identifiant :", SwingConstants.CENTER);
        styleController.addStyleToLabel(idLabel);
        leftPanel.add(idLabel);

        idTextField = new JTextField();
        styleController.addStyleToTextField(idTextField);
        leftPanel.add(idTextField);
        idTextField.setEditable(false);

        prenomLabel = new JLabel("Prenom :", SwingConstants.CENTER);
        styleController.addStyleToLabel(prenomLabel);
        leftPanel.add(prenomLabel);

        prenomTextField = new JTextField();
        styleController.addStyleToTextField(prenomTextField);
        leftPanel.add(prenomTextField);

        nomLabel = new JLabel("Nom :", SwingConstants.CENTER);
        styleController.addStyleToLabel(nomLabel);
        leftPanel.add(nomLabel);

        nomTextField = new JTextField();
        styleController.addStyleToTextField(nomTextField);
        leftPanel.add(nomTextField);

        emailLabel = new JLabel("Email :", SwingConstants.CENTER);
        styleController.addStyleToLabel(emailLabel);
        leftPanel.add(emailLabel);

        emailTextField = new JTextField();
        styleController.addStyleToTextField(emailTextField);
        leftPanel.add(emailTextField);

        livreLabel = new JLabel("Mes livre :", SwingConstants.CENTER);
        styleController.addStyleToLabel(livreLabel);
        rightPanel.add(livreLabel, BorderLayout.NORTH);

        listElements = new DefaultListModel<String>();
        listLivre = new JList<String>(listElements);
        styleController.addStyleToList(listLivre);
        rightPanel.add(listLivre, BorderLayout.CENTER);

        btnModifier = new JButton("Modifier");
        styleController.addStyleToButton(btnModifier);
        btnModifier.setPreferredSize(new Dimension(180,70));

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

        bottomPanel.add(btnModifier);
        bottomPanel.add(btnRetour);

        frame.add(bottomPanel,BorderLayout.SOUTH);


        frame.setVisible(true);
    }


    public DefaultListModel<String> getListElements() {
        return listElements;
    }

    public void setListElements(DefaultListModel<String> listElements) {
        this.listElements = listElements;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getTitre() {
        return titre;
    }

    public void setTitre(JLabel titre) {
        this.titre = titre;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JButton getBtnConfirmer() {
        return btnConfirmer;
    }

    public void setBtnConfirmer(JButton btnConfirmer) {
        this.btnConfirmer = btnConfirmer;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(JPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }

    public StyleController getStyleController() {
        return styleController;
    }

    public void setStyleController(StyleController styleController) {
        this.styleController = styleController;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel = leftPanel;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
    }

    public JLabel getPrenomLabel() {
        return prenomLabel;
    }

    public void setPrenomLabel(JLabel prenomLabel) {
        this.prenomLabel = prenomLabel;
    }

    public JTextField getPrenomTextField() {
        return prenomTextField;
    }

    public void setPrenomTextField(JTextField prenomTextField) {
        this.prenomTextField = prenomTextField;
    }

    public JLabel getNomLabel() {
        return nomLabel;
    }

    public void setNomLabel(JLabel nomLabel) {
        this.nomLabel = nomLabel;
    }

    public JTextField getNomTextField() {
        return nomTextField;
    }

    public void setNomTextField(JTextField nomTextField) {
        this.nomTextField = nomTextField;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JLabel getLivreLabel() {
        return livreLabel;
    }

    public void setLivreLabel(JLabel livreLabel) {
        this.livreLabel = livreLabel;
    }

    public JList<String> getListLivre() {
        return listLivre;
    }

    public void setListLivre(JList<String> listLivre) {
        this.listLivre = listLivre;
    }

    public JButton getBtnRetour() {
        return btnRetour;
    }

    public void setBtnRetour(JButton btnRetour) {
        this.btnRetour = btnRetour;
    }

    public JButton getBtnModifier() {
        return btnModifier;
    }

    public void setBtnModifier(JButton btnModifier) {
        this.btnModifier = btnModifier;
    }
}
