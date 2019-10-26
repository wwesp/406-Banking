package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class transfer_money_to extends JFrame{
    private JPanel transfer_money_to;
    private JTable table1;
    private JButton back_button;
    private JButton accept_button;

    public static void main(String[] args) {
        new transfer_money_to("x");
    }

    public transfer_money_to(String x) {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(transfer_money_to);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                transfer_money_from transfer_money_from = new transfer_money_from("x");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        accept_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                transfer_money_summary transfer_money_summary = new transfer_money_summary();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
