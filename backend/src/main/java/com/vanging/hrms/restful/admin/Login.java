package com.vanging.hrms.restful.admin;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.actions.Admin;
import com.vanging.hrms.persistence.Persistence;
import com.vanging.hrms.persistence.models.Administrator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        System.out.println("request");
        String finalResponse;

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if(id == null || password == null)
        {
            finalResponse = "no_id_or_password";
        }
        else
        {
            if(Admin.login((long)Float.parseFloat(id), password))
            {
                finalResponse = "ok";
            }
            else
            {
                finalResponse = "error";
            }
        }

        response.setHeader("Content-Type", "text/plain");
        PrintWriter out = response.getWriter();
        out.print(finalResponse);
    }

}
