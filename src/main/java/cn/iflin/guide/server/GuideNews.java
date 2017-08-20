package cn.iflin.guide.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.iflin.guide.model.ArticleModel;
import cn.iflin.guide.model.MysqlConnection;



public class GuideNews {
	/**
	 * 获取已爬取的文章列表
	 */
	public static ArrayList<ArticleModel> getSpiderArticle(String source) {
		ArrayList<ArticleModel> articleList = new ArrayList<ArticleModel>();
		Connection conn = MysqlConnection.getConnection();
		// 通过数据的连接操作数据库
		String sql = "SELECT * FROM context WHERE Source='" + source + "' order by ArticleId desc LIMIT 5";
		Statement stmt;
		ResultSet result = null;
		String articleId, title,url;
		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			if (result == null) {
				ArticleModel am = new ArticleModel();
				am.setTitle("暂无文章");
				articleList.add(am);
				return articleList;
			}
			while (result.next()) {
				articleId = result.getString("ArticleId");
				title = result.getString("Title");
				url = result.getString("Url");
				ArticleModel am = new ArticleModel();
				am.setArticleId(articleId);
				am.setTitle(title);
				am.setUrl(url);
				articleList.add(am);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articleList;
	}
}
