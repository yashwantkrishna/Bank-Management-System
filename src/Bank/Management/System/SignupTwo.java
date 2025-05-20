package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.jar.JarFile;

public class SignupTwo extends JFrame implements ActionListener {

    JLabel name,fname,dob,state,pin,pan,aadhar,occu,edu;
    JTextField aadharTextField,panTextField;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,education,occupation;
    ButtonGroup seniorgroup,existgroup;
    JButton next;
    String formno;

    SignupTwo(String formno){
        this.formno = formno;
        setTitle("New Account Application Form - Page 2");

        JLabel additionaldetail=new JLabel("Page 1 : Additional Details");
        additionaldetail.setBounds(280,80,400,40);
        additionaldetail.setFont(new Font("Rale way",Font.BOLD,22));
        add(additionaldetail);

        name=new JLabel("Religion :");
        name.setBounds(100,200,200,30);
        name.setFont(new Font("Rale way",Font.BOLD,22));
        add(name);

        String[] valreligion = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300,200,300,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        fname=new JLabel("Category :");
        fname.setBounds(100,250,200,30);
        fname.setFont(new Font("Rale way",Font.BOLD,22));
        add(fname);

        String valcatogery[] ={"General","OBC","SC","ST"};
        category=new JComboBox<>(valcatogery);
        category.setBounds(300,250,300,30);
        category.setBackground(Color.WHITE);
        add(category);

        dob=new JLabel("Income :");
        dob.setBounds(100,300,200,30);
        dob.setFont(new Font("Rale way",Font.BOLD,22));
        add(dob);

        String valincome[] ={"Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        income=new JComboBox<>(valincome);
        income.setBounds(300,300,300,30);
        income.setBackground(Color.WHITE);
        add(income);

        edu=new JLabel("Education :");
        edu.setBounds(100,350,200,30);
        edu.setFont(new Font("Rale way",Font.BOLD,22));
        add(edu);

        String educationval[] ={"Graduate","Non-Graduate","Post-Graduate","Doctorate","Others"};
        education=new JComboBox<>(educationval);
        education.setBounds(300,350,300,30);
        education.setBackground(Color.WHITE);
        add(education);


        occu=new JLabel("Occupation :");
        occu.setBounds(100,400,200,30);
        occu.setFont(new Font("Rale way",Font.BOLD,22));
        add(occu);

        String occupationval[] ={"Salaried","Self-Employed","Business","Retired","Student","Others"};
        occupation=new JComboBox<>(occupationval);
        occupation.setBounds(300,400,300,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        pan=new JLabel("PAN Number :");
        pan.setBounds(100,450,200,30);
        pan.setFont(new Font("Rale way",Font.BOLD,22));
        add(pan);

        panTextField=new JTextField();
        panTextField.setBounds(300,450,300,30);
        panTextField.setFont(new Font("Rale way",Font.BOLD,14));
        add(panTextField);

        aadhar=new JLabel("Aadhar Number :");
        aadhar.setBounds(100,500,200,30);
        aadhar.setFont(new Font("Rale way",Font.BOLD,22));
        add(aadhar);

        aadharTextField=new JTextField();
        aadharTextField.setBounds(300,500,300,30);
        aadharTextField.setFont(new Font("Rale way",Font.BOLD,14));
        add(aadharTextField);

        state=new JLabel("Senior Citizen :");
        state.setBounds(100,550,200,30);
        state.setFont(new Font("Rale way",Font.BOLD,22));
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,550,100,30);
        syes.setBackground(Color.white);
        add(syes);
        sno=new JRadioButton("No");
        sno.setBounds(420,550,100,30);
        sno.setBackground(Color.white);
        add(sno);
        seniorgroup=new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);


        pin=new JLabel("Existing Account :");
        pin.setBounds(100,600,200,30);
        pin.setFont(new Font("Rale way",Font.BOLD,22));
        add(pin);
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,600,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        eno=new JRadioButton("No");
        eno.setBounds(420,600,100,30);
        eno.setBackground(Color.white);
        add(eno);
        existgroup=new ButtonGroup();
        existgroup.add(eyes);
        existgroup.add(eno);

        next=new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(520,660,80,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String sreligion = (String)religion.getSelectedItem();
        String scatogery=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String senorcetizion=null;
        if (syes.isSelected()){
            senorcetizion="Yes";
        } else if (sno.isSelected()) {
            senorcetizion="No";
        }
        String existingaccount=null;
        if (eyes.isSelected()){
            existingaccount="Yes";
        } else if (eno.isSelected()) {
            existingaccount="No";
        }
        String saadhar=aadharTextField.getText();
        String span=panTextField.getText();

        try{
            conn c = new conn();
            String query = "Insert into signup2 values('"+formno+"','"+sreligion+"','"+scatogery+"','"+sincome+"','"+span+"','"+saadhar+"','"+senorcetizion+"','"+soccupation+"','"+seducation+"','"+existingaccount+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
        catch (Exception z){
            System.out.println(z);
        }


    }
}
