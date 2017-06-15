package com.vanging.hrms.restful.admin;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.persistence.actions.Admin;
import com.vanging.hrms.restful.response.JSONResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateEmployee extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONResponse finalResponse = new JSONResponse();

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        System.out.println(username);
        String usertype = request.getParameter("usertype");
        String tel = request.getParameter("tel");
        String salary_per_hour_str = request.getParameter("salary_per_hour");
        String salary_fixed_str = request.getParameter("salary_fixed");
        String salary_rate_str = request.getParameter("salary_rate");
        String hour_limit_str = request.getParameter("hour_limit");

        if(id == null || username == null || usertype == null || tel == null || salary_per_hour_str == null || salary_fixed_str == null || salary_rate_str == null || hour_limit_str == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            float salary_per_hour;
            float salary_fixed;
            float salary_rate;
            int hour_limit;
            try
            {
                salary_per_hour = Float.parseFloat(salary_per_hour_str);
                salary_fixed = Float.parseFloat(salary_fixed_str);
                salary_rate = Float.parseFloat(salary_rate_str);
                hour_limit = (int)Float.parseFloat(hour_limit_str);

                boolean result = Admin.updateEmployee
                        (
                                id,
                                username,
                                usertype,
                                tel,
                                salary_per_hour,
                                salary_fixed,
                                salary_rate,
                                hour_limit
                        );
                if(result)
                {
                    finalResponse.setStatus("ok");
                }
                else
                {
                    finalResponse.setStatus("id_not_exist");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
                finalResponse.setStatus("bad_number");
            }

            JSON.writeJSONString(response.getWriter(), finalResponse);
        }
    }
}
