import javax.swing.*;
import java.awt.*;

public class InventorySection extends JPanel {

    public InventorySection(Dimension size) {

        setBackground(Color.cyan);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Items to Borrow");
        add(titleLabel);

        // Inventory list
        // TO DO
        DefaultListModel inventoryListModel = new DefaultListModel(); // This is to dynamically manage the contents of the JList we'll use to display the Inventory List

        // Creating the JList, which will display the Inventory List, and adding it to the window
        JList inventoryJList = new JList();
        add(inventoryJList);
        inventoryJList.setModel(inventoryListModel);

        // Label for Item Details text area
        JLabel detailsLabel = new JLabel("Item Details");
        add(detailsLabel);

        // Section to display details of of currently selected member
        TextArea itemDetails = new TextArea();
        itemDetails.setMaximumSize(new Dimension(320,200));
        add(itemDetails);

        // Button to borrow item
        JButton borrowButton = new JButton("Borrow");
        add(borrowButton);

        // Button to return item
        JButton returnButton = new JButton("Return");
        add(returnButton);
    }
}
