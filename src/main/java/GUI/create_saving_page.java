package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class create_saving_page extends JFrame{
    private JPanel create_saving_page;
    private JButton accept_button;
    private JButton back_button;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public static void main(String[] args) {
        new create_saving_page(0);
    }

    public create_saving_page(int x) {
        JFrame frame = new JFrame("Create Savings Account");
        frame.setContentPane(create_saving_page);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == 1){
                    frame.dispose();
                    teller_home teller_home = new teller_home();
                    teller_home.setVisible(true);
                }
                if (x == 2){
                    frame.dispose();
                    manager_home manager_home = new manager_home();
                    manager_home.setVisible(true);
                }
            }
        });
    }
}
