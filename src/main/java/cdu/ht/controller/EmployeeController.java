package cdu.ht.controller;

import cdu.ht.annotation.LogAnno;
import cdu.ht.entity.Employee;
import cdu.ht.service.DepartmentService;
import cdu.ht.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping("/findAll")
    public ModelAndView findAll(HttpSession httpSession,
                                @RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        List<Employee> all = employeeService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(all);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("employeeParam", null);
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @LogAnno
    @RequestMapping("/update")
    public String update(HttpSession httpSession, Employee employee) {
        employeeService.update(employee);
        return "redirect:findAll";
    }

    @RequestMapping("/updateUI")
    public ModelAndView updateUI(int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.setViewName("employee-update");
        return modelAndView;
    }

    @LogAnno
    @RequestMapping("/insert")
    public String insert(HttpSession httpSession, Employee employee) {
        employeeService.insert(employee);
        return "redirect:findAll";
    }

    @LogAnno
    @RequestMapping("/del")
    public String del(HttpSession httpSession,Integer id) {
        employeeService.delById(id);
        return "redirect:findAll";
    }

    @RequestMapping("/fuzzyFind")
    public ModelAndView fuzzyFind(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                  @RequestParam(name = "size", required = true, defaultValue = "5") int size,
                                  @RequestParam(name = "number", required = false) Integer number,
                                  @RequestParam(name = "name", required = true) String name,
                                  @RequestParam(name = "gender", required = true) String gender) {
        Employee employee = new Employee();
        employee.setGender(gender);
        employee.setName(name);
        employee.setNumber(number);
        List<Employee> employees = employeeService.fuzzyFind(employee, page, size);
        PageInfo pageInfo = new PageInfo(employees);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("methodName", "fuzzyFind");
        modelAndView.addObject("employeeParam", employee);
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @RequestMapping("/findByDepId")
    public ModelAndView findByDepId(Integer dep_id,
                                    @RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                    @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        List<Employee> employees = employeeService.findByDepId(dep_id, page, size);
        Employee employeeParam = new Employee();
        employeeParam.setDep_id(dep_id);
        PageInfo pageInfo = new PageInfo(employees);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("methodName", "findByDepId");
        modelAndView.addObject("employeeParam", employeeParam);
        modelAndView.setViewName("employee");
        return modelAndView;
    }
}
