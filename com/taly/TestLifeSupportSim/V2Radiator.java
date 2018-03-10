package com.taly.TestLifeSupportSim;

import java.util.ArrayList;

/**
 * Created by Taly on 10.03.2018.
 */
public class V2Radiator {
	V2Radiator(ArrayList list){
		for (int i = 0; i < 5; i++) {
			list.add(new SimUnit("V2радиатор"));
		}
	}
}
