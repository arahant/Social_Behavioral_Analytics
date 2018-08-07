package sba.official.news.crawler;

import java.io.IOException;
import java.util.List;

import sba.official.news.article.ScrapeArticle;
import sba.official.news.source.Source;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewsCrawlerCategory extends NewsCrawlerRss implements Runnable {
	
	public NewsCrawlerCategory(int max, List<Source> feeds) {
		super(max, feeds);
	}

	public void run() {
		System.err.println("Crawling through the rss feeds...");
		try {
			ScrapeArticle scrape = new ScrapeArticle();
			for(Source source:feeds) {
				String url = source.getLink(); 
				if(verifyURL(url)) {
					Elements items = Jsoup.connect(url).get().getElementsByTag("item");
					int n=items.size();
					System.err.println("Extracting "+(n>max?max:n)+" out of "+n+" articles from "+url);
					if(n>max) {
						for(int i=n-1;i>=max;i--)
							items.remove(i);
					}
					for(Element item:items) {
						item_list.add(scrape.scrape(item));
					}
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
