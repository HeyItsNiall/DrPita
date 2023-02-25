/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import User.Owner;
import com.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmad Dannial Dzulkarnain bin Ahmad Sahmulaili
 */
public class OwnerDAO {
    
    private Connection connection;
    
    public OwnerDAO() throws ClassNotFoundException{
            
        connection = DBConnection.createConnection();
    }
    
    //Add User
    public void addOwner (Owner owner) throws SQLException{
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into owners(ownerid, firstname, lastname, address, phone, email) values (?,?,?,?,?,?)");
            //parameters start with 1
            preparedStatement.setString(1, owner.getOwnerid());
            preparedStatement.setString(2, owner.getFirstname());
            preparedStatement.setString(3, owner.getLastname());
            preparedStatement.setString(4, owner.getAddress());
            preparedStatement.setString(5, owner.getPhone());
            preparedStatement.setString(6, owner.getEmail());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //Delete User
    public void deleteOwner(String Ownerid){
        
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from owners where ownerid=?");
            //parameter start with 1
            preparedStatement.setString(1, Ownerid);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //Update User
    public void updateOwner(Owner owner) throws SQLException{
        
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update owners set firstname=?, lastname=?, address=?, phone=?, email=? where ownerid=?");
            //parameter start with 1
            preparedStatement.setString(1, owner.getFirstname());
            preparedStatement.setString(2, owner.getLastname());
            preparedStatement.setString(3, owner.getAddress());
            preparedStatement.setString(4, owner.getPhone());
            preparedStatement.setString(5, owner.getEmail());
            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //List User
    public List<Owner> getAllOwners(){
        List<Owner> owners = new ArrayList<Owner>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from owners");
            while (rs.next()){
            
                Owner owner = new Owner();
                owner.setOwnerid(rs.getString("ownerid"));
                owner.setFirstname(rs.getString("firstname"));
                owner.setLastname(rs.getString("lastname"));
                owner.setAddress(rs.getString("address"));
                owner.setPhone(rs.getString("phone"));
                owner.setEmail(rs.getString("email"));
                owners.add(owner);
                
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return owners;
    }
    
    //Get User
    public Owner getOwnerById(String Ownerid){
        
        Owner owner = new Owner();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from owner where ownerid");
            preparedStatement.setString(1, Ownerid);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                
                owner.setOwnerid(rs.getString("ownerid"));
                owner.setFirstname(rs.getString("firstname"));
                owner.setLastname(rs.getString("lastname"));
                owner.setAddress(rs.getString("address"));
                owner.setPhone(rs.getString("phone"));
                owner.setEmail(rs.getString("email"));
            }
            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return owner;
        
    }
}
