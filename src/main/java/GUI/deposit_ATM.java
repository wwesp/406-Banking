package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import SystemHelper.SystemHelper;
import persistence.GetData.GetData;
import SystemHelper.SystemHelper.*;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.nio.file.StandardWatchEventKinds;
import java.text.ParseException;
import java.util.ArrayList;

public class deposit_ATM extends JFrame {
    public GetData getBoi;
    private JPanel deposit_ATM;
    private JTextField textField1;
    private JButton accept_button;
    private JButton back_button;
    private double deposit_ammount;
    private int print_value;

    public static void main(String[] args) {
        new deposit_ATM(null, null, null, null, null);
    }

    public deposit_ATM(String customer, String ID, String ID_type, String SSN, String previous_page) {
        JFrame frame = new JFrame("Deposit");
        frame.setContentPane(deposit_ATM);
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
                    teller_view_accounts teller_view_accounts = new teller_view_accounts(customer);
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
                        deposit_ammount = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                    }

                    for (Checking j : che) {
                        if (j.getID().equals(ID)) {
                            j.addBalence(deposit_ammount, savings);
                            print_value = print_value + 1;
                        }
                    }
                    if (print_value == 1) {
                        JOptionPane.showMessageDialog(null, "Deposit Successful");
                    } else {
                        JOptionPane.showMessageDialog(null, "Deposit Failed");
                    }

                    SaveData saveData = new SaveData();
                    saveData.saveCheckAndSave(savings, che);

                }
                else {
                    ArrayList<Checking> che = new GetData().getCheckingBySSN(customer);
                    ArrayList<RegSavings> sav = new GetData().getRegSavings(customer);
                    try {
                        deposit_ammount = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                    }

                    if (ID_type.equals("Checking")) {

                        for (Checking j : che) {
                            if (j.getID().equals(ID)) {
                                j.addBalence(deposit_ammount, savings);
                                print_value = print_value + 1;
                            }
                        }
                        if (print_value == 1) {
                            JOptionPane.showMessageDialog(null, "Deposit Successful");
                        } else {
                            JOptionPane.showMessageDialog(null, "Deposit Failed");
                        }

                        SaveData saveData = new SaveData();
                        saveData.saveCheckAndSave(savings, che);
                    }
                    if (ID_type.equals("Savings")) {

                        for (RegSavings j : sav) {
                            if (j.getID().equals(ID)) {
                                j.authorizeDeposit(deposit_ammount);
                                print_value = print_value + 1;
                            }
                        }
                        if (print_value == 1) {
                            JOptionPane.showMessageDialog(null, "Deposit Successful");
                        } else {
                            JOptionPane.showMessageDialog(null, "Deposit Failed");
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
                    teller_view_accounts teller_view_accounts = new teller_view_accounts(customer);
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
