import java.awt.Color;
import java.awt.Graphics;

public class Fond {
    public static void dessinerFondBlanc(Graphics g) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                g.setColor(Color.white);
                g.fillRect(i * 30, j * 30, 29, 29);
            }
        }
    }
}
