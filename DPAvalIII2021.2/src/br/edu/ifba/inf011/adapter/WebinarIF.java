package br.edu.ifba.inf011.adapter;

public interface WebinarIF {
	public String getId();
	public String getTitle();
	public double getPrice();
	public void play();
	public String getHoster();
	public long getMinutes();
	public boolean wasWatched();
	public String getUri();
}
