package com.taly.MusicTest1;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/**
 * Created by Taly on 14.03.2018.
 */
public class MusicTest1 {
	public void play(){
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			System.out.println("Мы получили синтезатор");
		} catch (MidiUnavailableException e){
			System.out.println("Fail");
			//e.getStackTrace();
		}
	} // закрываем play

	public static void main(String[] args) {
		MusicTest1 mt = new MusicTest1();
		mt.play();
	} // закрываем main
} // закрываем класс
