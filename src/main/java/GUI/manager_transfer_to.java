package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.BankAccounts.Money.Savings;
import Accounts.People.Customer;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Customer customer1 = new GetData().getCustomerBySSN(customer);
        last_name.setText(customer1.getlName());
        first_name.setText(customer1.getfName());
        String SSN = customer1.getSsn();

        ArrayList<Checking> checking = new GetData().getCheckingBySSN(customer);
        String[] checking_headers = {"Account ID", "Balance", "Account Type", "Card Number", "Back up Account"};
        DefaultTableModel checking_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) { return false; }};
        checking_model.setColumnIdentifiers(checking_headers);
        checking_table.setModel(checking_model);
        for (Checking x: checking){
            if (!account_Type.equals("Checking")) {
                checking_model.addRow(new Object[]{x.getID(), x.getBalancef(), x.getAccType(), x.getAtmCard(), x.getBackupAcc()});
            }
            else {
                if (!x.getID().equals(first_ID)){
                    checking_model.addRow(new Object[]{x.getID(), x.getBalancef(), x.getAccType(), x.getAtmCard(), x.getBackupAcc()});
                }
            }
        }


        ArrayList<RegSavings> savings = new GetData().getRegSavings(customer);
        String[] savings_headers = {"Account ID", "Balance", "Open Date", "Interest Rate", "Last Compound of Interest"};
        DefaultTableModel savings_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        savings_model.setColumnIdentifiers(savings_headers);
        savings_table.setModel(savings_model);
        for (RegSavings x: savings) {
            if (!account_Type.equals("Savings")) {
                savings_model.addRow(new Object[]{x.getID(), x.getBalancef(), x.getOpenDate(), x.getInterestRate(), x.getLastDayInterestCompounded()});
            }
            else {
                if (!x.getID().equals(first_ID)){
                    savings_model.addRow(new Object[]{x.getID(), x.getBalancef(), x.getOpenDate(), x.getInterestRate(), x.getLastDayInterestCompounded()});
                }
            }
        }


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
                        SaveData saveData = new SaveData();
                        saveData.saveCheckAndSave(savings, selected_checking_account);
                    }
                    if (account_Type.equals("Savings")) {
                        ArrayList<RegSavings> selected_account = new GetData().getRegSavings(customer);
                        for (RegSavings y : selected_account) {
                            if (y.getID().equals(first_ID)) {
                                first_savings_account = y;
                            }
                        }
                        second_checking_account.moneyTransfer(first_savings_account, amount);
                        SaveData saveData = new SaveData();
                        saveData.saveCheckAndSave(selected_account, checking);
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
                        SaveData saveData = new SaveData();
                        saveData.saveCheckAndSave(savings, selected_checking_account);
                    }
                    if (account_Type.equals("Savings")) {
                        ArrayList<RegSavings> selected_account = new GetData().getRegSavings(customer);
                        for (RegSavings y : selected_account) {
                            if (y.getID().equals(first_ID)) {
                                first_savings_account = y;
                            }
                        }
                        second_savings_Account.moneyTransfer(first_savings_account, amount);
                        SaveData saveData = new SaveData();
                        saveData.saveCheckAndSave(selected_account, checking);
                    }
                }

                JOptionPane.showMessageDialog(null, "Transfer Successful");
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
