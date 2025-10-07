package View;

import Model.StyleController;

import javax.swing.*;
import java.awt.*;

public class RestituerGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel titre;
    private JLabel isbnLabel;
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
        panel.setLayout(new GridLayout(1,1, 30, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(140,20,120,20));
        panel.setBackground(new Color(30, 58, 95));

        titre = new JLabel("Restituer un livre", SwingConstants.CENTER);
        styleController.addStyleToTitle(titre);
        frame.add(titre,BorderLayout.NORTH);

        isbnLabel = new JLabel("ISBN du livre :",  SwingConstants.CENTER);
        styleController.addStyleToLabel(isbnLabel);
        panel.add(isbnLabel);

        idTextField = new JTextField();
        styleController.addStyleToTextField(idTextField);
        panel.add(idTextField);

        btnRestituer = new JButton("Confirmer");
        styleController.addStyleToButton(btnRestituer);
        btnRestituer.setPreferredSize(new Dimension(220,70));

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

        bottomPanel.add(btnRestituer);
        bottomPanel.add(btnRetour);

        panel.add(isbnLabel);
        panel.add(idTextField);

        frame.add(panel,BorderLayout.CENTER);
        frame.add(bottomPanel,BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
