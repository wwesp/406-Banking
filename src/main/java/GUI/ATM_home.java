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
    private int withdraw_history;
    private String back_up_acc_ID;
    private String ID_type = null;

    public static void main(String[] args) {
        new ATM_home(null);
    }

    public ATM_home(String customer) {
        JFrame frame = new JFrame("Select Deposit or Withdraw");
        frame.setContentPane(ATM_home);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Customer customer1 = new GetData().getCustomerByATM(customer);
        last_name_label.setText(customer1.getlName());
        first_name_label.setText(customer1.getfName());
        String SSN = customer1.getSsn();
        ArrayList<Checking> checking = new GetData().getCheckingByATMCard(customer);
        ArrayList<RegSavings> savings = new GetData().getRegSavings(SSN);



        //This sets the Checking Table
        String[] checking_headers = {"Account ID", "Balance", "Account Type", "Card Number", "Back up Account"};
        DefaultTableModel checking_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) { return false; }};
        checking_model.setColumnIdentifiers(checking_headers);
        checking_table.setModel(checking_model);
        for (Checking x: checking){
            checking_model.addRow(new Object[] {x.getID(), x.getBalancef(), x.getAccType(), x.getAtmCard(), x.getBackupAcc()});
            back_up_acc_ID = x.getBackupAcc();
        }




        //THis sets the Savings Table
        String[] savings_headers = {"Account ID", "Balance", "Open Date", "Interest Rate", "Last Compound of Interest"};
        DefaultTableModel savings_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        savings_model.setColumnIdentifiers(savings_headers);
        saving_table.setModel(savings_model);
        for (RegSavings x: savings){
            if (x.getID().equals(back_up_acc_ID))
            savings_model.addRow(new Object[] {x.getID(), x.getBalancef(), x.getOpenDate(), x.getInterestRate(), x.getLastDayInterestCompounded()});
        }




        withdraw_account_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { ;
                for (Checking j:checking) {
                    if (j.getID().equals(ID)) {
                        withdraw_history = j.getAtmHistory().size();
                    }
                }
                if (withdraw_history < 2 ) {
                    if (ID != null) {
                        frame.setVisible(false);
                        withdraw_ATM withdraw_page = new withdraw_ATM(customer, ID, ID_type, SSN, "1");
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Pick Account");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Sorry, You Have Exceeded Your Daily Withdraw Limit");
                }
            }
        });
        deposit_account_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ID != null) {
                    frame.setVisible(false);
                    deposit_ATM deposit_page = new deposit_ATM(customer, ID, ID_type, SSN, "1");
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
            }
        });


        saving_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Please Pick Checking Account");
            }
        });
    }
}
