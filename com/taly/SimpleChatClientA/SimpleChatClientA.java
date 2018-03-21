package com.taly.SimpleChatClientA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Taly on 21.03.2018.
 */
public class SimpleChatClientA {
    JTextField outgoing;
    PrintWriter writer;
    Socket socket;

    public void go(){
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        outgoing = new JTextField(20);

        JButton sendBtn = new JButton("Send");
        sendBtn.addActionListener(new SendButtonListener());

        panel.add(outgoing);
        panel.add(sendBtn);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        SetUpNetworking();

        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void SetUpNetworking(){
        try {
            socket = new Socket("127.0.0.1", 4242);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("networking established");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public class SendButtonListener implements ActionListener{
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
        SimpleChatClientA client = new SimpleChatClientA();
        client.go();
    }
}
