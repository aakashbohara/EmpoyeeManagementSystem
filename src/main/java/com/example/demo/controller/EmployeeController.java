package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping({"/showEmployee", "/", "list"})
	public ModelAndView showEmployees() {
		
		ModelAndView modelAndView = new ModelAndView("list-employee");
		
		List<Employee> list = employeeRepository.findAll();
		
		modelAndView.addObject("employees", list);
		
		return modelAndView;
		
	}
	
	@GetMapping("/new-employee")
	public ModelAndView addEmployeeForm() {
		
		ModelAndView mav = new ModelAndView("new-employee");
		Employee newEmployee = new Employee();
		mav.addObject("employee", newEmployee);
		return mav;
		

		
	}
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		
		employeeRepository.save(employee);
		
		return "redirect:/list";
		
		
	}
	
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long employeeId)
	{
		ModelAndView mav = new  ModelAndView("new-employee");
		
		Employee employee = employeeRepository.findById(employeeId).get();
		
		mav.addObject("employee", employee);
		
		return mav;
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Long employeeId) {
		
		employeeRepository.deleteById(employeeId);
		
		
		
		return "redirect:/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
//	@GetMapping("/new-employee")
//    public String newEmployee()
//    {
//        return "new-employee";
//    }
	

	
//	@GetMapping("/addEmployeeForm")
//	public String addEmployeeForm() {
//	    return "add-employee-form";
//	}
	
	
//	
//	  @GetMapping("/addEmployeeForm")
//	  public String handleGetRequest(Model model) {
//	      model.addAttribute("addEmployeeForm", model);
//	      return "add-employee-form";
//	  }
//	
	
//	@GetMapping("/addEmployeeForm")
//	public ModelAndView addEmployeeForm() {
//		
//		ModelAndView modelAndView = new ModelAndView("add-employee-form");
//		Employee employee = new Employee();
//		
//		modelAndView.addObject("employee", employee);
//		return modelAndView;
//		
//		
//	}
//	
	
	
//	@GetMapping("/addEmployeeForm")
//	public ModelAndView addEmployeeForm(ModelMap model) {
//		
//		model.addAttribute("attribute", "addEmployeeForm");
//		
//		return new ModelAndView("redirect:/add-employee-form", model);
//		
//	}
	
//	@GetMapping("/add-employee-form")
//	public RedirectView addEmployeeForm(RedirectAttributes attributes) {
//	 
//	    attributes.addFlashAttribute("flashAttribute", "addEmployeeForm");
//	    attributes.addAttribute("attribute", "addEmployeeForm");
//	    return new RedirectView("add-employee-form");
//	}
	
	
	
	
	

}
