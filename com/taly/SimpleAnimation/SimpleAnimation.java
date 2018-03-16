package com.taly.SimpleAnimation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Taly on 16.03.2018.
 */
public class SimpleAnimation {
	private int x = 70;
	private int y = 70;
	private int z = 40;

	public static void main(String[] args) {
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyDrawPanel panel = new MyDrawPanel();

		frame.getContentPane().add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);

		for (int i = 0; i < 130; i++) {
			x++;
			y++;

				panel.repaint();
			try {
				Thread.sleep(50);
			} catch (Exception e){}
		} // end for

	} //end go()

	class MyDrawPanel extends JPanel{
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0,0,this.getWidth(), this.getHeight()); // залить весь прямоугольник панели белым цветом
			// при каждой отрисовке
			g.setColor(Color.BLUE);
			g.fillOval(x, y, 70, 70);
		}
	} // closing inner class
} // closing outer class
