package br.com.infoglobo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;

import br.com.infoglobo.domain.Description;
import br.com.infoglobo.domain.Feed;
import br.com.infoglobo.domain.Item;

@Service
public class FeedProcessorServiceImpl implements FeedProcessorService {

	private static final Logger loggger = LoggerFactory.getLogger(FeedProcessorServiceImpl.class);

	@Autowired
	private ElementFindService elementFindService;

	private Feed feed;

	@Override
	public Feed process(SyndFeed parser) {

		loggger.info("Iniciando parse do feed...");

		if (parser == null)
			throw new IllegalArgumentException();

		List<Item> itens = new ArrayList<>();

		for (Object object : parser.getEntries()) {
			SyndEntryImpl itemSynd = (SyndEntryImpl) object;
			Item item = parserItem(itemSynd, elementFindService.find(Optional.of(itemSynd.getDescription().getValue())));
			itens.add(item);
		}

		addFeed(itens);

		loggger.info("Fim parse feed...");

		return feed;
	}
	
	private void addFeed(List<Item> itens) {
		if (!itens.isEmpty())
			feed = new Feed(itens);
	}

	private Item parserItem(SyndEntryImpl itemSynd, List<Description> description) {
		return new Item(itemSynd.getTitle(), itemSynd.getLink(), description);
	}

}
