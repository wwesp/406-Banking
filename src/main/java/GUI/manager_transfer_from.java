package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.People.Customer;
import SystemHelper.SystemHelper;
import persistence.GetData.GetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class manager_transfer_from extends JFrame{
    private JPanel manager_transfer_from;
    private JButton back_button;
    private JButton accept_button;
    private JTable checking_table;
    private JTable savings_table;
    private JLabel last_name;
    private JLabel first_name;
    private JTextField amount_text;
    private String ID;
    private String account_Type;
    private double amount;

    public static void main(String[] args) {
        new manager_transfer_from(null);
    }

    public manager_transfer_from(String customer) {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_transfer_from);
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
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (amount_text != null && ID != null) {
                    amount = new SystemHelper().truncOrRound(Double.parseDouble(amount_text.getText()), 0);
                    frame.setVisible(false);
                    manager_transfer_to transfer_money_to = new manager_transfer_to(customer, ID, account_Type, amount);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Amount");
                }
            }
        });
        amount_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (amount_text != null && ID != null) {
                    amount = new SystemHelper().truncOrRound(Double.parseDouble(amount_text.getText()), 0);
                    frame.setVisible(false);
                    manager_transfer_to transfer_money_to = new manager_transfer_to(customer, ID, account_Type, amount);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Amount");
                }
            }
        });
    }
}
