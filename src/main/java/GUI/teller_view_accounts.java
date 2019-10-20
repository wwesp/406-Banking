package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class teller_view_accounts extends JFrame{
    private JTable table1;
    private JButton back_button;
    private JPanel teller_view_accounts;

    public static void main(String[] args) {
        new teller_view_accounts();
    }

    public teller_view_accounts() {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(teller_view_accounts);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                teller_home teller_home = new teller_home();
                teller_home.setVisible(true);
            }
        });
    }
}
