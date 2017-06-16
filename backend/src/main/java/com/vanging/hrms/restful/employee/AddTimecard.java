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

public class AddTimecard extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONResponse finalResponse = new JSONResponse();

        String pid = request.getParameter("pid");
        String uid = request.getParameter("uid");
        String start_str = request.getParameter("start");
        String end_str = request.getParameter("end");
        String date = request.getParameter("date");

        if(pid == null || uid == null || start_str == null || end_str == null || date == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            try
            {
                int start = (int)(long)Float.parseFloat(start_str);
                int end = (int)(long)Float.parseFloat(end_str);

                if(Employee.addTimecard(pid, uid,start, end, date))
                {
                    finalResponse.setStatus("ok");
                }
                else
                {
                    finalResponse.setStatus("error");
                }
            }
            catch(Exception e)
            {
                finalResponse.setStatus("bad_int");
            }
        }

        JSON.writeJSONString(response.getWriter(), finalResponse);
    }

}
