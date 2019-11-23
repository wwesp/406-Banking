package GUI;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Debt.ShortTermLoan;
import Accounts.BankAccounts.Money.Checking;
import Accounts.People.Customer;
import persistence.GetData.GetData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class view_debts {
    private JPanel view_debts_panel;
    private JButton back_button;
    private JButton creditCardHistoryButton;
    private JTable short_term_loans_table;
    private JTable long_term_loans_table;
    private JTable credit_card_table;
    private String ID;

    public static void main(String[] args) {
        new view_debts(null, null);
    }

    public view_debts(String customer, String user_type) {
        JFrame frame = new JFrame("Check History");
        frame.setContentPane(view_debts_panel);
        frame.setPreferredSize(new Dimension(1600, 900));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        ArrayList<CreditCard> creditCards = new GetData().getCC(customer);
        if(creditCards==null)creditCards=new ArrayList<CreditCard>();
        ArrayList<LongTermLoan> longTermLoans = new GetData().getLongLoan(customer);
        if(longTermLoans==null)longTermLoans=new ArrayList<LongTermLoan>();
        ArrayList<ShortTermLoan> shortTermLoans = new GetData().getShortLoan(customer);
        if(shortTermLoans==null)shortTermLoans=new ArrayList<ShortTermLoan>();

        String[] credit_headers = {"Account ID", "Payment Due", "Fees", "Accruing Balence", "Interest Rate"};
        DefaultTableModel credit_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) { return false; }};
        credit_model.setColumnIdentifiers(credit_headers);
        credit_card_table.setModel(credit_model);
        for (CreditCard x: creditCards){
            credit_model.addRow(new Object[] {x.getID(),x.getCurrentPaymentDue(),x.getFees(),x.getBalancef(),x.getInterestRate()});
        }

        String[] short_headers = {"Account ID", "Loan Balence", "Fees", "Current Payment Due", "Interest Rate"};
        DefaultTableModel short_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) { return false; }};
        short_model.setColumnIdentifiers(short_headers);
        short_term_loans_table.setModel(short_model);
        for (ShortTermLoan x: shortTermLoans){
            short_model.addRow(new Object[] {x.getID(),x.getBalancef(), x.getFees(), x.getCurrentPaymentDue(),x.getInterestRate()});
        }

        String[] long_headers = {"Account ID", "Loan Balence", "Fees", "Current Payment Due", "Interest Rate"};
        DefaultTableModel long_model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) { return false; }};
        long_model.setColumnIdentifiers(long_headers);
        long_term_loans_table.setModel(long_model);
        for (LongTermLoan x: longTermLoans){
            System.out.println("View debts fuckin :   "+x);
            long_model.addRow(new Object[] {x.getID(),x.getBalancef(), x.getFees(), x.getCurrentPaymentDue(),x.getInterestRate()});
        }

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user_type.equals("teller")) {
                    frame.setVisible(false);
                    teller_view_accounts teller_view_accounts = new teller_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                if (user_type.equals("manager")){
                    frame.setVisible(false);
                    manager_view_accounts manager_view_accounts = new manager_view_accounts(customer);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        creditCardHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ID != null) {
                    frame.setVisible(false);
                    credit_card_history credit_card_history = new credit_card_history(customer, user_type, ID);
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please Select Credit Card Account");
                }
            }
        });
        credit_card_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = credit_card_table.getSelectedRow();
                ID = credit_card_table.getModel().getValueAt(row,0).toString();
            }
        });
    }
}
