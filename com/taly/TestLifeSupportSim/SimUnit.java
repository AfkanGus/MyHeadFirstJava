package com.taly.TestLifeSupportSim;

/**
 * Created by Taly on 10.03.2018.
 */
public class SimUnit {
	String botType;
	SimUnit(String type)
	{
		botType = type;
		System.out.println("Created " + botType);
	}

	int powerUse(){
		if ("Теполовая машина".equals(botType)){
			return 2;
		} else {
			return 4;
		}
	}

}
