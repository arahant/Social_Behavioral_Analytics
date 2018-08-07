package sba.social.twitter.crawler;

import java.io.IOException;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sba.social.twitter.tweet.Tweet;

public class TwitterCrawlerUser extends TwitterCrawler implements Runnable {
	
	private static final String SEARCH_LINK = "https://twitrss.me/twitter_user_to_rss/?user=";
	private static final String TAG_POST = "item";
	private static final String TAG_DATE = "pubDate";
	private static final String TAG_BODY = "title";
	private static final String TAG_LINK = "link";
	
	/*
	 *<item>
	 * 	<title(body)>
	 * 	<pubDate>
	 * 	<link>
	 * */

	public void run() {
		String author = Thread.currentThread().getName();
		String search_url = SEARCH_LINK+author;
		try {
			if(verifyURL(search_url)) {
				Elements twitter_tweets = Jsoup.connect(search_url).get().getElementsByTag(TAG_POST);
				for(Element post:twitter_tweets) {
					String date = post.getElementsByTag(TAG_DATE).first().text();
					String link = post.getElementsByTag(TAG_LINK).first().text();
					String body = post.getElementsByTag(TAG_BODY).first().text();
					
					Tweet tweet = new Tweet(author, date, link, body);
					tweets = new LinkedList<>();
					tweets.add(tweet);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
