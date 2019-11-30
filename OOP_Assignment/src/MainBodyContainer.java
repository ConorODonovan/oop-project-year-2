import javax.swing.*;
import java.awt.*;

public class MainBodyContainer extends JPanel {

    public MainBodyContainer(Dimension appRes) {

        // This is the panel that holds everything under the top information section in the UI,
        // i.e. the Member and Inventory sections

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(appRes.width, appRes.height/8 * 7));
        setLayout(new GridLayout(1,2));
    }
}
