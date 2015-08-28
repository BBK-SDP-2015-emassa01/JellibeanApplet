package jbeanApplet;

import java.util.ArrayList;

public class FakeClazz {
	
	public ArrayList<String> writeSomething(String q){
		String query = q.replace(" ", "+");
		GoogleCustomSearchApiApplet gcse = new GoogleCustomSearchApiApplet();
		gcse.qry = query;

		try {
			gcse.cse();
		} catch (Exception e) {
			System.out
					.println("There was an error in the Google Custom Search method.");
			e.printStackTrace();
		}

		JsoupHtmlParserApplet jshtml = new JsoupHtmlParserApplet();
		jshtml.query = query;

		jshtml.jsouphtmlYahoo();
		jshtml.jsouphtmlBing();

		System.out.println("Completed 1.");

		ArrayList<String> linkArrayList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			linkArrayList.add(jshtml.jSoupYahooLinks.get(i));
			linkArrayList.add(jshtml.jSoupBingLinks.get(i));
			linkArrayList.add(gcse.jSoupGoogleLinks.get(i));
		}
		System.out.println("Completed 2.");
		
		return linkArrayList;

	}
	}


