package br.com.infoglobo.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "feed")
public class Feed {

	@Id
	public String id;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Indexed
	private LocalDateTime created;

	private List<Item> item;

	public Feed(List<Item> item) {
		this.item = item;
		this.created = LocalDateTime.now();
	}

	public Feed() {
	}

}
