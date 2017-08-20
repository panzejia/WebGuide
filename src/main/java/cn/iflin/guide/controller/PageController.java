package cn.iflin.guide.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.iflin.guide.server.GuideNews;


@Controller
public class PageController {
	@RequestMapping("")
	public String getIndex1(Model model) {
		model.addAttribute("glxy", GuideNews.getSpiderArticle("管理学院"));
		model.addAttribute("jwc", GuideNews.getSpiderArticle("北师珠教务处"));
		model.addAttribute("ithome", GuideNews.getSpiderArticle("IT之家"));
		return "forward:index.jsp";
	}
	@RequestMapping("/index.html")
	public String getIndex(Model model) {
		model.addAttribute("glxy", GuideNews.getSpiderArticle("管理学院"));
		model.addAttribute("jwc", GuideNews.getSpiderArticle("北师珠教务处"));
		model.addAttribute("ithome", GuideNews.getSpiderArticle("IT之家"));
		return "forward:index.jsp";
	}
}
