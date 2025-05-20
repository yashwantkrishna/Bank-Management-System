package Bank.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JLabel formno,personaldetail,name,fname,dob,gender,email,marital,address,city,state,pin;
    JTextField nametextfield,fnametextfield,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JDateChooser datechooser;
    JRadioButton male,female,married,unmarried;
    ButtonGroup maritalgroup,gendergroup;
    JButton next;

    SignupOne(){
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L) + 1000L);

        formno = new JLabel("APPLICATION FORM NO. :" + random);
        formno.setBounds(140,20,600,40);
        formno.setFont(new Font("Rale way",Font.BOLD,38));
        add(formno);

        personaldetail = new JLabel("Page 1 : Personal Details ");
        personaldetail.setBounds(280, 80, 400, 40);
        personaldetail.setFont(new Font("Rale way", Font.BOLD, 22));
        add(personaldetail);

        name = new JLabel("Name :");
        name.setBounds(100, 150, 100, 30);
        name.setFont(new Font("Rale way", Font.BOLD, 22));
        add(name);

        nametextfield = new JTextField();
        nametextfield.setBounds(300,150,300,30);
        nametextfield.setFont(new Font("Rale way",Font.BOLD,14));
        add(nametextfield);

        fname = new JLabel("Father's Name :");
        fname.setBounds(100, 200, 200, 30);
        fname.setFont(new Font("Rale way", Font.BOLD, 22));
        add(fname);

        fnametextfield = new JTextField();
        fnametextfield.setBounds(300,200,300,30);
        fnametextfield.setFont(new Font("Rale way",Font.BOLD,14));
        add(fnametextfield);

        dob = new JLabel("Date of Birth :");
        dob.setBounds(100, 250, 200, 30);
        dob.setFont(new Font("Rale way", Font.BOLD, 22));
        add(dob);

        datechooser = new JDateChooser();
        datechooser.setBounds(300,250,300,30);
        add(datechooser);

        gender = new JLabel("Gender :");
        gender.setBounds(100, 300, 100, 30);
        gender.setFont(new Font("Rale way", Font.BOLD, 22));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,300,80,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(420,300,80,30);
        female.setBackground(Color.white);
        add(female);

        gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        email=new JLabel("Email Address :");
        email.setBounds(100,350,200,30);
        email.setFont(new Font("Rale way",Font.BOLD,22));
        add(email);

        emailTextField=new JTextField();
        emailTextField.setBounds(300,350,300,30);
        emailTextField.setFont(new Font("Rale way",Font.BOLD,14));
        add(emailTextField);

        marital=new JLabel("Marital Status :");
        marital.setBounds(100,400,200,30);
        marital.setFont(new Font("Rale way",Font.BOLD,22));
        add(marital);
        married=new JRadioButton("Married");
        married.setBounds(300,400,100,30);
        married.setBackground(Color.white);
        add(married);
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(420,400,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);


        address=new JLabel("Address :");
        address.setBounds(100,450,200,30);
        address.setFont(new Font("Rale way",Font.BOLD,22));
        add(address);

        addressTextField=new JTextField();
        addressTextField.setBounds(300,450,300,30);
        addressTextField.setFont(new Font("Rale way",Font.BOLD,14));
        add(addressTextField);

        city=new JLabel("City :");
        city.setBounds(100,500,100,30);
        city.setFont(new Font("Rale way",Font.BOLD,22));
        add(city);
        cityTextField=new JTextField();
        cityTextField.setBounds(300,500,300,30);
        cityTextField.setFont(new Font("Rale way",Font.BOLD,14));
        add(cityTextField);

        state=new JLabel("State :");
        state.setBounds(100,550,100,30);
        state.setFont(new Font("Rale way",Font.BOLD,22));
        add(state);
        stateTextField=new JTextField();
        stateTextField.setBounds(300,550,300,30);
        stateTextField.setFont(new Font("Rale way",Font.BOLD,14));
        add(stateTextField);

        pin=new JLabel("Pin Code :");
        pin.setBounds(100,600,200,30);
        pin.setFont(new Font("Rale way",Font.BOLD,22));
        add(pin);
        pinTextField=new JTextField();
        pinTextField.setBounds(300,600,300,30);
        pinTextField.setFont(new Font("Rale way",Font.BOLD,14));
        add(pinTextField);

        next=new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(520,660,80,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = ""+random;
        String name = nametextfield.getText();
        String fname = fnametextfield.getText();
        String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()) {
            gender="Female";
        }
        String email=emailTextField.getText();
        String marital=null;
        if (married.isSelected()){
            marital="Married";
        } else if (unmarried.isSelected()) {
            marital="Unmarried";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name cannot be empty");
            }
            else {
                conn c = new conn();
                String query = "Insert into signup1 values('"+formno+"' , '"+name+"' , '"+fname+"' ,'"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);

            }
        }
        catch(Exception f){
            System.out.println(f);
        }

    }
    public static void main(String[] args){
        new SignupOne();
    }
}
