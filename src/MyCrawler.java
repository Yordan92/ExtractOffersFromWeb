import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler {
	
	private static final String CONTEINER_FOLDER = "htmls";

	private final static String domain = "http://www.homes.bg/";
		
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
                + "|png|mp3|mp3|zip|gz))$");

	private final static Pattern OFFERES = Pattern.compile(domain + "[^/?=&]+");
	
	private Map<String, Boolean> visited;
	

	public MyCrawler(Map<String, Boolean> visited) {
		this.visited = visited;
	}
	
	private String getOfferId(String url) {
		return url.substring(url.lastIndexOf("/") + 1);
	}
	
    /**
     * This method receives two parameters. The first parameter is the page
     * in which we have discovered this new url and the second parameter is
     * the new url. You should implement this function to specify whether
     * the given url should be crawled or not (based on your crawling logic).
     * In this example, we are instructing the crawler to ignore urls that
     * have css, js, git, ... extensions and to only accept urls that start
     * with "http://www.ics.uci.edu/". In this case, we didn't need the
     * referringPage parameter to make the decision.
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches() 
       		&& href.startsWith(domain)
       		&& (href.contains("page=") || OFFERES.matcher(href).matches())
       		&& !visited.containsKey(getOfferId(href));
    }

     /**
      * This function is called when a page is fetched and ready
      * to be processed by your program.
      */
     @Override
     public void visit(Page page) {
         String url = page.getWebURL().getURL();
         System.out.println("URL: " + url);

         if (page.getParseData() instanceof HtmlParseData) {
             HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
             String text = htmlParseData.getText();
             String html = htmlParseData.getHtml();
             Set<WebURL> links = htmlParseData.getOutgoingUrls();
             if (OFFERES.matcher(url).matches()) {
            	 File f = new File(CONTEINER_FOLDER + File.separator + getOfferId(url) + ".html");
					try {
						if (!f.exists()) {
							f.createNewFile();
						} else {
							throw new Exception("This url is alredy parsed");
						}
						OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
						osw.write(html);
						osw.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
             }

             System.out.println("Text length: " + text.length());
             System.out.println("Html length: " + html.length());
             System.out.println("Number of outgoing links: " + links.size());
         }
    }
}
		
	
