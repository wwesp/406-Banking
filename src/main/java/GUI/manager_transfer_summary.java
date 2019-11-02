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
