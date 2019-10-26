package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class transfer_money_summary extends JFrame {
    private JPanel transfer_money_summary;
    private JTable table1;
    private JButton back_to_home;

    public static void main(String[] args) {
        new transfer_money_summary();
    }

    public transfer_money_summary() {
        JFrame frame = new JFrame("Teller");
        frame.setContentPane(transfer_money_summary);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        back_to_home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                teller_home teller_home = new teller_home();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
