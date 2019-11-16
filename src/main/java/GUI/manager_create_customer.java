package GUI;

import Accounts.People.Customer;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class manager_create_customer {
    private JTextField address_text;
    private JTextField zip_text;
    private JTextField fname_text;
    private JTextField city_text;
    private JTextField state_text;
    private JTextField ssn_text;
    private JTextField lname_text;
    private JButton acceptButton;
    private JButton backButton;
    private JPanel manager_create_customer_panel;

    public static void main(String[] args) {
        new manager_create_customer();
    }

    public manager_create_customer(){
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_create_customer_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ssn_text.getText().equals("");
                if (ssn_text.getText().isEmpty() || ssn_text.getText().equals("") && fname_text.getText().isEmpty() ||
                fname_text.getText().equals("") && lname_text.getText().isEmpty() || lname_text.getText().equals("") &&
                address_text.getText().isEmpty() || address_text.getText().equals("") && city_text.getText().isEmpty() ||
                city_text.getText().equals("") && state_text.getText().isEmpty() || state_text.getText().equals("") &&
                zip_text.getText().isEmpty() || zip_text.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter All Fields");
                }else {
                    Customer customer = new Customer(ssn_text.getText(), fname_text.getText(), lname_text.getText(),
                            address_text.getText(), city_text.getText(), state_text.getText(), zip_text.getText(),
                            null);
                    SaveData customer_to_save = new SaveData();
                    customer_to_save.saveCustomer(customer);
                    JOptionPane.showMessageDialog(null, fname_text.getText() + " " + lname_text.getText()
                    + "'s account has been created");
                    frame.setVisible(false);
                    manager_home manager_home = new manager_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
    }
}
