import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Whatsapp extends JFrame implements ActionListener {
    JButton send;
    JTextField text;

    public Whatsapp() {
        JPanel green = new JPanel();
        green.setBackground(new Color(3, 94, 3));
        green.setBounds(0, 0, 400, 60);
        green.setLayout(null);
        add(green);
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
        ImageIcon user1 = new ImageIcon(ClassLoader.getSystemResource("icons/Gaitonde.png"));
        Image i9 = user1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i10 = new ImageIcon(i9);
        JLabel user1Image = new JLabel(i10);
        user1Image.setBounds(50, 10, 40, 40);
        green.add(user1Image);
        // Name
        JLabel gaitonde=new JLabel("Gaitonde");
        gaitonde.setBounds(150,10,100,20);
        gaitonde.setForeground(Color.white);
        gaitonde.setFont(new Font("system",Font.PLAIN,16));
        green.add(gaitonde);
        JLabel status=new JLabel("Active now");
        status.setBounds(150,40,100,20);
        status.setForeground(Color.white);
        status.setFont(new Font("system",Font.PLAIN,13));
        green.add(status);
        // TextField
        text = new JTextField();
        text.setBounds(10, 560, 270, 30);
        add(text);
        // Button
        send = new JButton("Send");
        send.setBounds(285, 560, 100, 30);
        send.setBackground(new Color(3, 94, 3));
        send.setForeground(Color.white);
        add(send);
        // Default setup
        setTitle("Whatsapp");
        setLayout(null);
        setUndecorated(true);
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        new Whatsapp();
    }
}
