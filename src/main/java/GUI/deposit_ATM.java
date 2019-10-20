package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deposit_ATM extends JFrame {
    private JPanel deposit_ATM;
    private JTextField textField1;
    private JButton accept_button;
    private JButton back_button;

    public static void main(String[] args) {
        new deposit_ATM();
    }

    public deposit_ATM() {
        JFrame frame = new JFrame("Deposit");
        frame.setContentPane(deposit_ATM);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ATM_home ATM_page = new ATM_home();
                ATM_page.setVisible(true);
            }
        });
    }
}
