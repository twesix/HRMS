package com.vanging.hrms.restful.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeReport extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String finalResponse = "admin / employee report";

        response.setHeader("Content-Type", "text/plain");
        PrintWriter out = response.getWriter();
        out.print(finalResponse);
    }

}
