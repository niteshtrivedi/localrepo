package org.testing.assertion;

import org.testing.Utilities.LogsCapture;

public class Assertt {

	public static Boolean assertion1(String actual,String expected,String className) {
		
		if(actual.equals(expected)) {
			
			LogsCapture.takeLog(className,"Assertion getting Pass");
			return true;
		}
		else {
			
			LogsCapture.takeLog(className,"Assertion getting Fail");
			return false;
		}
	}

	
	
}
