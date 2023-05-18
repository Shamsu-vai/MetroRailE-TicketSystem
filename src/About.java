import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class About extends JFrame implements ActionListener , MouseListener {
    private JLayeredPane mainLayer;
    private JLabel imageLabel, logoLabel,
            welcomeLabel,metroLabel;
    private JButton back;
    private JPanel panel;

    public About (){

//images are objects to change
//these are placeholder images.
        ImageIcon aboutBG = new ImageIcon(getClass().getResource("/images/ab_3.png"));
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo1.png"));

//main layered pane as container
        mainLayer = new JLayeredPane();
        mainLayer.setSize(1024,768);

//Background image label
        imageLabel = new JLabel();
        imageLabel.setIcon(aboutBG);
        imageLabel.setBounds(0,0,1024,768);

//top logo image label
//logoLabel = new JLabel();
//logoLabel.setBounds(580,110,500,500);
//logoLabel.setIcon(logo);

        this.setIconImage(logo.getImage());

//Welcome text label
        welcomeLabel = new JLabel();
        welcomeLabel.setText("About This Project");
        welcomeLabel.setBounds(352,20,277,80);
        welcomeLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        welcomeLabel.setForeground(Color.WHITE);
//welcomeLabel.setOpaque(true);

//Metro text label
        metroLabel = new JLabel();
        metroLabel.setText("METRO RAIL E-TICKETING SYSTEM");
        metroLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,48));
        metroLabel.setForeground(Color.WHITE);
        metroLabel.setBounds(60,80,900,80);
//metroLabel.setOpaque(true);


// back button
        back = new JButton();
        back.addMouseListener(this);
        back.addActionListener(this);
        back.setActionCommand("back");
        back.setText("Back");
        back.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        back.setBounds(875,675,80,36);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createEmptyBorder());

/*
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
// dayLabel.setHorizontalAlignment(JLabel.LEFT);//why those
dayLabel.setVerticalTextPosition(JLabel.TOP);//aren't working
dateLayer.add(dayLabel);

dateFormat = new SimpleDateFormat("dd, MM, yyyy");
dateLabel =new JLabel();
dateLabel.setFont(new Font("Ink Free",Font.BOLD,22));
String date= dateFormat.format(Calendar.getInstance().getTime());
dateLabel.setText(date);
dateLayer.add(dateLabel);
*/
//Adding to the main layered pane
        mainLayer.add(back);
//mainLayer.add(about);
//mainLayer.add(register);
        mainLayer.add(metroLabel);
        mainLayer.add(welcomeLabel);
        mainLayer.add(imageLabel);
        this.add(mainLayer);

// Welcome frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("About");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();//getSource mane ki ??
        if (command == "back") {
            this.setVisible(false);
            Welcome w = new Welcome();
        }
    }

    public static void main(String[] args) {

        About about = new About();

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
        if (source == back){
            back.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        }
        if (source == back){
            back.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.CYAN,Color.CYAN,null,null));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if (source == back) {
            back.setBorder(BorderFactory.createEmptyBorder());
        }
    }
}