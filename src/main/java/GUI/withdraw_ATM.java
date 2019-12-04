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
    private int print_value;

    public static void main(String[] args) {
        new withdraw_ATM(null,null, null,null, null);
    }

    public withdraw_ATM(String customer, String ID, String ID_type, String SSN, String previous_page) {
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
                if (previous_page.equals("1")) {
                    frame.setVisible(false);
                    ATM_home ATM_page = new ATM_home(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (previous_page.equals("2")){
                    frame.setVisible(false);
                    teller_view_accounts ATM_page = new teller_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (previous_page.equals("3")){
                    frame.setVisible(false);
                    manager_view_accounts manager_view_accounts = new manager_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (previous_page == "1") {
                    ArrayList<Checking> che = new GetData().getCheckingByATMCard(customer);
                    try {
                        withdraw_ammount = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                    }

                    for (Checking j : che) {
                        if (j.getID().equals(ID)) {
                            j.authorizeWithdrawlATM(withdraw_ammount, savings);
                            print_value++;
                            if (withdraw_ammount > j.getBalancef()) {
                                JOptionPane.showMessageDialog(null, "Withdraw Amount is Greater than Checking Balance");
                                print_value++;
                            }
                        }
                    }
                    if (print_value == 1) {
                        JOptionPane.showMessageDialog(null, "Withdraw Successful");
                    }

                    SaveData saveData = new SaveData();
                    saveData.saveCheckAndSave(savings, che);

                }
                else {
                    ArrayList<Checking> che = new GetData().getCheckingBySSN(customer);
                    ArrayList<RegSavings> sav = new GetData().getRegSavings(customer);
                    try {
                        withdraw_ammount = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                    }

                    if (ID_type.equals("Checking")) {
                        for (Checking j : che) {
                            if (j.getID().equals(ID)) {
                                j.authorizeWithdrawl(withdraw_ammount, savings, false);
                                print_value++;
                                if (withdraw_ammount > j.getBalancef()) {
                                    JOptionPane.showMessageDialog(null, "Withdraw Amount is Greater than Checking Balance");
                                    print_value++;
                                }
                            }
                        }
                        if (print_value == 1) {
                            JOptionPane.showMessageDialog(null, "Withdraw Successful");
                        }
                        SaveData saveData = new SaveData();
                        saveData.saveCheckAndSave(savings, che);
                    }
                    if (ID_type.equals("Savings")){
                        for (RegSavings j : sav) {
                            if (j.getID().equals(ID)) {
                                j.authorizeWithdraw(withdraw_ammount);
                                print_value++;
                                if (!j.authorizeWithdraw(withdraw_ammount)) {
                                    JOptionPane.showMessageDialog(null, "Withdraw Amount is Greater than Savings Balance");
                                    print_value++;
                                }
                            }
                        }
                        if (print_value == 1) {
                            JOptionPane.showMessageDialog(null, "Withdraw Successful");
                        } else {
                            JOptionPane.showMessageDialog(null, "Withdraw Failed");
                        }
                        SaveData saveData = new SaveData();
                        saveData.saveSaving(sav);
                    }



                }

                if (previous_page.equals("1")) {
                    frame.setVisible(false);
                    ATM_home ATM_page = new ATM_home(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (previous_page.equals("2")){
                    frame.setVisible(false);
                    teller_view_accounts ATM_page = new teller_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (previous_page.equals("3")){
                    frame.setVisible(false);
                    manager_view_accounts manager_view_accounts = new manager_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (previous_page == "1") {
                    ArrayList<Checking> che = new GetData().getCheckingByATMCard(customer);
                    try {
                        withdraw_ammount = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                    }

                    System.out.println(ID);
                    for (Checking j : che) {
                        if (j.getID().equals(ID)) {
                            j.authorizeWithdrawlATM(withdraw_ammount, savings);
                            print_value++;
                            if (withdraw_ammount > j.getBalancef()) {
                                JOptionPane.showMessageDialog(null, "Withdraw Amount is Greater than Checking Balance");
                                print_value++;
                            }
                        }
                    }
                    if (print_value == 1) {
                        JOptionPane.showMessageDialog(null, "Withdraw Successful");
                    } else {
                        JOptionPane.showMessageDialog(null, "Withdraw Failed");
                    }

                    SaveData saveData = new SaveData();
                    saveData.saveCheckAndSave(savings, che);

                }
                else {
                    ArrayList<Checking> che = new GetData().getCheckingBySSN(customer);
                    ArrayList<RegSavings> sav = new GetData().getRegSavings(customer);
                    try {
                        withdraw_ammount = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                    }

                    if (ID_type.equals("Checking")) {
                        for (Checking j : che) {
                            if (j.getID().equals(ID)) {
                                j.authorizeWithdrawl(withdraw_ammount, savings, false);
                                print_value++;
                                if (withdraw_ammount > j.getBalancef()) {
                                    JOptionPane.showMessageDialog(null, "Withdraw Amount is Greater than Checking Balance");
                                    print_value++;
                                }
                            }
                        }
                        if (print_value == 1) {
                            JOptionPane.showMessageDialog(null, "Withdraw Successful");
                        }
                        SaveData saveData = new SaveData();
                        saveData.saveCheckAndSave(savings, che);
                    }
                    if (ID_type.equals("Savings")){
                        for (RegSavings j : sav) {
                            if (j.getID().equals(ID)) {
                                j.authorizeWithdraw(withdraw_ammount);
                                print_value++;
                                if (!j.authorizeWithdraw(withdraw_ammount)) {
                                    JOptionPane.showMessageDialog(null, "Withdraw Amount is Greater than Savings Balance");
                                    print_value++;
                                }
                            }
                        }
                        if (print_value == 1) {
                            JOptionPane.showMessageDialog(null, "Withdraw Successful");
                        } else {
                            JOptionPane.showMessageDialog(null, "Withdraw Failed");
                        }
                        SaveData saveData = new SaveData();
                        saveData.saveSaving(sav);
                    }



                }

                if (previous_page.equals("1")) {
                    frame.setVisible(false);
                    ATM_home ATM_page = new ATM_home(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (previous_page.equals("2")){
                    frame.setVisible(false);
                    teller_view_accounts ATM_page = new teller_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (previous_page.equals("3")){
                    frame.setVisible(false);
                    manager_view_accounts manager_view_accounts = new manager_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
    }
}
