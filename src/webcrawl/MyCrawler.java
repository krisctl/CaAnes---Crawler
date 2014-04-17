package webcrawl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" 
			+ "|png|tiff?|mid|mp2|mp3|mp4"
			+ "|wav|avi|mov|mpeg|ram|m4v|pdf" 
			+ "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

	// Hashset to maintain unique words
	static Set<String> uniquewords = new HashSet<String>();
	
	/**
	 * @param Web URL
	 * @return true/false after filter matching  
	 * Provides the option to match the page URL with any filters 
	 * or the list of URLs and then only crawling it.
	 */
	@Override
	public boolean shouldVisit(WebURL url) {
		String href = url.getURL().toLowerCase();
		return !FILTERS.matcher(href).matches() && href.startsWith("http://www.caanes.com/");
	}

	/**
	 * @param Page instance
	 * This function is called when a page is fetched and ready 
	 * to be processed by your program.
	 */
	@Override
	public void visit(Page page) {          
		String url = page.getWebURL().getURL();
		
		System.out.println("URL: " + url);
		System.out.println();


		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();

			List<String> words = cleanAndSplitString(htmlParseData.getText());

			for(String s: words){
				uniquewords.add(s.replaceAll("^\\s+|\\s+$", "").toLowerCase());
			}
			System.out.println("size of unique words in hash: " + uniquewords.size());
		}
				 
	}
	
	/**
	 * @param sortedUniques
	 * Prints all the sorted words on the console
	 */
	public static void display(List<String> sortedUniques) {
		// TODO Auto-generated method stub
		// Printing sorted unique words
		for(int i=0; i< sortedUniques.size(); i++)
			System.out.print(sortedUniques.get(i) +" ");
		/*System.out.println("size of the unique list: "+uniques.size());*/

	}
	
	/**
	 * @param input- String with words with digits and spaces.
	 * @return List<String>
	 * Removes punctuations and digits from the given input string and uses space as 
	 * delimiter. 
	 */
	public List<String> cleanAndSplitString(final String input) {
		if (input != null) {
			final String[] dic = input.replaceAll("\\p{Punct}", "").replaceAll("\\p{Digit}", "").split("\\s+");
			return Arrays.asList(dic);
		}
		return new ArrayList<>();
	}

}
