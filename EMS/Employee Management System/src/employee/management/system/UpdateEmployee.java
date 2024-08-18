
package employee.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmployee extends JFrame implements ActionListener {
    JButton add,back;
    JTextField tname,tfeducditon,faname,tsalary,taddress,tphone,temail,tdige,tAddhar;
    
    String empid;
    JLabel ID;
    
    UpdateEmployee(String empid){
        this.empid=empid;
            
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
//        adding lable
        JLabel heading =new JLabel("ADD EMPLOYEE DETAIL");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN SERIF",Font.BOLD,25));
        add(heading);
        
//       emp name
        JLabel ename=new JLabel("Name");
        ename.setBounds(50,150,150,30);
        ename.setFont(new Font("serif",Font.PLAIN,20));
        add(ename);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(180,150,150,30);
        add(lblname);
//        Fname
        JLabel fname=new JLabel("Father Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("serif",Font.PLAIN,20));
        add(fname);
        
         faname=new JTextField();
        faname.setBounds(600,150,150,30);
        add(faname);
// date of  barth
        JLabel DOB=new JLabel("Date of Birth");
        DOB.setBounds(50,200,150,30);
        DOB.setFont(new Font("serif",Font.PLAIN,20));
        add(DOB);
//        for  calender 
        JLabel dcdob=new JLabel();
        dcdob.setBounds(180,200,150,30);
        add(dcdob);
        
// salary  
        JLabel salary=new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("serif",Font.PLAIN,20));
        add(salary);
        
        tsalary=new JTextField();
        tsalary.setBounds(600,200,150,30);
        add(tsalary);
        
//        address
        JLabel address=new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("serif",Font.PLAIN,20));
        add(address);
         taddress=new JTextField();
        taddress.setBounds(180,250,150,30);
        add(taddress);
//     phone
        JLabel phone=new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("serif",Font.PLAIN,20));
        add(phone);
         tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);
//       email 
        JLabel email=new JLabel("Email_id");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("serif",Font.PLAIN,20));
        add(email);
        temail=new JTextField();
        temail.setBounds(180,300,150,30);
        add(temail);
        
//        dropdown
        JLabel eduction=new JLabel("Higest Eduction");
        eduction.setBounds(400,300,150,30);
        eduction.setFont(new Font("serif",Font.PLAIN,20));
        add(eduction);
        
        tfeducditon=new JTextField();
        tfeducditon.setBounds(600 ,300, 150,30);
        add(tfeducditon);
        
//        desigation
        JLabel dige=new JLabel("Designation");
        dige.setBounds(50,350,150,30);
       dige.setFont(new Font("serif",Font.PLAIN,20));
        add(dige);
        tdige=new JTextField();
        tdige.setBounds(180,350,150,30);
        add(tdige);
        
//        addhar no
        JLabel Addhar=new JLabel("Aadhar Number");
        Addhar.setBounds(400,350,150,30);
        Addhar.setFont(new Font("serif",Font.PLAIN,20));
        add(Addhar);
        JLabel lblaadhar =new  JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
//        emp id auto genrate
        JLabel EMPID=new JLabel("EMPLOYEE ID");
        EMPID.setBounds(50,400,150,30);
        EMPID.setFont(new Font("serif",Font.PLAIN,20));
        add(EMPID);
        
        ID=new JLabel();
        ID.setBounds(200,400,150,30);
        ID.setFont(new Font("serif",Font.PLAIN,20));
        add(ID);
        try{
           datacon c=new datacon();
           String query="select * from employee where empid= '"+empid+"'";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next()){
               lblname.setText(rs.getString("name"));
               faname.setText(rs.getString("fname"));
               dcdob.setText(rs.getString("dob"));
               tsalary.setText(rs.getString("salary"));
               taddress.setText(rs.getString("address"));
               tphone.setText(rs.getString("phone"));
               temail.setText(rs.getString("email"));
               tfeducditon.setText(rs.getString("eduction"));
               tdige.setText(rs.getString("designation"));
               lblaadhar.setText(rs.getString("aadhr"));
               ID.setText(rs.getString("empid"));
               
               
               
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
//add button
     add=new JButton("Update Details");
    add.setBounds(250,550,150,40);
    add.addActionListener(this);
    add.setBackground(Color.black);
    add.setForeground(Color.white);
    add(add);
    
//   Button 2  view
      back=new JButton("Back");
    back.setBounds(450,550,150,40);
    back.addActionListener(this);
    back.setBackground(Color.black);
    back.setForeground(Color.white);
    add(back);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            
            String fname=faname.getText();
            String salary=tsalary.getText();
            String addrsss=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=tfeducditon.getText();
            String designation=tdige.getText();
            
            
            
            try{
                datacon conn=new datacon();
                String query="update employee set fname='"+fname+"',salary='"+salary+"',address='"+addrsss+"',phone='"+phone+"',email='"+email+"',eduction='"+education+"',designation='"+designation+"'where empid='"+empid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Details updated  Successfilly");
                 setVisible(false);
                 new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
