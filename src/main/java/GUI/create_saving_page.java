package GUI;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;

public class create_saving_page extends JFrame{
    private JPanel create_saving_page;
    private JButton accept_button;
    private JButton back_button;
    private JTextField balance_text;
    private JLabel SSN_label;

    public static void main(String[] args) {
        new create_saving_page(0, null);
    }

    public create_saving_page(int x, String SSN) {
        JFrame frame = new JFrame("Create Savings Account");
        frame.setContentPane(create_saving_page);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        SSN_label.setText(SSN);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == 1){
                    frame.setVisible(false);
                    teller_home teller_home = new teller_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));                }
                if (x == 2){
                    frame.setVisible(false);
                    manager_home manager_home = new manager_home();
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double balance = Double.parseDouble(balance_text.getText());
                RegSavings new_checking = new RegSavings(SSN,balance);
                SaveData save_new_checking = new SaveData();
                ArrayList<RegSavings> savings_arraylist = new ArrayList<>();
                savings_arraylist.add(new_checking);
                save_new_checking.saveSaving(savings_arraylist);

                JOptionPane.showMessageDialog(null, "The Account has Been Successfully Created");
                frame.setVisible(false);
                teller_home teller_home = new teller_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
