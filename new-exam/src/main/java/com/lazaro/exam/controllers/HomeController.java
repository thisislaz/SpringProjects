package com.lazaro.exam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lazaro.exam.models.Course;
import com.lazaro.exam.models.LoginUser;
import com.lazaro.exam.models.User;
import com.lazaro.exam.services.CourseService;
import com.lazaro.exam.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseService courseService;
	
	//------------- LOGIN & REGISTRATION ---------------
	//render the login register form
		@GetMapping("/")
		public String renderLogReg(Model model) {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "loginregform.jsp";
		}
		
	//userId is what's used in the drop down selection option section
		@PostMapping("/register")
		public String processRegister(
				@Valid @ModelAttribute("newUser") User newUser,
				BindingResult result,
				Model model,
				HttpSession session
				) {
			 userService.register(newUser, result);
			 if(result.hasErrors()) {
		            model.addAttribute("newLogin", new LoginUser());
		            return "loginregform.jsp";
			 }
			 session.setAttribute("userId", newUser.getId());
			 return "redirect:/courses";
		            
		}
	
	//userId is what's used in the drop down selection option section
		@PostMapping("/login")
		public String processLogin(
				@Valid @ModelAttribute("newLogin") LoginUser newLogin,
				BindingResult result,
				Model model,
				HttpSession session
				) {
			User user = userService.login(newLogin, result);
			
			if(result.hasErrors()) {
				model.addAttribute("newUser", new User());
				return "loginregform.jsp";
			}
			session.setAttribute("userId", user.getId());
			return "redirect:/courses";
		}
		
		
	//------------- LOGOUT ---------------
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate(); //clears all sessions
			return "redirect:/";
		}	
		
	//------------- DASHBOARD ---------------
	//userId is what's used in the drop down selection option section
		@GetMapping("/courses")
		public String allCourses(HttpSession session, Model model) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			
			User user = userService.oneUser((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			
			List<Course> courseList = courseService.allCourses();
			model.addAttribute("courseList", courseList);
			return "dashboard.jsp";
		}	
		
	//------------- CREATE ---------------
	//render the form
		@GetMapping("/courses/add")
		public String renderCreateCourse(
				@ModelAttribute("course")Course course,
				HttpSession session
				) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			return "createCourse.jsp";
		}
		
	//process the form
		@PostMapping("/courses/add")
		public String processCreateCourse(
				@Valid @ModelAttribute("course") Course course,
				BindingResult result
				) {
			if(result.hasErrors()) {
				return "createCourse.jsp";
			} else {
				courseService.createCourse(course);
				return "redirect:/courses";
			}
		}
		
	//------------- EDIT ---------------
	//rendering
		@GetMapping("/courses/edit/{id}")
		public String renderEditCourse(
				@PathVariable("id")Long id, 
				Model model,
				HttpSession session
				) {
			Course course = courseService.oneCourse(id);
			if(course.getInstructor().getId() != (Long)session.getAttribute("userId")) {
				return "redirect:/courses";
			}
			model.addAttribute("course", course );//courseService.oneCourse(id)
			return "editCourse.jsp";
		}
		
	//processing
		@PutMapping("/courses/edit/{id}")
		public String processEditCourse(
				@Valid @ModelAttribute("course") Course course,
				BindingResult result,
				HttpSession session
				) {
			if(course.getInstructor().getId() != (Long)session.getAttribute("userId")) {
				return "redirect:/courses";
			}
			if(result.hasErrors()) {
				return "editCourse.jsp";
			} else {
				courseService.updateCourse(course);
				return "redirect:/courses";
			}
		}
		
	//------------- DELETE ---------------
		@DeleteMapping("/courses/delete/{id}")
		public String deleteCourse(
				@PathVariable("id")Long id
				) {
			courseService.deleteCourse(id);
			return "redirect:/courses";
		}
	
	//------------ FINDONE ----------	
		@GetMapping("/courses/{id}")
		public String oneCourse(
				@PathVariable("id")Long id,
				Model model
				) {
			model.addAttribute("course", courseService.oneCourse(id));
			return "courseDetails.jsp";
		}
		
		
		
		
		
		
}
