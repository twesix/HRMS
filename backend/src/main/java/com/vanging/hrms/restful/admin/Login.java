package com.vanging.hrms.restful.admin;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.persistence.actions.Admin;
import com.vanging.hrms.restful.response.JSONResponse;

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
        JSONResponse finalResponse = new JSONResponse();

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if(id == null || password == null)
        {
            finalResponse.setStatus("no_id_or_password");
        }
        else
        {
            if(Admin.login(id, password))
            {
                finalResponse.setStatus("ok");
            }
            else
            {
                finalResponse.setStatus("wrong_password");
            }
        }
        JSON.writeJSONString(response.getWriter(), finalResponse);
    }

}