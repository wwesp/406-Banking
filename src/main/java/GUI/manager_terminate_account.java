package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class manager_terminate_account extends JFrame{
    private JPanel manager_terminate_account;
    private JTable table1;
    private JButton back_button;
    private JButton accept_button;

    public static void main(String[] args) {
        new manager_terminate_account();
    }

    public manager_terminate_account() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_terminate_account);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    }
}
