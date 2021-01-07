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

	@RequestMapping("/dashboard/notifications")
	public ModelAndView notifications() { return new ModelAndView("notifications"); }

	@RequestMapping("/profile")
	public ModelAndView profile() { return new ModelAndView("profile"); }

	@RequestMapping("/modifyprofile")
	public ModelAndView modifyprofile() { return new ModelAndView("modifyprofile"); }

	@RequestMapping("/admin/deleteUsers")
	public ModelAndView deleteUsers() { return new ModelAndView("deleteModifyUsers"); }

	@RequestMapping("/admin/deletePlaces")
	public ModelAndView deletePlaces() { return new ModelAndView("deleteModifyPlaces"); }

	@RequestMapping("/admin/deleteActivites")
	public ModelAndView deleteActivites() { return new ModelAndView("deleteModifyActivites"); }

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