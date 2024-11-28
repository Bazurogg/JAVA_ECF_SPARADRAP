package fr.pompey.dev.afpa.utilities;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class RoundedPanel extends JPanel {
    private int radius; // Rayon des coins arrondis

    public RoundedPanel(int radius) {
        this.radius = radius;
        setOpaque(false); // Important pour que la transparence soit gérée
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Nécessaire pour dessiner un fond arrondi
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dessiner un rectangle arrondi
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2d.dispose();
    }
}

