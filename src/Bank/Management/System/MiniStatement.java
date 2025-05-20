package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String pinnumber;

    MiniStatement (String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        JLabel bank = new JLabel("Indian Overseas Bank");
        bank.setBounds(150, 20, 200, 20);
        add(bank);


        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel bala = new JLabel();
        bala.setBounds(20, 400, 300, 30);
        add(bala);

        try{
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }
        catch (Exception e ){
            System.out.println(e);
        }

        try{
            conn c = new conn();
            int balance =0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br><html>");
            if(rs.getString("Type").equals("Deposit")){
                balance += Integer.parseInt(rs.getString("amount"));
            }
            else{
                balance -= Integer.parseInt(rs.getString("amount"));
            }
            }
            bala.setText("Your current account balance is : " + balance);
        }
        catch(Exception ef){
            System.out.println(ef);
        }
        setSize(400,600);
        setLocation(50,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);


    }
        @Override
        public void actionPerformed (ActionEvent e){

        }


    public static void main(String[] args) {
        new MiniStatement("");
    }
}
