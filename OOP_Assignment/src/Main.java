import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        //************************************//
        // Reading text file of Library Items //
        //************************************//

        Scanner fileIn;
        String fileName = "LibraryInventoryList.txt";
        ArrayList<Object> inventoryList = new ArrayList<>(); // Array list to store the objects in the Library's inventory

        try {

            fileIn = new Scanner(new FileReader(fileName));
            //fileIn.useDelimiter("\n");

            while (fileIn.hasNextLine()) {

                // Check the first line of each entry, which contains the name of the object type
                if (fileIn.hasNext("Book")) {

                    // Create a new book object, read through each line, and populate each field with the data
                    Book book = new Book();
                    fileIn.nextLine();

                    book.setName(fileIn.nextLine());

                    String tempBorrowTime = fileIn.nextLine(); // The scanner reads the file in as a string, so needs to be converted to an int
                    book.setBorrowTime(Integer.parseInt(tempBorrowTime));

                    String tempLateFee = fileIn.nextLine(); // The scanner reads the file in as a string, so needs to be converted to a double
                    book.setLateFee(Double.parseDouble(tempLateFee));

                    book.setCurrentlyBorrowed(false);

                    book.setAuthor(fileIn.nextLine());

                    String tempNumberOfPages = fileIn.nextLine(); // The scanner reads the file in as a string, so needs to be converted to an int
                    book.setNumberOfPages(Integer.parseInt(tempNumberOfPages));

                    book.setGenre(fileIn.nextLine());

                    inventoryList.add(book); // Adds the book object to the array list

                    // Checks if there is another line in the file, and moves the scanner to it if so
                    if (fileIn.hasNextLine()) {

                        fileIn.nextLine();
                    }
                }
                else if (fileIn.hasNext("DVD")) {

                    DVD dvd = new DVD();
                    fileIn.nextLine();

                    dvd.setName(fileIn.nextLine());

                    String tempBorrowTime = fileIn.nextLine(); // The scanner reads the file in as a string, so needs to be converted to an int
                    dvd.setBorrowTime(Integer.parseInt(tempBorrowTime));

                    String tempLateFee = fileIn.nextLine(); // The scanner reads the file in as a string, so needs to be converted to a double
                    dvd.setLateFee(Double.parseDouble(tempLateFee));

                    dvd.setCurrentlyBorrowed(false);

                    dvd.setDirector(fileIn.nextLine());

                    String tempLength = fileIn.nextLine(); // The scanner reads the file in as a string, so needs to be converted to an int
                    dvd.setLength(Integer.parseInt(tempLength));

                    inventoryList.add(dvd); // Adds the DVD object to the array list

                    // Checks if there is another line in the file, and moves the scanner to it if so
                    if (fileIn.hasNextLine()) {

                        fileIn.nextLine();
                    }
                }
                else if (fileIn.hasNext("Magazine")) {

                    Magazine magazine = new Magazine();
                    fileIn.nextLine();

                    magazine.setName(fileIn.nextLine());

                    String tempBorrowTime = fileIn.nextLine(); // The scanner reads the file in as a string, so needs to be converted to an int
                    magazine.setBorrowTime(Integer.parseInt(tempBorrowTime));

                    String tempLateFee = fileIn.nextLine(); // The scanner reads the file in as a string, so needs to be converted to a double
                    magazine.setLateFee(Double.parseDouble(tempLateFee));

                    magazine.setCurrentlyBorrowed(false);

                    String tempIssue = fileIn.nextLine(); // The scanner reads the file in as a string, so needs to be converted to an int
                    magazine.setBorrowTime(Integer.parseInt(tempIssue));

                    inventoryList.add(magazine); // Adds the magazine object to the array list

                    // Checks if there is another line in the file, and moves the scanner to it if so
                    if (fileIn.hasNextLine()) {

                        fileIn.nextLine();
                    }
                }
                else {
                    fileIn.nextLine();
                }
            }

            fileIn.close();
        }
        catch (FileNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
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

        // Panel to contain everything under the Library Information section
        MainBodyContainer mainBodyContainer = new MainBodyContainer(frame.getAppResolution());

        // Adding Library Information section and Main Body section
        mainContainer.add(topInfoSection, BorderLayout.NORTH);
        mainContainer.add(mainBodyContainer, BorderLayout.CENTER);

        // Creating Member section and Inventory section
        MemberSection memberSection = new MemberSection();
        InventorySection inventorySection = new InventorySection(frame.getAppResolution());

        // Adding Member section and Inventory section to window
        mainBodyContainer.add(memberSection);
        mainBodyContainer.add(inventorySection);
    }
}
