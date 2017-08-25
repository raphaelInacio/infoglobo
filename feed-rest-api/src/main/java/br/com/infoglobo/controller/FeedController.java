package br.com.infoglobo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.infoglobo.json.FeedJson;
import br.com.infoglobo.service.FeedService;

@RestController
@RequestMapping(value = "/api/feeds")
public class FeedController {

	@Autowired
	private FeedService feedService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<FeedJson> getFeeds() {
		return feedService.findLastFeed();
	}
}
