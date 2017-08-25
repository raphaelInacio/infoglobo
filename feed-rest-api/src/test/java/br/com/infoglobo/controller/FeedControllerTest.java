package br.com.infoglobo.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.infoglobo.json.FeedJson;
import br.com.infoglobo.mock.MockFeed;
import br.com.infoglobo.service.FeedService;

@RunWith(SpringRunner.class)
@WebMvcTest(FeedController.class)
public class FeedControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private FeedService service;

	@Test
	@WithMockUser(username = "infoglobo", password = "desafio", roles = "USER")
	public void deveRetornar204QuandoNaoHouverFeeds() throws Exception {
		given(this.service.findLastFeed()).willReturn(new ResponseEntity<FeedJson>(HttpStatus.NO_CONTENT));
		mvc.perform(get("/api/feeds")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().is(204));
	}
	
	@Test
	@WithMockUser(username = "infoglobo", password = "desafio", roles = "USER")
	public void deveRetornar200QuandoHouverFeeds() throws Exception {
		given(this.service.findLastFeed()).willReturn(new ResponseEntity<FeedJson>(MockFeed.getMockFeedJson(), HttpStatus.OK));
		mvc.perform(get("/api/feeds")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().is(200))
	      .andExpect(jsonPath("$.feed.item").isArray())
	      .andExpect(jsonPath("$.feed.item").isNotEmpty())
	      .andExpect(jsonPath("$.feed.item[0].title").value("Titulo Materia teste"))
	      .andExpect(jsonPath("$.feed.item[0].link").value("http://linkteste.com.br"))
	      .andExpect(jsonPath("$.feed.item[0].description").isArray());
	}
	
	@Test
	public void deveRetornar401CasoNaoInfomeUsuarioESenhaPreDefinido() throws Exception {
		given(this.service.findLastFeed()).willReturn(new ResponseEntity<FeedJson>(MockFeed.getMockFeedJson(), HttpStatus.OK));
		mvc.perform(get("/api/feeds")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().is(401));
	}
	
	

}
