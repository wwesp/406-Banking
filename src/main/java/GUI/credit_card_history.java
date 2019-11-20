package GUI;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import persistence.GetData.GetData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class credit_card_history {
    private JPanel credit_card_history_panel;
    private JButton back_button;
    private JTable credit_card_history_table;
    private CreditCard actual_account;

    public static void main(String[] args) {
        new credit_card_history(null, null, null);
    }

    public credit_card_history(String customer, String user_type, String ID) {
        JFrame frame = new JFrame("Credit Card History");
        frame.setContentPane(credit_card_history_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ArrayList<CreditCard> CD = new GetData().getCC(customer);
        for (CreditCard y: CD){
            if (y.getID().equals(ID)){
                actual_account = y;

            }
        }
        HashMap<String, Double> mons = actual_account.getPaymentHistory();
        HashMap<String, String> item = actual_account.getPaymentHistoryDescription();
        HashMap<String, String> dat = actual_account.getPaymentHistoryDate();

        String[] checking_headers = {"CC ID", "Amount", "Item","Date"};
        DefaultTableModel denied_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        denied_model.setColumnIdentifiers(checking_headers);
        credit_card_history_table.setModel(denied_model);
        for (String x: mons.keySet()){
            denied_model.addRow(new Object[] {x,mons.get(x),item.get(x), dat.get(x)});
        }

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user_type.equals("teller")) {
                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (user_type.equals("manager")){
                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
    }
}
