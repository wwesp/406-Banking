package GUI;

import Accounts.People.Teller;
import persistence.GetData.GetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class validate_teller_user extends JFrame{
    private JPanel validate_teller_user;
    private JButton back_button;
    private JButton accept_button;
    private JPasswordField passwordField1;

    public static void main(String[] args) {
        new validate_teller_user();
    }

    public validate_teller_user() {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(validate_teller_user);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                home_page home_page = new home_page();
                home_page.setVisible(true);
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teller teller = new GetData().getTeller(String.copyValueOf(passwordField1.getPassword()));
                if (teller != null){
                    frame.dispose();
                    teller_home teller_home = new teller_home();
                    teller_home.setVisible(true);
                }
                else JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        });
        passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teller teller = new GetData().getTeller(String.copyValueOf(passwordField1.getPassword()));
                if (teller != null){
                    frame.dispose();
                    teller_home teller_home = new teller_home();
                    teller_home.setVisible(true);
                }
                else JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        });
    }
}
