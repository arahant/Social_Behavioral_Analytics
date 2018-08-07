package sba.social.twitter.tweet;

public class Tweet {
	
	private String author, link, date, body, image;
	
	public Tweet(String a, String d, String l, String b) {
		this.author = a;
		this.date = d;
		this.link = l;
		this.body = b;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getAuthor() {
		return author;
	}
	public String getLink() {
		return link;
	}
	public String getDate() {
		return date;
	}
	public String getBody() {
		return body;
	}
	public String getImage() {
		return image;
	}

}
