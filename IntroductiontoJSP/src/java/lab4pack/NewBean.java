package lab4pack;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewBean implements Serializable{
    Connection con;
    Statement stmt;
    String un,pass,regd;

    public String getUn() {
        return un;
    }

    public String getRegd() {
        return regd;
    }

    public String getPass() {
        return pass;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRegd(String regd) {
        this.regd = regd;
    }
    public NewBean(){
        
    }
}