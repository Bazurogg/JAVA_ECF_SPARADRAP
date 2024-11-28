package fr.pompey.dev.afpa.utilities;

import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    private int radius; // Rayon des coins arrondis

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius + 1, radius + 1, radius + 1, radius + 1);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(c.getBackground()); // Couleur de fond du panneau
        g2d.fillRoundRect(x, y, width - 1, height - 1, radius, radius); // Remplir le fond
        g2d.setColor(Color.GRAY); // Couleur de la bordure
        g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius); // Dessiner la bordure
    }
}

