package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.People.Customer;
import persistence.GetData.GetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class transfer_money_to extends JFrame{
    private JPanel transfer_money_to;
    private JButton back_button;
    private JButton accept_button;
    private JTable savings_table;
    private JTable checking_table;
    private JLabel last_name;
    private JLabel first_name;

    public static void main(String[] args) {
        new transfer_money_to(null,null,null, null);
    }

    public transfer_money_to(String first_customer, String first_ID, String first_SSN, Double amount) {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(transfer_money_to);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Customer customer1 = new GetData().getCustomerBySSN(first_customer);
        last_name.setText(customer1.getlName());
        first_name.setText(customer1.getfName());
        String SSN = customer1.getSsn();

        ArrayList<Checking> checking = new GetData().getCheckingBySSN(first_customer);
        checking_table.setModel(new javax.swing.table.DefaultTableModel(

                new Object [][] {
                        {checking.get(0).getID(), checking.get(0).getBalancef(), checking.get(0).getAccType()}
                        },
                new String []{
                        "Account ID", "Balance", "Account Type"
                })
                                {public boolean isCellEditable(int row, int column){return false;}}
        );

        ArrayList<RegSavings> savings = new GetData().getRegSavings(first_customer);
        savings_table.setModel(new javax.swing.table.DefaultTableModel(

                new Object [][] {
                        {savings.get(0).getID(), savings.get(0).getBalancef(), savings.get(0).getInterestRate()}
                        },
                new String []{
                        "Account ID", "Balance", "Interest Rate"
                })
                               {public boolean isCellEditable(int row, int column){return false;}}
        );

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                transfer_money_from transfer_money_from = new transfer_money_from(first_customer);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                transfer_money_summary transfer_money_summary = new transfer_money_summary();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
