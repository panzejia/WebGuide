package cn.iflin.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	@RequestMapping("/about")
	public String getEnglishPage(Model model) {
		return "about";
	}
}
