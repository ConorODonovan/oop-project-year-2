import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class MemberSection extends JPanel {

    public MemberSection() {

        setBackground(Color.green);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Members");
        add(titleLabel);

        // Initialising Member list
        ArrayList<Member> memberList = new ArrayList<>();
        DefaultListModel memberListModel = new DefaultListModel(); // This is to dynamically manage the contents of the JList we'll use to display the Member List

        // Creating some existing members to add to list
        Member member1 = new Member("Sarah Williamson", 'F', true);
        Member member2 = new Member("Joe Briggs", 'M', true);
        Member member3 = new Member("Kate Johnson", 'F', false);

        // Adding them to the standard ArrayList
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);

        // Adding them to the list model data structure also
        memberListModel.addElement(member1);
        memberListModel.addElement(member2);
        memberListModel.addElement(member3);

        // Creating the JList, which will display the Member List, and adding it to the window
        JList memberJList = new JList();
        add(memberJList, BorderLayout.CENTER);
        memberJList.setModel(memberListModel);

        // Button to add a new member
        JButton addNewMemberButton = new JButton("Add New Member");
        add(addNewMemberButton, BorderLayout.SOUTH);

        addNewMemberButton.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Asks user to input new member details with a series of popups
                String memberForeName = JOptionPane.showInputDialog("Please enter the member's first name");
                String memberSurname = JOptionPane.showInputDialog("Please enter the member's surname");
                char memberGender = 'F'; // Defaults to F, need to change this to allow user to select gender

                // Creates a new member object using the details the user inputs
                Member member = new Member(memberForeName + " " + memberSurname, memberGender, true);

                // Adds the new member object to the member list
                addMemberToList(memberList, memberJList, memberListModel, member);
            }
        }));

        // JUST FOR TESTING - REMOVE!!!
        for (int i = 0; i < memberList.size(); i ++) {

            System.out.println(memberList.get(i));
        }

        /*
        This next function is used to determine what the JList component actually displays
        As each element of the list is a Member object, not using a custom cell renderer means
        that what will actually be displayed on the window is the name of the object type plus a memory address
        This isn't useful for the front end of an application
        */
        memberJList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (renderer instanceof JLabel && value instanceof Member) {

                    ((JLabel) renderer).setText(((Member) value).getName());
                }

                return renderer;
            }
        });
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
        modelList.add(list.size(), newMember); // Adds new member to the list model at index position equal to current member list size; i.e. puts it at the end

        // JUST FOR TESTING - REMOVE!!!
        for (int i = 0; i < list.size(); i ++) {

            System.out.println(list.get(i));
        }

        // Refreshes the JList component, so the new member is displayed
        jList.setModel(modelList);
    }
}
