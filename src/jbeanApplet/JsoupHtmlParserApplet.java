package jbeanApplet;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupHtmlParserApplet {

	String query = null;
	public ArrayList<String> jSoupYahooLinks = new ArrayList<>();
	public ArrayList<String> jSoupBingLinks = new ArrayList<>();

	public void jsouphtmlYahoo() {

		Document doc;
		try {

			String searchPage = "https://uk.search.yahoo.com/search?p=";
			String tempSearch = searchPage + query;

			// need http protocol
			doc = Jsoup.connect(tempSearch).get();

			// get page title
			String title = doc.title();
			String selection = "h3.title > a";

			Elements links = doc.select(selection);
			for (Element l : links) {
				jSoupYahooLinks.add(l.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void jsouphtmlBing() {

		Document doc;
		try {

			String searchPage = "https://www.bing.com/search?q=";
			String tempSearch = searchPage + query;

			// need http protocol
			doc = Jsoup.connect(tempSearch).get();

			// get page title
			String title = doc.title();
			String selection = "h2 a";

			Elements links = doc.select(selection);

			for (Element l : links) {
				jSoupBingLinks.add(l.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
