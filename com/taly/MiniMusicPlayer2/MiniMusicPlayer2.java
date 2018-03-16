package com.taly.MiniMusicPlayer2;

import javax.sound.midi.*;

/**
 * Created by Taly on 16.03.2018.
 */
public class MiniMusicPlayer2 implements ControllerEventListener { // для отслеживания события ControllerEvent
	// реализуем интерфейс слушателя
	public static void main(String[] args) {
		MiniMusicPlayer2 mini = new MiniMusicPlayer2();
		mini.go();
	} // закрываем main

	public void go(){
		try {
			Sequencer sequencer = MidiSystem.getSequencer(); // создаем и открываем синтезатор
			sequencer.open();
			/*
			Регистрируем события синтезатором. Метод, отвечающий за регистрацию, принимает объект
			слушателя и целочисленный массив, представляющий собой список событий ControllerEvent,
			которые нам нужны. Нас интересует только одно событие - № 127
			 */
			int[] eventsIWant = {127};
			sequencer.addControllerEventListener(this, eventsIWant);

			Sequence seq = new Sequence(Sequence.PPQ, 4); // создаем последовательность и дорожку
			Track track = seq.createTrack();

			for (int i = 5; i < 61; i+= 4) { // создаем группу событий, чтобы ноты фортепиано поднимались
				track.add(makeEvent(144, 1, i, 100, i)); // от 5 до 61

				track.add(makeEvent(176, 1, 127, 0, i)); //176 - тип события ControllerEvent
				//для контроля ритма добавили свое событие с аргуметом события 127

				track.add(makeEvent(128, 1, i, 100, i + 2));
			} // конец  цикла
			sequencer.setSequence(seq); // запускаем синтезатор
			sequencer.setTempoInBPM(220);
			sequencer.start();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	// метод обработки события (из интерфейса слушателя события ControllerEvent)
	// при каждом получении события выводим ссобщение
	public void controlChange(ShortMessage event){
		System.out.println("ля");
	}

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
