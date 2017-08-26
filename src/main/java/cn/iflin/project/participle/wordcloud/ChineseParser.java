package cn.iflin.project.participle.wordcloud;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChineseParser {
	// 判断一个字符是否是中文
	private static boolean isChinese(char c) {
		return c >= 0x4E00 && c <= 0x9FA5;// 根据字节码判断
	}

	// 判断一个字符串是否含有中文
	public static boolean isChinese(String str) {
		if (str == null)
			return false;
		for (char c : str.toCharArray()) {
			if (isChinese(c))
				return true;// 有一个中文字符就返回
		}
		return false;
	}
	//将一句话转换成数组
	public static String[] changeList(String s) {
		String[] data =new String[20];
		Pattern pattern =  Pattern.compile("[\u4e00-\u9fa5]*");
		Matcher matcher = pattern.matcher(s);
		int i =0;
		while (matcher.find()){
			if(matcher.group().equals("")){
				continue;
			}
			data[i]=matcher.group();
			i++;
		}
		return data;
	}
}
