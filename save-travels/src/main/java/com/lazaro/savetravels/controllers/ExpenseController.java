package com.lazaro.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lazaro.savetravels.models.Expense;
import com.lazaro.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses/new")
	public String newExpenseView(@ModelAttribute("expense")Expense expense) {
		return "/expenses.jsp";
	}
	
	@GetMapping("/expenses")
	public String index(Model model) {
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
		return "redirect:/expenses/new";
	}
}
