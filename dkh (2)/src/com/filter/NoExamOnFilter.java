package com.filter;

import com.dao.ExamDao;

import javax.servlet.*;
import java.io.IOException;

public class NoExamOnFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String exam_name = ExamDao.check_exam_exist();
        if(exam_name==null){
            return;
        }
        else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
