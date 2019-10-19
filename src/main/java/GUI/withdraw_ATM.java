package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class withdraw_ATM extends JFrame {
    private JPanel withdraw_ATM;
    private JTextField textField1;
    private JButton back_button;
    private JButton accept_button;

    public static void main(String[] args) {
        new withdraw_ATM();
    }

    public withdraw_ATM() {

        JFrame frame = new JFrame("Deposit");
        frame.setContentPane(withdraw_ATM);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                home_page home_page = new home_page();
                home_page.setVisible(true);
            }
        });
    }
}
