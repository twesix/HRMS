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

public class Worktime extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONResponse finalResponse = new JSONResponse();

        String id = request.getParameter("id");
        String start_str = request.getParameter("start");
        String end_str = request.getParameter("end");

        if(id == null || start_str == null || end_str == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            long start = (long)Float.parseFloat(start_str);
            long end = (long)Float.parseFloat(end_str);

            int worktime = Admin.worktime(id, start, end);
            finalResponse.setStatus("ok");
            finalResponse.setMessage(worktime);
        }

        JSON.writeJSONString(response.getWriter(), finalResponse);
    }

}
