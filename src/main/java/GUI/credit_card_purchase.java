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

public class credit_card_purchase {
    private JPanel credit_card_purchase_panel;
    private JTextField Item_text;
    private JTextField price_text;
    private JButton accept_button;
    private JButton back_button;
    private CreditCard creditCard;
    private Double purchase;
    private String item;

    public static void main(String[] args) {
        new credit_card_purchase(null, null, null);
    }

    public credit_card_purchase(String customer, String user_type, String ID) {
        JFrame frame = new JFrame("Check History");
        frame.setContentPane(credit_card_purchase_panel);
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
                view_debts view_debts = new view_debts(customer, user_type);
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
                purchase = new SystemHelper().truncOrRound(Double.parseDouble(price_text.getText()), 0);
                item = Item_text.getText();
                if (purchase != null && item != null) {
                    creditCard.makeCreditPurchase(purchase, item);

                    ArrayList<CreditCard> creditCardArrayList = new ArrayList<>();
                    creditCardArrayList.add(creditCard);

                    SaveData saveData = new SaveData();
                    saveData.saveCC(creditCardArrayList);

                    JOptionPane.showMessageDialog(null, "Payment Completed");

                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Enter Both Fields");
                }
            }
        });
        Item_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (CreditCard x: creditCards){
                    if (x.getID().equals(ID)){
                        creditCard = x;
                    }
                }
                purchase = new SystemHelper().truncOrRound(Double.parseDouble(price_text.getText()), 0);
                item = Item_text.getText();
                if (purchase != null && item != null) {

                    boolean failed = creditCard.makeCreditPurchase(purchase, item);
                    if (!failed){
                        JOptionPane.showMessageDialog(null, "Credit Line Smaller Than Purchase");
                    }

                    ArrayList<CreditCard> creditCardArrayList = new ArrayList<>();
                    creditCardArrayList.add(creditCard);

                    SaveData saveData = new SaveData();
                    saveData.saveCC(creditCardArrayList);

                    JOptionPane.showMessageDialog(null, "Payment Completed");

                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Enter Both Fields");
                }
            }
        });
        price_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (CreditCard x: creditCards){
                    if (x.getID().equals(ID)){
                        creditCard = x;
                    }
                }
                purchase = new SystemHelper().truncOrRound(Double.parseDouble(price_text.getText()), 0);
                item = Item_text.getText();
                if (purchase != null && item != null) {
                    creditCard.makeCreditPurchase(purchase, item);

                    ArrayList<CreditCard> creditCardArrayList = new ArrayList<>();
                    creditCardArrayList.add(creditCard);

                    SaveData saveData = new SaveData();
                    saveData.saveCC(creditCardArrayList);

                    JOptionPane.showMessageDialog(null, "Payment Completed");

                    frame.setVisible(false);
                    view_debts view_debts = new view_debts(customer, user_type);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Enter Both Fields");
                }
            }
        });
    }
}
