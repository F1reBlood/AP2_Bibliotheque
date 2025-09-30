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
}
