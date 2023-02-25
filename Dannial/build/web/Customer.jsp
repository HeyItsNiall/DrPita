<%-- 
    Document   : Customer
    Created on : 28 Jan 2023, 8:00:20 pm
    Author     : Ahmad Dannial Dzulkarnain bin Ahmad Sahmulaili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Furniture Repairing Reservation System</title>
    </head>
    <body>
        <br/>
        <p><b>New Record</b></p>
        <form name="frmAddUser" action="CustomerController" method="POST" >
            <input type="hidden" name="action" value="insert">
            <table border="0">
                <tbody>
                    <tr>
                        <td>User ID</td>
                        <td><input type="text" name="userid" value="" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" value="" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lname" value="" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username" value="" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="passwords" value="" size="25" required /></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Submit" size="25" name="submit" required />
                            <input type="reset" value="Cancel"  size="25" name="cancel" required />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
