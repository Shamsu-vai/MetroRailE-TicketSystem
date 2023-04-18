import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class LoginFrame extends JFrame {
    private JLayeredPane backLayer;
    private JPanel mainLayer;
    private JLabel imageLabel;
    private JLabel loginLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private ImageIcon metroBg;
    public LoginFrame(){

        Font font=new Font(Font.SANS_SERIF,Font.BOLD,36);

        metroBg = new ImageIcon("metro rail.png");
        ImageIcon logo = new ImageIcon("LOGO.png");

        imageLabel=new JLabel();
        imageLabel.setIcon(metroBg);
        imageLabel.setBounds(0,-3,800,900);
        imageLabel.setVerticalAlignment(JLabel.TOP);

        backLayer = new JLayeredPane();
        backLayer.add(imageLabel);
        backLayer.setBounds(0,0,800,600);


        loginLabel = new JLabel();
        loginLabel.setFont(font);
        //loginLabel.setIcon(logo);
        loginLabel.setText("LOGIN");
        loginLabel.setBounds(115,30,120,50);
        //loginLabel.setOpaque(true);

        nameField = new JTextField();
        nameField.setBounds(75,125,200,25);

        passwordField = new JPasswordField();
        passwordField.setBounds(75,200,200,25);

        mainLayer = new JPanel();
        mainLayer.setLayout(null);
        mainLayer.setBounds(225,100,350,400);
        mainLayer.setBackground(new Color(54, 69, 79,200));
        mainLayer.add(loginLabel);
        mainLayer.add(nameField);
        mainLayer.add(passwordField);

        this.add(mainLayer);
        this.add(backLayer);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setUndecorated(true);
        //this.setShape(new RoundRectangle2D.Double(0, 0, 800, 600, 50, 50));
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
