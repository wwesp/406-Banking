package GUI;

import Accounts.BankAccounts.Accounts;
import Accounts.BankAccounts.Money.Checking;
import persistence.GetData.GetData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;

public class check_history {
    private JPanel check_history_panel;
    private JButton back_button;
    private JButton accept_button;
    private JTable denied_checks_table;
    private JTable pending_checks_table;
    private JTable accepted_checks_table;
    private Checking actual_account;

    public static void main(String[] args) {
        new check_history(null, null, null);
    }

    public check_history(String customer, String user_type, String ID) {
        JFrame frame = new JFrame("Check Histroy");
        frame.setContentPane(check_history_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        if (user_type.equals("teller")){
            accept_button.setEnabled(false);
        }


        ArrayList<Checking> checking = new GetData().getCheckingBySSN(customer);
        for (Checking y: checking){
            if (y.getID().equals(ID)){
                actual_account = y;
            }
        }
        HashMap<String, String> denied_checks=null;
        if(user_type.equals("manager")){
            denied_checks = actual_account.getDeniedChecks();
        }
        else {
            denied_checks = actual_account.getDeniedChecksTeller();
        }
        String[] checking_headers = {"Check Number", "Check Date", "Amount"};
        DefaultTableModel denied_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        denied_model.setColumnIdentifiers(checking_headers);
        denied_checks_table.setModel(denied_model);
        for (String x: denied_checks.keySet()){
            String arr[] = denied_checks.get(x).split("::",2);
            denied_model.addRow(new Object[] {x, arr[0], arr[1]});
        }

        HashMap<String, Double> pending_checks = actual_account.getPendingChecks();

        String[] pending_headers = {"Check Number", "Amount"};
        DefaultTableModel pending_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        pending_model.setColumnIdentifiers(pending_headers);
        pending_checks_table.setModel(pending_model);
        for (String x: pending_checks.keySet()){
            pending_model.addRow(new Object[] {x, pending_checks.get(x)});
        }

        HashMap<String, String> accepted_checks=null;
        if(user_type.equals("manager")){
            accepted_checks = actual_account.getDeniedChecks();
        }
        else {
            accepted_checks = actual_account.getDeniedChecksTeller();
        }


        String[] accepted_headers = {"Check Number", "Check Date", "Amount"};
        DefaultTableModel accepted_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        accepted_model.setColumnIdentifiers(accepted_headers);
        accepted_checks_table.setModel(accepted_model);
        for (String x: accepted_checks.keySet()){
            String arr[] = accepted_checks.get(x).split("::",2);
            accepted_model.addRow(new Object[] {x, arr[0], arr[1]});
        }

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user_type.equals("teller")) {
                    frame.setVisible(false);
                    teller_view_accounts teller_view_accounts = new teller_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (user_type.equals("manager")){
                    frame.setVisible(false);
                    manager_view_accounts manager_view_accounts = new manager_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
    }
}
