package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager_verify_accounts_customer extends JFrame{
    private JPanel manager_verify_accounts_customer;
    private JTextField textField1;
    private JButton accept_button;
    private JButton back_button;

    public static void main(String[] args) {
        new manager_verify_accounts_customer();
    }

    public manager_verify_accounts_customer() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_verify_accounts_customer);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_home manager_home = new manager_home();
                manager_home.setVisible(true);
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_view_accounts manager_view_accounts = new manager_view_accounts();
                manager_view_accounts.setVisible(true);
            }
        });
    }
}
