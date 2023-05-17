import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoginFrame extends JFrame implements ActionListener , MouseListener {
    private JLayeredPane backLayer;
    private String name ,email ,password ,gender , phone ,  address , nationality , nid;
    private User user;
    private JButton login,back;
    private JPanel mainLayer;
    private JLabel imageLabel,loginLabel,nlabel,plabel,dateLabel,dayLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private ImageIcon metroBg,logo;
    private String userName ;
    private String pass;
    private JPanel dateLayer;
    private SimpleDateFormat dayFormat,dateFormat;
    public LoginFrame(){

        Font font=new Font(Font.SANS_SERIF,Font.BOLD,36);
        metroBg = new ImageIcon(getClass().getResource("/images/metro rail.png"));
        logo = new ImageIcon(getClass().getResource("/images/logo1.png"));
        this.setTitle("Metro e-ticket");
        this.setIconImage(logo.getImage());

        //Layer for Date
        dateLayer = new JPanel();
        dateLayer.setBounds(0,537,800,28);
        dateLayer.setBackground(new Color(126, 230, 228));
        dateLayer.setForeground(Color.BLUE);

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


        imageLabel=new JLabel();
        imageLabel.setIcon(metroBg);
        imageLabel.setBounds(0,-3,800,900);
        imageLabel.setVerticalAlignment(JLabel.TOP);
        backLayer = new JLayeredPane();
        //backLayer.add(imageLabel);
        backLayer.setBounds(0,0,800,600);
        backLayer.add(dateLayer);

        loginLabel = new JLabel();
        loginLabel.setFont(font);
        //loginLabel.setIcon(logo);
        loginLabel.setText("LOGIN");
        loginLabel.setForeground(Color.white);
        loginLabel.setBounds(115,30,120,50);
        //loginLabel.setOpaque(true);


        nlabel=new JLabel();
        nlabel.setText("User ID:");
        nlabel.setBounds(18,125,75,30);
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

        //Log in Button
        login = new JButton("Log in");
        login.addMouseListener(this);
        login.addActionListener(this);
        login.setFont(new Font("Arial",Font.BOLD,19));
        login.setFocusable(false);
        login.setBounds(60,250,100,40);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Back Button
        back = new JButton("Back");
        back.addMouseListener(this);
        back.addActionListener(this);
        back.setFont(new Font("Arial",Font.BOLD,19));
        back.setFocusable(false);
        back.setBounds(180,250,100,40);
        back.setBorder(BorderFactory.createEmptyBorder());
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

        //this.add(mainLayer);
        backLayer.add(mainLayer);
        backLayer.add(imageLabel);


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

            if(source== login) {
                if (!nameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
                    try {
                        userName = nameField.getText().toLowerCase();
                        pass = passwordField.getText();

                        String line = null;
                        int lineNum = 0;
                        BufferedReader reader = new BufferedReader(new FileReader("userlogin.txt"));

                        while ((line = reader.readLine()) != null) {
                            lineNum++;
                        }
                        reader.close();
                        for (int i = 0; i < lineNum; i++) {
                            line = Files.readAllLines(Paths.get("userlogin.txt")).get(i);
                            if (line.equals(userName)) {
                                String line2 = Files.readAllLines(Paths.get("userlogin.txt")).get((i + 1));
                                if (line2.equals(pass)) {
                                    JOptionPane.showMessageDialog(null, "Welcome " + nameField.getText() + " hope" +
                                            " you have a wonderful journey");
                                    name=line;
                                    password=line2;
                                    email=Files.readAllLines(Paths.get("userlogin.txt")).get((i + 2));
                                    gender=Files.readAllLines(Paths.get("userlogin.txt")).get((i + 3));
                                    phone=Files.readAllLines(Paths.get("userlogin.txt")).get((i + 4));
                                    address=Files.readAllLines(Paths.get("userlogin.txt")).get((i + 5));
                                    nationality=Files.readAllLines(Paths.get("userlogin.txt")).get((i + 6));
                                    nid=Files.readAllLines(Paths.get("userlogin.txt")).get((i + 7));
                                    user = new User(name,password,email,gender,phone,address,nationality,nid);
                                    setVisible(false);
                                    new Dashboard(user);
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Incorrect Password");
                                }
                            }
                        }
                    } catch(FileNotFoundException ex){
                        ex.printStackTrace();
                    } catch(IOException ex){
                        ex.printStackTrace();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Please fill up the form");
                }

            }
            else if (source==back) {

                this.setVisible(false);
                Welcome w = new Welcome();
            }



    }

    public static void main(String[] args) {
        LoginFrame lf = new LoginFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source == login){
            login.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.CYAN,Color.CYAN,null,null));
        }else if (source == back){
            back.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.CYAN,Color.CYAN,null,null));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if (source == login){
            login.setBorder(BorderFactory.createEmptyBorder());
        } else if (source == back) {
            back.setBorder(BorderFactory.createEmptyBorder());
        }
    }

    public void fetchUserData(){
        for (int i = 0; i < 8; i++) {

        }
    }
}
