package br.com.infoglobo.service;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

@Service
public class ReadRssServiceImpl implements ReadRssService {

	private static final Logger loggger = LoggerFactory.getLogger(ReadRssServiceImpl.class);

	@Override
	public SyndFeed read(Optional<String> url) {

		loggger.info("Iniciando a leitura do Feed..");

		SyndFeed feed = null;

		try {

			if (!url.isPresent())
				throw new IllegalArgumentException();

			SyndFeedInput input = new SyndFeedInput();
			feed = input.build(new XmlReader(new URL(url.get())));

			loggger.info("Feed recuperado com sucesso", feed.toString());

		} catch (IllegalArgumentException e) {
			loggger.error("URl não informada ou inválida!", e.getMessage());
		} catch (FeedException e) {
			loggger.error("Não foi possível ler o Feed!", e.getMessage());
		} catch (IOException e) {
			loggger.error("Houve um erro inesperado!", e.getMessage());
		}

		return feed;
	}
}
