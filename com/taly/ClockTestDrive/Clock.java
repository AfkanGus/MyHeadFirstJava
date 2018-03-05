package com.taly.ClockTestDrive;

/**
 * Created by Taly on 01.03.2018.
 */
public class Clock {
	private String time;
	void setTime(String t){
		time = t;
	}
	String getTime(){
		return time;
	}
}
class ClockTestDrive{
	public static void main(String[] args) {
		Clock c  = new Clock();
		c.setTime("1245");
		String tod = c.getTime();
		System.out.println("время: " + tod);
	}
}
