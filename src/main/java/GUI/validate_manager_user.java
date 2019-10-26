package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Accounts.BankAccounts.Accounts;
import Accounts.People.Managment;
import persistence.GetData.GetData;
import persistence.GetData.GetData.*;

public class validate_manager_user extends JFrame{
    private JPanel validate_manager_user;
    private JButton accept_button;
    private JButton back_button;
    private JPasswordField passwordField1;

    public static void main(String[] args) {
        new validate_manager_user();
    }

    public validate_manager_user() {
        JFrame frame = new JFrame("Create Savings Account");
        frame.setContentPane(validate_manager_user);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                home_page home_page = new home_page();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Managment managers = new GetData().getManager(String.copyValueOf(passwordField1.getPassword()));
                if (managers != null){
                    frame.setVisible(false);
                    manager_home manager_home = new manager_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        });
        passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Managment managers = new GetData().getManager(String.copyValueOf(passwordField1.getPassword()));
                if (managers != null){
                    frame.setVisible(false);
                    manager_home manager_home = new manager_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        });
    }
}
