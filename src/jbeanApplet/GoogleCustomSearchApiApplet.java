
package jbeanApplet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Esha
 */
public class GoogleCustomSearchApiApplet {

	String qry = null;
	public ArrayList<String> jSoupGoogleLinks = new ArrayList<>();

	public void cse() throws IOException {

		String key = "AIzaSyCnAIDiZchNkR0OTBH3NMMNt4GmRiwpdnA";// server key

		String cx = "008818185974073145685:ga_fmgk9gf0";
		URL url = new URL("https://www.googleapis.com/customsearch/v1?key="
				+ key + "&cx=" + cx + "&q=" + qry + "&alt=json");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		while ((output = br.readLine()) != null) {

			if (output.contains("\"link\": \"")) {
				String link = output.substring(output.indexOf("\"link\": \"")
						+ ("\"link\": \"").length(), output.indexOf("\","));
				jSoupGoogleLinks.add(link.toString());
			}
		}
		conn.disconnect();
	}

}







