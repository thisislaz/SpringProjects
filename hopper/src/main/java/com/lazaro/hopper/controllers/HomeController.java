package com.lazaro.hopper.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String index(Model model) {
		String name = "Grace Hopper";
		String itemName = "Copper wire";
		double price = 5.25;
		String description = "Metal stripes, also an illustration of anonseconds";
		String vendor = "Little Things Corner Store";
		
		
		model.addAttribute("name", name);
		model.addAttribute("itemName",itemName);
		model.addAttribute("price", price);
		model.addAttribute("description", description);
		model.addAttribute("vendor", vendor);
		
		
		return "index.jsp";
	}
	
	@RequestMapping("/time")
	public String datePage(Model model) {
		Date date = new Date();
		SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm aa");
		String time = formatTime.format(date);
		model.addAttribute("date", time);
		
		return "date.jsp";
	}
	
	@RequestMapping("/date")
	public String timePage(Model model) {
		Date date = new Date();
		SimpleDateFormat formatTime = new SimpleDateFormat("EEEE, dd MMMM, yyyy");
		String time = formatTime.format(date);
		model.addAttribute("date", time);
		return "time.jsp";
	}
}
