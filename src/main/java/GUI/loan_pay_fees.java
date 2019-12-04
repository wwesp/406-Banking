package GUI;

import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Debt.ShortTermLoan;
import SystemHelper.SystemHelper;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class loan_pay_fees {
    private JPanel pay_missed_payments;
    private JTextField textField1;
    private JButton back_button;
    private JButton accept_button;
    private Double payment;
    private LongTermLoan longTermLoan;
    private ShortTermLoan shortTermLoan;

    public static void main(String[] args) {
        new loan_pay_fees(null, null, null,null);
    }

    public loan_pay_fees(String customer, String user_type, String ID, String loan_type) {
        JFrame frame = new JFrame("Check History");
        frame.setContentPane(pay_missed_payments);
        frame.setPreferredSize(new Dimension(1600, 900));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ArrayList<LongTermLoan> longTermLoans = new GetData().getLongLoan(customer);
        ArrayList<ShortTermLoan> shortTermLoans = new GetData().getShortLoan(customer);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                view_debts view_debts= new view_debts(customer, user_type);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loan_type.equals("Short Term")) {
                    for (ShortTermLoan x : shortTermLoans) {
                        if (x.getID().equals(ID)) {
                            shortTermLoan = x;
                        }
                    }
                    payment = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    shortTermLoan.payMissedFees(payment);

                    ArrayList<ShortTermLoan> shortTermLoans1 = new ArrayList<>();
                    shortTermLoans1.add(shortTermLoan);

                    SaveData saveData = new SaveData();
                    saveData.saveShortLoan(shortTermLoans1);

                    JOptionPane.showMessageDialog(null, "Payment Completed");

                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    for (LongTermLoan x : longTermLoans) {
                        if (x.getID().equals(ID)) {
                            longTermLoan = x;
                        }
                    }
                    payment = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    longTermLoan.payMissedFees(payment);

                    ArrayList<LongTermLoan> longTermLoanArrayList = new ArrayList<>();
                    longTermLoanArrayList.add(longTermLoan);

                    SaveData saveData = new SaveData();
                    saveData.saveLongLoan(longTermLoanArrayList);

                    JOptionPane.showMessageDialog(null, "Payment Completed");

                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loan_type.equals("Short Term")) {
                    for (ShortTermLoan x : shortTermLoans) {
                        if (x.getID().equals(ID)) {
                            shortTermLoan = x;
                        }
                    }
                    payment = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    shortTermLoan.payMissedFees(payment);

                    ArrayList<ShortTermLoan> shortTermLoans1 = new ArrayList<>();
                    shortTermLoans1.add(shortTermLoan);

                    SaveData saveData = new SaveData();
                    saveData.saveShortLoan(shortTermLoans1);

                    JOptionPane.showMessageDialog(null, "Payment Completed");

                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    for (LongTermLoan x : longTermLoans) {
                        if (x.getID().equals(ID)) {
                            longTermLoan = x;
                        }
                    }
                    payment = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    longTermLoan.payMissedFees(payment);

                    ArrayList<LongTermLoan> longTermLoanArrayList = new ArrayList<>();
                    longTermLoanArrayList.add(longTermLoan);

                    SaveData saveData = new SaveData();
                    saveData.saveLongLoan(longTermLoanArrayList);

                    JOptionPane.showMessageDialog(null, "Payment Completed");

                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
    }
}
