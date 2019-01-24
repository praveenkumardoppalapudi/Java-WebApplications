<%-- 
    Document   : insertbean
    Created on : Jan 10, 2019, 5:11:04 PM
    Author     : Admin
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <jsp:useBean id="bean1" class="lab4pack.NewBean"></jsp:useBean>
        <jsp:setProperty name="bean1" property="*"></jsp:setProperty>
        
        
        <%
            Connection con;
            Statement stmt;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/logindetails","app","app");
            stmt=con.createStatement();
            stmt.executeUpdate("insert into logins values('"+bean1.getUn()+"','"+bean1.getPass()+"','"+bean1.getRegd()+"')");
            con.close();
        %>
        <h2>Your Registration is Done</h2>
        <a href="index.html">Click here for Login Page </a>
    </center>
    </body>
</html>
