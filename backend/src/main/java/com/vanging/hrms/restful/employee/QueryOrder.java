package com.vanging.hrms.restful.employee;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.persistence.actions.Employee;
import com.vanging.hrms.restful.response.JSONResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryOrder extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONResponse finalResponse = new JSONResponse();

        String order_id = request.getParameter("order_id");
        if(order_id == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            Object order = Employee.queryOrder(order_id);
            if(order.equals(""))
            {
                finalResponse.setStatus("id_not_exist");
            }
            else
            {
                finalResponse.setStatus("ok");
                finalResponse.setMessage(order);
            }
        }

        JSON.writeJSONString(response.getWriter(), finalResponse);
    }

}
