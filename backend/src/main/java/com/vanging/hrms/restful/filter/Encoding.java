package com.vanging.hrms.restful.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Encoding implements Filter
{
    public void destroy()
    {

    }

    public void init(FilterConfig config) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        req.setCharacterEncoding("utf-8");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
