package com.vanging.hrms.restful;

import com.alibaba.fastjson.JSON;
import com.vanging.hrms.restful.response.JSONResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Index extends HttpServlet
{

    public void init()
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONResponse finalResponse = new JSONResponse();

        finalResponse.setStatus("ok");
        finalResponse.setMessage("it works !");
        PrintWriter out = response.getWriter();
        JSON.writeJSONString(out, finalResponse);
    }

}
