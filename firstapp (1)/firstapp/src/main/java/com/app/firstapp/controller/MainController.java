package com.app.firstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
@GetMapping("/")
public String showIndex() {
	return "index";
	
	
}
@PostMapping("/")
public String calc(HttpServletRequest request, RedirectAttributes attrib ) {
	int n1=Integer.parseInt(request.getParameter("n1"));
	int n2=Integer.parseInt(request.getParameter("n2"));
	String op=request.getParameter("op");
	int res=0;
	if(op.equals("add")) {
		res=n1+n2;
	}
	else if(op.equals("sub")) {
		res=n1-n2;
	}
	else if(op.equals("mult")) {
		res=n1*n2;
	}
	else if(op.equals("div")) {
		res=n1/n2;
	}
	//System.out.println("Result="+res);
	String result ="Result="+res;
	attrib.addFlashAttribute("result", result);
	
	return "redirect:/";
	
}
}
