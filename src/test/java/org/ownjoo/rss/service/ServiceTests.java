package org.ownjoo.rss.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ownjoo.rss.model.RssChannel;
import org.ownjoo.rss.model.RssItem;
import org.ownjoo.rss.domain.Subscription;
import org.ownjoo.rss.model.RssFeed;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests
{
	private Service service;
	private String url = "http://www.vogella.com/article.rss";

	@Before
	public void setup()
	{
		List<Subscription> subscriptions = new LinkedList<>();
		Subscription subscription = new Subscription(url);
		subscriptions.add(subscription);

		service = new Service(subscriptions);
	}

	@Test
	public void shouldInstantiateRssService()
	{
		assertNotNull(service);
	}

	@Test
	public void shouldGetRssFeed()
	{
		List<RssFeed> actual = this.service.getFeeds();
		assertNotNull(actual);
	}

	@Test
	public void shouldGetFeedMessage()
	{
		List<RssFeed> feeds = this.service.getFeeds();
		assertNotNull(feeds);
		assertTrue(feeds.size() > 0 );
		List<RssChannel> channels = feeds.get(0).getChannels();
		assertNotNull(channels);
		assertTrue(channels.size() > 0 );
		List<RssItem> rssItems = channels.get(0).getRssItems();
		assertNotNull(rssItems);
		assertTrue(rssItems.size() > 0 );
		RssItem actual = rssItems.get(0);

		assertNotNull(actual);
		assertFalse(actual.getAuthor().isEmpty());
		assertFalse(actual.getDescription().isEmpty());
		assertFalse(actual.getGuid().isEmpty());
		assertFalse(actual.getLink().isEmpty());
		assertFalse(actual.getTitle().isEmpty());
	}

	@Test
	public void shouldGetFeedWithUrlArg()
	{
		Service service = new Service(url);
		List<RssFeed> feeds = service.getFeeds();
		assertNotNull(feeds);
		System.out.println("feeds size: " + feeds.size());
		assertTrue(feeds.size() > 0 );
		List<RssChannel> channels = feeds.get(0).getChannels();
		assertNotNull(channels);
		assertTrue(channels.size() > 0 );
		List<RssItem> rssItems = channels.get(0).getRssItems();
		assertNotNull(rssItems);
		System.out.println("items size: " + rssItems.size());
		assertTrue(rssItems.size() > 0 );
		RssItem actual = rssItems.get(0);
		System.out.println("actual: " + actual);

		assertNotNull(actual);
		assertFalse(actual.getAuthor().isEmpty());
		assertFalse(actual.getDescription().isEmpty());
		assertFalse(actual.getGuid().isEmpty());
		assertFalse(actual.getLink().isEmpty());
		assertFalse(actual.getTitle().isEmpty());
	}
}
