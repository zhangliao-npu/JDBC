package com.zl.servlet;

import com.zl.bean.Customer;
import com.zl.dao.impl.CusDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        CusDaoImpl cusDao=new CusDaoImpl();
        int id=Integer.parseInt("id");
        cusDao.delCustomer(id);
        request.getRequestDispatcher("delete.jsp").forward(request,response);
    }
}
