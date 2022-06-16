package BoardingPassGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BoardingFrame extends JFrame{
    static Font labelFont = new Font("SansSerif", Font.BOLD, 18);
    static Font entryFont = new Font("SansSerif", Font.PLAIN, 16);
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private String age;
    public static String days;
    private String origin;
    private String destination;
    public static String flightClass;
    JButton bookButton;

    //String Array that populates seats if "B" is selected
    final DefaultComboBoxModel businessClass = new DefaultComboBoxModel<>(new String[] {"A1", "A2", "A3", "A4", "A6", "A7", "A8", "A9", "A10", "A11", "A12",
                                                                                        "B1", "B2", "B3", "B4", "B6", "B7", "B8", "B9", "B10", "B11", "B12"});
    //String Array that populates seats if "E" is selected
    final DefaultComboBoxModel economyClass = new DefaultComboBoxModel<>(new String[] {"C1", "C2", "C3", "C4", "C6", "C7", "C8", "C9", "C10", "C11", "C12",
                                                                                    "D1", "D2", "D3", "D4", "D6", "D7", "D8", "D9", "D10", "D11", "D12",
                                                                                    "E6", "E7", "E8", "E9", "E10", "E11", "E12",
                                                                                    "F6", "F7", "F8", "F9", "F10", "F11", "F12",
                                                                                    "G6", "G7", "G8", "G9", "G10", "G11", "G12"});
    BoardingFrame() throws IOException {
        //Stops program if window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        //Sets window dimensions
        this.setSize(400, 650);
        //Opens window in center of screen
        this.setLocationRelativeTo(null);

        //Name Label
        JLabel passengerNameLabel = new JLabel("Name");
        passengerNameLabel.setFont(labelFont);
        passengerNameLabel.setBounds(50, 50, 100, 25);
        this.add(passengerNameLabel);

        //Name
        JTextField passengerName = new JTextField();
        passengerName.setFont(entryFont);
        passengerName.setBounds(125, 50, 200, 25);
        this.add(passengerName);

        //Email Label
        JLabel passengerEmailLabel = new JLabel("Email");
        passengerEmailLabel.setFont(labelFont);
        passengerEmailLabel.setBounds(50, 100, 100, 25);
        this.add(passengerEmailLabel);

        //Email
        JTextField passengerEmail = new JTextField();
        passengerEmail.setFont(entryFont);
        passengerEmail.setBounds(125, 100, 200, 25);
        this.add(passengerEmail);

        //Phone Number Label
        JLabel passengerPhoneNumberLabel = new JLabel("Phone");
        passengerPhoneNumberLabel.setFont(labelFont);
        passengerPhoneNumberLabel.setBounds(50, 150, 100, 25);
        this.add(passengerPhoneNumberLabel);

        //Phone Number
        JTextField passengerPhoneNumber = new JTextField();
        passengerPhoneNumber.setFont(entryFont);
        passengerPhoneNumber.setBounds(125, 150, 200, 25);
        this.add(passengerPhoneNumber);

        //Gender Label
        JLabel passengerGenderLabel = new JLabel("Gender");
        passengerGenderLabel.setFont(labelFont);
        passengerGenderLabel.setBounds(50, 200, 100, 25);
        this.add(passengerGenderLabel);

        //Gender
        String[] genders = {"Select", "Male", "Female", "Other"};
        JComboBox passengerGender = new JComboBox(genders);
        passengerGender.setFont(entryFont);
        passengerGender.setBounds(125, 200, 100, 25);
        this.add(passengerGender);

        //Age Label
        JLabel passengerAgeLabel = new JLabel("Age");
        passengerAgeLabel.setFont(labelFont);
        passengerAgeLabel.setBounds(50, 250, 100, 25);
        this.add(passengerAgeLabel);

        //Age
        JTextField passengerAge = new JTextField();
        passengerAge.setFont(entryFont);
        passengerAge.setBounds(125, 250, 50, 25);
        this.add(passengerAge);

        //Date Label
        JLabel passengerDateLabel = new JLabel("Days Until Departure");
        passengerDateLabel.setFont(labelFont);
        passengerDateLabel.setBounds(50, 300, 250, 25);
        this.add(passengerDateLabel);

        //Date
        JTextField passengerDate = new JTextField();
        passengerDate.setFont(entryFont);
        passengerDate.setBounds(250, 300, 75, 25);
        this.add(passengerDate);

        //Origin Label
        JLabel passengerOriginLabel = new JLabel("Origin");
        passengerOriginLabel.setFont(labelFont);
        passengerOriginLabel.setBounds(50, 400, 150, 25);
        this.add(passengerOriginLabel);

        //Origin
        String[] origins = {"Select", "Los Angeles", "San Francisco", "New York City", "Chicago",
                "Phoenix", "Philadelphia", "Houston", "San Antonio", "Dallas", "Atlanta",
                "Denver", "Orlando", "Miami"};
        JComboBox passengerOrigin = new JComboBox(origins);
        passengerOrigin.setFont(entryFont);
        passengerOrigin.setBounds(165, 400, 150, 25);
        this.add(passengerOrigin);

        //Destination Label
        JLabel passengerDestinationLabel = new JLabel("Destination");
        passengerDestinationLabel.setFont(labelFont);
        passengerDestinationLabel.setBounds(50, 350, 150, 25);
        this.add(passengerDestinationLabel);

        //Destination
        String[] destinations = {"Select", "Los Angeles", "San Francisco", "New York City", "Chicago",
                "Phoenix", "Philadelphia", "Houston", "San Antonio", "Dallas", "Atlanta",
                "Denver", "Orlando", "Miami"};
        JComboBox passengerDestination = new JComboBox(destinations);
        passengerDestination.setFont(entryFont);
        passengerDestination.setBounds(165, 350, 150, 25);
        this.add(passengerDestination);

        //Class Label
        JLabel passengerClassLabel = new JLabel("Business (B) or Economy (E)?");
        passengerClassLabel.setFont(labelFont);
        passengerClassLabel.setBounds(25, 450, 300, 25);
        this.add(passengerClassLabel);

        //Class
        String[] classes = {"Select", "B", "E"};
        JComboBox passengerClass = new JComboBox(classes);
        passengerClass.setFont(entryFont);
        passengerClass.setBounds(300, 450, 50, 25);
        this.add(passengerClass);

        //Seat Label
        JLabel passengerSeatLabel = new JLabel("Select Seat");
        passengerSeatLabel.setFont(labelFont);
        passengerSeatLabel.setBounds(50, 500, 100, 25);
        this.add(passengerSeatLabel);

        //Seat
        JComboBox passengerSeat = new JComboBox();
        //Sets seat combobox values based on selection of passenger class combobox
        passengerClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //If B is selected seats combobox is populated with business class array
                if("B".equals(passengerClass.getSelectedItem())) {
                    passengerSeat.setModel(businessClass);
                    passengerSeat.setFont(entryFont);
                    passengerSeat.setBounds(150, 500, 100, 25);
                } else {
                    //If E is selected seats combobox is populated with business class array
                    passengerSeat.setModel(economyClass);
                    passengerSeat.setFont(entryFont);
                    passengerSeat.setBounds(150, 500, 100, 25);
                }
            }
        });
        this.add(passengerSeat);

        //Sets book button
        bookButton = new JButton();
        bookButton.setBounds(150, 550, 100, 25);
        bookButton.setText("Book");
        //Gets rid of box around "Book" on button
        bookButton.setFocusable(false);
        //If button is pushed everything below is executed
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardingPass boardingPass = null;
                try {
                    boardingPass = new BoardingPass(flightClass, name, origin, destination, age, email, gender, phoneNumber);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                //Sets all values entered in GUI to boarding pass variables
                boardingPass.type = passengerClass.getSelectedItem().toString();
                boardingPass.name = passengerName.getText();
                boardingPass.from = passengerOrigin.getSelectedItem().toString();
                boardingPass.destination = passengerDestination.getSelectedItem().toString();
                boardingPass.age = passengerAge.getText();
                boardingPass.email = passengerEmail.getText();
                boardingPass.gender = passengerGender.getSelectedItem().toString();
                boardingPass.phone = passengerPhoneNumber.getText();
                boardingPass.seat = passengerSeat.getSelectedItem().toString();

                try {
                    //Moved from main
                    boardingPass.generatePass();
                    boardingPass.calculateETA();
                    boardingPass.claculateCost();
                    boardingPass.writeImage();
                    System.exit(0);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        this.add(passengerSeat);
        this.add(bookButton);


        this.setVisible(true);
    }

}

