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

public class transfer_money_to extends JFrame{
    private JPanel transfer_money_to;
    private JButton back_button;
    private JButton accept_button;
    private JTable savings_table;
    private JTable checking_table;
    private JLabel last_name;
    private JLabel first_name;
    private Checking first_checking_account;
    private Savings first_savings_account;
    private String ID;
    private String second_account_type;
    private Checking second_checking_account;
    private Savings second_savings_Account;

    public static void main(String[] args) {
        new transfer_money_to(null,null,null, null);
    }

    public transfer_money_to(String first_customer, String first_ID, String account_Type, Double amount) {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(transfer_money_to);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
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
        checking_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = checking_table.getSelectedRow();
                ID = checking_table.getModel().getValueAt(row,0).toString();
                second_account_type = "Checking";
                ArrayList<Checking> selected_checking_account = new GetData().getCheckingBySSN(first_customer);
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
                ArrayList<RegSavings> selected_account = new GetData().getRegSavings(first_customer);
                for (RegSavings y : selected_account) {
                    if (y.getID().equals(ID)) {
                        second_savings_Account = y;
                    }
                }
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (second_account_type.equals("Checking")) {
                    if (account_Type.equals("Checking")) {
                        ArrayList<Checking> selected_checking_account = new GetData().getCheckingBySSN(first_customer);
                        for (Checking y : selected_checking_account) {
                            if (y.getID().equals(first_ID)) {
                                first_checking_account = y;
                            }
                        }
                        second_checking_account.moneyTransfer(first_checking_account, amount);
                    }
                    if (account_Type.equals("Savings")) {
                        ArrayList<RegSavings> selected_account = new GetData().getRegSavings(first_customer);
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
                        ArrayList<Checking> selected_checking_account = new GetData().getCheckingBySSN(first_customer);
                        for (Checking y : selected_checking_account) {
                            if (y.getID().equals(first_ID)) {
                                first_checking_account = y;
                            }
                        }
                        second_savings_Account.moneyTransfer(first_checking_account, amount);
                    }
                    if (account_Type.equals("Savings")) {
                        ArrayList<RegSavings> selected_account = new GetData().getRegSavings(first_customer);
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
                transfer_money_summary transfer_money_summary = new transfer_money_summary(first_customer);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
