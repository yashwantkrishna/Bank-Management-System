package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JLabel image , text;
    JTextField amount ;
    JButton withdraw , back ;
    String pinnumber;

    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,20);
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent ea) {

        if(ea.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Plaese enter an amount");
            }
            else{
                try{
                    conn c =new conn();
                    String query = "insert into bank values ('" +pinnumber+"' ,'" +date+"' ,' Withdraw' ,'" +number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Withdraw Successfull");
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }

    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
