package br.com.infoglobo.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Item {

	private String title;
	private String link;
	private List<Description> description;

	public Item(String title, String link, List<Description> description) {
		this.title = title;
		this.link = link;
		this.description = description;
	}

}
