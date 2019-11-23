package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import SystemHelper.SystemHelper;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class create_check {
    private JPanel create_check_panel;
    private JTextField textField1;
    private JButton accept_button;
    private JButton back_button;
    private Checking checking_account;
    private Double check_ammount;

    public static void main(String[] args) {
        new create_check(null, null, null);
    }

    public create_check(String customer, String user_type, String ID) {
        JFrame frame = new JFrame("Check Histroy");
        frame.setContentPane(create_check_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


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

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check_ammount = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                ArrayList<Checking> checking = new GetData().getCheckingBySSN(customer);
                for (Checking x : checking){
                    if (x.getID().equals(ID)){
                        checking_account = x;
                    }
                }
                checking_account.addCheck(check_ammount);

                SaveData f = new SaveData();
                f.saveChecking(checking);

                JOptionPane.showMessageDialog(null, "The Check has been Created");
                frame.setVisible(false);
                check_history check_history = new check_history(customer, user_type, ID);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check_ammount = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                ArrayList<Checking> checking = new GetData().getCheckingBySSN(customer);
                for (Checking x : checking){
                    if (x.getID().equals(ID)){
                        checking_account = x;
                    }
                }
                checking_account.addCheck(check_ammount);

                SaveData f = new SaveData();
                f.saveChecking(checking);

                JOptionPane.showMessageDialog(null, "The Check has been Created");
                frame.setVisible(false);
                check_history check_history = new check_history(customer, user_type, ID);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
