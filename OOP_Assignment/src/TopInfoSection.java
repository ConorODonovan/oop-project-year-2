import javax.swing.*;
import java.awt.*;

public class TopInfoSection extends JPanel {

    public TopInfoSection(Dimension appRes) {

        Library library = new Library();

        setBackground(Color.pink);
        setPreferredSize(new Dimension(appRes.width, appRes.height/8));
        setLayout(new GridLayout(1,3));

        // Icon for Library header
        ImageIcon imgThisImg = new ImageIcon("src/LibraryIcon.png");
        JLabel libIcon = new JLabel();
        libIcon.setIcon(imgThisImg);
        libIcon.setBorder(BorderFactory.createEmptyBorder(0,130,0,0));
        add(libIcon);

        // Library Name displayed on header
        JLabel libName = new JLabel(library.getName());
        libName.setFont(libName.getFont().deriveFont (48.0f));
        add(libName);

        // Contact details displayed on header
        // New panel created so that contact details could be displayed over multiple lines
        // JLabel does not recognise line breaks so trying to use them when constructing a string for a JLabel doesn't
        // work - you just end up with everything on one line
        JPanel contact = new JPanel();
        contact.setLayout(new GridLayout(6,1));
        contact.setBorder(BorderFactory.createEmptyBorder(0,64,0,0));
        contact.setBackground(Color.pink);
        add(contact);

        JLabel libAddressHeader = new JLabel("Address:");
        JLabel libAddressLine1 = new JLabel(library.getAddressLine1());
        JLabel libAddressLine2 = new JLabel(library.getAddressLine2());
        JLabel libAddressLine3 = new JLabel(library.getAddressLine3());
        JLabel libPhoneHeader = new JLabel("Phone:");
        JLabel libPhone = new JLabel(library.getPhone());

        contact.add(libAddressHeader);
        contact.add(libAddressLine1);
        contact.add(libAddressLine2);
        contact.add(libAddressLine3);
        contact.add(libPhoneHeader);
        contact.add(libPhone);
    }
}
