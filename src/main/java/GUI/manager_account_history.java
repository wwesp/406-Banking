package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class manager_account_history extends JFrame{
    private JPanel manager_account_history;
    private JButton back_button;
    private JTable table1;

    public static void main(String[] args) {
        new manager_account_history(null, null, null);
    }

    public manager_account_history(String customer, String ID, String account_Type) {
        JFrame frame = new JFrame("Manager");
        frame.setContentPane(manager_account_history);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                manager_view_accounts manager_view_accounts = new manager_view_accounts(customer);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
