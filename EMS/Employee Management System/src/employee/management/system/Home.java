
package employee.management.system;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Home extends JFrame implements ActionListener{
    JButton addE,view,update,remove;
    Home(){
    setLayout(null);
//    background Image 
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
    Image i2=i1.getImage().getScaledInstance(1120, 630,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,1120,630);
    add(image);
    
    JLabel heading=new JLabel("Employee Management System");
    heading.setBounds(620,20,400,40);
    heading.setFont(new Font("RALWAY",Font.BOLD,25));
    image.add(heading);
    
//    button 1 adding  employee
     addE=new JButton("ADD EMPLOYEE");
    addE.setBounds(650,80,150,40);
    addE.addActionListener(this);
    image.add(addE);
    
//   Button 2  view
     view=new JButton("View EMPLOYEES");
    view.setBounds(820,80,160,40);
    view.addActionListener(this);
    image.add(view);
//   Button 3  update
    update=new JButton("Update EMPLOYEE");
    update.setBounds(650,140,150,40);
    update.addActionListener(this);
    image.add(update);
//   Button 4 remove
     remove=new JButton("Remove EMPLOYEE");
    remove.setBounds(820,140,160,40);
    remove.addActionListener(this);
    image.add(remove);
    
    
    setSize(1120,630);
    setLocation(250,100);
    setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==addE){
              setVisible(false);
              new AddEmployee();
         }else if(ae.getSource()==view){
             setVisible(false);
             new ViewEmployee();
             
         }else if(ae.getSource()==update){
             setVisible(false);
             new ViewEmployee();
             
         }else{
             setVisible(false);
             new RemoveEmployee();
         }

     }
    public static void main(String[] args) {
        new Home();
        
    }
}
