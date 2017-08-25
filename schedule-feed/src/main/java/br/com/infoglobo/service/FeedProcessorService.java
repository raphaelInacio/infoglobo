package br.com.infoglobo.service;

import com.sun.syndication.feed.synd.SyndFeed;

import br.com.infoglobo.domain.Feed;

public interface FeedProcessorService {
	public Feed process(SyndFeed parser);
}
