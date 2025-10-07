package View;

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

    public InformationsGUI() {
        StyleController styleController = new StyleController();

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

    }
}
