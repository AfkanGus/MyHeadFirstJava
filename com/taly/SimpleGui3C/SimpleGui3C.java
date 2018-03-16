package com.taly.SimpleGui3C;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Taly on 15.03.2018.
 */
public class SimpleGui3C implements ActionListener {
	JFrame frame;
	JButton button;
	int count;

	public class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){

			Graphics2D g2d = (Graphics2D) g;

			g.fillRect(0,0,this.getWidth(),this.getHeight()); // закрасим всю панель цветом по умолчанию

			Image image = new ImageIcon("d:\\Docs\\Загрузки\\images\\i_m.jpg").getImage();
			g.drawImage(image,1,1,this);

			int red = (int)(Math.random() * 255);
			int green = (int)(Math.random() * 255);
			int blue = (int)(Math.random() * 255);
			Color randomColor = new Color(red, green, blue);

			red = (int)(Math.random() * 255);
			green = (int)(Math.random() * 255);
			blue = (int)(Math.random() * 255);
			Color endColor = new Color(red, green, blue);

			GradientPaint gradient = new GradientPaint(5, 5, randomColor, 150, 150, endColor);

			//g.setColor(randomColor);
			g2d.setPaint(gradient);

			g.fillOval(5,5,100,100);
		}
	}

	public static void main(String[] args) {
		SimpleGui3C gui = new SimpleGui3C();
		gui.go();
	}

	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("Click");
		button.addActionListener(this);

		MyDrawPanel panel = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.repaint();
		button.setText("Clicked!!! " + (++count));
	}
}
