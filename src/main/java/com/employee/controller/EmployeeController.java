package com.employee.controller;

import com.employee.dao.EmployeeDao;
import com.employee.dao.EmployeeDaoImpl;
import com.employee.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employee",value = "/")
public class EmployeeController extends HttpServlet {
    private final EmployeeDao dao = new EmployeeDaoImpl();
    Employee employee;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listEmp",dao.getAll());
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if (method.equals("DELETE")) {
            Integer id = Integer.valueOf(req.getParameter("idEmp"));
             dao.deleteById(id);
        } else {
            employee = new Employee();

            String id = req.getParameter("id");
            if (id != null) employee.setId(Integer.valueOf(id));
            employee.setFullname(req.getParameter("fullname"));
            employee.setAddress(req.getParameter("address"));
            employee.setDepartment(req.getParameter("department"));
            employee.setPosition(req.getParameter("position"));
            dao.createOrUpdate(employee);
        }
        resp.sendRedirect("employee");

    }
}
