package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class manager_create_loan {
    private JPanel manager_create_loan;
    private JButton credit_button;
    private JButton short_term_button;
    private JButton long_term_loan;
    private JButton accept_button;
    private JButton back_button;

    public static void main(String[] args) {
        new manager_create_loan();
    }

    public manager_create_loan() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_create_loan);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        credit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_create_credit manager_create_credit = new manager_create_credit();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
