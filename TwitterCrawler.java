package sba.social.twitter.crawler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.jsoup.Jsoup;

import sba.social.twitter.tweet.Tweet;

public class TwitterCrawler {
	
	protected List<Tweet> tweets;
	
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

	protected List<Tweet> getTweets() {
		return tweets;
	}

}
