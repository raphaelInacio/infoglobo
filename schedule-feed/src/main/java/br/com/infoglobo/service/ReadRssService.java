package br.com.infoglobo.service;

import java.util.Optional;

import com.sun.syndication.feed.synd.SyndFeed;

public interface ReadRssService {
	public SyndFeed read(Optional<String> url);
}
