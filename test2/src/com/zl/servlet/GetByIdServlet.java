package com.zl.servlet;

import com.zl.bean.Customer;
import com.zl.dao.impl.CusDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetByIdServlet")
public class GetByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //Customer customer=new Customer();
        CusDaoImpl cusDao=new CusDaoImpl();
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=cusDao.getById(id);
        request.setAttribute("customer",customer);
        request.getRequestDispatcher("selectbyid.jsp").forward(request,response);

    }
}
