package com.taly.Button1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Taly on 19.03.2018.
 */
public class Button1 {
	public static void main (String[] args)
	{
		Button1 gui = new Button1();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		JButton button = new JButton("click like you mean it");
		Font bigFont = new Font("serif", Font.BOLD, 28);
		button.setFont(bigFont);
		//frame.getContentPane().add(BorderLayout.EAST, button);
		frame.getContentPane().add(BorderLayout.NORTH, button);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}
