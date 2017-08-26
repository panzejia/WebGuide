package cn.iflin.project.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.iflin.project.model.ArticleModel;
import cn.iflin.project.model.WordModel;
import cn.iflin.project.participle.wordcloud.CalculateChineseFrequency;
import cn.iflin.project.participle.wordcloud.ChineseParser;


@Controller
public class WordCloudController {
	@RequestMapping("/wordcloud")
	public String getEnglishPage(Model model) {
		return "wordcloud/wordcloud";
	}
	
	@RequestMapping(value = "/wordcloud/doResult", method = RequestMethod.POST)
	public String getWordFreTemp(@RequestParam("content") String content, Model model) {
		ArrayList<WordModel> wordList = CalculateChineseFrequency.getWordFre(content, "temp");
		WordModel word;
		String datas = "";
		if(wordList.size()>20){
			for (int i = 0; i < 20; i++) {
				word=wordList.get(i);
				datas += word.getWord()+",";
			}
		}else{
			for (int i = 0; i < wordList.size(); i++) {
				word=wordList.get(i);
				datas += word.getWord()+",";
			}
		}
		model.addAttribute("data", content);
		model.addAttribute("wordList", wordList);
		model.addAttribute("total", wordList.size());
		model.addAttribute("chinesecloudcontent", datas);
		return "wordcloud/freView";
	}

//	@RequestMapping(value = "/getWordCloudDraw", method = RequestMethod.POST)
//	public void getWordCloudDraw(HttpServletRequest request, HttpServletResponse response,@RequestParam("articleId") String articleId) {
//		ArticleModel article = ArticleSqlConfiguration.getArticleInfo(articleId);
//		ArrayList<WordModel> wordList = WordCloud.getWordFre(article.getContent(), articleId,"chinese","");
//		String[] data = new String[20];
//		WordModel word;
//		if(wordList.size()>20){
//			for (int i = 0; i < 20; i++) {
//				word=wordList.get(i);
//				data[i] = word.getWord();
//			}
//		}else{
//			for (int i = 0; i < wordList.size(); i++) {
//				word=wordList.get(i);
//				data[i] = word.getWord();
//			}
//		}
//		
//		ResponseJsonUtils.json(response, data);  
//	}
	@RequestMapping(value = "/getWordCloudDrawByUser", method = RequestMethod.POST)
	public void getWordCloudDrawByUser(HttpServletRequest request, HttpServletResponse response,@RequestParam("content") String content) {
		String[] data = ChineseParser.changeList(content);
		ResponseJsonUtils.json(response, data);  
	}
}
