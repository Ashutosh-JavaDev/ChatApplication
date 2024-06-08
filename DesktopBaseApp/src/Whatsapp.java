import java.awt.Color;

import javax.swing.*;
public class Whatsapp extends JFrame {
    public Whatsapp(){
        JPanel green=new JPanel();
        green.setBackground(Color.GREEN);
        green.setBounds(0,0,400,50);
        add(green);
        // Default setup
        setTitle("Whatsapp");
        setLayout(null);
        setSize(400,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(35,50);
        setVisible(true);
    }
    public static void main(String[]args){
        new Whatsapp();
    }
}
