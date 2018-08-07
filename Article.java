package sba.official.news.article;

import java.util.Comparator;

public class Article implements Comparable<Article>{
	
	private String title, link, date;
	private String source, image, description, category;
	private String[] keywords;
	private float rank;
	
	public Article() {}
	
	public Article(String l) {
		this.link=l;
	}
	
	public Article(String t,String l) {
		this.title=t;
		this.link=l;
	}
	
	public Article(String t, String l, String d) {
		this.title=t;
		this.link=l;
		this.date=d;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setRank(float rank) {
		this.rank += rank;
	}
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	
	public String getTitle() {
		return title;
	}
	public String getLink() {
		return link;
	}
	public String getDate() {
		return date;
	}
	public String getSource() {
		return source;
	}
	public String getImage() {
		return image;
	}
	public String getDescription() {
		return description;
	}
	public String getCategory() {
		return category;
	}
	public float getRank() {
		return rank;
	}
	public String[] getKeywords() {
		return keywords;
	}
	
	public boolean equals(Object obj) {
		Article a = (Article) obj;
		return this.link.equals(a.link);
	}
	
	public int hashCode() {
		return this.link.hashCode();
	}

	public int compareTo(Article arg) {
		return this.link.compareTo(arg.link);
	}
	
	public static class RankComparator implements Comparator<Article> {
		public int compare(Article o1, Article o2) {
			if(o1.rank<o2.rank)
				return 1;
			else if(o1.rank>o2.rank)
				return -1;
			else return 0;
		}
	}

}
