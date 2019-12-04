package GUI;

import Accounts.BankAccounts.Debt.CreditCard;
import SystemHelper.SystemHelper;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class credit_card_payment {
    private JPanel credit_card_payment;
    private JTextField textField1;
    private JButton back_button;
    private JButton accept_button;
    private CreditCard creditCard;
    private Double payment;

    public static void main(String[] args) {
        new credit_card_payment(null, null, null);
    }

    public credit_card_payment(String customer, String user_type, String ID) {
        JFrame frame = new JFrame("Check History");
        frame.setContentPane(credit_card_payment);
        frame.setPreferredSize(new Dimension(1600, 900));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ArrayList<CreditCard> creditCards = new GetData().getCC(customer);


        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                view_debts view_debts= new view_debts(customer, user_type);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (CreditCard x: creditCards){
                    if (x.getID().equals(ID)){
                        creditCard = x;
                    }
                }
                if (!textField1.getText().equals("")) {
                    payment = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                    double need = creditCard.makePayment(payment);
                    System.out.println(need);


                    ArrayList<CreditCard> creditCardArrayList = new ArrayList<>();
                    creditCardArrayList.add(creditCard);

                    SaveData saveData = new SaveData();
                    saveData.saveCC(creditCardArrayList);

                    if (need > 0.0) {
                        JOptionPane.showMessageDialog(null, "Over Paid By " + need);
                    }

                    JOptionPane.showMessageDialog(null, "Payment Completed");

                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Number");
                }
            }
        });

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (CreditCard x: creditCards){
                    if (x.getID().equals(ID)){
                        creditCard = x;
                    }
                }
                payment = new SystemHelper().truncOrRound(Double.parseDouble(textField1.getText()), 0);
                if (!textField1.getText().equals("")) {
                    double need = creditCard.makePayment(payment);
                    System.out.println(need);


                    ArrayList<CreditCard> creditCardArrayList = new ArrayList<>();
                    creditCardArrayList.add(creditCard);

                    SaveData saveData = new SaveData();
                    saveData.saveCC(creditCardArrayList);

                    if (need > 0.0) {
                        JOptionPane.showMessageDialog(null, "Over Paid By " + need);
                    }

                    JOptionPane.showMessageDialog(null, "Payment Completed");

                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Number");
                }
            }
        });
    }
}
