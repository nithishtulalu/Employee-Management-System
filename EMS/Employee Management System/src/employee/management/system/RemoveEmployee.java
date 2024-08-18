
package employee.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    Choice cempid;
    JButton delete,back;
    RemoveEmployee(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblempid=new JLabel("Employee Id");
        lblempid.setBounds(50,50,100,30);
        add(lblempid);
        cempid=new Choice();
        cempid.setBounds(200,50,150,30);
        add(cempid);
        try{
            datacon c=new datacon();
            String query="select * from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname=new JLabel("Nmae");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        JLabel lblname=new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
         JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        JLabel lblphone=new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        JLabel lblemail=new JLabel();
        lblemail.setBounds(200,200,100,30);
        add(lblemail);
         try{
            datacon c=new datacon();
            String query="select * from employee where empid= '"+cempid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         
         cempid.addItemListener(new ItemListener(){
             public void itemStateChanged(ItemEvent ie){
                try{
                        datacon c=new datacon();
                        String query="select * from employee where empid= '"+cempid.getSelectedItem()+"'";
                        ResultSet rs=c.s.executeQuery(query);
                        while(rs.next()){
                            lblname.setText(rs.getString("name"));
                            lblphone.setText(rs.getString("phone"));
                            lblemail.setText(rs.getString("email"));
                }
                }catch(Exception e){
                         e.printStackTrace();
                  } 
                 
             }
         });
         
//         delete buutton
         delete=new JButton("DELETE");
         delete.setBounds(80,300,100,30);
         delete.setBackground(Color.black);
         delete.setForeground(Color.white);
         delete.addActionListener(this);
         add(delete);
//        back button
         back=new JButton("BACK");
         back.setBounds(220,300,100,30);
         back.setBackground(Color.black);
         back.setForeground(Color.white);
         back.addActionListener(this);
         add(back);
//         for image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,600,400);
        add(image);
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==delete){
             try{
                 datacon c=new datacon();
                 String query="delete from employee where empid= '"+cempid.getSelectedItem()+"'";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Employee information deleted  sucessfully");
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
        new RemoveEmployee();
    }
    
}
