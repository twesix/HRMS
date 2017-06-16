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

public class DeleteOrder extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONResponse finalResponse = new JSONResponse();

        String order_id = request.getParameter("order_id");
        String uid = request.getParameter("uid");

        if(order_id == null || uid == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            if(Employee.deleteOrder(uid, order_id))
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
