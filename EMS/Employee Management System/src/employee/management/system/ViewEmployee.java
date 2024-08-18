
package employee.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener{
    JTable table;
    Choice cempid;
    JButton searchb,print,Update,back;
    ViewEmployee(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
//        adding  search  option
        JLabel search=new JLabel("Search By emp id");
        search.setBounds(20, 20, 150, 20);
        add(search);
        
        cempid=new Choice();
        cempid.setBounds(180,20,150,20);
        add(cempid);
        
         try{
            datacon c=new datacon();
            ResultSet rs=c.s.executeQuery("select * from employee");
            
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
            
           
        }catch(Exception e){
            e.printStackTrace();
        }
        
//        table
        table =new JTable();
        try{
            datacon c=new datacon();
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
           
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp =new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
//        search button
        searchb =new JButton("SEARCH");
        searchb.setBounds(20,70,100,20);
        searchb.addActionListener(this);
        add(searchb);
//        print button
        print =new JButton("PRINT");
        print.setBounds(150,70,80,20);
        print.addActionListener(this);
        add(print);
        
//        update
       Update =new JButton("UPDATE");
        Update.setBounds(250,70,100,20);
       Update.addActionListener(this);
        add(Update);
//        back button
        back =new JButton("BACK");
       back.setBounds(370,70,80,20);
       back.addActionListener(this);
        add(back);
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== searchb){
            String Query ="select * from  employee where empid ='"+cempid.getSelectedItem()+"'";
            try{
                datacon c=new datacon();
                ResultSet rs=c.s.executeQuery(Query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==Update){
            setVisible(false);
            new UpdateEmployee(cempid.getSelectedItem());
            
        }else{
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String[] args) {
        new ViewEmployee("");
    }
}
