import javax.swing.*;
import java.awt.*;

public class InventorySection extends JPanel {

    public InventorySection(Dimension size) {

        setBackground(Color.cyan);
        setPreferredSize(new Dimension(size.width/2, size.height/8 * 7));
        add(new JLabel("Inventory"), BorderLayout.NORTH);
    }
}
