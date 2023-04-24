import javax.swing.*;

public class Register extends JFrame {
    private JButton submitbutton,backbutton;
    private JLabel label;

    public Register(){
        label =new JLabel("Register");
        label.setBounds(259,44,259,44);
        this.add(label);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Register");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Register R= new Register();
    }
}