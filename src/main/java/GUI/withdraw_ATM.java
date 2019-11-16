package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import SystemHelper.SystemHelper;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class withdraw_ATM extends JFrame {
    private JPanel withdraw_ATM;
    private JTextField textField1;
    private JButton back_button;
    private JButton accept_button;
    private double withdraw_ammount;

    public static void main(String[] args) {
        new withdraw_ATM(null,null, null);
    }

    public withdraw_ATM(String customer, String ID, String SSN) {
        JFrame frame = new JFrame("Withdraw");
        frame.setContentPane(withdraw_ATM);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ArrayList<RegSavings> savings = new GetData().getRegSavings(SSN);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ATM_home ATM_page = new ATM_home(null);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Checking> che = new GetData().getCheckingByATMCard(customer);
                try {
                    withdraw_ammount = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                }

                for (Checking j:che){
                    if (j.getID().equals(ID)){
                        System.out.println(withdraw_ammount+"        "+ savings);
                        j.authorizeWithdrawlATM(withdraw_ammount, savings);
                        if (withdraw_ammount > j.getBalancef()){
                            JOptionPane.showMessageDialog(null, "Withdraw Amount is Greater than Checking Balance, Pulling from Savings");
                        }
                        System.out.println(j.getBalancef());
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Account Not Found");
                    }
                }
                SaveData saveData = new SaveData();
                saveData.saveCheckAndSave(savings, che);
                frame.setVisible(false);
                ATM_home ATM_page = new ATM_home(customer);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
