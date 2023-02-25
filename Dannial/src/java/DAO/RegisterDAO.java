/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Bean.RegisterBean;
import com.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ahmad Dannial Dzulkarnain bin Ahmad Sahmulaili
 */
public class RegisterDAO {
    public String registerCustomer(RegisterBean registerBean) throws ClassNotFoundException{
        
        String firstname = registerBean.getFirstname();
        String lastname = registerBean.getLastname();
        String address = registerBean.getAddress();
        String email = registerBean.getEmail();
        String phone = registerBean.getPhone();
        String username = registerBean.getUsername();
        String password = registerBean.getPassword();
        
        
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try{
        
            con = DBConnection.createConnection();
            String query = "insert into customer (firstname, lastname, address, email, phone, username, password) values (?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(query); //making use of prepared statement to insert bunch of data
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, username);
            preparedStatement.setString(7, password);
            
            int i= preparedStatement.executeUpdate();
            
            if (i!=0) //to ensure data has been inserted into database
                return "Success";
        }
        catch (SQLException e){
        
            e.printStackTrace();
        }
        return "Oops.. Something went wrong there..!"; // failure message
    }
    
}
