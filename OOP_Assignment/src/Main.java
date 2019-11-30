import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //****************************************//
        // Get console input before drawing Frame //
        //****************************************//

        System.out.println("Welcome to our library system\nPlease type S to start, or E to exit. Then press Enter");

        Scanner scanner = new Scanner(System.in);

        String userInput = "";
        userInput = scanner.nextLine();

        // Loop for input validation
        while (!userInput.equals("S") && !userInput.equals("E") && !userInput.equals("s") && !userInput.equals("e")) {

            System.out.println("Invalid selection! Please type S to start, or E to exit. Then press Enter");
            userInput = scanner.nextLine();
        }

        scanner.close();

        // If user types E, exit program
        if (userInput.equals("E") || userInput.equals("e")) {

            System.out.println("Thank you for using our library system, goodbye!");
            System.exit(0);
        }

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
        topInfoSection.createLibraryIcon();
        topInfoSection.createLibraryInfo();

        // Panel to contain everything under the Library Information section
        MainBodyContainer mainBodyContainer = new MainBodyContainer(frame.getAppResolution());

        // Adding Library Information section and Main Body section
        mainContainer.add(topInfoSection, BorderLayout.NORTH);
        mainContainer.add(mainBodyContainer, BorderLayout.CENTER);

        // Creating Member section
        MemberSection memberSection = new MemberSection();
        mainBodyContainer.add(memberSection);

        // Create Inventory section
        InventorySection inventorySection = new InventorySection();
        mainBodyContainer.add(inventorySection);
    }
}
