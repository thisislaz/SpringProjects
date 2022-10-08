package com.lazaro.sessionformdemo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	//------------------------- SESSION --------------------------
	@GetMapping("/")
	public String setCount(HttpSession session) {
		//check if count is in the session
		if(session.getAttribute("count") == null) {
			//if not, create count as 0
			session.setAttribute("count", 0);	
		}//grab the count from the session and cast it into the right datatype
		Integer tempcount = (Integer) session.getAttribute("count");
		 //increment the count in the session
		tempcount++;
		//set the session with the new temp
		session.setAttribute("count", tempcount);
		//increment the count in the session
		return "counthome.jsp";
	}
	
	@GetMapping("/getcount")
	public String getCount() {
		return "countget.jsp";
	}
	
	//-------------------------SEARCH FORM (GET METHOD) --------------------------
	//render the form
	@GetMapping("/searchForm")
	public String searchForm() {
		return "searchForm/searchForm.jsp";
	}
	
	//localhost:8080/search?keyword=whateveryoutyped
	//display the form from result
	@GetMapping("/search")
	public String displayForm(@RequestParam("keyword") String keyword, Model model) {
		model.addAttribute("keyword", keyword);
		return "/searchForm/displayForm.jsp";
	}
	
	//-------------------------REVIEW FORM (POST METHOD) --------------------------
	//Render the form
	@GetMapping("/reviewForm")
	public String renderReviewForm() {
		return "/reviewForm/reviewForm.jsp";
	}
	
	//PROCESS FORM
	//@PostMapping("/process")
	//this is the short method above
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String processReviewForm(
			@RequestParam("product") String product,
			@RequestParam("comments") String comments,
			@RequestParam("rating") Integer rating,
			HttpSession session
			) {
		//process the info
		session.setAttribute("product", product);
		session.setAttribute("comments", comments);
		session.setAttribute("rating", rating);
		
		return "redirect:/displayReview";
	}
	
	@GetMapping("/displayReview")
	public String displayReview() {
		return"/reviewForm/reviewFormDisplay.jsp";
	}
	
}
