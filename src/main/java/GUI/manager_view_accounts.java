package GUI;

import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.People.Customer;
import persistence.GetData.GetData;
import persistence.RemoveData.RemoveData;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class manager_view_accounts extends JFrame{
    private JPanel manager_view_accounts;
    private JButton back_button;
    private JButton full_history_button;
    private JTable savings_table;
    private JTable checking_table;
    private JTable CD_table;
    private JLabel last_name;
    private JLabel first_name;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton viewDebtsButton;
    private JButton terminateCheckingButton;
    private JButton terminateSavingsButton;
    private JButton terminateCDButton;
    private String ID;
    private String account_Type = "";
    private String SSN;
    private Checking checking1;
    private RegSavings savings1;

    public static void main(String[] args) {
        new manager_view_accounts(null);
    }

    public manager_view_accounts(String customer) {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_view_accounts);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Customer customer1 = new GetData().getCustomerBySSN(customer);
        last_name.setText(customer1.getlName());
        first_name.setText(customer1.getfName());
        SSN = customer1.getSsn();

        ArrayList<Checking> checking = new GetData().getCheckingBySSN(customer);
        if (checking != null) {
            //This sets the Checking Table
            String[] checking_headers = {"Account ID", "Balance", "Account Type", "Card Number", "Back Up Account"};
            DefaultTableModel checking_model = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            checking_model.setColumnIdentifiers(checking_headers);
            checking_table.setModel(checking_model);
            for (Checking x: checking){
                checking_model.addRow(new Object[] {x.getID(), x.getBalancef(), x.getAccType(), x.getAtmCard(), x.getBackupAcc()});
            }
        }

        ArrayList<RegSavings> savings = new GetData().getRegSavings(customer);
        if (savings != null) {
            String[] savings_headers = {"Account ID", "Balance", "Open Date", "Interest Rate", "Last Compound of Interest"};
            DefaultTableModel savings_model = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            savings_model.setColumnIdentifiers(savings_headers);
            savings_table.setModel(savings_model);
            for (RegSavings x: savings){
                savings_model.addRow(new Object[] {x.getID(), x.getBalancef(), x.getOpenDate(), x.getInterestRate(), x.getLastDayInterestCompounded()});
            }
        }

        ArrayList<CDs> cds = new GetData().getCD(customer);
        if (cds != null) {
            String[] checking_headers = {"Account ID", "Balance", "Open Date", "End Date", "Interest Rate"};
            DefaultTableModel checking_model = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            checking_model.setColumnIdentifiers(checking_headers);
            CD_table.setModel(checking_model);
            for (CDs x: cds){
                checking_model.addRow(new Object[] {x.getID(), x.getBalancef(), x.getOpenDate(), x.getEndDate(), x.getInterestRate()});
            }
        }
        checking_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = checking_table.getSelectedRow();
                ID = checking_table.getModel().getValueAt(row,0).toString();
                account_Type = "Checking";
            }
        });
        savings_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = savings_table.getSelectedRow();
                ID = savings_table.getModel().getValueAt(row,0).toString();
                account_Type = "Savings";
            }
        });
        CD_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = savings_table.getSelectedRow();
                ID = savings_table.getModel().getValueAt(row,0).toString();
                account_Type = "CD";
            }
        });
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ID != null) {
                    frame.setVisible(false);
                    deposit_ATM deposit_atm = new deposit_ATM(customer, ID, account_Type, SSN, "3");
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Pick Checking Account");
                }
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ID != null) {
                    frame.setVisible(false);
                    withdraw_ATM withdraw_atm = new withdraw_ATM(customer, ID, account_Type, SSN, "3");
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Pick Checking Account");
                }
            }
        });
        viewDebtsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                view_debts view_debts = new view_debts(customer, "manager");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        full_history_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ID != null && !account_Type.equals("Savings")) {
                    frame.setVisible(false);
                    check_history check_history = new check_history(customer, "manager", ID);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Pick Checking Account");

                }
            }
        });
        terminateCheckingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (account_Type.equals("Checking")){
                    for (Checking x: checking){
                        if (x.getID().equals(ID)){
                            checking1 = x;
                        }
                    }
                    double due = checking1.endAccount();

                    ArrayList<Checking> arrayList_of_checking = new ArrayList<>();
                    arrayList_of_checking.add(checking1);

                    RemoveData removeData = new RemoveData();
                    removeData.rmChecking(arrayList_of_checking);
                    if (due < 0.0) {
                        JOptionPane.showMessageDialog(null, "You Owe: " + due * -1.0);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Bank Owes you: " + due);
                    }

                    frame.setVisible(false);
                    manager_view_accounts manager_view_accounts = new manager_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Pick Checking Account");
                }
            }
        });
        terminateSavingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (account_Type.equals("Savings")){
                    for (RegSavings x: savings){
                        if (x.getID().equals(ID)){
                            savings1 = x;
                        }
                    }
                    double due = savings1.endAccount();

                    ArrayList<RegSavings> arrayList_of_checking = new ArrayList<>();
                    arrayList_of_checking.add(savings1);

                    RemoveData removeData = new RemoveData();
                    removeData.rmSaving(arrayList_of_checking, savings1.getID());
                    if (due < 0.0) {
                        JOptionPane.showMessageDialog(null, "You Owe: " + due * -1.0);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Bank Owes you: " + due);
                    }

                    frame.setVisible(false);
                    manager_view_accounts manager_view_accounts = new manager_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Pick Checking Account");
                }
            }
        });
        terminateCDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (account_Type.equals("CD")){

                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Pick CD Account");
                }
            }
        });
    }
}
