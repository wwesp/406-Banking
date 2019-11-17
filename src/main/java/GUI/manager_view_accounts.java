package GUI;

import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.People.Customer;
import persistence.GetData.GetData;

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
    private String ID;
    private String account_Type;

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
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        full_history_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_account_history manager_account_history = new manager_account_history(customer, ID, account_Type);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
