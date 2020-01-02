package com.zl.dao.impl;

import com.mysql.cj.xdevapi.SqlDataResult;
import com.zl.bean.Customer;
import com.zl.dao.CustomerDao;
import com.zl.util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CusDaoImpl implements CustomerDao {
    @Override
    public boolean addCustomer(Customer customer) {
        String sql="insert into customer(id,name,desc,contact)VALUES(?,?,?,?)";
        Connection conn= JDBCutil.getconnection();
        try{
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1,customer.getId());
            pst.setString(2,customer.getName());
            pst.setString(3,customer.getDesc());
            pst.setString(4,customer.getContact());
            int count=pst.executeUpdate();
            pst.close();
            return count>0? true:false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delCustomer(int id) {
        String sql="DELETE FROM customer WHERE id=?";
        Connection conn=JDBCutil.getconnection();
        try{
            PreparedStatement pst=conn.prepareStatement(sql);
           // PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1,id);
            int count=pst.executeUpdate();
            pst.close();
            return count>0? true:false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updCustomer(Customer customer) {
        String sql="UPDATE customer SET name=?,desc=?contact=? WHERE id=?";
        Connection conn=JDBCutil.getconnection();
        try{
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1,customer.getId());
            pst.setString(2,customer.getName());
            pst.setString(3,customer.getDesc());
            pst.setString(4,customer.getContact());
            int count=pst.executeUpdate();
            return count>0? true:false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer getById(int id) {
        String sql="SELECT * FROM customer WHERE id="+id;
        Connection conn=JDBCutil.getconnection();
        Customer customer=new Customer();
        try{
            PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id"+"通过id查询"));
                if(rs.getInt("id")==id) {
                    customer.setId(rs.getInt("id"));
                    customer.setName(rs.getString("name"));
                    customer.setDesc(rs.getString("desc"));
                    customer.setContact(rs.getString("contact"));
                }
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList=new ArrayList<>();
        String sql="SELECT * FROM customer";
        Connection conn=JDBCutil.getconnection();
        try{
            PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                Customer customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setDesc(rs.getString("desc"));
                customer.setContact(rs.getString("contact"));
            }
            rs.close();
            pst.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }
}
