package com.zl.servlet;

import com.zl.bean.Customer;
import com.zl.dao.impl.CusDaoImpl;
import com.zl.dao.impl.CusDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet")
public class UpdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Customer customer=new Customer();
        CusDaoImpl cusDao=new CusDaoImpl();
        //获取参数
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String desc=request.getParameter("desc");
        String contact=request.getParameter("contact");
        //设置增加的属性
        customer.setId(id);
        customer.setName(name);
        customer.setDesc(desc);
        customer.setContact(contact);
        cusDao.updCustomer(customer);
        request.setAttribute("customer",customer);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
