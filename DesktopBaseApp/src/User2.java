import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class User2 implements ActionListener {
    JButton send;
    JTextField text;
    static JPanel textPanel;
    static Box vertical = Box.createVerticalBox();
    static DataOutputStream dout;
    static JFrame frame = new JFrame();

    public User2() {
        JPanel green = new JPanel();
        green.setBackground(new Color(3, 94, 3));
        green.setBounds(0, 0, 450, 60);
        green.setLayout(null);
        frame.add(green);
        // Image
        ImageIcon back = new ImageIcon(ClassLoader.getSystemResource("icons/three.png"));
        Image i1 = back.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(5, 20, 25, 25);
        green.add(image);
        image.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        // Video logo
        ImageIcon video = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i3 = video.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel videoImage = new JLabel(i4);
        videoImage.setBounds(280, 20, 25, 25);
        green.add(videoImage);
        // Call
        ImageIcon call = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i5 = call.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel callImage = new JLabel(i6);
        callImage.setBounds(325, 20, 25, 25);
        green.add(callImage);
        // icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/icon.png"));
        Image i7 = icon.getImage().getScaledInstance(15, 25, Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel iconImage = new JLabel(i8);
        iconImage.setBounds(375, 20, 15, 25);
        green.add(iconImage);
        // user1
        ImageIcon user1 = new ImageIcon(ClassLoader.getSystemResource("icons/Bunty.png"));
        Image i9 = user1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i10 = new ImageIcon(i9);
        JLabel user1Image = new JLabel(i10);
        user1Image.setBounds(50, 10, 40, 40);
        green.add(user1Image);
        // Name
        JLabel gaitonde = new JLabel("Bunty");
        gaitonde.setBounds(100, 10, 100, 20);
        gaitonde.setForeground(Color.white);
        gaitonde.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        green.add(gaitonde);
        JLabel status = new JLabel("Active now");
        status.setBounds(100, 33, 100, 20);
        status.setForeground(Color.white);
        status.setFont(new Font("SAN_SERIF", Font.PLAIN, 13));
        green.add(status);
        // Panel
        textPanel = new JPanel();
        textPanel.setBounds(5, 75, 440, 570);
        textPanel.setLayout(null);
        frame.add(textPanel);
        // TextField
        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        frame.add(text);
        // Button
        send = new JButton("Send");
        send.setBounds(325, 655, 100, 40);
        send.setBackground(new Color(3, 94, 3));
        send.setForeground(Color.white);
        frame.add(send);
        send.addActionListener(this);
        // Default setup
        frame.setTitle("Whatsapp");
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(450, 700);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocation(900, 150);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
   try{
    String textx = text.getText();
    JPanel p2 = formatpanel(textx);
    textPanel.setLayout(new BorderLayout());
    JPanel right = new JPanel(new BorderLayout());
    right.add(p2, BorderLayout.LINE_END);
    vertical.add(right);
    vertical.add(Box.createVerticalStrut(15));
    textPanel.add(vertical, BorderLayout.PAGE_START);
    text.setText("");
    dout.writeUTF(textx);
    frame.repaint();
    frame.invalidate();
    frame.validate();
   }
   catch(IOException e){
    e.printStackTrace();
   }
    }

    public static JPanel formatpanel(String textx) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel output = new JLabel(textx);
        output.setFont(new Font("Arial", Font.BOLD, 15));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        output.setBackground(new Color(37, 211, 102));
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel formet = new JLabel();
        formet.setText(sdf.format(cal.getTime()));
        panel.add(formet);
        panel.add(output);

        return panel;
    }

    public static void main(String[] args) {
        new User2();
        try {
            Socket s = new Socket("127.0.0.1", 6001);
            DataInputStream din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            while (true) {
                textPanel.setLayout(new BorderLayout());
                String msg = din.readUTF();
                JPanel panel = formatpanel(msg);
                JPanel left = new JPanel(new BorderLayout());
                left.add(panel, BorderLayout.LINE_START);
                vertical.add(left);
                vertical.add(Box.createVerticalStrut(15));
                textPanel.add(vertical,BorderLayout.PAGE_START);
                frame.validate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
