package cn.iflin.project.participle.englishwords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnglishParser {
//	public static void main(String[] args) {
//		testReg("B. Closing offices on holidays.");
//	}

	public static String delPunctuation(String text) {
		// 先去掉标点,再合并空格
		Pattern p = Pattern.compile("[(.|,|\"|\\?|!|:;')]");// 这边增加所有的符号,例如要加一个'则变成[(.|,|\"|\\?|!|:|')],如果是特殊符号要加转换
		Matcher m = p.matcher(text);// 这为要整理的字符串
		String first = m.replaceAll("");
		p = Pattern.compile("   {2,}");
		m = p.matcher(first);
		String second = m.replaceAll("");
		return second;
	}
	//判断单词是否属于某一分类
	public static boolean checkEnglishWord(String checkWord, String englishClass) {
		ArrayList<String> words = getEnglishWords(englishClass);
		for (String word : words) {
			if (word.equals(checkWord)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取单词列表
	 * 
	 * @param sourceName
	 *            单词级别
	 * @return 单词列表
	 */
	public static ArrayList<String> getEnglishWords(String sourceName) {
		ArrayList<String> words = new ArrayList<String>();
		String filePath = "C:\\Spider\\EnglishWords\\" + sourceName + ".txt";
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader br = new BufferedReader(read);
				String lineText = null;
				while ((lineText = br.readLine()) != null) {
					words.add(lineText);
				}
				read.close();
			} else {
				System.out.println("找不到指定文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件出错");
			e.printStackTrace();
		}
		return words;

	}
}
