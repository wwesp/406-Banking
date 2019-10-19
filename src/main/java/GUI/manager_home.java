package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager_home extends JPanel {
    private JPanel manager_home_panel;
    private JButton create_checking_account;
    private JButton back_button;

    public static void main(String[] args) {
        new manager_home();
    }

    public manager_home() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_home_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        create_checking_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                create_checking_page checking = new create_checking_page(3);
                checking.setVisible(true);
            }
        });
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
