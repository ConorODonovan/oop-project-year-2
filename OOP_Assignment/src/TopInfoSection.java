import javax.swing.*;
import java.awt.*;

public class TopInfoSection extends JPanel {

    public TopInfoSection(Dimension appRes) {

        setBackground(new Color(42, 47, 78));
        setPreferredSize(new Dimension(appRes.width, appRes.height/8));
        setLayout(new GridLayout(1,3));
    }

    public void createLibraryIcon() {

        // Icon for Library header
        ImageIcon imgThisImg = new ImageIcon("LibraryIcon.png");
        JLabel libIcon = new JLabel();
        libIcon.setIcon(imgThisImg);
        libIcon.setBorder(BorderFactory.createEmptyBorder(0,130,0,0));
        add(libIcon);
    }

    public void createLibraryInfo() {

        Library library = new Library("C & C's Books", "1010 Java Lane", "Javatown", "Javaland", "555-1492");

        // Library Name displayed on header
        JLabel libName = new JLabel(library.getName());
        libName.setFont(libName.getFont().deriveFont (48.0f));
        libName.setForeground(new Color(255,200,37));
        add(libName);

        // Contact details displayed on header
        // New panel created so that contact details could be displayed over multiple lines
        // JLabel does not recognise line breaks so trying to use them when constructing a string for a JLabel doesn't
        // work - you just end up with everything on one line
        JPanel contact = new JPanel();
        contact.setLayout(new GridLayout(6,1));
        contact.setBorder(BorderFactory.createEmptyBorder(0,64,0,0));
        contact.setBackground(new Color(42, 47, 78));
        add(contact);

        JLabel libAddressHeader = new JLabel("Address:");
        libAddressHeader.setForeground(new Color(255,200,37));
        JLabel libAddressLine1 = new JLabel(library.getAddressLine1());
        libAddressLine1.setForeground(new Color(255,200,37));
        JLabel libAddressLine2 = new JLabel(library.getAddressLine2());
        libAddressLine2.setForeground(new Color(255,200,37));
        JLabel libAddressLine3 = new JLabel(library.getAddressLine3());
        libAddressLine3.setForeground(new Color(255,200,37));
        JLabel libPhoneHeader = new JLabel("Phone:");
        libPhoneHeader.setForeground(new Color(255,200,37));
        JLabel libPhone = new JLabel(library.getPhone());
        libPhone.setForeground(new Color(255,200,37));

        contact.add(libAddressHeader);
        contact.add(libAddressLine1);
        contact.add(libAddressLine2);
        contact.add(libAddressLine3);
        contact.add(libPhoneHeader);
        contact.add(libPhone);
    }
}
