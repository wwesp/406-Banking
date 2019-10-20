package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager_rollover_notices extends JFrame{
    private JPanel manager_rollover_notices;
    private JTable table1;
    private JButton back_button;
    private JButton send_button;

    public static void main(String[] args) {
        new manager_rollover_notices();
    }

    public manager_rollover_notices() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_rollover_notices);
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
    }
}
