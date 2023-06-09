import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Map extends JFrame implements ActionListener {

    User user;
    private ImageIcon map,buttonIcon1,buttonIcon2;
    private JTextArea from,to;
    private JLabel imageLabel,dayLabel,dateLabel;
    private JPanel dateLayer;
    private SimpleDateFormat dayFormat,dateFormat;
    private String destination,initLocation;
    private boolean destfixed , isConfirmed;
    int distanceFactor,fromnum,tonum;

    private JButton one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,Fix,confirm;
    public Map(User user){

        this.user = user;

        this.setTitle("Buy Ticket");
        this.setSize(980,618);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo1.png"));
        this.setIconImage(logo.getImage());

        map = new ImageIcon(getClass().getResource("/images/map.png"));
        imageLabel = new JLabel();
        imageLabel.setIcon(map);
        imageLabel.setBounds(0,0,980,550);
        this.add(imageLabel);

        buttonIcon1 = new ImageIcon(getClass().getResource("/images/red_button2.jpg"));
        buttonIcon2 = new ImageIcon(getClass().getResource("/images/red_button3.jpg"));

        from = new JTextArea();
        from.setBounds(80,320,130,30);
        from.setText("From");
        from.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        from.setEditable(false);
        //from.addActionListener(this);
        this.add(from);

        to = new JTextArea();
        to.setBounds(260,320,130,30);
        to.setText("to");
        to.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        this.add(to);

        one = new JButton();
        one.setActionCommand("1");
        one.setIcon(buttonIcon1);
        one.setBounds(76,457,20,20);
        one.addActionListener(this);
        this.add(one);

        two = new JButton();
        two.setActionCommand("2");
        two.setIcon(buttonIcon1);
        two.setBounds(138,478,20,20);
        two.addActionListener(this);
        this.add(two);

        three = new JButton();
        three.setActionCommand("3");
        three.setIcon(buttonIcon1);
        three.setBounds(201,485,20,20);
        three.addActionListener(this);
        this.add(three);

        four = new JButton();
        four.setActionCommand("4");
        four.setIcon(buttonIcon1);
        four.setBounds(298,490,20,20);
        four.addActionListener(this);
        this.add(four);

        five = new JButton();
        five.setActionCommand("5");
        five.setIcon(buttonIcon1);
        five.setBounds(364,483,20,20);
        five.addActionListener(this);
        this.add(five);

        six = new JButton();
        one.setActionCommand("6");
        six.setIcon(buttonIcon1);
        six.setBounds(420,470,20,20);
        six.addActionListener(this);
        this.add(six);

        seven = new JButton();
        one.setActionCommand("7");
        seven.setIcon(buttonIcon1);
        seven.setBounds(482,447,20,20);
        seven.addActionListener(this);
        this.add(seven);

        eight= new JButton();
        one.setActionCommand("8");
        eight.setIcon(buttonIcon1);
        eight.setBounds(542,422,20,20);
        eight.addActionListener(this);
        this.add(eight);

        nine = new JButton();
        one.setActionCommand("9");
        nine.setIcon(buttonIcon1);
        nine.setBounds(602,405,20,20);
        nine.addActionListener(this);
        this.add(nine);

        ten = new JButton();
        one.setActionCommand("10");
        ten.setIcon(buttonIcon2);
        ten.setBounds(650,394,20,20);
        ten.addActionListener(this);
        this.add(ten);

        eleven = new JButton();
        one.setActionCommand("11");
        eleven.setIcon(buttonIcon2);
        eleven.setBounds(719,352,20,20);
        eleven.addActionListener(this);
        this.add(eleven);

        twelve = new JButton();
        one.setActionCommand("12");
        twelve.setIcon(buttonIcon2);
        twelve.setBounds(778,325,20,20);
        twelve.addActionListener(this);
        this.add(twelve);

        thirteen = new JButton();
        one.setActionCommand("13");
        thirteen.setIcon(buttonIcon2);
        thirteen.setBounds(838,320,20,20);
        thirteen.addActionListener(this);
        this.add(thirteen);

        fourteen = new JButton();
        one.setActionCommand("14");
        fourteen.setIcon(buttonIcon2);
        fourteen.setBounds(875,320,20,20);
        fourteen.addActionListener(this);
        this.add(fourteen);

        fifteen = new JButton();
        one.setActionCommand("15");
        fifteen.setIcon(buttonIcon2);
        fifteen.setBounds(895,250,20,20);
        fifteen.addActionListener(this);
        this.add(fifteen);

        sixteen = new JButton();
        one.setActionCommand("16");
        sixteen.setIcon(buttonIcon2);
        sixteen.setBounds(908,180,20,20);
        sixteen.addActionListener(this);
        this.add(sixteen);

        Fix = new JButton("Fix");
        Fix.setFont(new Font("Arial",Font.BOLD,19));
        Fix.setBounds(778,430,100,40);
        Fix.setFocusable(false);
        Fix.addActionListener(this);
        Fix.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(Fix);

        confirm = new JButton("confirm");
        confirm.setFont(new Font("Arial",Font.BOLD,19));
        confirm.setBounds(778,430,150,40);
        confirm.setFocusable(false);
        confirm.setEnabled(false);
        confirm.setVisible(false);
        confirm.addActionListener(this);
        confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(confirm);

        dateLayer = new JPanel();
        dateLayer.setBounds(0,552,980,28);
        dateLayer.setBackground(new Color(126, 230, 228));
        this.add(dateLayer);

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

        this.setVisible(true);
    }

    public static void main(String[] args) {
        //Map m= new Map();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        int clickCount=0;
        if (destfixed==false && isConfirmed==false) {
            if (source == one) {
                from.setText("Uttara North");
                fromnum = 1;
                clickCount++;
            } else if (source == two) {
                from.setText("Uttara Center");
                fromnum = 2;
                clickCount++;
            } else if (source == three) {
                from.setText("Uttara South");
                fromnum =3;
                clickCount++;
            } else if (source == four) {
                from.setText("Pallabi");
                fromnum = 4;
                clickCount++;
            } else if (source == five) {
                from.setText("Mirpur 11");
                fromnum = 5;
                clickCount++;
            } else if (source == six) {
                from.setText("Mirpur 10");
                fromnum = 6;
                clickCount++;
            } else if (source == seven) {
                from.setText("Kazi Para");
                fromnum = 7;
                clickCount++;
            } else if (source == eight) {
                from.setText("Shewrapara");
                fromnum = 8;
                clickCount++;
            } else if (source == nine) {
                from.setText("Agargaon");
                fromnum = 9;
                clickCount++;
            } else if (source == ten) {
                from.setText("Bijoy Sarani");
                fromnum = 10;
                clickCount++;
            } else if (source == eleven) {
                from.setText("Farmgate");
                fromnum = 11;
                clickCount++;
            } else if (source == twelve) {
                from.setText("Kawran Bazar");
                fromnum = 12;
                clickCount++;
            } else if (source == thirteen) {
                from.setText("Shahbagh");
                fromnum = 13;
                clickCount++;
            } else if (source == fourteen) {
                from.setText("Dhaka University");
                fromnum = 14;
                clickCount++;
            } else if (source == fifteen) {
                from.setText("BD Secretariat");
                fromnum = 15;
                clickCount++;
            } else if (source == sixteen) {
                from.setText("Motijheel");
                fromnum = 16;
                clickCount++;
            }
        }

        if (source==Fix || destfixed==true && isConfirmed==false){
            destfixed = true;
            Fix.setEnabled(false);
            Fix.setVisible(false);
            confirm.setVisible(true);
            confirm.setEnabled(true);
            initLocation = from.getText();

            if (source == one) {
                to.setText("Uttara North");
                tonum = 1;
                clickCount++;
            } else if (source == two) {
                to.setText("Uttara Center");
                tonum = 2;
                clickCount++;
            } else if (source == three) {
                to.setText("Uttara South");
                tonum = 3;
                clickCount++;
            } else if (source == four) {
                to.setText("Pallabi");
                tonum = 4;
                clickCount++;
            } else if (source == five) {
                to.setText("Mirpur 11");
                tonum = 5;
                clickCount++;
            } else if (source == six) {
                to.setText("Mirpur 10");
                tonum = 6;
                clickCount++;
            } else if (source == seven) {
                to.setText("Kazi Para");
                tonum = 7;
                clickCount++;
            } else if (source == eight) {
                to.setText("Shewrapara");
                tonum = 8;
                clickCount++;
            } else if (source == nine) {
                to.setText("Agargaon");
                tonum = 9;
                clickCount++;
            } else if (source == ten) {
                to.setText("Bijoy Sarani");
                tonum = 10;
                clickCount++;
            } else if (source == eleven) {
                to.setText("Farmgate");
                tonum = 11;
                clickCount++;
            } else if (source == twelve) {
                to.setText("Kawran Bazar");
                tonum = 12;
                clickCount++;
            } else if (source == thirteen) {
                to.setText("Shahbagh");
                tonum = 13;
                clickCount++;
            } else if (source == fourteen) {
                to.setText("Dhaka University");
                tonum = 14;
                clickCount++;
            } else if (source == fifteen) {
                to.setText("BD Secretariat");
                tonum = 15;
                clickCount++;
            } else if (source == sixteen) {
                to.setText("Motijheel");
                tonum = 16;
                clickCount++;
            }
        }
        if (source==confirm){

            isConfirmed = true;
            destination = to.getText();
            initLocation = from.getText();
            distanceFactor=Math.abs(fromnum-tonum);
            System.out.println(distanceFactor);
            setVisible(false);
            new TicketingPortal(initLocation,destination,distanceFactor,user);
        }

    }
}
