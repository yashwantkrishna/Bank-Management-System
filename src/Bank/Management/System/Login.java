package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login , clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        setTitle("Bank Management System");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);
        label.setBounds(70,30,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.PLAIN,40));
        text.setBounds(200,40,800,50);
        add(text);

        JLabel cardno = new JLabel("Card No. :");
        cardno.setFont(new Font("Osward",Font.BOLD,30));
        cardno.setBounds(120,150,150,25);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(cardTextField);

        JLabel pin= new JLabel("PIN :");
        pin.setFont(new Font("Osward",Font.BOLD,30));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        login = new JButton("Sign in");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(new Color(150,150,25));
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        else if(e.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else if(e.getSource() == login){
         conn c = new conn();
         String cardnumber = cardTextField.getText();
         String pinnumber = pinTextField.getText();
         String query="select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
         try{
             ResultSet rs = c.s.executeQuery(query);
             if(rs.next()){
                 setVisible(false);
                 new transactions(pinnumber).setVisible(true);
             }
             else{
                 JOptionPane.showMessageDialog(null,"Incorrect CardNumber or Pin");
             }
         }
         catch(Exception ef){
             System.out.println(ef);
         }


        }
    }
}


