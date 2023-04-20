import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Welcome extends JFrame implements ActionListener {
    private JLayeredPane mainLayer;
    private JLabel imageLabel, logoLabel,
            welcomeLabel,metroLabel;
    private JButton log,register,about;
    private JPanel panel;

    public Welcome(){

        //images are objects to change
        //these are placeholder images.
        ImageIcon welcomeBG = new ImageIcon(getClass().getResource("/images/welcomeBG.jpg"));
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo1.png"));

        //main layered pane as container
        mainLayer = new JLayeredPane();
        mainLayer.setSize(1512,982);

        //Background image label
        imageLabel = new JLabel();
        imageLabel.setIcon(welcomeBG);
        imageLabel.setBounds(0,0,1512,982);

        //top logo image label
        logoLabel = new JLabel();
        logoLabel.setBounds(580,110,500,500);
        logoLabel.setIcon(logo);

        //Welcome text label
        welcomeLabel = new JLabel();
        welcomeLabel.setText("WELCOME");
        welcomeLabel.setBounds(617,455,277,80);
        welcomeLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,50));
        //welcomeLabel.setOpaque(true);

        //Metro text lebel
        metroLabel = new JLabel();
        metroLabel.setText("METRO RAIL E-TICKETING");
        metroLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,48));
        metroLabel.setBounds(420,557,625,80);
        //metroLabel.setOpaque(true);


        // Log in button
        log = new JButton();
        log.addActionListener(this);
        log.setActionCommand("login");
        log.setText("LOG IN");
        log.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        log.setBounds(450,690,132,36);
        log.setFocusable(false);
        log.setBorder(BorderFactory.createEmptyBorder());

        // Register button
        register = new JButton();
        register.addActionListener(this);
        register.setActionCommand("register");
        register.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        register.setText("REGISTER");
        register.setBorder(BorderFactory.createEmptyBorder());
        register.setBounds(650,690,136,36);
        register.setFocusable(false);

        // About button
        about = new JButton();
        about.addActionListener(this);
        about.setActionCommand("about");
        about.setText("ABOUT");
        about.setFocusable(false);
        about.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        about.setBounds(850,690,130,36);
        about.setFocusable(false);
        about.setBorder(BorderFactory.createEmptyBorder());


        //Adding to the main layered pane
        mainLayer.add(log);
        mainLayer.add(about);
        mainLayer.add(register);
        mainLayer.add(metroLabel);
        mainLayer.add(welcomeLabel);
        mainLayer.add(imageLabel);
        this.add(mainLayer);

        // Welcome frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1512,982);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "login":
                this.setVisible(false);
                LoginFrame logFrame = new LoginFrame();
            break;
            case"register":break;
            case "about":break;
            default:
        }
    }

    public static void main(String[] args) {
        Welcome w = new Welcome();
    }
}
