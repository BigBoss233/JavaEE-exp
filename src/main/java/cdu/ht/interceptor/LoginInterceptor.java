package cdu.ht.interceptor;

import cdu.ht.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
            return false;
        }
        return true;
    }
}
