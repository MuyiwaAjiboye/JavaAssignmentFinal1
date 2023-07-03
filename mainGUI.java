import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class mainGUI {

    JTextField fullname = new JTextField();

    JTextField Department = new JTextField();

    JTextField Clocation = new JTextField();

    JTextField Time = new JTextField();
    String[] tp = { "Tricycle-Tier1_#300", "Tricycle-Tier2_#100", "Motorcycle_#100" };

    JComboBox tplist = new JComboBox(tp);

    String[] locations = { "Portfolio_hostel", "New_Girls_hostel1", "New_Boys_hostel", "Chapel", "ICT",
            "Old_Hostel_Boys", "Old_Hostel_Girls", "Big_Cafe", "SDC", "Green_Plaza", "MED_Block", "SBS_block",
            "Nursing_Block", "Main_Library", "Admin_Block", "Security_Post", "FacultyOfEnvironment",
            "ComputerScienceBlock" };

    JComboBox listOfLocations = new JComboBox(locations);

    public void mainGui() {

        // my drop down simple code

        listOfLocations.setAlignmentX(10);
        listOfLocations.setAlignmentY(10);
        //

        // Welcome Dialog
        JOptionPane.showMessageDialog(null, "Welcome To Bingham Transport Services");
        //

        // Text requests
        DTextf label1 = new DTextf();
        label1.setText("Please Enter Your Full_Name:");
        DTextf label2 = new DTextf();
        label2.setText("Please Enter Your Department:");
        DTextf label3 = new DTextf();
        label3.setText("Please Enter Your Current Location:");
        DTextf label4 = new DTextf();
        label4.setText("Please Enter Where you're Heading To:");
        DTextf label5 = new DTextf();
        label5.setText("What day and time do you want to leave:?");

        //

        // TextField Code
        fullname.setPreferredSize(new Dimension(240, 30));
        fullname.setFont(new Font("Consolas", Font.PLAIN, 30));

        Department.setPreferredSize(new Dimension(240, 30));
        Department.setFont(new Font("Consolas", Font.PLAIN, 30));

        Clocation.setPreferredSize(new Dimension(240, 10));
        Clocation.setFont(new Font("Consolas", Font.PLAIN, 30));
        Time.setPreferredSize(new Dimension(240, 5));
        Time.setFont(new Font("Consolas", Font.PLAIN, 30));

        //

        // button code

        JButton setRide = new JButton();
        setRide.setBounds(150, 100, 0, 0);
        setRide.setText("Set ride");
        setRide.setFocusable(false);// removes annoying border around my text
        setRide.setForeground(Color.green);
        setRide.setBorder(BorderFactory.createEtchedBorder());
        setRide.addActionListener(e -> {

            String name = fullname.getText();
            String department = Department.getText();
            String currentl = Clocation.getText();
            String time = Time.getText();

            if (name.isEmpty() || department.isEmpty() || currentl.isEmpty() || time.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hey there! You haven't filled all required fields!");
            } else {
                Overview();
            }

            try {

                Filewriter.appendData("|TransportSlip|");
                Filewriter.appendData(fullname.getText());
                Filewriter.appendData(Department.getText());
                Filewriter.appendData(Clocation.getText());
                Filewriter.appendData(tplist.getSelectedItem().toString());
                Filewriter.appendData(Time.getText());
                Filewriter.appendData(listOfLocations.getSelectedItem().toString());

            } catch (IOException e1) {

                e1.printStackTrace();
            }

        });

        //

        // Frame
        Dframe frame1 = new Dframe();
        frame1.add(label1);
        frame1.add(fullname);
        frame1.add(tplist);
        frame1.add(label2);
        frame1.add(Department);
        frame1.add(label3);
        frame1.add(Clocation);
        frame1.add(label4);
        frame1.add(listOfLocations);
        frame1.add(label5);
        frame1.add(Time);
        frame1.add(setRide);

        frame1.setLayout(new GridLayout(12, 1, 6, 10));

    }

    public void Overview() {
        // mainGUI info = new mainGUI();
        // String name = info.fullname.getText();
        // String department = info.Department.getText();
        // String currentl = info.Clocation.getText();

        JOptionPane.showMessageDialog(null, "Hello" + " " + fullname.getText() + '\n' +
                "of" + " " + Department.getText() + '\n'
                + "You're Currently at" + " " + Clocation.getText() + '\n' + "Your " + ""
                + tplist.getSelectedItem().toString() + " Will come pick you at" + " " + Clocation.getText() + " "
                + "at" + " "
                + Time.getText() + "and then drop you at" + " "
                + listOfLocations.getSelectedItem().toString());
    }
}
