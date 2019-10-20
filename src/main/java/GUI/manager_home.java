package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager_home extends JPanel {
    private JPanel manager_home_panel;
    private JButton create_checking_account;
    private JButton back_button;
    private JButton billing_button;
    private JButton rollover_notice_button;
    private JButton terminate_account_button;
    private JButton loan_button;
    private JButton transfer_funds_button;
    private JButton create_savings_button;
    private JButton lookup_accout_button;

    public static void main(String[] args) {
        new manager_home();
    }

    public manager_home() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_home_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        create_checking_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                create_checking_page checking = new create_checking_page(3);
                checking.setVisible(true);
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
        lookup_accout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_verify_accounts_customer manager_verify_accounts_customer = new manager_verify_accounts_customer();
                manager_verify_accounts_customer.setVisible(true);
            }
        });
        transfer_funds_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_verify_transfer_customer manager_verify_transfer_customer = new manager_verify_transfer_customer();
                manager_verify_transfer_customer.setVisible(true);
            }
        });
        loan_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_verify_loan_customer manager_verify_loan_customer = new manager_verify_loan_customer();
                manager_verify_loan_customer.setVisible(true);
            }
        });
        terminate_account_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_verify_terminate_customer manager_verify_terminate_customer = new manager_verify_terminate_customer();
                manager_verify_terminate_customer.setVisible(true);
            }
        });
        rollover_notice_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_rollover_notices manager_rollover_notices = new manager_rollover_notices();
                manager_rollover_notices.setVisible(true);
            }
        });
        billing_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_send_bills manager_send_bills = new manager_send_bills();
                manager_send_bills.setVisible(true);
            }
        });
        create_savings_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                create_saving_page create_saving_page = new create_saving_page(2);
                create_saving_page.setVisible(true);
            }
        });
    }
}
