package org.ownjoo.rss.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RssItemTests
{
	private RssItem rssItem;

	@Before
	public void setup()
	{
		rssItem = new RssItem();
	}

	@Test
	public void shouldInstantiateFeed()
	{
		assertNotNull(rssItem);
	}

	@Test
	public void shouldInstantiateFeedWithArgs()
	{
		String title = "title";
		String link = "http://localhost:8080/";
		String description = "description";
		String author = "Bob";
		String guid = "0000";

		RssItem actual = new RssItem(title, link, description, author, guid);

		assertNotNull(actual);
	}

}
