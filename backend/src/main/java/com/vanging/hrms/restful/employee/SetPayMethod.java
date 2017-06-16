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

public class SetPayMethod extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONResponse finalResponse = new JSONResponse();

        String id = request.getParameter("id");
        String method = request.getParameter("method");
        String detail = request.getParameter("detail");

        if(id == null || method == null || detail == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            if(Employee.setPayMethod(id, method, detail))
            {
                finalResponse.setStatus("ok");
            }
            else
            {
                finalResponse.setStatus("error");
            }
        }

        JSON.writeJSONString(response.getWriter(), finalResponse);
    }

}
