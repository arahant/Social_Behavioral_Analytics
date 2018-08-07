package sba.official.news.crawler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import sba.official.news.article.Article;
import sba.official.news.source.Source;

import org.jsoup.Jsoup;

public class NewsCrawlerRss {

	protected static final String KEY_TITLE = "title";
	protected static final String KEY_LINK = "link";
	protected static final String KEY_DATE = "pubDate";

	protected List<Source> feeds;
	protected TreeSet<Article> item_list;
	protected static HashSet<Article> cache;
	protected static final int CACHE_SIZE = 50;
	protected int max;
	
	public NewsCrawlerRss(int max, List<Source> feeds) {
		item_list = new TreeSet<>();
		this.max=max;
		this.feeds=feeds;
		if(cache==null)
			cache = new HashSet<>();
	}
	
	public TreeSet<Article> getArticleList() {
		return item_list;
	}
	public static HashSet<Article> getCache() {
		return cache;
	}
	
	protected boolean verifyURL(String url) {
		try {
			new URI(url);
			if(Jsoup.connect(url).ignoreHttpErrors(true).execute().statusCode()<400)
				return true;
		} catch (URISyntaxException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
