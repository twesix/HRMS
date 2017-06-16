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

public class UpdateOrder extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONResponse finalResponse = new JSONResponse();

        String order_id = request.getParameter("order_id");
        String customer_point_of_contact = request.getParameter("customer_point_of_contact");
        String customer_billing_address = request.getParameter("customer_billing_address");
        String products_purchased = request.getParameter("products_purchased");

        if(order_id == null || customer_point_of_contact == null || customer_billing_address == null || products_purchased == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            if(Employee.updateOrder(order_id, customer_point_of_contact, customer_billing_address, products_purchased))
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
