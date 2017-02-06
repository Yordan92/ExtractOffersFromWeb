import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class MainClass {
	
	private static final String ADDITIONAL_INFORMATION_SELECTOR = "table.ver13black > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1)";
	
	
	public static void main(String[] args) throws Exception {
		startCrawling();
	}

	private static void startCrawling() throws Exception {
		String crawlStorageFolder="C:\\Users\\yordan\\Desktop\\testFile";
        int numberOfCrawlers = 4;
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
//        controller.addSeed("http://www.homes.bg/?go=apartmentsrent&type=1&search=1&advanced=&fromhomeu=1&Neighbourhoods=447&regiontype=1&locationId=1&offersfrom%5B1%5D=1&offersfrom%5B2%5D=1&offersfrom%5B3%5D=1&furnitureId=0&price=&currencyId=1");
        controller.addSeed("http://www.homes.bg/?go=apartmentssell&type=1&search=1&advanced=&fromhomeu=1&Neighbourhoods=532&regiontype=1&locationId=1&offersfrom%5B1%5D=1&offersfrom%5B2%5D=1&offersfrom%5B3%5D=1&finished=&area=&price=&currencyId=1");
        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         * 
         */
//        config.setMaxDepthOfCrawling(2);
        config.setPolitenessDelay(4000);
        controller.start(new MyCrawlerFactory(), numberOfCrawlers);
	}
}

