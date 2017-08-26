package cn.iflin.project.participle.wordcloud;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.DocsEnum;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import cn.iflin.project.model.WordModel;
import cn.iflin.project.participle.WordsParticiple;
import cn.iflin.project.participle.englishwords.EnglishParser;

/**
 * 计算词频
 * 
 * @author Jaypan
 *
 */
public class CalculateChineseFrequency  extends WordsParticiple{
	
	/**
	 * 返回排序后的词频
	 * 
	 * @param text 需分词内容
	 * @param articleId 分词内容 属性 （数据库or用户自定义(temp)）
	 * @param tag English：siji、liuji、kaoyan;Chinese：chinese
	 * @return
	 */
	public static ArrayList<WordModel> getWordFre(String text, String articleId) {
		ArrayList<WordModel> wordList = new ArrayList<WordModel>();
		try {
			wordList = getTF(text, articleId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 定义排序规则
		class SortByFre implements Comparator {
			public int compare(Object o1, Object o2) {
				WordModel s1 = (WordModel) o1;
				WordModel s2 = (WordModel) o2;
				return s2.getWordFrequency().compareTo(s1.getWordFrequency());
			}
		}
		Collections.sort(wordList, new SortByFre());
		return wordList;
	}
}
