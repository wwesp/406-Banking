package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home_page extends JFrame {
    private JButton ATM_button;
    private JPanel Homepage;
    private JButton manager;
    private JButton teller;


    public static void main(String[] args) {
        new home_page();
    }

    public home_page() {

        JFrame frame = new JFrame("Home ");
        frame.setContentPane(Homepage);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        teller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                validate_teller_user validate_teller_user = new validate_teller_user();
                validate_teller_user.setVisible(true);
            }
        });
        ATM_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                validate_atm_customer ATM = new validate_atm_customer();
                ATM.setVisible(true);
            }
        });
        manager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_home tellerHome = new manager_home();
                tellerHome.setVisible(true);
            }
        });
    }
}
