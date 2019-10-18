package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class create_checking_page extends JPanel{

    private JPanel CreateCheckingPage;
    private JButton AcceptButton;
    private JButton Clear;
    private JTextField SSN_textfield;
    private JTextField customer_textfield;
    private JTextField account_number_textfield;
    private JTextField routing_number_textfield;
    private JTextField balance_textfield;
    private JTextField history_textfield;
    private JLabel SSN;
    private JLabel Customer;
    private JLabel account_num;
    private JLabel routing_num;
    private JLabel balance;
    private JLabel history;
    private JButton back_button;

    public static void main(String[] args) {
        new create_checking_page();
    }
    public create_checking_page() {

        JFrame frame = new JFrame("Create Checking ");
        frame.setContentPane(CreateCheckingPage);
        frame.setPreferredSize(new Dimension(801, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //double bal = Double.parseDouble(new GUI().textField3.getText());
        AcceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountnum = account_number_textfield.getText();
                String routingnum = routing_number_textfield.getText();
                String SSN = SSN_textfield.getText();
                double balance = Double.parseDouble(balance_textfield.getText());
                String history = history_textfield.getText();
                CheckingAccount x = new CheckingAccount(SSN,accountnum, routingnum, balance,null);
                JOptionPane.showInternalMessageDialog(null, x );
                System.out.println("This is the Checking Account " + x );
            }
        });
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SSN_textfield.setText("");
                customer_textfield.setText("");
                account_number_textfield.setText("");
                routing_number_textfield.setText("");
                balance_textfield.setText("");
                history_textfield.setText("");
            }
        });
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}




