package com.taly.TwoButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taly on 16.03.2018.
 */
public class TwoButtons {
	private JFrame frame;
	private JLabel label;

	public static void main(String[] args) {
		TwoButtons gui = new TwoButtons();
		gui.go();
	}

	private void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton labelButton = new JButton("Change label");//методу регистрации слушателя кнопки передается
		labelButton.addActionListener(new LabelListener()); // экземпляр соответствующего класса слушателя
		JButton colorButton = new JButton("Change circle");
		colorButton.addActionListener(new ColorListener());

		label = new JLabel("I'm label");
		MyDrawPanel drawPanel = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);

		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	class LabelListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText("Ouch!");
		}
	}

	class ColorListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.repaint();
		}
	}
}
class MyDrawPanel extends JPanel{
	@Override
	protected void paintComponent(Graphics g) {
		g.fillRect(0,0,this.getWidth(),this.getHeight()); // закрасим всю панель цветом по умолчанию

		int red = (int)(Math.random() * 255);
		int green = (int)(Math.random() * 255);
		int blue = (int)(Math.random() * 255);
		Color randomColor = new Color(red, green, blue);

		g.setColor(randomColor);
		g.fillOval(5,5,100,100);
	}
}
