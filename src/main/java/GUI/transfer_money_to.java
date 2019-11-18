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

public class transfer_money_to extends JFrame{
    private JPanel transfer_money_to;
    private JButton back_button;
    private JButton accept_button;
    private JTable savings_table;
    private JTable checking_table;
    private JLabel last_name;
    private JLabel first_name;
    private Checking first_checking_account;
    private RegSavings first_savings_account;
    private String ID;
    private String second_account_type;
    private Checking second_checking_account;
    private RegSavings second_savings_Account;

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
        String[] checking_headers = {"Account ID", "Balance", "Account Type", "Card Number", "Back up Account"};
        DefaultTableModel checking_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) { return false; }};
        checking_model.setColumnIdentifiers(checking_headers);
        checking_table.setModel(checking_model);
        for (Checking x: checking) {
            if (!account_Type.equals("Checking")) {
                checking_model.addRow(new Object[]{x.getID(), x.getBalancef(), x.getAccType(), x.getAtmCard(), x.getBackupAcc()});
            }
            else {
                if (!x.getID().equals(first_ID)){
                    checking_model.addRow(new Object[]{x.getID(), x.getBalancef(), x.getAccType(), x.getAtmCard(), x.getBackupAcc()});
                }
            }
        }

        ArrayList<RegSavings> savings = new GetData().getRegSavings(first_customer);
        String[] savings_headers = {"Account ID", "Balance", "Open Date", "Interest Rate", "Last Compound of Interest"};
        DefaultTableModel savings_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        savings_model.setColumnIdentifiers(savings_headers);
        savings_table.setModel(savings_model);
        for (RegSavings x: savings){
            if (!account_Type.equals("Savings")) {
                savings_model.addRow(new Object[]{x.getID(), x.getBalancef(), x.getOpenDate(), x.getInterestRate(), x.getLastDayInterestCompounded()});
            }
            else {
                if (!x.getID().equals(first_ID)){
                    savings_model.addRow(new Object[]{x.getID(), x.getBalancef(), x.getOpenDate(), x.getInterestRate(), x.getLastDayInterestCompounded()});
                }
            }
        }

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
                SaveData savedat = new SaveData();
                ArrayList<Checking> chesav = new ArrayList<>();
                ArrayList<RegSavings> resav = new ArrayList<>();

                if (second_account_type.equals("Checking")) {
                    if (account_Type.equals("Checking")) {
                        ArrayList<Checking> selected_checking_account = new GetData().getCheckingBySSN(first_customer);
                        for (Checking y : selected_checking_account) {
                            if (y.getID().equals(first_ID)) {
                                first_checking_account = y;
                            }
                        }
                        System.out.println("adding " + amount + "to " + first_checking_account);
                        second_checking_account.moneyTransfer(first_checking_account, amount);
                        System.out.println(first_checking_account + " now has " + amount);

                    }
                    if (account_Type.equals("Savings")) {
                        ArrayList<RegSavings> selected_account = new GetData().getRegSavings(first_customer);
                        for (RegSavings y : selected_account) {
                            if (y.getID().equals(first_ID)) {
                                first_savings_account = y;
                            }
                        }
                        System.out.println("adding " + amount + "to " + first_savings_account);
                        second_checking_account.moneyTransfer(first_savings_account, amount);
                        System.out.println(first_savings_account + " now has " + amount);

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
                        System.out.println("adding " + amount + "to " + first_checking_account);
                        second_savings_Account.moneyTransfer(first_checking_account, amount);
                        System.out.println(first_checking_account + " now has " + amount);

                    }
                    if (account_Type.equals("Savings")) {
                        ArrayList<RegSavings> selected_account = new GetData().getRegSavings(first_customer);
                        for (RegSavings y : selected_account) {
                            if (y.getID().equals(first_ID)) {
                                first_savings_account = y;
                            }
                        }
                        System.out.println("adding " + amount + "to " + first_savings_account);
                        second_savings_Account.moneyTransfer(first_savings_account, amount);
                        System.out.println(first_savings_account + " now has " + amount);

                    }
                }

                if(first_savings_account!=null)resav.add(first_savings_account);

                if(second_savings_Account!=null)resav.add(second_savings_Account);

                if(first_checking_account!=null)chesav.add(first_checking_account);

                if(second_checking_account!=null)chesav.add(second_checking_account);




                savedat.saveCheckAndSave(resav,chesav);



                JOptionPane.showMessageDialog(null, "Transfer Successful");
                frame.setVisible(false);
                teller_home teller_home = new teller_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
