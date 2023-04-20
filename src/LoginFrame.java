import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class LoginFrame extends JFrame implements ActionListener {
    private JLayeredPane backLayer;
    private JButton login,back;
    private JPanel mainLayer;
    private JLabel imageLabel,loginLabel,nlabel,plabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private ImageIcon metroBg,logo;
    public LoginFrame(){

        Font font=new Font(Font.SANS_SERIF,Font.BOLD,36);

        metroBg = new ImageIcon(getClass().getResource("/images/metro rail.png"));
        logo = new ImageIcon(getClass().getResource("/images/logo1.png"));
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

        nlabel=new JLabel();
        nlabel.setText("User ID:");
        nlabel.setBounds(18,125,73,30);
        nlabel.setFont(new Font("Arial",Font.BOLD,19));
        nlabel.setForeground(Color.WHITE);

        plabel=new JLabel();
        plabel.setText("Password:");
        plabel.setBounds(18,180,100,30);
        plabel.setFont(new Font("Arial",Font.BOLD,19));
        plabel.setForeground(Color.WHITE);

        nameField = new JTextField();
        nameField.setBounds(120,125,200,30);
        nameField.setBorder(BorderFactory.createEmptyBorder());
        nameField.setFont(new Font("Arial",Font.BOLD,20));

        passwordField = new JPasswordField();
        passwordField.setBounds(120,180,200,30);
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        passwordField.setFont(new Font("Arial",Font.BOLD,20));

        login = new JButton("Log in");
        login.setFont(new Font("Arial",Font.BOLD,19));
        login.setFocusable(false);
        login.setBounds(60,250,100,40);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));

        back = new JButton("Back");
        back.setFont(new Font("Arial",Font.BOLD,19));
        back.setFocusable(false);
        back.setBounds(180,250,100,40);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));


        mainLayer = new JPanel();
        mainLayer.setLayout(null);
        mainLayer.setBounds(225,100,350,400);
        mainLayer.setBackground(new Color(54, 69, 79,200));

        mainLayer.add(back);
        mainLayer.add(plabel);
        mainLayer.add(nlabel);
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
