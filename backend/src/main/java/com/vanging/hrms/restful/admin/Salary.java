package com.vanging.hrms.restful.admin;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.persistence.actions.Admin;
import com.vanging.hrms.restful.response.JSONResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class Salary extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONResponse finalResponse = new JSONResponse();

        String id = request.getParameter("id");
        String start_str = request.getParameter("start");
        String end_str = request.getParameter("start");

        if(id == null || start_str == null || end_str == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            try
            {
                long start_num = (long)Float.parseFloat(start_str);
                long end_num = (long)Float.parseFloat(end_str);

                float salary = Admin.salary(id, start_num, end_num);
                finalResponse.setStatus("ok");
                finalResponse.setMessage(salary);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                finalResponse.setStatus("bad_number");
            }
        }

        JSON.writeJSONString(response.getWriter(), finalResponse);
    }
}
