package com.grayda.projectportfolio.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.grayda.projectportfolio.models.Comment;
import com.grayda.projectportfolio.models.Employee;
import com.grayda.projectportfolio.models.Item;
import com.grayda.projectportfolio.models.LoginUser;
import com.grayda.projectportfolio.models.User;
import com.grayda.projectportfolio.services.CommentService;
import com.grayda.projectportfolio.services.EmployeeService;
import com.grayda.projectportfolio.services.ItemService;
import com.grayda.projectportfolio.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	CommentService commentService;
	
	
	@GetMapping("/")
	public String aboutUs(@ModelAttribute("theComment") Comment theComment,
			Model model) {
		
		model.addAttribute("showComment", commentService.s_allComment());
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String comment(@Valid@ModelAttribute("theComment") Comment theComment,
			BindingResult result,
			Model model) {

		if(commentService.s_dupComment(theComment, result)==null) {
			model.addAttribute("showComment", commentService.s_allComment());
			return "index.jsp";
		}
		if(result.hasErrors()) {
			model.addAttribute("showComment", commentService.s_allComment());
			return "index.jsp";			
		}
		commentService.s_addComment(theComment);
		return "redirect:/";
	}
	
	@GetMapping("/mainpage")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "login.jsp";
	}
	
	@PostMapping("/register")
	public String reg(@Valid@ModelAttribute("newUser") User newUser,
			BindingResult result, 
			HttpSession session, 
			Model model) {
		
		User user = userService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}		
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";		
	}
	
	@PostMapping("/login")
	public String log(@Valid@ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result, 
			HttpSession session, 
			Model model) {
		
		User user = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}		
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";	
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model,
			HttpSession session) {
		
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}	
		
		Long id = (Long) session.getAttribute("userId");
		User user = userService.findById(id);

		model.addAttribute("user", user);

		return "dashboard.jsp";
	}
	
	@GetMapping("/inventory")
	public String inventory(Model model, @ModelAttribute("inventory") Item inventory ,HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}	
		Long id = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(id));
		model.addAttribute("items", itemService.s_allItem());
		return "inventory.jsp";
	}
	
	@PostMapping("/inventory")
	public String inventory(@Valid@ModelAttribute("inventory") Item inventory,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("items", itemService.s_allItem());
			return "inventory.jsp";
		}
		itemService.s_addItem(inventory);
		return "redirect:/inventory";
	}
	
	@GetMapping("/edit/inventory/{id}")
	public String editInventory(@PathVariable("id") Long id, 
			@ModelAttribute("editItems") Item editItems, 
			HttpSession session,
			Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}	
		Long id2 = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(id2));		
		model.addAttribute("items", itemService.s_findItem(id));
		return "itemEdit.jsp";
	}
	
	@PostMapping("/edit/inventory/{id}")
	public String editInventory(@PathVariable("id") Long id,
			@Valid@ModelAttribute("editItems") Item editItems,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("items", itemService.s_findItem(id));
			return "itemEdit.jsp";	
		}
		itemService.s_updateItem(editItems);
		return "redirect:/inventory";
	}
	
	@GetMapping("/delete/inventory/{id}")
	public String deleteInventory(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}	
		itemService.s_deleteItem(id);
		return "redirect:/inventory";
	}
	
	@GetMapping("/employees")
	public String employees(@ModelAttribute("employees") Employee employees,
			Model model,
			HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}	
		Long id = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(id));		
		model.addAttribute("workSched", employeeService.s_allEmployee());

		return "employees.jsp";
	}
	
	@PostMapping("/employees")
	public String employees(@Valid@ModelAttribute("employees") Employee employees,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {	
			model.addAttribute("workSched", employeeService.s_allEmployee());
			return "employees.jsp";
		}
		employeeService.s_addEmployee(employees);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
	public String stats(@PathVariable("id") Long id,
			@ModelAttribute("selStat") Employee selStat,
			Model model,
			HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}	
		Long id2 = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(id2));		
		model.addAttribute("stat", employeeService.s_findEmployee(id));
		return "employeesStatus.jsp";
	}
	@PostMapping("/employees/{id}")
	public String stats(@PathVariable("id") Long id, 
			@Valid@ModelAttribute("selStat") Employee selStat,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			return "employeesStatus.jsp";
		}
		employeeService.s_addEmployee(selStat);

		return "redirect:/employees";
	}
	
	@GetMapping("/delete/employees/{id}")
	public String deleteEmployees(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}	
		employeeService.s_deleteEmployee(id);
		return "redirect:/employees";
	}	
	

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
