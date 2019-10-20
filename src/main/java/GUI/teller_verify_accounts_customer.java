package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class teller_verify_accounts_customer extends JFrame{
    private JPanel teller_verify_accounts_customer;
    private JPasswordField passwordField1;
    private JButton accept_button;
    private JButton back_button;

    public static void main(String[] args) {
        new teller_verify_accounts_customer();
    }

    public teller_verify_accounts_customer() {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(teller_verify_accounts_customer);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                teller_home teller_home = new teller_home();
                teller_home.setVisible(true);
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                teller_view_accounts teller_view_accounts = new teller_view_accounts();
                teller_view_accounts.setVisible(true);
            }
        });
    }
}
