/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import User.Transporter;
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
public class TransporterDAO {
    
    private Connection connection;
    
    public TransporterDAO() throws ClassNotFoundException{
            
        connection = DBConnection.createConnection();
    }
    
    //Add User
    public void addTransporter (Transporter transporter) throws SQLException{
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into transporter(transporterid, companyname, contactname, phone, email) values (?,?,?,?,?)");
            //parameters start with 1
            preparedStatement.setString(1, transporter.getTransporterid());
            preparedStatement.setString(2, transporter.getCompanyname());
            preparedStatement.setString(3, transporter.getContactname());
            preparedStatement.setString(4, transporter.getPhone());
            preparedStatement.setString(5, transporter.getEmail());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //Delete User
    public void deleteTransporter(String Transporterid){
        
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from transporter where transporterid=?");
            //parameter start with 1
            preparedStatement.setString(1, Transporterid);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //Update User
    public void updateTransporter(Transporter transporter) throws SQLException{
        
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update transporter set companyname=?, contactname=?, address=?, phone=?, email=? where transporterid=?");
            //parameter start with 1
            preparedStatement.setString(1, transporter.getCompanyname());
            preparedStatement.setString(2, transporter.getContactname());
            preparedStatement.setString(4, transporter.getPhone());
            preparedStatement.setString(5, transporter.getEmail());
            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //List User
    public List<Transporter> getAllTransporters(){
        List<Transporter> transporters = new ArrayList<Transporter>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from transporter");
            while (rs.next()){
            
                Transporter transporter = new Transporter();
                transporter.setTransporterid(rs.getString("trasnporterid"));
                transporter.setCompanyname(rs.getString("companyname"));
                transporter.setContactname(rs.getString("contactname"));
                transporter.setPhone(rs.getString("phone"));
                transporter.setEmail(rs.getString("email"));
                transporters.add(transporter);
                
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return transporters;
    }
    
    //Get User
    public Transporter getTransporterById(String Transporterid){
        
        Transporter supplier = new Transporter();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from transporter where transporterid");
            preparedStatement.setString(1, Transporterid);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                
                supplier.setTransporterid(rs.getString("transporterid"));
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
