import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Map;
import java.text.SimpleDateFormat;

public class Welcome extends JFrame implements ActionListener , MouseListener {
    private JLayeredPane mainLayer;
    private JPanel dateLayer;
    private JLabel imageLabel, logoLabel,
            welcomeLabel,metroLabel,dateLabel,dayLabel;
    private SimpleDateFormat dayFormat,dateFormat;
    private JButton log,register,about;
    private JPanel panel;

    public Welcome(){

        //images are objects to change
        //these are placeholder images.
        ImageIcon welcomeBG = new ImageIcon(getClass().getResource("/images/welcomeBG.jpg"));
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo1.png"));

        //main layered pane as container
        mainLayer = new JLayeredPane();
        mainLayer.setSize(980,720);

        //Layer for Date
        dateLayer = new JPanel();
        dateLayer.setBounds(0,655,980,28);
        dateLayer.setBackground(new Color(126, 230, 228));
        mainLayer.add(dateLayer);

        //Background image label
        imageLabel = new JLabel();
        imageLabel.setIcon(welcomeBG);
        imageLabel.setBounds(0,0,980,720);

          //top logo image label
          //logoLabel = new JLabel();
          //logoLabel.setBounds(580,110,500,500);
          //logoLabel.setIcon(logo);

        this.setIconImage(logo.getImage());

        //Welcome text label
        welcomeLabel = new JLabel();
        welcomeLabel.setText("WELCOME");
        welcomeLabel.setBounds(352,220,277,80);
        welcomeLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,50));
        //welcomeLabel.setOpaque(true);

        //Metro text label
        metroLabel = new JLabel();
        metroLabel.setText("METRO RAIL E-TICKETING");
        metroLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,48));
        metroLabel.setBounds(178,360,625,80);
        //metroLabel.setOpaque(true);


        // Log in button
        log = new JButton();
        log.addMouseListener(this);
        log.addActionListener(this);
        log.setActionCommand("login");
        log.setText("LOG IN");
        log.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        log.setBounds(238,518,136,36);
        log.setFocusable(false);
        log.setBorder(BorderFactory.createEmptyBorder());

        // Register button
        register = new JButton();
        register.addMouseListener(this);
        register.addActionListener(this);
        register.setActionCommand("register");
        register.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        register.setText("REGISTER");
        register.setBorder(BorderFactory.createEmptyBorder());
        register.setBounds(422,518,136,36);
        register.setFocusable(false);

        // About button
        about = new JButton();
        about.addMouseListener(this);
        about.addActionListener(this);
        about.setActionCommand("about");
        about.setText("ABOUT");
        about.setFocusable(false);
        about.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        about.setBounds(606,518,136,36);
        about.setFocusable(false);
        about.setBorder(BorderFactory.createEmptyBorder());

        //For date
        dayFormat = new SimpleDateFormat("EEEE");
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free",Font.BOLD,22));
        String day = dayFormat.format(Calendar.getInstance().getTime());
        dayLabel.setText(day);
//        dayLabel.setHorizontalAlignment(JLabel.LEFT);//why those
        dayLabel.setVerticalTextPosition(JLabel.TOP);//aren't working
        dateLayer.add(dayLabel);

        dateFormat = new SimpleDateFormat("dd, MM, yyyy");
        dateLabel =new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.BOLD,22));
        String date= dateFormat.format(Calendar.getInstance().getTime());
        dateLabel.setText(date);
        dateLayer.add(dateLabel);

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
        this.setTitle("WELCOME");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(980,720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();//getSource mane ki ??
        switch (command){
            case "login":
                this.setVisible(false);
                LoginFrame logFrame = new LoginFrame();
            break;
            case"register":
                this.setVisible(false);
                Register register = new Register();
                break;
            case "about":break;
            default:
        }
    }

    public static void main(String[] args) {

            Welcome w = new Welcome();

    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source == log){
            log.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        } else if (source == register) {
            register.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        } else if (source == about) {
            about.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if (source == log){
            log.setBorder(BorderFactory.createEmptyBorder());
        }else if (source == register) {
            register.setBorder(BorderFactory.createEmptyBorder());
        } else if (source == about) {
            about.setBorder(BorderFactory.createEmptyBorder());
        }
    }
}
