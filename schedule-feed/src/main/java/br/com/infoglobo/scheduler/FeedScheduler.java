package br.com.infoglobo.scheduler;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sun.syndication.feed.synd.SyndFeed;

import br.com.infoglobo.domain.Feed;
import br.com.infoglobo.repository.FeedRepository;
import br.com.infoglobo.service.FeedProcessorService;
import br.com.infoglobo.service.ReadRssService;

@Component
@EnableScheduling
public class FeedScheduler {

	private final long SEGUNDO = 1000;
	private final long MINUTO = SEGUNDO * 60;
	private final long HORA = MINUTO * 60;
	private static final String url = "http://revistaautoesporte.globo.com/rss/ultimas/feed.xml";

	private static final Logger loggger = LoggerFactory.getLogger(FeedScheduler.class);

	@Autowired
	private ReadRssService readRssService;

	@Autowired
	private FeedProcessorService feedProcessorService;

	@Autowired
	FeedRepository feedRepository;

	@Scheduled(fixedDelay = HORA)
	public void findNewFeeds() {

		loggger.info("Consultando ultimas atualizações...");

		SyndFeed syndFeed = readRssService.read(Optional.of(url));
		Feed feed = feedProcessorService.process(syndFeed);
		feedRepository.save(feed);

		loggger.info("Atualizações consultadas com sucesso!");
	}
}
