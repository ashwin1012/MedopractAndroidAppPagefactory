package MedoPractApp.MedoPractApp.Utilities;

import java.util.Date;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String TimeStamp() {
		Date date = new Date();
		String todaydate= date.toString().replace(":", "-");
		return todaydate;
	}

}
