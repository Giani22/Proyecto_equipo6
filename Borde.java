package ventana2;

import java.awt.*;
import javax.swing.border.Border;

public class Borde implements Border {

    private int radio;

    public Borde(int radio) {
        this.radio = radio;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radio, radio, radio, radio);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);  // color del borde
        g2.setStroke(new BasicStroke(1));
        g2.drawRoundRect(x, y, width - 1, height - 1, radio, radio);
    }
}
