import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    private int screenWidth, screenHeight, appWidth, appHeight;
    private Dimension screenSize, appResolution;

    public MyFrame() {

        // Calling the parent method to name the application
        super("OOP Assignment - Library Application");

        //***************************************************************//
        /* Setting up dimensions and position of main application window */
        //***************************************************************//

        // Get user's screen resolution and store width and height as variables
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenSize.getWidth();
        screenHeight = (int) screenSize.getHeight();

        // Configure resolution of application window
        appWidth = 1024;
        appHeight = 768;
        appResolution = new Dimension(appWidth, appHeight);

        // Set resolution and screen position of application window
        setPreferredSize(appResolution);
        setMinimumSize(appResolution);
        setMaximumSize(appResolution);
        setResizable(false); // User cannot resize window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the program when the window is closed
        setLocation((screenWidth - appWidth)/2, (screenHeight - appHeight)/2); // Draws the window in the center of the screen, regardless of resolution

        // Make the JFrame visible
        setVisible(true);
    }

    public int getScreenWidth() {

        return screenWidth;
    }

    public int getScreenHeight() {

        return screenHeight;
    }

    public int getAppWidth() {

        return appWidth;
    }

    public int getAppHeight() {

        return appHeight;
    }

    public Dimension getScreenSize() {

        return screenSize;
    }

    public Dimension getAppResolution() {

        return appResolution;
    }
}
