package GUI;

import Accounts.People.Customer;
import persistence.GetData.GetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class manager_verify_loan_customer extends JFrame{
    private JPanel manager_verify_loan_customer;
    private JButton accept_button;
    private JButton back_button;
    private JPasswordField passwordField1;

    public static void main(String[] args) {
        new manager_verify_loan_customer(null);
    }

    public manager_verify_loan_customer(String previous_page) {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_verify_loan_customer);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new GetData().getCustomerBySSN(String.copyValueOf(passwordField1.getPassword()));
                if (customer != null) {
                    if (previous_page.equals("View Loans")) {
                        frame.setVisible(false);
                        manager_view_loans manager_view_loans = new manager_view_loans(String.copyValueOf(passwordField1.getPassword()));
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    }
                    if (previous_page.equals("Create Loans")){
                        frame.setVisible(false);
                        manager_create_loan manager_create_loan = new manager_create_loan(String.copyValueOf(passwordField1.getPassword()));
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Account");
                }
            }
        });
        passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new GetData().getCustomerBySSN(String.copyValueOf(passwordField1.getPassword()));
                if (customer != null) {
                    if (previous_page.equals("View Loans")) {
                        frame.setVisible(false);
                        manager_view_loans manager_view_loans = new manager_view_loans(String.copyValueOf(passwordField1.getPassword()));
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    }
                    if (previous_page.equals("Create Loans")){
                        frame.setVisible(false);
                        manager_create_loan manager_create_loan = new manager_create_loan(String.copyValueOf(passwordField1.getPassword()));
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Account");
                }
            }
        });
    }
}
