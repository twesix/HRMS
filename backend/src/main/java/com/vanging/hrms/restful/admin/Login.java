package com.vanging.hrms.restful.admin;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        System.out.println("request");
        String finalResponse;

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if(id == null || password == null)
        {
            finalResponse = "error";
        }
        else
        {
            finalResponse = "ok";
        }

        response.setHeader("Content-Type", "text/plain");
        PrintWriter out = response.getWriter();
        out.print(finalResponse);
    }

}
