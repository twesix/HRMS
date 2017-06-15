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

public class AddOrder extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONResponse finalResponse = new JSONResponse();

        String customer_point_of_contact = request.getParameter("customer_point_of_contact");
        String customer_billing_address = request.getParameter("customer_billing_address");
        String products_purchased = request.getParameter("products_purchased");
        String date = request.getParameter("date");

        if(customer_point_of_contact == null || customer_billing_address == null || products_purchased == null || date == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            String order_id = Employee.addOrder(customer_point_of_contact, customer_billing_address, products_purchased, date);
            if(order_id.equals(""))
            {
                finalResponse.setStatus("error");
            }
            else
            {
                finalResponse.setStatus("ok");
                finalResponse.setMessage(order_id);
            }
        }
        JSON.writeJSONString(response.getWriter(), finalResponse);
    }

}
