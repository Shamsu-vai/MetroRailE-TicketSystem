import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class LoginFrame extends JFrame implements ActionListener {
    private JLayeredPane backLayer;
    private JButton login,back;
    private JPanel mainLayer;
    private JLabel imageLabel,loginLabel,label;
    private JTextField nameField;
    private JPasswordField passwordField;
    private ImageIcon metroBg;
    public LoginFrame(){

        Font font=new Font(Font.SANS_SERIF,Font.BOLD,36);

        metroBg = new ImageIcon("metro rail.png");
        ImageIcon logo = new ImageIcon("logo1.png");
        this.setTitle("Metro e-ticket");
        this.setIconImage(logo.getImage());

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
        loginLabel.setForeground(Color.white);
        loginLabel.setBounds(115,30,120,50);

        //loginLabel.setOpaque(true);

        label=new JLabel("User ID");//shamne user id ta astese na kn??
        label.setBounds(100,125,40,20);

        nameField = new JTextField();
        nameField.setBounds(115,125,200,25);

        passwordField = new JPasswordField();
        passwordField.setBounds(115,200,200,25);

        login = new JButton("Log in");
        login.setFont(new Font("Arial",Font.BOLD,19));
        login.setFocusable(false);
        login.setBounds(60,250,100,40);

        back = new JButton("Back");
        back.setFont(new Font("Arial",Font.BOLD,19));
        back.setFocusable(false);
        back.setBounds(180,250,100,40);


        mainLayer = new JPanel();
        mainLayer.setLayout(null);
        mainLayer.setBounds(225,100,350,400);
        mainLayer.setBackground(new Color(54, 69, 79,200));

        mainLayer.add(back);
        mainLayer.add(label);
        mainLayer.add(login);
        mainLayer.add(loginLabel);
        mainLayer.add(nameField);
        mainLayer.add(passwordField);

        this.add(mainLayer);
        this.add(backLayer);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        //this.setUndecorated(true);
        //this.setShape(new RoundRectangle2D.Double(0, 0, 800, 600, 50, 50));
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source== login){
            
        } else if (source==back) {
            
        }
    }
}
