package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.BankAccounts.Money.Savings;
import Accounts.People.Customer;
import SystemHelper.SystemHelper;
import persistence.GetData.GetData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class transfer_money_from extends JFrame{
    private JPanel transfer_money_from;
    private JButton back_button;
    private JButton accept_button;
    private JTable checking_table;
    private JTable saving_table;
    private JLabel last_name;
    private JLabel first_name;
    private JTextField amount_text;
    private String ID;
    private double amount;
    private String account_Type;

    public static void main(String[] args) {
        new transfer_money_from(null);
    }

    public transfer_money_from(String customer) {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(transfer_money_from);
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
            checking_model.addRow(new Object[] {x.getID(), x.getBalancef(), x.getAccType(), x.getAtmCard(), x.getBackupAcc()});
        }

        ArrayList<RegSavings> savings = new GetData().getRegSavings(customer);
        String[] savings_headers = {"Account ID", "Balance", "Open Date", "Interest Rate", "Last Compound of Interest"};
        DefaultTableModel savings_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        savings_model.setColumnIdentifiers(savings_headers);
        saving_table.setModel(savings_model);
        for (RegSavings x: savings){
            savings_model.addRow(new Object[] {x.getID(), x.getBalancef(), x.getOpenDate(), x.getInterestRate(), x.getLastDayInterestCompounded()});
        }

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                teller_home teller_home = new teller_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (amount_text != null && ID != null) {
                    amount = new SystemHelper().truncOrRound(Double.parseDouble(amount_text.getText()), 0);
                    frame.setVisible(false);
                    transfer_money_to transfer_money_to = new transfer_money_to(customer, ID, SSN, amount);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Amount");
                }
            }
        });
        checking_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = checking_table.getSelectedRow();
                ID = checking_table.getModel().getValueAt(row,0).toString();
                account_Type = "Checking";
            }
        });
        saving_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = saving_table.getSelectedRow();
                ID = saving_table.getModel().getValueAt(row,0).toString();
                account_Type = "Savings";
            }
        });
        amount_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (amount_text != null && ID != null) {
                    amount = new SystemHelper().truncOrRound(Double.parseDouble(amount_text.getText()), 0);
                    frame.setVisible(false);
                    transfer_money_to transfer_money_to = new transfer_money_to(customer, ID, account_Type, amount);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Amount");
                }
            }
        });
    }
}
