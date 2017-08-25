package br.com.infoglobo.mock;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.sun.syndication.feed.WireFeed;
import com.sun.syndication.feed.module.Module;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndImage;

public class MockSyndFeed implements SyndFeed {
	
	public MockSyndFeed() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	@Override
	public Class getInterface() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void copyFrom(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getSupportedFeedTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WireFeed createWireFeed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WireFeed createWireFeed(String feedType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WireFeed originalWireFeed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPreservingWireFeed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFeedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFeedType(String feedType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEncoding(String encoding) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUri(String uri) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SyndContent getTitleEx() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitleEx(SyndContent title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLink() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLink(String link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getLinks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLinks(List links) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SyndContent getDescriptionEx() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescriptionEx(SyndContent description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getPublishedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPublishedDate(Date publishedDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAuthors(List authors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAuthor(String author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getContributors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContributors(List contributors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCopyright() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCopyright(String copyright) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SyndImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setImage(SyndImage image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCategories(List categories) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getEntries() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public void setEntries(List entries) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLanguage(String language) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Module getModule(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getModules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setModules(List modules) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getForeignMarkup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setForeignMarkup(Object foreignMarkup) {
		// TODO Auto-generated method stub
		
	}

}
