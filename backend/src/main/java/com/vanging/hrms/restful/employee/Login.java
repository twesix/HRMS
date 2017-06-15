package com.vanging.hrms.restful.employee;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.persistence.actions.Employee;
import com.vanging.hrms.restful.response.JSONResponse;

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
        JSONResponse finalResponse = new JSONResponse();

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if(id == null || password == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            if(Employee.login(id, password))
            {
                finalResponse.setStatus("ok");
            }
            else
            {
                finalResponse.setStatus("not_match");
            }
        }
        JSON.writeJSONString(response.getWriter(), finalResponse);
    }

}
