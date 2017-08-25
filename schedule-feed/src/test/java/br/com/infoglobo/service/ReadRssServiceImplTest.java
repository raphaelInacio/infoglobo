package br.com.infoglobo.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadRssServiceImplTest {
	
	@Autowired
	private ReadRssService readRssService;
	
	@Test
	public void deveRetornarUmaListaDeFeeds() {
		readRssService.read(Optional.of("http://revistaautoesporte.globo.com/rss/ultimas/feed.xml"));
	}

}
