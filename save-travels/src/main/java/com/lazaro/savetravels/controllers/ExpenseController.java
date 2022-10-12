package com.lazaro.savetravels.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lazaro.savetravels.models.Expense;
import com.lazaro.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public String index(
			@ModelAttribute("expense")Expense expense,
			Model model
			) {
		model.addAttribute("expenses", expenseService.allExpenses());
		return "/expenses.jsp";
	}
	
	@PostMapping("/expenses")
	public String createNewExpense(
			@Valid @ModelAttribute("expense")Expense expense,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "/expenses.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	
	@RequestMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "/edit.jsp";
	}
	
	@RequestMapping(value="/expenses/{id}",method=RequestMethod.PUT)
	public String update(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "/edit.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@RequestMapping(value="/expenses/{id}", method=RequestMethod.DELETE)
	public String destory(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/{id}")
	public String viewOne(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		List<Expense> expenses = expenseService.allExpenses();
		
		model.addAttribute("expenses", expenses);
		model.addAttribute("expense", expense);
		return "viewone.jsp";
	}
	
}




