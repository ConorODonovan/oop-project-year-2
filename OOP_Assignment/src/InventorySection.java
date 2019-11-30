import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class InventorySection extends JPanel {

    private ArrayList<Object> inventoryList;
    private DefaultListModel inventoryListModel;

    public InventorySection() {

        setBackground(new Color(199,207,221));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        inventoryList = new ArrayList<>(); // Array list to store the objects in the Library's inventory
        inventoryListModel = new DefaultListModel(); // This is to dynamically manage the contents of the JList we'll use to display the Inventory List
    }

    public void readFile() {

        //************************************//
        // Reading text file of Library Items //
        //************************************//

        Scanner fileIn;
        String fileName = "LibraryInventoryList.txt";

        try {

            fileIn = new Scanner(new FileReader(fileName));

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
                    magazine.setIssue(Integer.parseInt(tempIssue));

                    inventoryList.add(magazine); // Adds the magazine object to the array list
                    inventoryListModel.addElement(magazine);

                    // Checks if there is another line in the file, and moves the scanner to it if so
                    if (fileIn.hasNextLine()) {

                        fileIn.nextLine();
                    }
                } else {
                    fileIn.nextLine();
                }
            }

            fileIn.close();
        } catch (FileNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    public void inventoryComponents() {

        //******************************//
        // Inventory section components //
        //******************************//

        JLabel titleLabel = new JLabel("Items to Borrow");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(24, 0, 8, 0));
        titleLabel.setFont(titleLabel.getFont().deriveFont(24.0f));
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

                    String type = "";
                    String name = "";

                    if (value instanceof Book) {

                        type = ("Book");
                        name = ((Book) value).getName();
                    } else if (value instanceof DVD) {

                        type = ("DVD");
                        name = ((DVD) value).getName();
                    } else if (value instanceof Magazine) {

                        type = ("Magazine");
                        name = ((Magazine) value).getName();
                    }

                    if (((Item) value).getCurrentlyBorrowed() == true) {

                        ((JLabel) renderer).setForeground(Color.RED);
                    }

                    ((JLabel) renderer).setText(name + " (" + type + ")");
                }

                return renderer;
            }
        });

        // Label for Item Details text area
        JLabel detailsLabel = new JLabel("Item Details");
        detailsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsLabel.setBorder(BorderFactory.createEmptyBorder(32, 0, 8, 0));
        detailsLabel.setFont(detailsLabel.getFont().deriveFont(24.0f));
        add(detailsLabel);

        // Section to display details of of currently selected member
        TextArea itemDetails = new TextArea();
        itemDetails.setMaximumSize(new Dimension(300, 160));
        itemDetails.setFont(inventoryJList.getFont().deriveFont(16.0f));
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

                    String currentlyBorrowedStr;

                    // Get a string value to display based on whether or not the item can currently be borrowed
                    if (currentlyBorrowed == false) {

                        currentlyBorrowedStr = "Yes";
                    } else {

                        currentlyBorrowedStr = "No";
                    }

                    if (inventoryJList.getSelectedValue() instanceof Book) {

                        String author = ((Book) inventoryJList.getSelectedValue()).getAuthor(); // Needs to be cast back to Book type as JList elements are some other type
                        int numberOfPages = ((Book) inventoryJList.getSelectedValue()).getNumberOfPages(); // Needs to be cast back to Book type as JList elements are some other type
                        String genre = ((Book) inventoryJList.getSelectedValue()).getGenre(); // Needs to be cast back to Book type as JList elements are some other type

                        itemDetails.setText(name + "\n" + "By " + author + "\n" + genre + "\n" + numberOfPages + " pages\n" + "Can be borrowed for " + borrowTime + " days\n" + "Late fee is " + "€" + lateFee + "0" + " per day\n" + "Available: " + currentlyBorrowedStr); // Build the string to be displayed for type Book
                    }

                    if (inventoryJList.getSelectedValue() instanceof DVD) {

                        String director = ((DVD) inventoryJList.getSelectedValue()).getDirector(); // Needs to be cast back to DVD type as JList elements are some other type
                        int length = ((DVD) inventoryJList.getSelectedValue()).getLength(); // Needs to be cast back to DVD type as JList elements are some other type

                        itemDetails.setText(name + "\n" + "Directed by " + director + "\n" + length + " minutes\n" + "Can be borrowed for " + borrowTime + " days\n" + "Late fee is " + "€" + lateFee + "0" + " per day\n" + "Available: " + currentlyBorrowedStr); // Build the string to be displayed for type DVD
                    }

                    if (inventoryJList.getSelectedValue() instanceof Magazine) {

                        int issue = ((Magazine) inventoryJList.getSelectedValue()).getIssue(); // Needs to be cast back to Magazine type as JList elements are some other type

                        itemDetails.setText(name + "\n" + "Issue No. " + issue + "\n" + "Can be borrowed for " + borrowTime + " days\n" + "Late fee is " + "€" + lateFee + "0" + " per day\n" + "Available: " + currentlyBorrowedStr); // Build the string to be displayed for type Magazine
                    }
                }
            }
        });

        // Empty label to create space between text area and button - only way I could figure out how to do it
        JLabel emptyLabel1 = new JLabel("");
        emptyLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        emptyLabel1.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));
        add(emptyLabel1);

        // Button to borrow item
        JButton borrowButton = new JButton("Borrow");
        borrowButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(borrowButton);

        // Action when clicking on "Borrow" button
        borrowButton.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if ((inventoryJList.getSelectedValue()) != null) {

                    ((Item) inventoryJList.getSelectedValue()).setCurrentlyBorrowed(true);
                    //itemDetails.update(itemDetails.getGraphics()); // COME BACK TO THIS
                    //itemDetails.setText("test update"); // FOR TESTING
                }
            }
        }));

        // Empty label to create space between text area and button - only way I could figure out how to do it
        JLabel emptyLabel2 = new JLabel("");
        emptyLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        emptyLabel2.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));
        add(emptyLabel2);

        // Button to return item
        JButton returnButton = new JButton("Return");
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(returnButton);

        // Action when clicking on "Return" button
        returnButton.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if ((inventoryJList.getSelectedValue()) != null) {

                    ((Item) inventoryJList.getSelectedValue()).setCurrentlyBorrowed(false);
                }
            }
        }));
    }
}
