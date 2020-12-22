package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session= request.getSession();
        System.out.println("admin_filter worked");
        String admin_name = (String) session.getAttribute("admin_name");
        if(admin_name==null)
        {
            //HttpServletResponse resp = (HttpServletResponse)servletRequest;
            //((HttpServletResponse) servletRequest).sendRedirect("http://www.baidu.com");
            System.out.println("dennyed");

            return;
        }
        else
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
