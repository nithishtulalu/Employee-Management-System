
package employee.management.system;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class loginframe extends JFrame implements ActionListener {
    JTextField txtusername,txtpassword;
    loginframe(){
         getContentPane().setBackground(Color.white);//frame  backgroun  color
        setLayout(null);
//        username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
         txtusername=new JTextField();
        txtusername.setBounds(150,20,150,30);
        add(txtusername);
//      password  
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
         txtpassword=new JTextField();
        txtpassword.setBounds(150,70,150,30);
        add(txtpassword);
        
        
//        adding  login  button
        JButton login=new JButton("Login");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
//        adding  image
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
    Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(350,0,200,200);
    add(image);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username=txtusername.getText();
            String password=txtpassword.getText();
            datacon c=new datacon();
            String Query="select * from  admin where username ='"+username+"'and password ='"+password+"'";
            
//        query execution
          ResultSet rs= c.s.executeQuery(Query);
         if(rs.next()){
              setVisible(false);
//              next frame
                new Home();
          }
         else{
             JOptionPane.showMessageDialog(null, "Invalid username or password");
             setVisible(false);
             
             
         }
          
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new loginframe();
        
    }
    
}
