package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager_loan_long_term extends JFrame{
    private JPanel manager_loan_long_term;
    private JTable table1;
    private JButton back_button;

    public static void main(String[] args) {
        new manager_loan_long_term();
    }

    public manager_loan_long_term() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_loan_long_term);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_view_loans manager_view_loans = new manager_view_loans();
                manager_view_loans.setVisible(true);
            }
        });
    }
}
