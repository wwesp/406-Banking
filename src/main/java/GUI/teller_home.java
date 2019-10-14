package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class teller_home  extends JPanel{
    private JPanel teller_home_panel;
    private JButton create_checking_account;

    public static void main(String[] args) {
        new teller_home();
    }

    public teller_home(){
        JFrame frame = new JFrame("Home ");
        frame.setContentPane(teller_home_panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        create_checking_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                checking_page checking = new checking_page();
                checking.setVisible(true);
            }
        });
    }
}
