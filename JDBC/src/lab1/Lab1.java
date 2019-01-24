/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con;
        Statement stmt;
        ResultSet rs;
        Scanner sc=new Scanner(System.in);
        int opt;
        
        while(true)
        {   
            System.out.println("Your Menu is>>\n0.Exit\n1.Insert\n2.view Info\n3.Alter\n4.Total Marks\n5.Grade\n");
            System.out.print("Enter Your Option:");
            opt=sc.nextInt();
            switch(opt)
            {
                case 0:System.exit(opt);
                       break;
                case 1:
                        try {
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                             con=DriverManager.getConnection("jdbc:derby://localhost:1527/Student","app","app");
                             stmt=con.createStatement();
                             stmt.executeUpdate("insert into APP.INFO values('y16acs444','venky',100,89,90,98,96,96)");
                             System.out.println("Data Inserted Succesfully\n\n\n\n\n\n");
                             con.close();
                         } catch (SQLException ex) {
                             Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        break;
                case 2:
                    try {
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                             con=DriverManager.getConnection("jdbc:derby://localhost:1527/Student","app","app");
                             stmt=con.createStatement();
                             String s="y16acs443";
                             rs=stmt.executeQuery("select * from APP.INFO where regsno='"+s+"'");
                             while(rs.next())
                             {
                                 System.out.println(rs.getString(1)+","+rs.getString(2)+"\n\n\n\n");
                             }
                             con.close();
                         } catch (SQLException ex) {
                             Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        
                        break;
                case 3:
                        try {
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                             con=DriverManager.getConnection("jdbc:derby://localhost:1527/Student","app","app");
                             stmt=con.createStatement();
                          
                             stmt.executeUpdate("ALTER TABLE APP.INFO add total INTEGER");
                             stmt.executeUpdate("ALTER TABLE APP.INFO add grade INTEGER");
                            // stmt.executeUpdate("ALTER TABLE APP.INFO DROP total");
                             //stmt.executeUpdate("ALTER TABLE APP.INFO DROP grade");
                             System.out.println("table alterd successfully");
                         } catch (SQLException ex) {
                             Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        break;
                case 4:
                        try {
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                             con=DriverManager.getConnection("jdbc:derby://localhost:1527/Student","app","app");
                             stmt=con.createStatement();
                             stmt.executeUpdate("update APP.INFO set total=Sub1+Sub2+Sub3+Sub4+Sub5+Sub6,grade=(Sub1+Sub2+Sub3+Sub4+Sub5+Sub6)/6 where regsno='y16acs444'");
                         } catch (SQLException ex) {
                             Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        break;
                case 5:
                        try {
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                             con=DriverManager.getConnection("jdbc:derby://localhost:1527/Student","app","app");
                             stmt=con.createStatement();
                             rs=stmt.executeQuery("select grade from APP.INFO where regsno='y16acs444'");
                             int gd = 0;
                             while(rs.next()){
                                 gd=rs.getInt("grade");
                             }
                             
                             //System.out.println("grade:"+gd);
                             if(gd>=90)
                             {
                                 System.out.println("Grade:10\n\n\n");
                             }
                             if(gd>=85&&gd<=89)
                             {
                                 System.out.println("Grade:9\n\n\n");
                             }
                             if(gd>=80&&gd<=84)
                             {
                                 System.out.println("Grade:8\n\n\n");
                             }
                             if(gd>=70&&gd<=79)
                             {
                                 System.out.println("Grade:7\n\n\n");
                             }
                             if(gd>=60&&gd<=69)
                             {
                                 System.out.println("Grade:6\n\n\n");
                             }
                             if(gd>=30&&gd<=59)
                             {
                                 System.out.println("Grade:5\n\n\n");
                             }
                             
                             
                         } catch (SQLException ex) {
                             Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        break;
            }
        }
    }
    
}
