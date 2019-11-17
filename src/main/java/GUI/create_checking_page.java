package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;

public class create_checking_page extends JPanel{

    private JPanel CreateCheckingPage;
    private JButton AcceptButton;
    private JButton Clear;
    private JTextField balance_text;
    private JLabel SSN;
    private JLabel account_num;
    private JLabel routing_num;
    private JLabel balance;
    private JButton back_button;
    private JComboBox<String> account_type_drop_down;
    private String account_type;
    private int account_number;
    private JCheckBox createATMCardCheckBox;
    private boolean ATM_card;
    private JLabel SSN_label;
    private JComboBox back_up_account_combo;


    public static void main(String[] args) {
        new create_checking_page(0, null);
    }
    public create_checking_page(int x, String SSN) {

        JFrame frame = new JFrame("Create Checking");
        frame.setContentPane(CreateCheckingPage);
        frame.setPreferredSize(new Dimension(820, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        SSN_label.setText(SSN);

        //String[] account_types = { "That's My Bank", "Gold/Diamond"};
        account_type_drop_down.addItem("That's My Bank");
        account_type_drop_down.addItem("Gold/Diamond");

        ArrayList<RegSavings> savings = new GetData().getRegSavings(SSN);

        back_up_account_combo.addItem("");
        for (RegSavings y : savings) {
            back_up_account_combo.addItem(y.getID());
        }
        //double bal = Double.parseDouble(new GUI().textField3.getText());
        AcceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                account_type = Objects.requireNonNull(account_type_drop_down.getSelectedItem()).toString();
                if (account_type == "That's My Bank"){
                    account_number = 0;
                }
                else {
                    account_number = 1;
                }
                double balance = Double.parseDouble(balance_text.getText());
                Checking new_checking = new Checking(SSN,balance,account_number, Objects.requireNonNull(back_up_account_combo.getSelectedItem()).toString(), ATM_card);
                SaveData save_new_checking = new SaveData();
                ArrayList<Checking> checking_arraylist = new ArrayList<>();
                checking_arraylist.add(new_checking);
                save_new_checking.saveChecking(checking_arraylist);

                JOptionPane.showMessageDialog(null, "The Account has Been Successfully Created");
                frame.setVisible(false);
                teller_home teller_home = new teller_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balance_text.setText("");
            }
        });
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == 1){
                    frame.setVisible(false);
                    ATM_home ATM_page = new ATM_home(null);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (x == 2){
                    frame.setVisible(false);
                    validate_teller_create_checking validate_teller_create_checking = new validate_teller_create_checking();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (x == 3){
                    frame.setVisible(false);
                    manager_home manager_page = new manager_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        balance_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                account_type = Objects.requireNonNull(account_type_drop_down.getSelectedItem()).toString();
                if (account_type.equals("That's My Bank")){
                    account_number = 0;
                }
                else {
                    account_number = 1;
                }
                double balance = Double.parseDouble(balance_text.getText());
                Checking new_checking = new Checking(SSN,balance,account_number, Objects.requireNonNull(back_up_account_combo.getSelectedItem()).toString(), ATM_card);
                System.out.println(new_checking.getBalancef());
                SaveData save_new_checking = new SaveData();
                ArrayList<Checking> checking_arraylist = new ArrayList<>();
                checking_arraylist.add(new_checking);
                save_new_checking.saveChecking(checking_arraylist);

                JOptionPane.showMessageDialog(null, "The Account has Been Successfully Created");
                frame.setVisible(false);
                teller_home teller_home = new teller_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        createATMCardCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ATM_card = true;
            }
        });
    }
}
