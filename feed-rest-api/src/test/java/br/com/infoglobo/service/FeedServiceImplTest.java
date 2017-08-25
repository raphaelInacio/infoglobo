package br.com.infoglobo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.infoglobo.json.FeedJson;
import br.com.infoglobo.mock.MockFeed;
import br.com.infoglobo.repository.FeedRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedServiceImplTest {
	
	@MockBean
	private FeedRepository repository;
	
	@Autowired
	private FeedService service;
	
	@Test
	public void deveRetornarCodigo200CasoEncontreUltimoFeed() {
		given(repository.findTopByOrderByCreatedDesc()).willReturn(MockFeed.getMockFeed());
		ResponseEntity<FeedJson> response = service.findLastFeed();
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void deveRetornarCodigo204CasoNaoEncontreFeed() {
		given(repository.findTopByOrderByCreatedDesc()).willReturn(null);
		ResponseEntity<FeedJson> response = service.findLastFeed();
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

}
