package GUI;

import Accounts.People.Customer;
import Accounts.People.Teller;
import persistence.GetData.GetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new GetData().getCustomerByATM(String.copyValueOf(passwordField1.getPassword()));
                if (customer != null){
                    frame.dispose();
                    ATM_home ATM_home = new ATM_home();
                    ATM_home.setVisible(true);
                }
                else JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        });
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                home_page home_page = new home_page();
                home_page.setVisible(true);
            }
        });
        passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new GetData().getCustomerByATM(String.copyValueOf(passwordField1.getPassword()));
                if (customer != null){
                    frame.dispose();
                    ATM_home ATM_home = new ATM_home();
                    ATM_home.setVisible(true);
                }
                else JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        });
    }
}