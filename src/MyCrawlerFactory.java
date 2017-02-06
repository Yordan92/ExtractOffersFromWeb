import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import edu.uci.ics.crawler4j.crawler.CrawlController;

public class MyCrawlerFactory  implements CrawlController.WebCrawlerFactory<MyCrawler>{

	private static final String CONTEINER_FOLDER = "htmls";
	
	private Map<String, Boolean> crawledFiles;
	
	public Map<String, Boolean> crawledOffers() {
		File f = new File(CONTEINER_FOLDER);
		if(!f.exists())
			return new ConcurrentHashMap<String, Boolean>();
		return Arrays.stream(f.listFiles())
			  .map(file -> file.getName().replaceFirst("[.][^.]+$", ""))
			  .collect(Collectors.toConcurrentMap(Function.identity(), x -> true));	
	}
	@Override
	public MyCrawler newInstance() throws Exception {
		this.crawledFiles = crawledOffers();
		return new MyCrawler(this.crawledOffers());
	}

}
