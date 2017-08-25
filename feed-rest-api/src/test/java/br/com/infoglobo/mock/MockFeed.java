package br.com.infoglobo.mock;

import java.util.ArrayList;
import java.util.List;

import br.com.infoglobo.domain.Description;
import br.com.infoglobo.domain.DescriptionType;
import br.com.infoglobo.domain.Feed;
import br.com.infoglobo.domain.Item;
import br.com.infoglobo.json.FeedJson;

public class MockFeed {

	public static Description getMockDescription() {
		return new Description(DescriptionType.TEXT.getType(), (Object) "Content test");

	}

	public static List<Description> getMockListDescription() {
		List<Description> list = new ArrayList<>();
		list.add(getMockDescription());
		return list;
	}

	public static Item getMockItem() {
		return new Item("Titulo Materia teste", "http://linkteste.com.br", getMockListDescription());
	}

	public static List<Item> getMockItemList() {
		Item item = getMockItem();
		List<Item> items = new ArrayList<>();
		items.add(item);
		return items;
	}

	public static FeedJson getMockFeedJson() {
		return new FeedJson(new Feed(getMockItemList()));
	}

	public static Feed getMockFeed() {
		return new Feed(getMockItemList());
	}
}
