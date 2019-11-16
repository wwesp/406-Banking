package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.People.Customer;
import persistence.GetData.GetData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ATM_home extends JFrame {
    private JPanel ATM_home;
    private JButton back_button;
    private JButton withdraw_account_2;
    private JButton deposit_account_2;
    private JTable checking_table;
    private JLabel last_name_label;
    private JLabel first_name_label;
    private JTable saving_table;
    private String ID;

    public static void main(String[] args) {
        new ATM_home(null);
    }

    public ATM_home(String customer){
        JFrame frame = new JFrame("Select Deposit or Withdraw");
        frame.setContentPane(ATM_home);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Customer customer1 = new GetData().getCustomerByATM(customer);
        last_name_label.setText(customer1.getlName());
        first_name_label.setText(customer1.getfName());
        String SSN = customer1.getSsn();
        ArrayList<Checking> checking = new GetData().getCheckingByATMCard(customer);
        ArrayList<RegSavings> savings = new GetData().getRegSavings(SSN);
        checking_table.setModel(new javax.swing.table.DefaultTableModel(

                new Object [][] {
                        {checking.get(0).getID(), checking.get(0).getBalancef(), checking.get(0).getAccType()}
                },
                new String []{
                        "Account ID", "Balance", "Account Type"
                }
        ) {public boolean isCellEditable(int row, int column){return false;}}
        );

        saving_table.setModel(new javax.swing.table.DefaultTableModel(

                new Object [][] {
                        {savings.get(0).getBalancef(), savings.get(0).getOpenDate(), savings.get(0).getInterestRate(),
                                savings.get(0).getLastDayInterestCompounded()}
                },
                new String [] {
                        "Balance", "Open Date", "Interest Rate", "Last Compound of Interest"
                }
        ) {public boolean isCellEditable(int row, int column){return false;}}
        );


        withdraw_account_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ID != null) {
                    frame.setVisible(false);
                    withdraw_ATM withdraw_page = new withdraw_ATM(customer,ID, SSN);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Pick Account");
                }
            }
        });
        deposit_account_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ID != null) {
                    frame.setVisible(false);
                    deposit_ATM deposit_page = new deposit_ATM(customer, ID, SSN);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Pick Checking Account");
                }
            }
        });
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                home_page home_page = new home_page();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        checking_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = checking_table.getSelectedRow();
                ID = checking_table.getModel().getValueAt(row,0).toString();
                System.out.println(ID);
            }
        });

    }
}
