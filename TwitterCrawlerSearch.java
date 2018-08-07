package sba.social.twitter.crawler;

import java.io.IOException;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sba.social.twitter.tweet.Tweet;

public class TwitterCrawlerSearch extends TwitterCrawler implements Runnable {
	
	private static final String SEARCH_LINK = "https://twitter.com/search?q=";
	private static final String TAG_HEADER = "stream-item-header";
	private static final String TAG_DATE = "[data-original-]?title";
	private static final String TAG_BODY1 = "js-tweet-text-container";
	private static final String TAG_BODY2 = "TweetTextSize js-tweet-text tweet-text";
	private static final String TAG_HREF = "href";
	private static final String TAG_REGEX = "<.*>";
	
	/*<li class="js-stream-item stream-item stream-item">
	 * 	<div class="content">
	 *		<div class="stream-item-header">
	 *			<a href="/author">
	 *			<small class="time">
	 *				<a data-original-title="9:01 am - 29 Jul 2018">
	 *		<div class="js-tweet-text-container">
	 *			<p class="... js-tweet-text tweet-text">body</p>
	 * */

	public void run() {
		String key = Thread.currentThread().getName();
		String search_url = SEARCH_LINK+key;
		try {
			if(verifyURL(search_url)) {
				Elements twitter_tweets = Jsoup.connect(search_url).get().getElementsByClass("js-stream-item stream-item stream-item");
				tweets = new LinkedList<>();
				for(Element post:twitter_tweets) {
					Element div = post.getElementsByClass("content").first();
					
					Element header = div.getElementsByClass(TAG_HEADER).first();
					String author = header.getElementsByTag("a").first().attr(TAG_HREF);
					String date = header.getElementsByTag("small").first().getElementsByTag("a").attr(TAG_DATE);
					String link = header.getElementsByTag("small").first().getElementsByTag("a").attr(TAG_HREF);
					
					Element body = post.getElementsByClass(TAG_BODY1).first().getElementsByClass(TAG_BODY2).first();
					String text = body.text().replaceAll(TAG_REGEX, "");
					
					Tweet tweet = new Tweet(author, date, link, text);
					tweets.add(tweet);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
