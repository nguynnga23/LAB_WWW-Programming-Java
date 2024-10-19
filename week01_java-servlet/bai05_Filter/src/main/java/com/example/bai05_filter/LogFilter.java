package com.example.bai05_filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class LogFilter implements Filter {

    public void init(FilterConfig config){
        //Get init paramater
        String testParam = config.getInitParameter("test-param");
        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String ipAddress = request.getRemoteAddr();
        System.out.println("IP " + ipAddress + ", Time " + new Date().toString());
        chain.doFilter(request, response);
    }
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }

    public void destroy(){

    }
}
