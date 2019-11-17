import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //****************************************************//
        // Creating and drawing the window and its components //
        //****************************************************//

        // Create new frame
        MyFrame frame = new MyFrame();

        // Main container to hold everything in the frame
        JPanel mainContainer = new MainContainer(frame.getAppResolution());

        // Adding main container to window
        frame.add(mainContainer);

        // Panel for Library Information section at top
        TopInfoSection topInfoSection = new TopInfoSection(frame.getAppResolution());

        // Panel to contain everything under the Library Information section
        MainBodyContainer mainBodyContainer = new MainBodyContainer(frame.getAppResolution());

        // Adding Library Information section and Main Body section
        mainContainer.add(topInfoSection, BorderLayout.NORTH);
        mainContainer.add(mainBodyContainer, BorderLayout.CENTER);

        // Creating Member section and Inventory section
        MemberSection memberSection = new MemberSection();
        InventorySection inventorySection = new InventorySection();

        // Adding Member section and Inventory section to window
        mainBodyContainer.add(memberSection);
        mainBodyContainer.add(inventorySection);
    }
}
