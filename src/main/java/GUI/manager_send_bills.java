package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class manager_send_bills extends JFrame{
    private JPanel manager_send_bills;
    private JTable table1;
    private JButton back_button;
    private JButton send_bill_button;

    public static void main(String[] args) {
        new manager_send_bills();
    }

    public manager_send_bills() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_send_bills);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
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
