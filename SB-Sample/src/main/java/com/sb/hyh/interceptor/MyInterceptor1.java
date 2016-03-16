package com.sb.hyh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 只有经过DispatcherServlet的请求,才会走拦截器链,我们自定义的Servlet请求是不会被拦截的
 */
public class MyInterceptor1 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("MyInterceptor1 preHandle在请求处理之前进行调用(Controller方法调用之前)");
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1 postHandle请求处理之后进行调用，但是在视图被渲染之前(Controller方法调用之后)");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(
                "MyInterceptor1 afterCompletion在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行(主要是用于进行资源清理工作)");
    }
}