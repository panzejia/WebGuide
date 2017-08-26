package cn.iflin.project.participle;

import java.io.File;
import java.io.IOException;
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
import cn.iflin.project.participle.englishwords.EnglishParser;
import cn.iflin.project.participle.wordcloud.ChineseParser;

public class WordsParticiple {
	/**
	 * 判断文件夹是否存在之后调用索引计算词频
	 */
	private static ArrayList<WordModel> checkFile(String text, String articleId) {
		ArrayList<WordModel> wordList = new ArrayList<WordModel>();
		return wordList;
	}


	private static void addDoc(IndexWriter w, String text) throws IOException {
		Document doc = new Document();
		FieldType ft = new FieldType();
		ft.setIndexed(true);// 存储
		ft.setStored(true);// 索引
		ft.setStoreTermVectors(true);
		ft.setTokenized(true);
		ft.setStoreTermVectorPositions(true);// 存储位置
		ft.setStoreTermVectorOffsets(true);// 存储偏移量
		doc.add(new Field("text", text, ft));
		w.addDocument(doc);
	}

	/**
	 * 删除文件
	 * 
	 * @param dir
	 * @return
	 */
	private static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}

	/**
	 * 计算英文词频
	 * 
	 * @param text
	 * @return
	 * @throws IOException
	 */
	 public static ArrayList<WordModel> getTF(String text, String articleId, String tag) throws IOException {
		ArrayList<WordModel> wordList = new ArrayList<WordModel>();
		File file = new File("C:\\Spider\\WordCloud_Lucene\\" + articleId);
		WordsParticiple.deleteDir(file);
		Analyzer analyzer = new IKAnalyzer(true);// 智能分词模式，如果构造函数参数为false，那么使用最细粒度分词。
		IndexWriterConfig configfile = new IndexWriterConfig(Version.LUCENE_47, analyzer);// 创建索引的配置信息
		Directory fileindex;
		fileindex = FSDirectory.open(file);
		IndexWriter filew = new IndexWriter(fileindex, configfile);
		try {
			WordsParticiple.addDoc(filew, text);
		} finally {
			// 统一释放内存
			filew.close();
		}
		try {
			IndexReader reader = DirectoryReader.open(fileindex);
			for (int i = 0; i < reader.numDocs(); i++) {
				int docId = i;
				Terms terms = reader.getTermVector(docId, "text");
				if (terms == null)
					continue;
				TermsEnum termsEnum = terms.iterator(null);
				BytesRef thisTerm = null;
				while ((thisTerm = termsEnum.next()) != null) {
					String termText = thisTerm.utf8ToString();
					DocsEnum docsEnum = termsEnum.docs(null, null);
					while ((docsEnum.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
						if(tag.equals("noLevel")){
							WordModel wm = new WordModel();
							wm.setWord(termText);
							wm.setWordFrequency(docsEnum.freq());
							wordList.add(wm);
						}
						else if (EnglishParser.checkEnglishWord(termText, tag)) {
							WordModel wm = new WordModel();
							wm.setWord(termText);
							wm.setWordFrequency(docsEnum.freq());
							wordList.add(wm);
						}
					}
				}
			}
			reader.close();
			fileindex.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wordList;
	}

	/**
	 * 计算中文词频
	 * 
	 * @param text
	 * @return
	 * @throws IOException
	 */
	 public static ArrayList<WordModel> getTF(String text, String articleId) throws IOException {
		ArrayList<WordModel> wordList = new ArrayList<WordModel>();
		File file = new File("C:\\Spider\\WordCloud_Lucene\\" + articleId);
		WordsParticiple.deleteDir(file);
		Analyzer analyzer = new IKAnalyzer(true);// 智能分词模式，如果构造函数参数为false，那么使用最细粒度分词。
		IndexWriterConfig configfile = new IndexWriterConfig(Version.LUCENE_47, analyzer);// 创建索引的配置信息
		Directory fileindex;
		fileindex = FSDirectory.open(file);
		IndexWriter filew = new IndexWriter(fileindex, configfile);
		try {
			WordsParticiple.addDoc(filew, text);
		} finally {
			// 统一释放内存
			filew.close();
		}
		try {
			IndexReader reader = DirectoryReader.open(fileindex);
			for (int i = 0; i < reader.numDocs(); i++) {
				int docId = i;
				Terms terms = reader.getTermVector(docId, "text");
				if (terms == null)
					continue;
				TermsEnum termsEnum = terms.iterator(null);
				BytesRef thisTerm = null;
				while ((thisTerm = termsEnum.next()) != null) {
					String termText = thisTerm.utf8ToString();
					DocsEnum docsEnum = termsEnum.docs(null, null);
					while ((docsEnum.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
						if (ChineseParser.isChinese(termText) && termText.length() >= 2) {
							WordModel wm = new WordModel();
							wm.setWord(termText);
							wm.setWordFrequency(docsEnum.freq());
							wordList.add(wm);
						}
					}
				}
			}
			reader.close();
			fileindex.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wordList;
	}

	// public static void main(String[] args) {
	// System.out.println(notEnglishStopWord("asdgsa"));
	// }
}
