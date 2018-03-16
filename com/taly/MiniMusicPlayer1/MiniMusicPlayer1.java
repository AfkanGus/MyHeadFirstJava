package com.taly.MiniMusicPlayer1;

import javax.sound.midi.*;

/**
 * Created by Taly on 16.03.2018.
 */
public class MiniMusicPlayer1 {
	public static void main(String[] args) {
		try {
			Sequencer sequencer = MidiSystem.getSequencer(); // создаем и открываем синтезатор
			sequencer.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4); // создаем последовательность и дорожку
			Track track = seq.createTrack();

			for (int i = 5; i < 61; i+= 4) { // создаем группу событий, чтобы ноты фортепиано поднимались
				track.add(makeEvent(144, 1, i, 100, i)); // от 5 до 61
				track.add(makeEvent(128, 1, i, 100, i + 2));
			} // конец  цикла
			sequencer.setSequence(seq); // запускаем синтезатор
			sequencer.setTempoInBPM(220);
			sequencer.start();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	} // закрываем main
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {

		}
		return event;
	}
}// закрываем класс
