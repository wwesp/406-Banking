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

    public static void main(String[] args) {
        new deposit_ATM(null, null, null);
    }

    public deposit_ATM(String customer, String ID, String SSN) {
        JFrame frame = new JFrame("Deposit");
        frame.setContentPane(deposit_ATM);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        ArrayList<RegSavings> savings = new GetData().getRegSavings(SSN);
        ArrayList<Checking> checking = new GetData().getCheckingBySSN(SSN);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ATM_home ATM_page = new ATM_home(customer);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Checking> che = new GetData().getCheckingByATMCard(customer);
                try {
                    deposit_ammount = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Please enter a Valid Number");
                }

                for (Checking j:che){
                    if (j.getID().equals(ID)){
                        System.out.println(deposit_ammount+"        "+ savings);
                        j.addBalence(deposit_ammount, savings);
                        System.out.println(j.getBalancef());
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Account Not Found");
                    }
                }
                //ArrayList<RegSavings> savings = new GetData().getRegSavings(SSN);
                //ArrayList<Checking> checking = new GetData().getCheckingBySSN(SSN);
                SaveData saveData = new SaveData();
                saveData.saveCheckAndSave(savings, checking);
                frame.setVisible(false);
                ATM_home ATM_page = new ATM_home(customer);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
