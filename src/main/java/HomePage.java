

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
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
        Goto_CreateChecking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
