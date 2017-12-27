package org.ownjoo.rss.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RssChannelTests
{
	private RssChannel rssChannel;

	@Before
	public void setup()
	{
		rssChannel = new RssChannel();
	}

	@Test
	public void shouldInstantiateFeed()
	{
		assertNotNull(rssChannel);
	}

	@Test
	public void shouldInstantiateFeedWithArgs()
	{
		String title = "title";
		String link = "http://localhost:8080/";
		String description = "description";
		String language = "language";
		String copyright = "2000";
		String pubDate = "2018-Jan-01";

		RssChannel actual = new RssChannel(title, link, description, language, copyright, pubDate);

		assertNotNull(actual);
	}

	@Test
	public void shouldGetFeedList()
	{
		assertNotNull(rssChannel.getRssItems());
	}

	@Test
	public void shouldAddFeedToList()
	{
		rssChannel.getRssItems().add(new RssItem());
		assertTrue(rssChannel.getRssItems().size() > 0);
	}
}
