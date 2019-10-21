package GUI;

import Accounts.BankAccounts.Money.RegSavings;
import persistence.GetData.GetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class teller_view_accounts extends JFrame{
    private JTable savings_table;
    private JButton back_button;
    private JPanel teller_view_accounts;
    private JTable checking_table;

    public static void main(String[] args) {
        new teller_view_accounts(null);
    }

    public teller_view_accounts(String customer) {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(teller_view_accounts);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //for(RegSavings x: savings){
        //    var y= x.getBalancef();
        //}

        /*
        checking_table.setModel(new javax.swing.table.DefaultTableModel(

                new Object [][] {
                        {savings.get(0).getBalancef(), savings.get(0).getOpenDate(), savings.get(0).getInterestRate(),
                                savings.get(0).getLastDayInterestCompounded()}
                },
                new String [] {
                        "Balance", "Open Date", "Interest Rate", "Last Compound of Interest"
                }
        ));
        */

        ArrayList<RegSavings> savings = new GetData().getRegSavings(customer);
        savings_table.setModel(new javax.swing.table.DefaultTableModel(

                new Object [][] {
                        {savings.get(0).getBalancef(), savings.get(0).getOpenDate(), savings.get(0).getInterestRate(),
                                savings.get(0).getLastDayInterestCompounded()}
                },
                new String [] {
                        "Balance", "Open Date", "Interest Rate", "Last Compound of Interest"
                }
        ));

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                teller_home teller_home = new teller_home();
                teller_home.setVisible(true);
            }
        });
    }
}
