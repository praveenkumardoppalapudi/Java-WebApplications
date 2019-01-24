<%-- 
    Document   : register
    Created on : Jan 10, 2019, 3:46:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="logincss.css" rel="stylesheet"/>
    </head>
    <body class='registerjsp'>
    <center>
        <div class="regjspbox">
        <form action="insertbean.jsp">
            <h1 class="headerstyle">Registration Page</h1>
            <table>
                <tr>
                    <td class='fsz'>UserID</td>
                </tr>
                <tr>
                    <td><input type="text" class="textbox" required="true" placeholder="Ex:praveen123@" name="un"/></td>
                </tr>
                <tr>
                    <td class="fsz">Password</td>
                </tr>
                <tr>
                    <td><input type="password" class="textbox" required="true" name="pass"/></td>
                </tr>
                <tr>
                    <td class="fsz">RegisterNumber</td>
                </tr>
                <tr>
                    <td><input type="text" class="textbox" name="regd" placeholder="Ex:Y16ACs400"/></td>
                </tr>
                <tr>
                    <td colspan="2"><center><input class="button" type="submit" value="Register" /></center></td>
                </tr>
            </table>
        </form>
            </div>
    </center>
   
    </body>
</html>
