package com.vanging.hrms.restful.admin;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.actions.Admin;
import com.vanging.hrms.restful.response.JSONResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployee extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        JSONResponse final_response = new JSONResponse();

        String id = request.getParameter("id");
        if(id == null)
        {
            final_response.setStatus("no_id");
        }
        else
        {
            boolean result = Admin.deleteEmployee(id);
            if(result)
            {
                final_response.setStatus("ok");
            }
            else
            {
                final_response.setStatus("error");
            }
        }
        JSON.writeJSONString(response.getWriter(), final_response);
    }
}
