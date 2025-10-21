package View;

import Model.Livre;
import Model.StyleController;

import javax.swing.*;
import java.awt.*;

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
    private JList<Livre> listLivre;
    private JButton btnRetour;
    private JButton btnModifier;

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

        //Temporaire :
        btnConfirmer.addActionListener(e -> {
            frame.dispose();
            this.InformationGUI_Page2();
        });

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

        listLivre = new JList<Livre>();
        styleController.addStyleToList(listLivre);
        rightPanel.add(listLivre, BorderLayout.CENTER);

        btnModifier = new JButton("Modifier");
        styleController.addStyleToButton(btnModifier);
        btnModifier.setPreferredSize(new Dimension(180,70));

        btnRetour = new JButton("Retour");
        btnRetour.addActionListener(e -> {
            new AccueilGUI();
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
}
