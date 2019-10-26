package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class manager_transfer_summary extends JFrame{
    private JPanel manager_transfer_summary;
    private JTable table1;
    private JButton home_button;

    public static void main(String[] args) {
        new manager_transfer_summary();
    }

    public manager_transfer_summary() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_transfer_summary);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        home_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_home manager_home = new manager_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
