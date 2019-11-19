package GUI;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.BankAccounts.Debt.ShortTermLoan;
import Accounts.BankAccounts.Money.CDs;
import persistence.GetData.GetData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class manager_rollover_notices extends JFrame{
    private JPanel manager_rollover_notices;
    private JButton back_button;
    private JButton send_button;
    private JTable rollover_table;

    public static void main(String[] args) {
        new manager_rollover_notices();
    }

    public manager_rollover_notices() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_rollover_notices);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ArrayList<CDs> cDs = new GetData().getAllCDs();
        String[] credit_headers = {"ID","Balence", "Open Date", "Close Date","End Date", "Interest Rate" };
        DefaultTableModel credit_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) { return false; }};
        credit_model.setColumnIdentifiers(credit_headers);
        rollover_table.setModel(credit_model);
        for (CDs x: cDs){
            credit_model.addRow(new Object[] {x.getID(),x.getBalancef(),x.getOpenDate(), x.getEndDate(), x.getInterestRate()});
        }

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        send_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(CDs f:cDs){
                    f.dailyInterest();

                }

                JOptionPane.showMessageDialog(null, "Rollover's Assessed and Interest Accrued if possible");
            }
        });
    }
}
