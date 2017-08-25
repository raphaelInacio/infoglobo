package br.com.infoglobo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.infoglobo.domain.Feed;
import br.com.infoglobo.json.FeedJson;
import br.com.infoglobo.repository.FeedRepository;

@Service
public class FeedServiceImpl implements FeedService {

	@Autowired
	FeedRepository repository;

	@Override
	public ResponseEntity<FeedJson> findAllFeeds() {
		List<Feed> feeds = repository.findAll();
		if (feeds == null || feeds.isEmpty())
			return new ResponseEntity<FeedJson>(HttpStatus.NO_CONTENT);

		FeedJson response = new FeedJson(feeds.iterator().next());
		return new ResponseEntity<FeedJson>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<FeedJson> findLastFeed() {
		Feed feed = repository.findTopByOrderByCreatedDesc();
		if (feed == null)
			return new ResponseEntity<FeedJson>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<FeedJson>(new FeedJson(feed), HttpStatus.OK);
	}

}
