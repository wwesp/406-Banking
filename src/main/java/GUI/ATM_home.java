package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM_home extends JFrame {
    private JPanel ATM_home;
    private JButton back_button;
    private JLabel account_1;
    private JLabel account_2;
    private JButton withdraw_account_1;
    private JButton withdraw_account_2;
    private JButton deposit_account_2;
    private JButton deposit_account_1;

    public static void main(String[] args) {
        new ATM_home();
    }

    public ATM_home(){
        JFrame frame = new JFrame("Deposit");
        frame.setContentPane(ATM_home);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        withdraw_account_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                withdraw_ATM withdraw_page = new withdraw_ATM();
                withdraw_page.setVisible(true);
            }
        });
        withdraw_account_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                withdraw_ATM withdraw_page = new withdraw_ATM();
                withdraw_page.setVisible(true);
            }
        });
        deposit_account_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                deposit_ATM deposit_page = new deposit_ATM();
                deposit_page.setVisible(true);
            }
        });
        deposit_account_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                deposit_ATM deposit_page = new deposit_ATM();
                deposit_page.setVisible(true);
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
