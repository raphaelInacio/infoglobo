package br.com.infoglobo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.syndication.feed.synd.SyndFeed;

import br.com.infoglobo.mock.MockSyndFeed;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedProcessorServiceImplTest {
	
	@Autowired
	private FeedProcessorService feedParser;
	
	@Test
	public void deveRealizarParser() {
		SyndFeed syndFeed = new MockSyndFeed();
		feedParser.process(syndFeed);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveRetornarExceptionCasoFeedEstiverNull() {
		feedParser.process(null);
	}

}
