package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.People.Customer;
import persistence.GetData.GetData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class manager_transfer_summary extends JFrame{
    private JPanel manager_transfer_summary;
    private JButton home_button;
    private JTable checking_table;
    private JTable savings_table;
    private JLabel last_name;
    private JLabel first_name;

    public static void main(String[] args) {
        new manager_transfer_summary(null);
    }

    public manager_transfer_summary(String customer) {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_transfer_summary);
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
        savings_table.setModel(savings_model);
        for (RegSavings x: savings){
            savings_model.addRow(new Object[] {x.getID(), x.getBalancef(), x.getOpenDate(), x.getInterestRate(), x.getLastDayInterestCompounded()});
        }

        home_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
