package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.People.Customer;
import persistence.GetData.GetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ATM_home extends JFrame {
    private JPanel ATM_home;
    private JButton back_button;
    private JButton withdraw_account_2;
    private JButton deposit_account_2;
    private JTable checking_table;
    private JLabel last_name_label;
    private JLabel first_name_label;

    public static void main(String[] args) {
        new ATM_home(null);
    }

    public ATM_home(String customer){
        JFrame frame = new JFrame("Deposit");
        frame.setContentPane(ATM_home);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Customer customer1 = new GetData().getCustomerByATM(customer);
        last_name_label.setText(customer1.getlName());
        first_name_label.setText(customer1.getfName());

        ArrayList<Checking> checking = new GetData().getCheckingByATMCard(customer);
        checking_table.setModel(new javax.swing.table.DefaultTableModel(

                new Object [][] {
                        {checking.get(0).getID(), checking.get(0).getBalancef(), checking.get(0).getAccType()}
                },
                new String [] {
                        "Account ID", "Balance", "Account Type"
                }
        ));

        withdraw_account_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                withdraw_ATM withdraw_page = new withdraw_ATM();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        deposit_account_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                deposit_ATM deposit_page = new deposit_ATM();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                home_page home_page = new home_page();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
