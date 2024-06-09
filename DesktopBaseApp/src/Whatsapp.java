import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

public class Whatsapp extends JFrame {
    JButton send;
    JTextField text;

    public Whatsapp() {
        ImageIcon back=new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i1=back.getImage().getScaledInstance(5, 10, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel image=new JLabel(i2);
        JPanel green = new JPanel();
        green.setBackground(new Color(3, 94, 3));
        green.setBounds(0, 0, 400, 60);
        add(green);
        // TextField
        text = new JTextField();
        text.setBounds(10,560,270,30);
        add(text);
        // Button
        send=new JButton("Send");
        send.setBounds(285,560,100,30);
        send.setBackground(new Color(3,94,3));
        send.setForeground(Color.white);
        add(send);
        // Default setup
        setTitle("Whatsapp");
        setLayout(null);
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(35, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Whatsapp();
    }
}
