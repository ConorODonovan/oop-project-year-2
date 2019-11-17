import java.util.*;
import javax.swing.*;
import java.awt.*;

public class MainBodyContainer extends JPanel {

    public MainBodyContainer(Dimension appRes) {

        setBackground(Color.orange);
        setPreferredSize(new Dimension(appRes.width, appRes.height/8 * 7));
        setLayout(new GridLayout(1,2));
    }
}
