package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class manager_create_credit {
    private JPanel manager_create_credit_panel;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton back_button;
    private JButton accept_button;

    public static void main(String[] args) {
        new manager_loan_credit();
    }

    public manager_create_credit(){
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_create_credit_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_create_loan manager_create_loan = new manager_create_loan();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
