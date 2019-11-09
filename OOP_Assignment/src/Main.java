import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Get user's screen resolution and store width and height as variables
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();

        // Resolution of application window
        int appWidth = 960;
        int appHeight = 540;
        Dimension appResolution = new Dimension(appWidth, appHeight);

        Library myLibrary = new Library("Test Name", "Test Address", "0123456789", 5);

        // Draw the main window for the application
        JFrame frame = new JFrame("OOP Assignment - Library Application");
        frame.setPreferredSize(appResolution);
        frame.setMinimumSize(appResolution);
        frame.setMaximumSize(appResolution);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the program when the window is closed
        frame.setLocation((screenWidth - appWidth)/2, (screenHeight - appHeight)/2); // Draws the window in the center of the screen, regardless of resolution
        frame.setVisible(true);

        // New panel
        GUI panel = new GUI();

        // Objects for horizontal and vertical Box layouts
        Box horBox = Box.createHorizontalBox();
        Box verBox = Box.createVerticalBox();

        JLabel labelLibraryName = new JLabel();
        JLabel labelLibraryAddress = new JLabel();
        JLabel labelLibraryPhone = new JLabel();

        // Library name label - setting colour to white
        labelLibraryName.setForeground(Color.WHITE);
        labelLibraryName.setText(myLibrary.getName());

        // Library address label - setting colour to white
        labelLibraryAddress.setForeground(Color.WHITE);
        labelLibraryAddress.setText("Address: " + myLibrary.getAddress());

        // Library phone label - setting colour to white
        labelLibraryPhone.setForeground(Color.WHITE);
        labelLibraryPhone.setText("Phone: " + myLibrary.getPhone());

        panel.add(labelLibraryName); // Show name of library
        panel.add(labelLibraryAddress); // Show address of library
        panel.add(labelLibraryPhone); // Show phone number of library

        // Add components to frame
        frame.add(panel);
    }
}
