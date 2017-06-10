package com.vanging.hrms.restful.admin;

import com.alibaba.fastjson.JSON;
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
    private Session session = null;
    private Transaction transaction = null;

    public void init()
    {
        session = Persistence.getSession();
        transaction = session.getTransaction();
    }

    @Override
    public void destroy()
    {
        session.close();
    }

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
//            Administrator administrator = session.get(Administrator.class, (int)Float.parseFloat(id));
            Administrator administrator = session.get(Administrator.class, id);
            if(administrator == null)
            {
                finalResponse = "id_not_exist";
            }
            else
            {
                if(administrator.getPassword().equals(password))
                {
                    finalResponse = "ok";
                }
                else
                {
                    finalResponse = "password_not_correct";
                }
            }
        }

        response.setHeader("Content-Type", "text/plain");
        PrintWriter out = response.getWriter();
        out.print(finalResponse);
    }

}
