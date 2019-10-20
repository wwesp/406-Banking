package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transfer_money_from extends JFrame{
    private JPanel transfer_money_from;
    private JTable table1;
    private JButton back_button;
    private JButton accept_button;

    public static void main(String[] args) {
        new transfer_money_from();
    }

    public transfer_money_from() {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(transfer_money_from);
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
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                transfer_money_to transfer_money_to = new transfer_money_to();
                transfer_money_to.setVisible(true);
            }
        });
    }
}
