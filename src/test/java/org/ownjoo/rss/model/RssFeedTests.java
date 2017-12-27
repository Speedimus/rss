package org.ownjoo.rss.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RssFeedTests
{
	private RssItem rssFeed;
	String expectedTitle = "title";
	String expectedLink = "http://localhost:8080";
	String expectedDescription = "description";
	String expectedLanguage = "en-us";
	String expectedCopyright = "2000";
	String expectedPubDate = "2000-Jan-01";
	String expectedAuthor = "bob";
	String expectedGuid = expectedLink;
	RssChannel channel;
	List<RssChannel> channels;

	@Before
	public void setup()
	{
		channel = new RssChannel( expectedTitle, expectedLink, expectedDescription, expectedLanguage, expectedCopyright, expectedPubDate );
		channel.getRssItems().add( new RssItem( expectedTitle, expectedDescription, expectedAuthor, expectedGuid, expectedLink ) );
		channels = new LinkedList<>();
		channels.add(channel);
	}

	@Test
	public void shouldInstantiateFeedWithArgs()
	{
		RssFeed actualFeed = new RssFeed(channels);
		assertNotNull(actualFeed);
		List<RssChannel> channels = actualFeed.getChannels();
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

}
