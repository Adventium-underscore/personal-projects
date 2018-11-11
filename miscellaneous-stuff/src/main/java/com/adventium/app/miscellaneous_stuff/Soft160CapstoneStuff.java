package com.adventium.app.miscellaneous_stuff;

/**
 * Stuff for working on the Soft160 capstone
 *
 */
public class Soft160CapstoneStuff {
	
	public enum sepsisAlert {
		CONTINUE_MONITORING, SIRS_2, SIRS_3, SIRS_4, SEPSIS_ALERT, SEVERE_SEPSIS_ALERT
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public static sepsisAlert sepsisLogic(boolean[] alertedSIRS, boolean[] alertedOD) {
		if (!alertedSIRS[0] || !alertedSIRS[1])
			return sepsisAlert.CONTINUE_MONITORING;

		int alertedSIRSCount = 0;
		for(boolean alert : alertedSIRS) {
			if(alert)
				++alertedSIRSCount;
		}
		if(alertedSIRSCount < 2)
			return sepsisAlert.CONTINUE_MONITORING;
		
		
		int alertedODCount = 0;
		for(boolean alert : alertedOD) {
			if(alert)
				++alertedODCount;
		}
		if(alertedODCount == 0) {
			switch (alertedSIRSCount) {
			case 2: return sepsisAlert.SIRS_2;
			case 3: return sepsisAlert.SIRS_3;
			case 4: return sepsisAlert.SIRS_4;
			default: return sepsisAlert.CONTINUE_MONITORING;
			}
		}
		if(alertedOD[0] || alertedODCount > 2)
			return sepsisAlert.SEVERE_SEPSIS_ALERT;
		return sepsisAlert.SEPSIS_ALERT;
	}
}
