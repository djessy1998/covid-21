package com.covid.covid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class MapController {

	@RequestMapping("/")
	public ModelAndView defaultHome() {
		return new ModelAndView("login");
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		return new ModelAndView("logout");
	}

	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping("/profile")
	public ModelAndView profile() { return new ModelAndView("profile"); }

	@RequestMapping("/addfriend")
	public ModelAndView addfriend() { return new ModelAndView("addfriend"); }

	@RequestMapping("/dashboard")
	public ModelAndView userDashboard() {
		return new ModelAndView("dashboard");
	}

	@RequestMapping("/admin/")
	public ModelAndView admin() {
		return new ModelAndView("admin/login");
	}

	@RequestMapping("/admin/login")
	public ModelAndView adminlogin() {
		return new ModelAndView("admin/login");
	}

	@RequestMapping("/admin/dashboard")
	public ModelAndView admindashboard() {
		return new ModelAndView("admin/dashboard");
	}
}