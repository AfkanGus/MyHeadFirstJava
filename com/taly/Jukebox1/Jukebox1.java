package com.taly.Jukebox1;

import com.taly.Jukebox3.Song;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Taly on 27.03.2018.
 */
public class Jukebox1 {
	ArrayList<String> songList = new ArrayList<String>();

	public static void main(String[] args) {
		new Jukebox1().go();
	}

	public void go(){
		getSong();
		System.out.println(songList);
	}

	private void getSong(){
		try {
		File file = new File("d:\\songs.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addSong(String lineToParse){
		String[] tokens = lineToParse.split("/");
		songList.add(tokens[0]);
	}
}
