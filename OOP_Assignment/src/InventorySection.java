import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class InventorySection extends JPanel {

    public InventorySection() {

        setBackground(Color.cyan);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //************************************//
        // Reading text file of Library Items //
        //************************************//

        Scanner fileIn;
        String fileName = "LibraryInventoryList.txt";
        ArrayList<Object> inventoryList = new ArrayList<>(); // Array list to store the objects in the Library's inventory
        DefaultListModel inventoryListModel = new DefaultListModel(); // This is to dynamically manage the contents of the JList we'll use to display the Inventory List

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
                    inventoryListModel.addElement(book);

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
                    inventoryListModel.addElement(dvd);

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
                    inventoryListModel.addElement(magazine);


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

        //******************************//
        // Inventory section components //
        //******************************//

        JLabel titleLabel = new JLabel("Items to Borrow");
        add(titleLabel);

        // Creating the JList, which will display the Inventory List, and adding it to the window
        JList inventoryJList = new JList();
        add(inventoryJList);
        inventoryJList.setModel(inventoryListModel);

        /*
        This next function is used to determine what the JList component actually displays
        As each element of the list is a Member object, not using a custom cell renderer means
        that what will actually be displayed on the window is the name of the object type plus a memory address
        This isn't useful for the front end of an application

        NOTE: This was taken almost verbatim from Stack Overflow, although in this case, the Object type needed to be checked first
        */
        inventoryJList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (renderer instanceof JLabel) {

                    if (value instanceof Book) {

                        String type = ("Book");
                        String name = ((Book) value).getName();

                        ((JLabel) renderer).setText(name + " (" + type + ")");
                    }
                    else if (value instanceof DVD) {

                        String type = ("DVD");
                        String name = ((DVD) value).getName();

                        ((JLabel) renderer).setText(name + " (" + type + ")");
                    }
                    else if (value instanceof Magazine) {

                        String type = ("Magazine");
                        String name = ((Magazine) value).getName();

                        ((JLabel) renderer).setText(name + " (" + type + ")");
                    }
                }

                return renderer;
            }
        });

        // Label for Item Details text area
        JLabel detailsLabel = new JLabel("Item Details");
        add(detailsLabel);

        // Section to display details of of currently selected member
        TextArea itemDetails = new TextArea();
        itemDetails.setMaximumSize(new Dimension(320,200));
        add(itemDetails);

        // Gets the selected member and displays their details below
        inventoryJList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String name = ((Item) inventoryJList.getSelectedValue()).getName(); // Needs to be cast back to Item type as JList elements are some other type
                    int borrowTime = ((Item) inventoryJList.getSelectedValue()).getBorrowTime(); // Needs to be cast back to Item type as JList elements are some other type
                    double lateFee = ((Item) inventoryJList.getSelectedValue()).getLateFee(); // Needs to be cast back to Item type as JList elements are some other type
                    boolean currentlyBorrowed = ((Item) inventoryJList.getSelectedValue()).getCurrentlyBorrowed(); // Needs to be cast back to Item type as JList elements are some other type

                    if (inventoryJList.getSelectedValue() instanceof Book) {

                        String author = ((Book) inventoryJList.getSelectedValue()).getAuthor(); // Needs to be cast back to Book type as JList elements are some other type
                        int numberOfPages = ((Book) inventoryJList.getSelectedValue()).getNumberOfPages(); // Needs to be cast back to Book type as JList elements are some other type
                        String genre = ((Book) inventoryJList.getSelectedValue()).getGenre(); // Needs to be cast back to Book type as JList elements are some other type

                        itemDetails.setText(name + "\n" + "By " + author + "\n" + genre + "\n" + "Number of Pages: " + numberOfPages + "\n" + "Can be borrowed for " + borrowTime + " days\n" + "Late fee is " + lateFee + " per day\n" + "Available: "); // Build the string to be displayed for type Book
                    }

                    if (inventoryJList.getSelectedValue() instanceof DVD) {

                        String director = ((DVD) inventoryJList.getSelectedValue()).getDirector(); // Needs to be cast back to DVD type as JList elements are some other type
                        int length = ((DVD) inventoryJList.getSelectedValue()).getLength(); // Needs to be cast back to DVD type as JList elements are some other type

                        itemDetails.setText(name + "\n" + borrowTime + "\n" + lateFee + "\n" + currentlyBorrowed); // Build the string to be displayed for type DVD
                    }

                    if (inventoryJList.getSelectedValue() instanceof Magazine) {

                        int issue = ((Magazine) inventoryJList.getSelectedValue()).getIssue(); // Needs to be cast back to Magazine type as JList elements are some other type

                        itemDetails.setText(name + "\n" + borrowTime + "\n" + lateFee + "\n" + currentlyBorrowed); // Build the string to be displayed for type Magazine
                    }
                }
            }
        });

        // Button to borrow item
        JButton borrowButton = new JButton("Borrow");
        add(borrowButton);

        // Button to return item
        JButton returnButton = new JButton("Return");
        add(returnButton);
    }
}
