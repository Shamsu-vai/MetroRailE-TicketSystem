import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Register extends JFrame implements ActionListener, MouseListener {
    private JButton submitbutton,backbutton;
    private JLabel rlabel,fnlabel,lnLabel,GLabel,dobLabel,nidLabel,phnLabel,addrLabel,nLabel,pLabel;
    private JTextField fnField,lnField,dobField,nidField,phnField,addrField,nField,pField;
    private String fName,lName,userName,gender,dob,nid,phone,address,nationality,payment;
    private int intNID , intPhn;
    private String [] genders = {"None","Male","Female"};
    private JComboBox genderCmb;

    public Register(){
        rlabel =new JLabel("REGISTER");
        rlabel.setBounds(34,45,259,48);
        rlabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,48));
        this.add(rlabel);

        fnlabel=new JLabel("First Name :");
        fnlabel.setBounds(34,132,120,24);
        fnlabel.setFont( new Font(Font.DIALOG,  Font.BOLD, 20));
        this.add(fnlabel);

        fnField=new JTextField();
        fnField.setBounds(34,167,283,52);
        fnField.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        this.add(fnField);

        lnLabel=new JLabel("Last Name :");
        lnLabel.setBounds(378,132,114,24);
        lnLabel.setFont( new Font(Font.DIALOG,  Font.BOLD, 20));
        this.add(lnLabel);

        lnField=new JTextField();
        lnField.setBounds(378,167,283,52);
        lnField.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        this.add(lnField);

        GLabel=new JLabel("Gender :");
        GLabel.setBounds(707,132,114,24);
        GLabel.setFont( new Font(Font.DIALOG,  Font.BOLD, 20));
        this.add(GLabel);

        genderCmb = new JComboBox(genders);
        genderCmb.setSelectedIndex(0);
        genderCmb.addActionListener(this);
        genderCmb.setBounds(707,167,283,52);
        genderCmb.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        this.add(genderCmb);

        //GField=new JTextField();
        //GField.setBounds(707,167,283,52);
        //GField.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        //this.add(GField);

        dobLabel=new JLabel("DOB :");
        dobLabel.setBounds(34,297,114,24);
        dobLabel.setFont( new Font(Font.DIALOG,  Font.BOLD, 20));
        this.add(dobLabel);

        dobField=new JTextField();
        dobField.addMouseListener(this);
        dobField.setText("yyyy/mm/dd");
        dobField.setBounds(34,337,283,52);
        dobField.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        this.add(dobField);

        nidLabel=new JLabel("NID/BirthCertificate:");
        nidLabel.setBounds(378,297,190,24);
        nidLabel.setFont( new Font(Font.DIALOG,  Font.BOLD, 20));
        this.add(nidLabel);

        nidField=new JTextField();
        nidField.setBounds(378,337,283,52);
        nidField.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        this.add(nidField);

        phnLabel=new JLabel("Phone Number :");
        phnLabel.setBounds(707,297,160,24);
        phnLabel.setFont( new Font(Font.DIALOG,  Font.BOLD, 20));
        this.add(phnLabel);

        phnField=new JTextField();
        phnField.setBounds(707,337,283,52);
        phnField.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        this.add(phnField);

        addrLabel=new JLabel("Address:");
        addrLabel.setBounds(34,473,114,24);
        addrLabel.setFont( new Font(Font.DIALOG,  Font.BOLD, 20));
        this.add(addrLabel);

        addrField=new JTextField();
        addrField.setBounds(34,506,283,52);
        addrField.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        this.add(addrField);

        nLabel=new JLabel("Nationality:");
        nLabel.setBounds(378,473,190,24);
        nLabel.setFont( new Font(Font.DIALOG,  Font.BOLD, 20));
        this.add(nLabel);

        nField=new JTextField();
        nField.setBounds(378,506,283,52);
        nField.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        this.add(nField);

        pLabel=new JLabel("Payment:");
        pLabel.setBounds(707,473,160,24);
        pLabel.setFont( new Font(Font.DIALOG,  Font.BOLD, 20));
        this.add(pLabel);

        pField=new JTextField();
        pField.setBounds(707,506,283,52);
        pField.setFont(new Font(Font.SERIF,Font.PLAIN,24));
        this.add(pField);

        submitbutton = new JButton("Submit");
        submitbutton.addActionListener(this);
        submitbutton.addMouseListener(this);
        submitbutton.setFont(new Font("Arial",Font.BOLD,19));
        submitbutton.setFocusable(false);
        submitbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitbutton.setBounds(274,625,180,50);
        this.add(submitbutton);

        backbutton = new JButton("Back");
        backbutton.addActionListener(this);
        backbutton.addMouseListener(this);
        backbutton.setFont(new Font("Arial",Font.BOLD,19));
        backbutton.setFocusable(false);
        backbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backbutton.setBounds(485,625,180,50);
        this.add(backbutton);

        ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo1.png"));
        this.setIconImage(logo.getImage());
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == submitbutton){
            gender = (String) genderCmb.getSelectedItem();
            System.out.println(gender);
            System.out.println("buttons work");

            if (fnField.getText()!=null && lnField.getText()!=null && ((String)genderCmb.getSelectedItem()!=null) &&
                    dobField.getText()!=null && nidField.getText()!=null && phnField.getText()!=null &&
                    addrField.getText()!=null && !nField.getText().isEmpty() && !pField.getText().isEmpty()){

                submitbutton.setEnabled(false);

                System.out.println("writer pls write");
                fName = fnField.getText();
                lName = lnField.getText();
                userName = "user:"+fName+" "+lName;
                gender = (String) genderCmb.getSelectedItem();
                nid = nidField.getText();
                //intNID = Integer.parseInt(nid);
                phone = pField.getText();
                //intPhn = Integer.parseInt(phone);
                address = addrField.getText();
                nationality = addrField.getText();
                payment = pField.getText();

                try {
                    FileWriter writer= new FileWriter("userlogin.txt",true);
                    writer.append(userName+"\n");
                    writer.append(gender+"\n");
                    writer.append("*************************************"+"\n");
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }




        } else if (source == backbutton) {
            this.setVisible(false);
            Welcome w = new Welcome();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source == dobField) {
            dobField.setText("");
        }
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
        if (source == submitbutton){
            submitbutton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.CYAN,Color.CYAN));
        }else if (source == backbutton){
            backbutton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.CYAN,Color.CYAN));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if (source == submitbutton){
            submitbutton.setBorder(BorderFactory.createEmptyBorder());
        } else if (source == backbutton) {
            backbutton.setBorder(BorderFactory.createEmptyBorder());
        }
    }
}