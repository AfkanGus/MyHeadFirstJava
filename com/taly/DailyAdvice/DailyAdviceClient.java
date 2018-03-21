package com.taly.DailyAdvice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Taly on 21.03.2018.
 */
public class DailyAdviceClient {
	public void go(){
		try{
			Socket socket = new Socket("127.0.0.1", 4242);
			InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
			String advice = reader.readLine();
			System.out.println("Сегодня ты должен: " + advice);
			reader.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}
}
