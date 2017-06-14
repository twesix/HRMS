package com.vanging.hrms.restful.admin;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.persistence.actions.Admin;
import com.vanging.hrms.persistence.models.Profile;
import com.vanging.hrms.restful.response.JSONResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryEmployee extends HttpServlet
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
            Profile profile = Admin.queryEmployee(id);
            if(profile == null)
            {
                final_response.setStatus("not_exist");
            }
            else
            {
                final_response.setStatus("ok");
                final_response.setMessage(profile);
            }
        }
        JSON.writeJSONString(response.getWriter(), final_response);
    }
}
