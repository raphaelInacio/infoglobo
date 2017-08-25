package br.com.infoglobo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.infoglobo.domain.Description;
import br.com.infoglobo.domain.DescriptionType;

@Service
public class ElementFindServiceImpl implements ElementFindService {

	private static final Logger loggger = LoggerFactory.getLogger(ElementFindServiceImpl.class);

	private List<Description> descriptions = new ArrayList<>();

	@Override
	public List<Description> find(Optional<String> content) {

		loggger.info("Iniciando busca de elementos...");

		if (!content.isPresent())
			throw new IllegalArgumentException();

		Document document = Jsoup.parse(content.get());
		Elements elements = document.body().select("*");
		elements.remove(0);
		
		elements.forEach(e -> {
			findImageElement(e);
			findParagraphElement(e);
			findLinksElement(e);
		});

		loggger.info("Fim busca de elementos.");

		return this.descriptions;

	}
	
	private void addItem(String type, Object value) {
		if (value instanceof String) {
			String text = (String) value;
			if (StringUtils.hasText(text) && text.length() > 1)
				this.descriptions.add(new Description(type, value));
		} else {
			this.descriptions.add(new Description(type, value));
		}
	}

	private void findImageElement(Element element) {
		if (!element.select("div").select("img").attr("src").isEmpty())
			descriptions.add(
					new Description(DescriptionType.IMAGE.getType(), element.select("div").select("img").attr("src")));
	}

	private void findParagraphElement(Element element) {
		if (!element.select("p").isEmpty())
			addItem(DescriptionType.TEXT.getType(), element.select("p").first().ownText());
	}

	private void findLinksElement(Element element) {
		if (!element.select("div").select("ul").select("li").select("a").isEmpty()) {

			Elements linksElements = element.select("div").select("ul").select("li").select("a");

			List<Object> links = new ArrayList<>();

			linksElements.forEach(e -> links.add(e.select("a").attr("href")));

			addItem(DescriptionType.LINKS.getType(), links);
		}
	}
}
