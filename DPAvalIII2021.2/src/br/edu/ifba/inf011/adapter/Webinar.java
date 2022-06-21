package br.edu.ifba.inf011.adapter;

public class Webinar implements WebinarIF{

	private String id;
	private String title;
	private String hoster;
	private double price;
	private long minutes;
	private boolean watched;
	private String uri;
	
	public Webinar(String id, String title, String hoster, double price, long minutes, String uri) {
		this.id = id;
		this.title = title;
		this.hoster = hoster;
		this.price = price;
		this.minutes = minutes;
		this.watched = false;
		this.uri= uri;
	}

	public String getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public double getPrice() {
		return this.price;
	}
	
	public void play() {
		this.watched = true;
	}
	
	public String getHoster() {
		return hoster;
	}

	public long getMinutes() {
		return minutes;
	}

	public boolean wasWatched() {
		return this.watched;
	}

	public String getUri() {
		return uri;
	}	
	
}
