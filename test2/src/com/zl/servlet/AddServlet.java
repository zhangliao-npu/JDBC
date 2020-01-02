package com.zl.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.zl.bean.Customer;
import com.zl.dao.impl.CusDaoImpl;

@WebServlet(name = "InsertServlet")
public class AddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;chartset=utf-8");
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
        cusDao.addCustomer(customer);
        request.setAttribute("customer",customer);
        request.getRequestDispatcher("insert.jsp").forward(request, response);
    }
}
