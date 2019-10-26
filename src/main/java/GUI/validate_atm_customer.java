package GUI;

import Accounts.People.Customer;
import Accounts.People.Teller;
import persistence.GetData.GetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class validate_atm_customer extends JFrame {
    private JPanel validate_atm_customer;
    private JPasswordField passwordField1;
    private JButton accept_button;
    private JButton back_button;

    public static void main(String[] args) {
        new validate_atm_customer();
    }

    public validate_atm_customer() {

        JFrame frame = new JFrame("Enter Card Number");
        frame.setContentPane(validate_atm_customer);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new GetData().getCustomerByATM(String.copyValueOf(passwordField1.getPassword()));
                if (customer != null){
                    frame.setVisible(false);
                    ATM_home ATM_home = new ATM_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        });
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                home_page home_page = new home_page();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new GetData().getCustomerByATM(String.copyValueOf(passwordField1.getPassword()));
                if (customer != null){
                    frame.setVisible(false);
                    ATM_home ATM_home = new ATM_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        });
    }
}