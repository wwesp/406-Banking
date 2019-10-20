package GUI;

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

                System.out.println(String.copyValueOf(passwordField1.getPassword()));
                if (String.copyValueOf(passwordField1.getPassword()).equals("guest")){
                    frame.dispose();
                    ATM_home atm_home_page = new ATM_home();
                    atm_home_page.setVisible(true);
                }
                else JOptionPane.showMessageDialog(null, "Invalid Card Number");
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
    }
}