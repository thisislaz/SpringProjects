package com.lazaro.dojoninjaassign.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lazaro.dojoninjaassign.models.Dojo;
import com.lazaro.dojoninjaassign.models.Ninja;
import com.lazaro.dojoninjaassign.services.DojoService;
import com.lazaro.dojoninjaassign.services.NinjaService;

@Controller
public class HomeController {

	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/")
	public String index(Model model) {
		//grab the list from dbs
		//send the list of donations to the jsp
		model.addAttribute("dojoList", dojoService.allDojos());
		model.addAttribute("ninjaList", ninjaService.allNinjas());
		return "dashboard.jsp";
	}
	
	
	// ----------- CREATE DOJO-------------
	//render the form
	@GetMapping("/dojos/new")				
	public String renderUserform(@ModelAttribute("dojo")Dojo dojo) {
		return "createDojo.jsp";
	}
	
	//process the form
	@PostMapping("/dojos/new")
	public String processUserform(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "createDojo.jsp";
		} else {
			dojoService.saveDojo(dojo);
			return "redirect:/";
		}
	}
	
	// ----------- CREATE NINJA -------------
		//render the form
		@GetMapping("/ninjas/new")
		public String renderNinjaForm(@ModelAttribute("ninja")Ninja ninja, Model model) {
			//grab the userList and send to the jsp
			List<Dojo> dojoList = dojoService.allDojos();
			model.addAttribute("dojoList", dojoList);
			return "createNinja.jsp";
		}
		
		//process the form
		@PostMapping("/ninjas/new")
		public String processNinjaForm(
				@Valid @ModelAttribute("ninja") Ninja ninja,
				BindingResult result,
				Model model
				) {
			if(result.hasErrors()) {
				//logic after failed form
				List<Dojo> dojoList = dojoService.allDojos();
				model.addAttribute("dojoList", dojoList);
				return "createNinja.jsp";
			} else {
				ninjaService.saveNinja(ninja);
				return "redirect:/";
			}
		}
	
		// ----------- FIND ONE -------------
		@GetMapping("/dojos/{id}")
		public String getOneDojo(
				@PathVariable("id")Long id,
				Model model
				) {
			model.addAttribute("dojo", dojoService.oneDojo(id));
			return "dojoDetails.jsp";
		}
		
}
