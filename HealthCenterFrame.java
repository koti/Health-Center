
package healthcenter;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;


public class HealthCenterFrame extends JFrame {
    
    //declare my components
    private JLabel l1, l2;
    private JButton calculate;
    private JComboBox gym, snack, massage;
    private JTextField customerID, age;
    private JRadioButton male, female;
    private ButtonGroup gender;
    private JRadioButtonMenuItem themeItems[];
    private ButtonGroup themeButtonGroup;

    private String gyms[] = {"Exercising Programs","Zumba", "Circuit", "Crossfit", "Yoga", "Pilates"};
    private String snacks[] = {"Snacks","Protein bar", "Protein scoop", "Isotonics", "Energy drinks"};
    private String massages[] = {"Massages","Full Body", "Relax", "Sports", "Reflexology", "Shiatsu"};
    private double gymsPrices[] = {0.0, 10.0, 10.0, 12.0, 10.0, 10.0};
    private int gymsDurations[] = {0, 45, 40, 50, 60, 60};
    private double snacksPrices[] = {0.0, 3.0, 3.0, 4.0, 5.0};
    private int snacksCalories[] = {0, 22, 150, 300, 500};
    private double massagesPrices[] = {0.0, 60.0, 40.0, 30.0, 30.0, 40.0};
    private int massagesDuration[] = {0, 90, 50, 45, 40, 60};
    private Formatter output;
    private Scanner input;
    
    //consstructor
    public HealthCenterFrame() {
        
        //Name of the window
        super("Health Center");
        setLayout(new FlowLayout());
        
        //set my components
        l1 = new JLabel("Customer ID (5 digits)");
        
        l2 = new JLabel("Age");
        
        calculate = new JButton("Calculate total");
        
        gym = new JComboBox(gyms);
        gym.setMaximumRowCount(gyms.length);
        
        snack = new JComboBox(snacks);
        snack.setMaximumRowCount(snacks.length);
        
        massage = new JComboBox(massages);
        massage.setMaximumRowCount(massages.length);
        
        customerID = new JTextField(4);
        
        age = new JTextField(2);
        
        male = new JRadioButton("Male");
        male.setActionCommand("Male");
        
        female = new JRadioButton("Female");
        female.setActionCommand("Female");
        
        gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);
        
        //add my components to their right place
        add(l1);
        add(customerID);
        add(l2);
        add(age);
        add(male);
        add(female);
        add(gym);
        add(snack);
        add(massage);
        add(calculate);
        
        // new handler
        Handler handler = new Handler();
        
        calculate.addActionListener(handler);

        //Start building my menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('f');
        
        //Updating my frame to make new payments
        JMenuItem newItem = new JMenuItem("New Payment");
        newItem.setMnemonic('n');
        fileMenu.add(newItem);
        newItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ev8) {
                        dispose();
                        HealthCenterFrame healthFrame = new HealthCenterFrame(); // create MenuFrame
                        healthFrame.pack();
                        healthFrame.setLocationRelativeTo(null);
                        healthFrame.setSize( 400, 200 ); // set frame size
                        healthFrame.setVisible( true ); // display frame
                        healthFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        );
        
        //"About" section of my program
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setMnemonic('a');
        fileMenu.add(aboutItem);
        aboutItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {
                        JOptionPane.showMessageDialog(HealthCenterFrame.this, "This is the Health Center's payment system. This program records every payment done by the clients.", "About", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
        );
        
        //Press it to exit the program
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('x');
        fileMenu.add(exitItem);
        exitItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ev3) {
                        System.exit(0);
                    }
                }
        );
        
        //Add the File tab
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(fileMenu); 
        
        //Add the Display tab
        JMenu displayMenu = new JMenu("Display");
        displayMenu.setMnemonic('d');
        
        //Add the Payment records section
        JMenuItem recordsItem = new JMenuItem("Payment Records");
        recordsItem.setMnemonic('r');
        displayMenu.add(recordsItem);
        recordsItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ev10) {
                        try {
                            input = new Scanner(new File("Payments.txt"));
                        }
                        catch (FileNotFoundException ex) {
                            System.err.println("Error opening the file");
                            return;
                        }
                        
                        PaymentRecord payments = new PaymentRecord();
                        String record = "";
                        
                        try {
                            while(input.hasNext()) {
                                String t = input.next();
                                payments.setCustomerID(input.nextInt());
                                String a = input.next();
                                payments.setAge(input.nextInt());
                                String b = input.next();
                                payments.setGender(input.next());
                                String c = input.next();
                                payments.setAmount(input.nextDouble());
                                String d = input.next();
                                record += payments.toString();
                            }
                            JOptionPane.showMessageDialog(null, record, "Payment Records", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch(IllegalStateException ex) {
                            System.err.println("Error reading from file.");
                            return;
                        }
                        catch(NoSuchElementException ex) {
                            System.err.println("File improperly formed.");
                            input.close();
                            return;
                        }
                    }
                }
        );
        
        //Dark and white theme
        String themes[] = {"White theme", "Dark theme"};
        
        JMenu themeMenu = new JMenu("Theme");
        themeMenu.setMnemonic('t');
        
        themeItems = new JRadioButtonMenuItem[themes.length];
        themeButtonGroup = new ButtonGroup();
        
        
        for(int i = 0; i < themes.length; i++) {
            themeItems[i] = new JRadioButtonMenuItem(themes[i]);
            themeMenu.add(themeItems[i]);
            themeButtonGroup.add(themeItems[i]);
            themeItems[i].addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent ev3) {
                            if(themeItems[0].isSelected()) {
                                getContentPane().setBackground(null);
                                l1.setForeground(null);
                                l2.setForeground(null);
                            }
                            else if( themeItems[1].isSelected()) {
                                getContentPane().setBackground(Color.DARK_GRAY);
                                l1.setForeground(Color.WHITE);
                                l2.setForeground(Color.WHITE);
                            }
                        }
                    });
        }
        
        themeItems[0].setSelected(true);
        
        displayMenu.add(themeMenu);
        
        bar.add(displayMenu);
        
        //try and catch my file creation
        try {
            FileWriter f = new FileWriter("Payments.txt", true);
            output = new Formatter(f);
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Error in creating or opening the file", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        catch(SecurityException securityException) {
            JOptionPane.showMessageDialog(null, "You do not have write access to this file", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    //impement the handler
    private class Handler implements ActionListener{
        
        //for catching possible input errors
        public void actionPerformed(ActionEvent ev1) {
            String idCheck = customerID.getText();
            String ageCheck = age.getText();
            
            
            //Trying and catch the input
            try { 
                int num2 = Integer.parseInt(ageCheck);
                if(idCheck.length() != 5) {
                    throw new NumberFormatException("demo");
                }
                if(num2 <= 0 || num2 > 130) {
                    throw new NumberFormatException("demo");
                }
                if(!male.isSelected() && !female.isSelected()) {
                    throw new NullPointerException("demo");
                }
                
                if(ev1.getSource() == calculate) {
                    ExercisingPrograms prg = new ExercisingPrograms(gymsPrices[gym.getSelectedIndex()], gyms[gym.getSelectedIndex()], gymsDurations[gym.getSelectedIndex()]);
                    Massages msg = new Massages(massagesPrices[massage.getSelectedIndex()], massages[massage.getSelectedIndex()], massagesDuration[massage.getSelectedIndex()]);
                    Snacks snk = new Snacks(snacksPrices[snack.getSelectedIndex()], snacks[snack.getSelectedIndex()], snacksCalories[snack.getSelectedIndex()]);    
                    double total;
                    total = prg.getPrice() + msg.getPrice() + snk.getPrice();
                    if(JOptionPane.showConfirmDialog(null,"Customer ID: " + customerID.getText()
                                                    + "\nAge: " + age.getText()
                                                    + "\nGender: " + gender.getSelection().getActionCommand()
                                                    + prg.toString()
                                                    + msg.toString()
                                                    + snk.toString()
                                                    + "\n Would you like to continue with the payment of " + total + "€?", " Payment Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {               
                    try {
                        output.format("CustomerID: " + customerID.getText() + "   Age: " + age.getText() + "   Gender: " + gender.getSelection().getActionCommand() + "   Amount: " + total + " €\n");
                    }
                    catch(FormatterClosedException elementException) {
                        JOptionPane.showMessageDialog(null, "Error writing to file", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    catch(NoSuchElementException elementException) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please try again", "Error", JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    }
                    output.close();
                    }
                    else {
                        return;
                    }    
                }
            }
            catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Customer ID must be a 5 digit number and Age must be a number not greater than 130. No one has ever lived more than that!", "Warning", JOptionPane.ERROR_MESSAGE);
            }
            catch(NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "You have to select a gender!", "Warning", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Unexpected error occured.", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
