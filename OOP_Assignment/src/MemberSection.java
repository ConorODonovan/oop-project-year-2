import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class MemberSection extends JPanel {

    private ArrayList<Member> memberList;
    private DefaultListModel memberListModel;
    private JList memberJList;
    private String[] memberArr;

    public MemberSection() {

        setBackground(new Color(146,161,185));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Members");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(24,0,8,0));
        titleLabel.setFont(titleLabel.getFont().deriveFont (24.0f));
        add(titleLabel);

        // Initialising Member list
        memberList = new ArrayList<>();
        memberListModel = new DefaultListModel(); // This is to dynamically manage the contents of the JList we'll use to display the Member List

        // Creating some existing members to add to list
        Member member1 = new Member("Sarah", "Williamson", 'F', 27);
        Member member2 = new Member("Joe", "Briggs", 'M', 42);
        Member member3 = new Member("Kate", "Johnson", 'F', 16);

        // Adding them to the standard ArrayList
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);

        // Adding them to the list model data structure also
        memberListModel.addElement(member1);
        memberListModel.addElement(member2);
        memberListModel.addElement(member3);

        // Creating the JList, which will display the Member List, and adding it to the window
        memberJList = new JList();
        add(memberJList);
        memberJList.setModel(memberListModel);

        // Label for member details area
        JLabel memberDetailsLabel = new JLabel("Member Details");
        memberDetailsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        memberDetailsLabel.setBorder(BorderFactory.createEmptyBorder(32,0,8,0));
        memberDetailsLabel.setFont(memberDetailsLabel.getFont().deriveFont (24.0f));
        add(memberDetailsLabel);

        // Section to display details of of currently selected member
        TextArea memberDetails = new TextArea();
        memberDetails.setMaximumSize(new Dimension(300,160));
        memberDetails.setFont(memberJList.getFont().deriveFont (16.0f));
        add(memberDetails);

        // Empty label to create space between text area and button - only way I could figure out how to do it
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        emptyLabel.setBorder(BorderFactory.createEmptyBorder(8,0,0,0));
        add(emptyLabel);

        // Button to add a new member
        JButton addNewMemberButton = new JButton("Add New Member");
        addNewMemberButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(addNewMemberButton);

        // Action when clicking on "Add New Member" button
        addNewMemberButton.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    // Asks user to input new member details with a series of popups
                    String memberForeName = JOptionPane.showInputDialog("Please enter the member's first name");
                    String memberSurname = JOptionPane.showInputDialog("Please enter the member's surname");
                    char memberGender = 'N';
                    boolean validgender = false;
                    while (validgender == false) {

                        String memberGenderString = JOptionPane.showInputDialog("Please enter the member's gender - F (Female) or M (Male)");

                        if ((memberGenderString.equals("M")) || (memberGenderString.equals("F")) || (memberGenderString.equals("m")) || (memberGenderString.equals("f")))
                        {

                            validgender = true;
                            memberGender = memberGenderString.charAt(0);
                        }
                    }

                    String memberAgeStr = JOptionPane.showInputDialog("Please enter the member's age");
                    int memberAge = Integer.parseInt(memberAgeStr);

                    // Creates a new member object using the details the user inputs
                    Member member = new Member(memberForeName, memberSurname, memberGender, memberAge);

                    // Adds the new member object to the member list
                    addMemberToList(memberList, memberJList, memberListModel, member);
                }
                catch (Exception e1) {

                    System.out.println("Beware you are reading from and writing to an array");
                }
            }
        }));

        // Gets the selected member and displays their details below
        memberJList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {

                    // The getValueIsAdjusting() method came from Stack Overflow. It returns true or false depending on whether actions
                    // are being performed to change the list selection, or they are completed.
                    // Checking if this is true seems to be necessary to avoid errors when adding a new value to the list.
                    // Omitting the check, or checking if it returns false, causes errors when a new value is added (although
                    // it does not actually crash the program or seem to impact anything

                    String forename = ((Member) memberJList.getSelectedValue()).getForename(); // Needs to be cast back to Member type as JList elements are some other type
                    String surname = ((Member) memberJList.getSelectedValue()).getSurname(); // Needs to be cast back to Member type as JList elements are some other type
                    char gender = ((Member) memberJList.getSelectedValue()).getGender(); // Needs to be cast back to Member type as JList elements are some other type
                    int age = ((Member) memberJList.getSelectedValue()).getAge(); // Needs to be cast back to Member type as JList elements are some other type

                    memberDetails.setText("Name: " + forename + " " + surname + "\n" + "Gender: " + gender + "\n" + "Age: " + age); // Build the string to be displayed
                }
            }
        });

        /*
        This next function is used to determine what the JList component actually displays
        As each element of the list is a Member object, not using a custom cell renderer means
        that what will actually be displayed on the window is the name of the object type plus a memory address
        This isn't useful for the front end of an application

        NOTE: This was taken almost verbatim from Stack Overflow
        */
        memberJList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (renderer instanceof JLabel && value instanceof Member) {

                    String forename = ((Member) value).getForename();
                    String surname = ((Member) value).getSurname();

                    ((JLabel) renderer).setText(forename + " " + surname);
                }

                return renderer;
            }
        });

        // Empty label to create space between text area and button - only way I could figure out how to do it
        JLabel emptyLabel2 = new JLabel("");
        emptyLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        emptyLabel2.setBorder(BorderFactory.createEmptyBorder(8,0,0,0));
        add(emptyLabel2);

        // Button to save member list as text file
        JButton writeMemberListToFile = new JButton("Download Member List");
        writeMemberListToFile.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(writeMemberListToFile);

        writeMemberListToFile.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                saveMemberList(memberList);
            }
        }));

        // Empty label to create space between text area and button - only way I could figure out how to do it
        JLabel emptyLabel3 = new JLabel("");
        emptyLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        emptyLabel3.setBorder(BorderFactory.createEmptyBorder(8,0,0,0));
        add(emptyLabel3);

        // Button to save member names as array
        JButton saveMemberNamesButton = new JButton("Save Member Names");
        saveMemberNamesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(saveMemberNamesButton);

        saveMemberNamesButton.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                memberArr = saveMemberNames(memberList);
                printMemberNames(memberArr);
            }
        }));
    }

    public void addMemberToList(ArrayList<Member> list, JList jList, DefaultListModel modelList, Member newMember) {
        /*
          Function to add a new member to the member list
          Parameter 1: The ArrayList of members
          Parameter 2: The JList component used to display the member list
          Parameter 3: The model list used to dynamically manage the JList component
          Parameter 4: An object of type Member
         */

        list.add(newMember); // Adds new member to the ArrayList
        modelList.add(modelList.size(), newMember); // Adds new member to the list model at index position equal to current member list size; i.e. puts it at the end

        // Refreshes the JList component, so the new member is displayed
        jList.setModel(modelList);
    }

    public void saveMemberList(ArrayList<Member> list) {

        String memberListStr = "MEMBER LIST\n\n";

        for (int i = 0; i < list.size(); i ++) {

            // Append member details to string
            memberListStr += list.get(i).getForename();
            memberListStr += " ";
            memberListStr += list.get(i).getSurname();
            memberListStr += "\n";
            memberListStr += list.get(i).getAge();
            memberListStr += "\n";
            memberListStr += list.get(i).getGender();
            memberListStr += "\n\n";
        }

        PrintWriter fileOut;
        String fileName = "MemberList.txt"; // Write to root of your package
        try {

            fileOut = new PrintWriter(fileName);
            fileOut.println(memberListStr);
            fileOut.close();
            System.out.println("File created successfully!\n");
        }
        catch (FileNotFoundException err){

            System.out.println("Error: " + err.getMessage());
        }
    }

    public String[] saveMemberNames(ArrayList<Member> list) {

        // Saves the member names to an array
        memberArr = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {

            memberArr[i] = list.get(i).getForename() + " " + list.get(i).getSurname();
        }

        return memberArr;
    }

    public void printMemberNames(String[] arr) {

        // Prints the contents of the array holding the member names to the console
        for (int i = 0; i < arr.length; i ++) {

            System.out.println("Member " + (i + 1) + ": " + arr[i]);
        }

        System.out.println("\n");
    }
}
