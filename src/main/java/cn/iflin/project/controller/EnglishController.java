package cn.iflin.project.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.iflin.project.model.WordModel;
import cn.iflin.project.wordcloud.WordCloud;

@Controller
public class EnglishController {
	@RequestMapping("/english.html")
	public String getIndex(Model model) {
		return "english/english";
	}
	
	@RequestMapping(value = "/getEnglishFreTemp", method = RequestMethod.POST)
	public String getEnglishFreTemp(@RequestParam("content") String content,@RequestParam("englishClass") String englishClass, Model model) {
		ArrayList<WordModel> wordList = WordCloud.getWordFre(content, "temp","english",englishClass);
		model.addAttribute("data", content);
		model.addAttribute("wordList", wordList);
		model.addAttribute("total", wordList.size());
		return "english/freView";
	}
}
