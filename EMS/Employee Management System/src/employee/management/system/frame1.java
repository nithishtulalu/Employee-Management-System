
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class frame1 extends JFrame implements ActionListener{
    frame1(){
        getContentPane().setBackground(Color.white);//frame  backgroun  color
        setLayout(null);
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(150,30,1200,80);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.red);
        add(heading);
        
        
//        background  image 

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
    Image i2=i1.getImage().getScaledInstance(1100, 700,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(50,100,1050,500);
    add(image);
    
//    adding  button
    JButton Click=new JButton("CLICK HEAR TO  CONTITNUE");
    Click.setBounds(400, 400, 300, 70);
    Click.setBackground(Color.gray);
    Click.setForeground(Color.white);
    Click.addActionListener(this);
    image.add(Click);
        
//        all  frame  seetings
        setSize(1170,650);
        setLocation(200,50);
        setVisible(true);
        
//        for the  heading  depper operation
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){   
            }
             heading.setVisible(true);
             try{
                Thread.sleep(500);
            }
            catch(Exception e){   
            }
        }
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new loginframe();
        
    }
    public static void main(String args[]){
        new frame1();
    }
    
}
