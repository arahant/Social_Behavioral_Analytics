package sba.official.news.source;

import java.util.LinkedList;
import java.util.List;

public class NewsSource {

    public static final String KEY_LOCAL="local";
    public static final String KEY_ENTERTAINMENT="entertainment";
    public static final String KEY_INTERNATIONAL="international";
    public static final String KEY_NATIONAL="national";
    public static final String KEY_ECONOMY="economy";
    public static final String KEY_TECHNOLOGY="technology";
    public static final String KEY_SPORTS="sports";

    public List<Source> getAllFeeds() {
        List<Source> feeds = new LinkedList<>();
        feeds.addAll(getInternationalFeeds());
        //feeds.addAll(getNationalFeeds());
        //feeds.addAll(getLocalFeeds());
        //feeds.addAll(getEconomyFeeds());
        //feeds.addAll(getScienceFeeds());
        //feeds.addAll(getSportsFeeds());
        //feeds.addAll(getEntertainmentFeeds());
        return feeds;
    }

    public List<Source> getFeeds(String category) {
        List<Source> feeds = new LinkedList<>();
        switch(category) {
            case KEY_INTERNATIONAL:
                feeds = getInternationalFeeds();
                break;
            case KEY_NATIONAL:
                feeds = getNationalFeeds();
                break;
            case KEY_LOCAL:
                feeds = getLocalFeeds();
                break;

            case KEY_ECONOMY:
                feeds = getEconomyFeeds();
                break;
            case KEY_TECHNOLOGY:
                feeds = getScienceFeeds();
                break;

            case KEY_SPORTS:
                feeds = getSportsFeeds();
                break;
            case KEY_ENTERTAINMENT:
                feeds = getEntertainmentFeeds();
                break;
        }
        return feeds;
    }

    private List<Source> getInternationalFeeds() {
        List<Source> feeds = new LinkedList<>();
        String url;
//        url = "http://www.orfonline.org/feed/?post_type=research";feeds.add(new Source(url));
//        url = "http://indianexpress.com/section/world/feed/";feeds.add(new Source(url));
//        url = "http://www.thehindu.com/news/international/?service=rss";feeds.add(new Source(url));
//        url = "https://timesofindia.indiatimes.com/rssfeeds/296589292.cms";feeds.add(new Source(url));
        url = "https://timesofindia.indiatimes.com/rssfeeds/3907412.cms";feeds.add(new Source(url));
//        url = "https://timesofindia.indiatimes.com/rssfeeds/1898274.cms";feeds.add(new Source(url));
//        url = "http://www.aljazeera.com/xml/rss/all.xml";feeds.add(new Source(url));
//        url = "http://www.economist.com/feeds/print-sections/74/international.xml";feeds.add(new Source(url));
//        url = "http://www.economist.com/feeds/print-sections/75/europe.xml";feeds.add(new Source(url));
//        url = "http://www.economist.com/feeds/print-sections/73/asia.xml";feeds.add(new Source(url));
        return feeds;
    }

    private List<Source> getNationalFeeds() {
        List<Source> feeds = new LinkedList<>();
        String url;
        url = "https://economictimes.indiatimes.com/news/politics-and-nation/rssfeeds/1052732854.cms";feeds.add(new Source(url));
        url = "http://www.financialexpress.com/print/india/feed/";feeds.add(new Source(url));
        url = "http://www.hindustantimes.com/rss/india/rssfeed.xml";feeds.add(new Source(url));
        url = "http://www.thehindu.com/news/national/?service=rss";feeds.add(new Source(url));
        url = "http://www.thehindubusinessline.com/news/national/?service=rss";feeds.add(new Source(url));
        return feeds;
    }

    private List<Source> getLocalFeeds() {
        List<Source> feeds = new LinkedList<>();
        String url;
        url = "https://timesofindia.indiatimes.com/rssfeeds/-2128839596.cms";feeds.add(new Source(url));
        url = "http://www.thehindu.com/news/cities/Delhi/?service=rss";feeds.add(new Source(url));
        url = "https://timesofindia.indiatimes.com/rssfeeds/-2128830821.cms";feeds.add(new Source(url));
        url = "https://timesofindia.indiatimes.com/rssfeeds/-2128838597.cms";feeds.add(new Source(url));
        url = "http://www.thehindu.com/news/cities/Chennai/?service=rss";feeds.add(new Source(url));
        url = "https://timesofindia.indiatimes.com/rssfeeds/2950623.cms";feeds.add(new Source(url));
        url = "http://www.thehindu.com/news/cities/Bangalore/?service=rss";feeds.add(new Source(url));
        url = "https://timesofindia.indiatimes.com/rssfeeds/-2128833038.cms";feeds.add(new Source(url));
        return feeds;
    }

    private List<Source> getEconomyFeeds() {
        List<Source> feeds = new LinkedList<>();
        String url;
        url = "https://economictimes.indiatimes.com/rssfeedsdefault.cms";feeds.add(new Source(url));
        url = "https://economictimes.indiatimes.com/news/rssfeeds/1715249553.cms";feeds.add(new Source(url));
        url = "https://economictimes.indiatimes.com/news/economy/rssfeeds/1373380680.cms";feeds.add(new Source(url));
        url = "https://economictimes.indiatimes.com/wealth/tax/rssfeeds/47119912.cms";feeds.add(new Source(url));

        url = "http://www.financialexpress.com/feed/";feeds.add(new Source(url));
        url = "http://www.financialexpress.com/economy/feed/";feeds.add(new Source(url));
        url = "http://www.financialexpress.com/market/feed/";feeds.add(new Source(url));
        url = "http://www.financialexpress.com/market/world-markets/feed/";feeds.add(new Source(url));
        url = "http://www.financialexpress.com/industry/feed/";feeds.add(new Source(url));

        url = "http://www.thehindu.com/business/?service=rss";feeds.add(new Source(url));
        url = "http://www.thehindubusinessline.com/economy/?service=rss";feeds.add(new Source(url));
        url = "http://www.thehindubusinessline.com/companies/?service=rss";feeds.add(new Source(url));
        url = "http://www.thehindubusinessline.com/markets/stock-markets/?service=rss";feeds.add(new Source(url));
        return feeds;
    }

    private List<Source> getScienceFeeds() {
        List<Source> feeds = new LinkedList<>();
        String url;
        url = "https://economictimes.indiatimes.com/tech/software/rssfeeds/13357555.cms";feeds.add(new Source(url));
        url = "https://economictimes.indiatimes.com/tech/hardware/rssfeeds/13357565.cms";feeds.add(new Source(url));
        url = "https://economictimes.indiatimes.com/tech/rssfeeds/13357270.cms";feeds.add(new Source(url));

        url = "http://www.financialexpress.com/lifestyle/science/feed/";feeds.add(new Source(url));
        url = "http://www.thehindu.com/sci-tech/technology/?service=rss";feeds.add(new Source(url));
        url = "http://www.thehindubusinessline.com/news/science/?service=rss";feeds.add(new Source(url));
        url = "http://www.thehindubusinessline.com/info-tech/?service=rss";feeds.add(new Source(url));
        return feeds;
    }

    private List<Source> getSportsFeeds() {
        List<Source> feeds = new LinkedList<>();
        String url;
        url = "https://economictimes.indiatimes.com/industry/sports/rssfeeds/58571631.cms";feeds.add(new Source(url));
        url = "http://www.hindustantimes.com/rss/sports/rssfeed.xml";feeds.add(new Source(url));
        url = "http://www.hindustantimes.com/rss/othersports/rssfeed.xml";feeds.add(new Source(url));
        url = "http://www.thehindu.com/sport/?service=rss";feeds.add(new Source(url));
        url = "http://www.thehindubusinessline.com/news/sports/?service=rss";feeds.add(new Source(url));
        return feeds;
    }

    private List<Source> getEntertainmentFeeds() {
        List<Source> feeds = new LinkedList<>();
        String url;
        url = "http://www.deccanherald.com/rss/entertainment.rss";feeds.add(new Source(url));
        url = "https://economictimes.indiatimes.com/rssfeeds/13357410.cms";feeds.add(new Source(url));
        url = "https://timesofindia.indiatimes.com/rssfeeds/1081479906.cms";feeds.add(new Source(url));
        return feeds;
    }

}
