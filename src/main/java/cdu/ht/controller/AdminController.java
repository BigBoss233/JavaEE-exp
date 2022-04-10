package cdu.ht.controller;

import cdu.ht.annotation.LogAnno;
import cdu.ht.entity.Admin;
import cdu.ht.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @LogAnno
    public ModelAndView login(HttpSession httpSession, Admin admin) {
        Admin admin1 = adminService.login(admin);
        httpSession.setAttribute("admin", admin1);
        ModelAndView modelAndView = new ModelAndView();
        if (admin1 != null) {
            modelAndView.addObject("admin", admin1);
            modelAndView.setViewName("index");
        } else {
            String error = "登录失败，请检查用户名和密码是否正确";
            modelAndView.addObject("error", error);
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @LogAnno
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        if (httpSession.getAttribute("admin") != null) {
            httpSession.removeAttribute("admin");
        }
        System.out.println("注销成功");
        return "login";
    }
}
