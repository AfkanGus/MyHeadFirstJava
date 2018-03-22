package com.taly.SimpleChatClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Taly on 22.03.2018.
 */
public class SimpleChatClient {
	JTextArea incoming;
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket socket;

	public void go(){
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		incoming = new JTextArea(15, 20);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScroller = new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel panel = new JPanel();
		outgoing = new JTextField(20);

		JButton sendBtn = new JButton("Send");
		sendBtn.addActionListener(new SendButtonListener());

		panel.add(qScroller);
		panel.add(outgoing);
		panel.add(sendBtn);
		frame.getContentPane().add(BorderLayout.CENTER, panel);

		SetUpNetworking();

		Thread readerThread = new Thread(new IncomingReader()); // запускаем новый поток, используя класс
		readerThread.start();   // в качестве Runnable (задачи)

		frame.setSize(400, 500);
		frame.setVisible(true);
	}

	public class  IncomingReader implements Runnable{
		@Override
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					System.out.println("read " + message);
					incoming.append(message + "\n");
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	private void SetUpNetworking(){
		try {
			socket = new Socket("127.0.0.1", 4242);
			InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(socket.getOutputStream());
			System.out.println("networking established");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public class SendButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				writer.println(outgoing.getText());
				writer.flush();
				System.out.println("information send");
			} catch (Exception e1){
				e1.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}


	public static void main(String[] args) {
		SimpleChatClient client = new SimpleChatClient();
		client.go();
	}
}
