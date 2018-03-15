package com.taly.SimpleGui1B;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taly on 15.03.2018.
 */
public class SimpleGui1B implements ActionListener {
	private int num = 1;
	JButton button;

	public static void main(String[] args) {
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		button = new JButton("Click me");

		button.addActionListener(this); //добавляем наш объект класса (реализуемого ActionListener)
		//в список слушателей кнопки
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(button);
		frame.setSize(300, 200);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) { //кнопка вызывает этот метод и отправляет объект ActionEvent
		if (num % 2 == 0) {
			button.setText("Click me");
			System.out.println(num);
		} else {
			button.setText("I\'m clicked");
			System.out.println(num);
		}
		num++;
	}
}
