package com.vanging.hrms.restful;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Index extends HttpServlet
{

    public void init()
    {

    }

    public void dooGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String finalResponse = "ok, this is working !";

        response.setHeader("Content-Type", "text/plain");
        PrintWriter out = response.getWriter();
        out.print(finalResponse);
    }

}