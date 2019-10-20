package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager_view_loans extends JFrame{
    private JPanel manager_view_loans;
    private JTable table1;
    private JButton back_button;
    private JButton long_term_loan_button;
    private JButton short_term_button;
    private JButton credit_button;

    public static void main(String[] args) {
        new manager_view_loans();
    }

    public manager_view_loans() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_view_loans);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_home manager_home = new manager_home();
                manager_home.setVisible(true);
            }
        });
        credit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_loan_credit manager_loan_credit = new manager_loan_credit();
                manager_loan_credit.setVisible(true);
            }
        });
        short_term_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_loan_short_term manager_loan_short_term = new manager_loan_short_term();
                manager_loan_short_term.setVisible(true);
            }
        });
        long_term_loan_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_loan_long_term manager_loan_long_term = new manager_loan_long_term();
                manager_loan_long_term.setVisible(true);
            }
        });
    }
}
