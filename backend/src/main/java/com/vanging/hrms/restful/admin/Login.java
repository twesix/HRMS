package com.vanging.hrms.restful.admin;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.actions.Admin;
import com.vanging.hrms.restful.response.JSONResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        System.out.println("request");
        JSONResponse finalResponse = new JSONResponse();

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if(id == null || password == null)
        {
            finalResponse.setStatus("no_id_or_password");
        }
        else
        {
            long the_id;
            try
            {
                the_id = (long)Float.parseFloat(id);
                if(Admin.login(the_id, password))
                {
                    finalResponse.setStatus("ok");
                }
                else
                {
                    finalResponse.setStatus("wrong_password");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
                finalResponse.setStatus("bad_id");
            }
        }

        response.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();
        JSON.writeJSONString(out, finalResponse);
    }

}

class Message
{
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}