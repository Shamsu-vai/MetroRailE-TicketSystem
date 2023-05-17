import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {


    User user;
    JPanel panel;
    JLabel profileLabel;
    JButton buyTicket;
    JMenuBar menuBar;
    JMenu fileMenu,aboutMenu;
    JMenuItem exit,about,version;
    public Dashboard(User user){

        this.user = user;

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        aboutMenu = new JMenu("About");

        exit = new JMenuItem("Exit");
        about = new JMenuItem("About");
        version = new JMenuItem("Version");

        fileMenu.add(exit);
        aboutMenu.add(about);
        aboutMenu.add(version);

        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);

        profileLabel = new JLabel();
        profileLabel.setBounds(0,53,800,150);
        profileLabel.setText("Welcome ,"+user.getName());
        profileLabel.setOpaque(true);

        buyTicket = new JButton();
        buyTicket.setBounds(75,225,150,75);
        buyTicket.setOpaque(true);
        buyTicket.setText("BUY TICKET");
        buyTicket.setFocusable(false);
        buyTicket.addActionListener(this);


        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,800,600);

        panel.add(profileLabel);
        panel.add(buyTicket);

        add(panel);
        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setLayout(null);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        //new Dashboard(user);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buyTicket){
            buyTicket.setEnabled(false);
            setVisible(false);
            new Map(user);
        }
    }
}
