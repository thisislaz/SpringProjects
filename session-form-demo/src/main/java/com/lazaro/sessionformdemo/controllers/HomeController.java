package com.lazaro.sessionformdemo.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			@RequestParam("reviewer") String reviewer,
			HttpSession session,
			RedirectAttributes redirectAttributes
			) {
		//process the info
		if(rating < 0) {
			redirectAttributes.addFlashAttribute("error", "Rating must be positive");
			return "redirect:/reviewForm";
		}
		session.setAttribute("product", product);
		session.setAttribute("comments", comments);
		session.setAttribute("rating", rating);
		session.setAttribute("reviewer", reviewer);
		
		return "redirect:/displayReview";
	}
	
	@GetMapping("/displayReview")
	public String displayReview() {
		return"/reviewForm/reviewFormDisplay.jsp";
	}
	
	//-------------------------RESERVATIONFORM (DATE/TIME, POST METHOD) --------------------------
	//Render the form
	@GetMapping("/reserve")
	public String renderReserveForm() {
		return "/reservationForm/reservationForm.jsp";
	}
	
	//process the form
	@PostMapping("/processReservation")
	public String processReservation(
			@RequestParam("name") String name,
			@RequestParam("numOfPeople") Integer numOfPeople,
			@RequestParam("resDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date resDate,
			@RequestParam("resTime") @DateTimeFormat(pattern="HH:mm") Date resTime,
			HttpSession session
			) {
		
		session.setAttribute("name", name);
		session.setAttribute("numOfPeople", numOfPeople);
		session.setAttribute("resDate", resDate);
		session.setAttribute("resTime", resTime);
		
		return "redirect:/reserveResult";
	}
	
	//display the form
	@GetMapping("/reserveResult")
	public String displayReservationResult() {
		return "reservationForm/reservationDisplay.jsp";
	}
	
	
	
}
