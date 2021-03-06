package com.taly.Jukebox4;

/**
 * Created by Taly on 27.03.2018.
 */
class Song implements Comparable<Song> {
	String title;
	String artist;
	String rating;
	String bpm;

	@Override
	public int compareTo(Song o) {
		return title.compareTo(o.getTitle());
	}

	Song(String t, String a, String r, String b){
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getRating() {
		return rating;
	}

	public String getBpm() {
		return bpm;
	}

	@Override
	public String toString() {
		return title + ":" + artist;
	}
}
