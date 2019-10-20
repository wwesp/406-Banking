package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager_view_accounts extends JFrame{
    private JPanel manager_view_accounts;
    private JTable table1;
    private JButton back_button;
    private JButton full_history_button;

    public static void main(String[] args) {
        new manager_view_accounts();
    }

    public manager_view_accounts() {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_view_accounts);
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
        full_history_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_account_history manager_account_history = new manager_account_history();
                manager_account_history.setVisible(true);
            }
        });
    }
}
