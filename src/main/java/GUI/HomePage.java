package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.GUI;

public class HomePage extends JPanel{
    private JButton Goto_CreateChecking;
    private JPanel Homepage;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Enter ");
        frame.setContentPane(new HomePage().Homepage);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public HomePage() {
        JFrame frame = new JFrame("test ");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setContentPane(Homepage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Goto_CreateChecking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI checking = new GUI();
                checking.setVisible(true);
            }
        });
    }
}
