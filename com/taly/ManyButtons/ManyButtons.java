package com.taly.ManyButtons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Taly on 19.03.2018.
 */
public class ManyButtons {
	public static void main(String[] args) {
		ManyButtons gui = new ManyButtons();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		JButton east = new JButton("East");
		JButton west = new JButton("West");
		JButton south = new JButton("South");
		JButton north = new JButton("North");
		JButton center = new JButton("Center");

		frame.getContentPane().add(BorderLayout.EAST, east);
		frame.getContentPane().add(BorderLayout.WEST, west);
		frame.getContentPane().add(BorderLayout.SOUTH, south);
		frame.getContentPane().add(BorderLayout.NORTH, north);
		frame.getContentPane().add(BorderLayout.CENTER, center);

		frame.setSize(300, 300);
		frame.setVisible(true);


	}

}
