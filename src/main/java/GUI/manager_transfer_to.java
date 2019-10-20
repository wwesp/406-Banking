package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager_transfer_to extends JFrame{
    private JPanel manager_transfer_to;
    private JTable table1;
    private JButton back_button;
    private JButton accept_button;

    public static void main(String[] args) {
        new manager_transfer_to();
    }

    public manager_transfer_to() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_transfer_to);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_transfer_from manager_transfer_from = new manager_transfer_from();
                manager_transfer_from.setVisible(true);
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_transfer_summary manager_transfer_summary = new manager_transfer_summary();
                manager_transfer_summary.setVisible(true);
            }
        });
    }
}
