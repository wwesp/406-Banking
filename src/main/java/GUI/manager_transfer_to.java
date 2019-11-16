package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.BankAccounts.Money.Savings;
import Accounts.People.Customer;
import persistence.GetData.GetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class manager_transfer_to extends JFrame{
    private JPanel manager_transfer_to;
    private JButton back_button;
    private JButton accept_button;
    private JTable checking_table;
    private JTable savings_table;
    private JLabel last_name;
    private JLabel first_name;
    private Checking first_checking_account;
    private Savings first_savings_account;
    private String ID;
    private String second_account_type;
    private Checking second_checking_account;
    private Savings second_savings_Account;

    public static void main(String[] args) {
        new manager_transfer_to(null, null, null, null);
    }

    public manager_transfer_to(String customer, String first_ID, String account_Type, Double amount) {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_transfer_to);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Customer customer1 = new GetData().getCustomerBySSN(customer);
        last_name.setText(customer1.getlName());
        first_name.setText(customer1.getfName());
        String SSN = customer1.getSsn();

        ArrayList<Checking> checking = new GetData().getCheckingBySSN(customer);
        checking_table.setModel(new javax.swing.table.DefaultTableModel(

                new Object [][] {
                        {checking.get(0).getID(), checking.get(0).getBalancef(), checking.get(0).getAccType()}
                },
                new String []{
                        "Account ID", "Balance", "Account Type"
                }) {public boolean isCellEditable(int row, int column){return false;}}
        );

        ArrayList<RegSavings> savings = new GetData().getRegSavings(customer);
        savings_table.setModel(new javax.swing.table.DefaultTableModel(

                new Object [][] {
                        {savings.get(0).getID(), savings.get(0).getBalancef(), savings.get(0).getInterestRate()}
                },
                new String []{
                        "Account ID", "Balance", "Interest Rate"
                }) {public boolean isCellEditable(int row, int column){return false;}}
        );
        checking_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = checking_table.getSelectedRow();
                ID = checking_table.getModel().getValueAt(row,0).toString();
                second_account_type = "Checking";
                ArrayList<Checking> selected_checking_account = new GetData().getCheckingBySSN(customer);
                for (Checking y : selected_checking_account) {
                    if (y.getID().equals(ID)) {
                        second_checking_account = y;
                    }
                }
            }
        });
        savings_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = savings_table.getSelectedRow();
                ID = savings_table.getModel().getValueAt(row, 0).toString();
                second_account_type = "Savings";
                ArrayList<RegSavings> selected_account = new GetData().getRegSavings(customer);
                for (RegSavings y : selected_account) {
                    if (y.getID().equals(ID)) {
                        second_savings_Account = y;
                    }
                }
            }
        });
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_transfer_from manager_transfer_from = new manager_transfer_from(customer);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (second_account_type.equals("Checking")) {
                    if (account_Type.equals("Checking")) {
                        ArrayList<Checking> selected_checking_account = new GetData().getCheckingBySSN(customer);
                        for (Checking y : selected_checking_account) {
                            if (y.getID().equals(first_ID)) {
                                first_checking_account = y;
                            }
                        }
                        second_checking_account.moneyTransfer(first_checking_account, amount);
                    }
                    if (account_Type.equals("Savings")) {
                        ArrayList<RegSavings> selected_account = new GetData().getRegSavings(customer);
                        for (RegSavings y : selected_account) {
                            if (y.getID().equals(first_ID)) {
                                first_savings_account = y;
                            }
                        }
                        second_checking_account.moneyTransfer(first_savings_account, amount);
                    }
                }

                if (second_account_type.equals("Savings")) {
                    if (account_Type.equals("Checking")) {
                        ArrayList<Checking> selected_checking_account = new GetData().getCheckingBySSN(customer);
                        for (Checking y : selected_checking_account) {
                            if (y.getID().equals(first_ID)) {
                                first_checking_account = y;
                            }
                        }
                        second_savings_Account.moneyTransfer(first_checking_account, amount);
                    }
                    if (account_Type.equals("Savings")) {
                        ArrayList<RegSavings> selected_account = new GetData().getRegSavings(customer);
                        for (RegSavings y : selected_account) {
                            if (y.getID().equals(first_ID)) {
                                first_savings_account = y;
                            }
                        }
                        second_savings_Account.moneyTransfer(first_savings_account, amount);
                    }
                }

                JOptionPane.showMessageDialog(null, "Transfer Successful");
                frame.setVisible(false);
                manager_transfer_summary transfer_money_summary = new manager_transfer_summary(customer);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
