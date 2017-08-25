package br.com.infoglobo.service;

import org.springframework.http.ResponseEntity;

import br.com.infoglobo.json.FeedJson;

public interface FeedService {
	ResponseEntity<FeedJson>findAllFeeds();
	ResponseEntity<FeedJson> findLastFeed();
}
