package sba.official.news.article;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeArticle {

	protected static final String KEY_TITLE = "title";
	protected static final String KEY_LINK = "link";
	protected static final String KEY_DATE = "pubDate";
	protected static final String KEY_PROP = "property";
	protected static final String KEY_NAME = "name";
	protected static final String KEY_CONTENT = "content";
	protected static final String KEY_SOURCE = "og:site_name";
	protected static final String KEY_IMAGE = "og:image";
	protected static final String KEY_DESCR = "og:description";
	protected static final String KEY_WORD = "keyword";

	public Article scrape(Element item) {
		String title = item.getElementsByTag(KEY_TITLE).get(0).text();
		String link = item.getElementsByTag(KEY_LINK).get(0).text();
		String date = item.getElementsByTag(KEY_DATE).get(0).text();
		Article article = new Article(title,link,date);
		scrapeInner(link, article);
		System.out.println(link);
		return article;
	}

	private Article scrapeInner(String url, Article article) {
		try {
			Elements meta_property = Jsoup.connect(url).get().select("meta[property]");
			Elements meta_name = Jsoup.connect(url).get().select("meta[name]");
			
			for(Element meta:meta_property) {
				if(meta.attr(KEY_PROP).matches(KEY_DESCR)) {
					article.setDescription(meta.attr(KEY_CONTENT));
					System.out.println(meta.attr(KEY_CONTENT));
				}
				if(meta.attr(KEY_PROP).matches(KEY_IMAGE)) {
					article.setImage(meta.attr(KEY_CONTENT));
					System.out.println(meta.attr(KEY_CONTENT));
				}
				if(meta.attr(KEY_PROP).matches(KEY_SOURCE)) {
					article.setSource(meta.attr(KEY_CONTENT));
					System.out.println(meta.attr(KEY_CONTENT));
				}
			}
			String keywords=null;
			for(Element meta:meta_name) {
				if(meta.attr(KEY_NAME).matches(".*keyword.*")) {
					keywords = meta.attr(KEY_CONTENT);
					break;
				}
			}
			if(keywords!=null)
				article.setKeywords(keywords.split(","));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return article;
	}

}
