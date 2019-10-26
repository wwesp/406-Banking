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

public class teller_view_accounts extends JFrame{
    private JTable savings_table;
    private JButton back_button;
    private JPanel teller_view_accounts;
    private JTable checking_table;
    private JLabel last_name_label;
    private JLabel first_name_label;
    private JButton account_history_button;

    public static void main(String[] args) {
        new teller_view_accounts(null);
    }

    public teller_view_accounts(String customer) {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(teller_view_accounts);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //for(RegSavings x: savings){
        //    var y= x.getBalancef();
        //}
        Customer customer1 = new GetData().getCustomerBySSN(customer);
        last_name_label.setText(customer1.getlName());
        first_name_label.setText(customer1.getfName());

        ArrayList<Checking> checking = new GetData().getCheckingBySSN(customer);
        checking_table.setModel(new javax.swing.table.DefaultTableModel(

                new Object [][] {
                        {checking.get(0).getBalancef(), checking.get(0).getOpenDate(), checking.get(0).getAcceptedChecks(),
                                checking.get(0).getPendingChecks(), checking.get(0).getDeniedChecks()}
                },
                new String [] {
                        "Balance", "Open Date", "Accepted Checks", "Pending Checks", "Denied Checks"
                }
        ));

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
                frame.setVisible(false);
                teller_home teller_home = new teller_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
