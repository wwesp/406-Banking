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

public class validate_teller_create_savings {
    private JPanel validate_teller_create_savings_panel;
    private JPasswordField passwordField1;
    private JButton accept_button;
    private JButton back_button;
    private String customer_ID;

    public static void main(String[] args) {
        new validate_teller_create_savings();
    }

    public validate_teller_create_savings() {
        JFrame frame = new JFrame("Create Checking");
        frame.setContentPane(validate_teller_create_savings_panel);
        frame.setPreferredSize(new Dimension(820, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<RegSavings> savings = new GetData().getRegSavings(String.copyValueOf(passwordField1.getPassword()));
                customer_ID = String.copyValueOf(passwordField1.getPassword());
                if (savings != null) {
                    frame.setVisible(false);
                    create_saving_page create_saving_page = new create_saving_page(2, customer_ID);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                } else
                    JOptionPane.showMessageDialog(null, "This Customer ID Does Not Exist. Please Create Customer Before Creating Saving Account");
            }
        });
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
                ArrayList<RegSavings> savings = new GetData().getRegSavings(String.copyValueOf(passwordField1.getPassword()));
                customer_ID = String.copyValueOf(passwordField1.getPassword());
                if (savings != null) {
                    frame.setVisible(false);
                    create_saving_page create_saving_page = new create_saving_page(2, customer_ID);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                } else
                    JOptionPane.showMessageDialog(null, "This Customer ID Does Not Exist. Please Create Customer Before Creating Saving Account");
            }
        });
    }
}
