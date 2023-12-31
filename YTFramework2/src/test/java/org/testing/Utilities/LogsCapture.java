package org.testing.Utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogsCapture {

	public static void takeLog(String className, String msg){
		
		DOMConfigurator.configure("../YTFramework2/objectRepo.properties");
		Logger L= Logger.getLogger(className);
		L.info(msg);
	}
}
 