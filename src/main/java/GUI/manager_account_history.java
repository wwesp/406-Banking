package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager_account_history extends JFrame{
    private JPanel manager_account_history;
    private JTable table1;
    private JButton back_button;

    public static void main(String[] args) {
        new manager_account_history(null);
    }

    public manager_account_history(String customer) {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_account_history);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manager_view_accounts manager_view_accounts = new manager_view_accounts(customer);
                manager_view_accounts.setVisible(true);
            }
        });
    }
}
