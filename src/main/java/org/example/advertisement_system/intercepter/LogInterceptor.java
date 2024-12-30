package org.example.advertisement_system.intercepter;

import org.apache.ibatis.plugin.Intercepts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.*;

@Component
@Intercepts({@org.apache.ibatis.plugin.Signature(type = Object.class, method = "methodName", args = {HttpServletRequest.class, HttpServletResponse.class, Object.class})})
public class LogInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
//        System.out.println("\n-------- LogInterception.preHandle --- ");
        System.err.println("<<<<");
        System.err.println("* Method:"+request.getMethod());
        System.err.println("* Request URL: " + request.getRequestURL());
        System.err.println("* Start Time: " + System.currentTimeMillis());

        request.setAttribute("startTime", startTime);

        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("---****---");
        System.err.println("* Request URL: " + request.getRequestURL());
    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("********************");

        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.err.println("Request URL: " + request.getRequestURL());
        System.err.println("End Time: " + endTime);

        System.err.println("Time Taken: " + (endTime - startTime));
        System.err.println("********************");
        System.err.println(">>>>");
    }
}
