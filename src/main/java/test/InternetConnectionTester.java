package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InternetConnectionTester {
	public static void main(String[] args) throws IOException, InterruptedException {
		URL google = new URL("http://www.google.com");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
		while(true) {
			String dateTime = sdf.format(new Date());
			try {
			HttpURLConnection conn = (HttpURLConnection) google.openConnection();
			if(conn.getResponseCode() == 200) {
				System.out.println(dateTime + "<==> Internet Works");
			} else {
				System.out.println(dateTime + "<==> Internet Not Working");
			}
			conn.disconnect();
			}catch(Exception e) {
				System.out.println(dateTime + "<==> Internet Not Working");
			}
			Thread.sleep(10000);
		}
	}
}
