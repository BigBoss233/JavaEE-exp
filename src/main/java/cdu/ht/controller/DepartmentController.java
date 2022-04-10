package cdu.ht.controller;

import cdu.ht.annotation.LogAnno;
import cdu.ht.entity.Department;
import cdu.ht.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("departments",departmentService.findAll());
        modelAndView.setViewName("department");
        return modelAndView;
    }

    @LogAnno
    @RequestMapping("/update")
    public String update(HttpSession httpSession,Department department){
        departmentService.update(department);
        return "redirect:findAll";
    }
    @RequestMapping("/updateUI")
    public ModelAndView updateUI(int  id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id",id);
        modelAndView.setViewName("department-update");
        return modelAndView;
    }
    @LogAnno
    @RequestMapping("/insert")
    public String insert(HttpSession httpSession,Department department){
        departmentService.insert(department);
        return "redirect:findAll";
    }

    @LogAnno
    @RequestMapping("/del")
    public String del(HttpSession httpSession,Integer id){
        departmentService.delById(id);
        return "redirect:findAll";
    }

    @RequestMapping("/findByName")
    public ModelAndView findByName(String name){
        List<Department> departments = departmentService.findByName(name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("departments",departments);
        modelAndView.setViewName("department");
        return modelAndView;
    }
}
