package GUI;

import Accounts.BankAccounts.Money.RegSavings;
import Accounts.People.Customer;
import persistence.GetData.GetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class teller_verify_transfer_customer extends JFrame{
    private JPanel teller_verify_transfer_customer;
    private JButton back_button;
    private JButton accept_button;
    private JPasswordField passwordField1;

    public static void main(String[] args) {
        new teller_verify_transfer_customer();
    }

    public teller_verify_transfer_customer() {
        JFrame frame = new JFrame("Home ");
        frame.setContentPane(teller_verify_transfer_customer);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                teller_home teller_home = new teller_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new GetData().getCustomerBySSN(String.copyValueOf(passwordField1.getPassword()));
                if (customer != null) {
                    frame.setVisible(false);
                    transfer_money_from transfer_money = new transfer_money_from(String.copyValueOf(passwordField1.getPassword()));
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        });
        passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new GetData().getCustomerBySSN(String.copyValueOf(passwordField1.getPassword()));
                if (customer != null){
                    frame.setVisible(false);
                    transfer_money_from transfer_money_from = new transfer_money_from(String.copyValueOf(passwordField1.getPassword()));
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        });
    }
}
