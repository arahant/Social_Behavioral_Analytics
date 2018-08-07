package sba.official.news.crawler;

import java.io.IOException;
import java.util.List;

import sba.official.news.article.Article;
import sba.official.news.article.ScrapeArticle;
import sba.official.news.source.Source;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewsCrawlerSearch extends NewsCrawlerRss implements Runnable {
	
	public NewsCrawlerSearch(int max, List<Source> feeds) {
		super(max, feeds);
	}
	
	public void run() {
		String key = Thread.currentThread().getName();
		System.err.println("Crawling for articles matching - "+key);
		//key = normalizeKey(key);
		String regexp = ".*\\b"+key+"\\b.*";
		ScrapeArticle scrape = new ScrapeArticle();
		try {
			for(Source source:feeds) {
			String url = source.getLink(); 
			if(verifyURL(url)) {
				Elements items = Jsoup.connect(url).get().getElementsByTag("item");
				int n=items.size();
				if(n>max) {
					for(int i=n-1;i>=max;i--)
						items.remove(i);
				}
				for(Element item:items) {
					String link = item.getElementsByTag(KEY_LINK).get(0).text();
					String title = item.getElementsByTag(KEY_TITLE).get(0).text();
					Article article = new Article(link);
					if(cache.add(article)) {
						if(title.toLowerCase().matches(regexp)) {
							cache.remove(article);
							article = scrape.scrape(item);
							cache.add(article);
							item_list.add(article);
						}
						else cache.remove(article);
					}
					else article=null;
				}
			}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.err.println("Cache size "+cache.size());
	}
	
	/*private String normalizeKey(String key) {
		return key.toLowerCase();
	}*/

}
