package com.zl.dao;

import com.zl.bean.Customer;

import java.util.List;

public interface CustomerDao {
    //添加用户接口
    public boolean addCustomer(Customer customer);
    //删除用户接口
    public boolean delCustomer(int id);
    //更新用户接口
    public boolean updCustomer(Customer customer);
    //根据ID获取信息接口
    public Customer getById(int id);
    //获取所有用户信息接口
    public List<Customer> selectAll();
}
