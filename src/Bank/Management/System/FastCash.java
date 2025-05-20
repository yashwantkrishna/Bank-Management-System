package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.*;

public class FastCash  extends JFrame implements ActionListener {

    JLabel image,text;
    JButton deposit,withdrawal,fastcash,ministatement,pinchange,balance,exit;
    String pinnumber;
    FastCash (String pinnumber){

        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text=new JLabel("Select Withdrawal Amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal=new JButton("Rs 500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance=new JButton("Rs 10000");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);

        exit=new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource() == exit){
               setVisible(false);
               new transactions(pinnumber).setVisible(true);
           }
           else{
               String amount = ((JButton)e.getSource()).getText().substring(3);
               conn c = new conn();
               try{
                   ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                   int balance =0;
                   while(rs.next()){
                       if(rs.getString("Type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("Amount"));
                       }
                       else {
                           balance -= Integer.parseInt(rs.getString("Amount"));
                       }
                   }
                   if(e.getSource() != exit && balance < Integer.parseInt(amount)){
                       JOptionPane.showMessageDialog(null,"Insufficient Balance");
                       return;
                   }
                   Date date = new Date();
                   String query = " insert into bank values ('"+pinnumber+"' , '"+date+"' ,'Withdraw' ,'"+amount+"')";
                   c.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,"Rs "+amount+ "Debited Successfully");
                   setVisible(false);
                   new transactions(pinnumber).setVisible(true);

               }
               catch(Exception fe){
                   System.out.println(fe);
               }
           }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
