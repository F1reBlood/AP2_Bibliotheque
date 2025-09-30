package Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StyleController {
    public void addStyleToLabel(JLabel label){
        label.setFont(new Font("Serif", Font.BOLD, 64));
        label.setForeground(new Color(174, 212, 255));
    }

    public void addStyleToTitle(JLabel title){
        title.setFont(new Font("Serif", Font.BOLD, 64));
        title.setForeground(new Color(174, 212, 255));
        title.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
    }

    public void addStyleToButton(JButton btn){
        btn.setFont(new Font("Segoe UI", Font.BOLD, 36));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(46, 92, 154));
        btn.setFocusPainted(false);
        btn.setOpaque(true);

        // Hover effect
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(62, 111, 176));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(46, 92, 154));
            }
        });
    }

    public void addStyleToList(JList list){
        // Style global de la JList
        list.setBackground(new Color(40, 70, 120)); // fond bleu foncé
        list.setForeground(Color.WHITE);            // texte blanc
        list.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        // Bordure arrondie autour de la liste
        list.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Couleur de sélection (texte + fond quand on clique)
        list.setSelectionBackground(new Color(80, 120, 180)); // bleu plus clair
        list.setSelectionForeground(Color.WHITE);

        // Affiche plusieurs lignes visibles
        list.setVisibleRowCount(10);

        // Scrollbar
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(20, 40, 70), 2));
    }
}
