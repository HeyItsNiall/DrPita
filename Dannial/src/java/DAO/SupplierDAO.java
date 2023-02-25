/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import User.Supplier;
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
public class SupplierDAO {
    
    private Connection connection;
    
    public SupplierDAO() throws ClassNotFoundException{
            
        connection = DBConnection.createConnection();
    }
    
    //Add User
    public void addSupplier (Supplier supplier) throws SQLException{
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into suppliers(supplierid, companyname, contactname, phone, email) values (?,?,?,?,?)");
            //parameters start with 1
            preparedStatement.setString(1, supplier.getSupplierid());
            preparedStatement.setString(2, supplier.getCompanyname());
            preparedStatement.setString(3, supplier.getContactname());
            preparedStatement.setString(4, supplier.getPhone());
            preparedStatement.setString(5, supplier.getEmail());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //Delete User
    public void deleteSupplier(String Supplierid){
        
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from suppliers where supplierid=?");
            //parameter start with 1
            preparedStatement.setString(1, Supplierid);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //Update User
    public void updateSupplier(Supplier supplier) throws SQLException{
        
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update suppliers set companyname=?, contactname=?, address=?, phone=?, email=? where supplierid=?");
            //parameter start with 1
            preparedStatement.setString(1, supplier.getCompanyname());
            preparedStatement.setString(2, supplier.getContactname());
            preparedStatement.setString(4, supplier.getPhone());
            preparedStatement.setString(5, supplier.getEmail());
            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //List User
    public List<Supplier> getAllSuppliers(){
        List<Supplier> suppliers = new ArrayList<Supplier>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from suppliers");
            while (rs.next()){
            
                Supplier supplier = new Supplier();
                supplier.setSupplierid(rs.getString("supplierid"));
                supplier.setCompanyname(rs.getString("Companyname"));
                supplier.setContactname(rs.getString("contactname"));
                supplier.setPhone(rs.getString("phone"));
                supplier.setEmail(rs.getString("email"));
                suppliers.add(supplier);
                
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return suppliers;
    }
    
    //Get User
    public Supplier getSupplierById(String Supplierid){
        
        Supplier supplier = new Supplier();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from suppliers where supplierid");
            preparedStatement.setString(1, Supplierid);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                
                supplier.setSupplierid(rs.getString("supplierid"));
                supplier.setCompanyname(rs.getString("companyname"));
                supplier.setContactname(rs.getString("contactname"));
                supplier.setPhone(rs.getString("phone"));
                supplier.setEmail(rs.getString("email"));
            }
            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return supplier;
        
    }
}
