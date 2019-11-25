package GUI;

import Accounts.Interest;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class change_interest {
    private JPanel change_interest_panel;
    private JTextField cd_interest_text;
    private JTextField credit_card_interest_text;
    private JTextField loan_interest_text;
    private JTextField checking_interest_text;
    private JTextField savings_interest_text;
    private JButton back_button;
    private JButton accept_button;

    public static void main(String[] args) {
        new change_interest();
    }

    public change_interest() {
        JFrame frame = new JFrame("Select Deposit or Withdraw");
        frame.setContentPane(change_interest_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Interest interest_rates = new GetData().getIntRates();
        checking_interest_text.setText(String.valueOf(interest_rates.getCheckingInterestRate()));
        savings_interest_text.setText(String.valueOf(interest_rates.getRegSavingsInterestRate()));
        cd_interest_text.setText(String.valueOf(interest_rates.getCDInterest()));
        loan_interest_text.setText(String.valueOf(interest_rates.getLoansInterest()));
        credit_card_interest_text.setText(String.valueOf(interest_rates.getCreditCardInterest()));


        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        credit_card_interest_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checking_interest_text.getText();
                Interest interest = new Interest(Double.parseDouble(checking_interest_text.getText()), Double.parseDouble(savings_interest_text.getText())
                , Double.parseDouble(cd_interest_text.getText()), Double.parseDouble(loan_interest_text.getText()), Double.parseDouble(credit_card_interest_text.getText()));

                SaveData saveData = new SaveData();
                saveData.saveInterest(interest);

                JOptionPane.showMessageDialog(null, "Interest Rates Updated");
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        loan_interest_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checking_interest_text.getText();
                Interest interest = new Interest(Double.parseDouble(checking_interest_text.getText()), Double.parseDouble(savings_interest_text.getText())
                        , Double.parseDouble(cd_interest_text.getText()), Double.parseDouble(loan_interest_text.getText()), Double.parseDouble(credit_card_interest_text.getText()));

                SaveData saveData = new SaveData();
                saveData.saveInterest(interest);

                JOptionPane.showMessageDialog(null, "Interest Rates Updated");
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        cd_interest_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checking_interest_text.getText();
                Interest interest = new Interest(Double.parseDouble(checking_interest_text.getText()), Double.parseDouble(savings_interest_text.getText())
                        , Double.parseDouble(cd_interest_text.getText()), Double.parseDouble(loan_interest_text.getText()), Double.parseDouble(credit_card_interest_text.getText()));

                SaveData saveData = new SaveData();
                saveData.saveInterest(interest);

                JOptionPane.showMessageDialog(null, "Interest Rates Updated");
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        savings_interest_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checking_interest_text.getText();
                Interest interest = new Interest(Double.parseDouble(checking_interest_text.getText()), Double.parseDouble(savings_interest_text.getText())
                        , Double.parseDouble(cd_interest_text.getText()), Double.parseDouble(loan_interest_text.getText()), Double.parseDouble(credit_card_interest_text.getText()));

                SaveData saveData = new SaveData();
                saveData.saveInterest(interest);

                JOptionPane.showMessageDialog(null, "Interest Rates Updated");
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        checking_interest_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checking_interest_text.getText();
                Interest interest = new Interest(Double.parseDouble(checking_interest_text.getText()), Double.parseDouble(savings_interest_text.getText())
                        , Double.parseDouble(cd_interest_text.getText()), Double.parseDouble(loan_interest_text.getText()), Double.parseDouble(credit_card_interest_text.getText()));


                SaveData saveData = new SaveData();
                saveData.saveInterest(interest);

                JOptionPane.showMessageDialog(null, "Interest Rates Updated");
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checking_interest_text.getText();
                Interest interest = new Interest(Double.parseDouble(checking_interest_text.getText()), Double.parseDouble(savings_interest_text.getText())
                        , Double.parseDouble(cd_interest_text.getText()), Double.parseDouble(loan_interest_text.getText()), Double.parseDouble(credit_card_interest_text.getText()));

                SaveData saveData = new SaveData();
                saveData.saveInterest(interest);

                JOptionPane.showMessageDialog(null, "Interest Rates Updated");
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
