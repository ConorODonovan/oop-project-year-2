import java.awt.*;
import javax.swing.*;

public class GUI extends JPanel {

    public GUI() {

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        setBackground(Color.DARK_GRAY);
        g.setColor(Color.WHITE);
    }
}
