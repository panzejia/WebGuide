package cn.iflin.project.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.iflin.project.model.WordModel;
import cn.iflin.project.participle.englishwords.CalculateEnglishFrequency;
import cn.iflin.project.participle.englishwords.EnglishParser;

@Controller
public class EnglishController {
	@RequestMapping("/english")
	public String getEnglishPage(Model model) {
		return "english/english";
	}
	
	@RequestMapping("/english/kaoyan")
	public String getKaoyanPage(Model model) {
		model.addAttribute("vocabulary",EnglishParser.getEnglishWords("kaoyan"));
		model.addAttribute("classification","考研");
		return "english/vocabulary";
	}
	
	@RequestMapping("/english/cet4")
	public String getCET4Page(Model model) {
		model.addAttribute("vocabulary",EnglishParser.getEnglishWords("cet4"));
		model.addAttribute("classification","四级");
		return "english/vocabulary";
	}
	
	@RequestMapping(value = "/english/doResult", method = RequestMethod.POST)
	public String getEnglishResult(@RequestParam("content") String content,@RequestParam("englishClass") String englishClass, Model model) {
		ArrayList<WordModel> wordList = CalculateEnglishFrequency.getWordFre(content, "temp",englishClass);
		model.addAttribute("data", content);
		model.addAttribute("wordList", wordList);
		model.addAttribute("total", wordList.size());
		return "english/freView";
	}
}
