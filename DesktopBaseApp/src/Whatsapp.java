import javax.swing.*;
public class Whatsapp extends JFrame {
    public Whatsapp(){
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
