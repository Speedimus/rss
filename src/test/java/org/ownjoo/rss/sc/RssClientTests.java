package org.ownjoo.rss.sc;

import org.junit.Test;
import org.ownjoo.rss.model.RssFeed;
import org.springframework.boot.test.context.SpringBootTest;
import java.net.MalformedURLException;
import static org.junit.Assert.*;

@SpringBootTest
public class RssClientTests
{
	@Test
	public void shouldGetFeed()
	{
		RssClient client = new RssClient();
		String url = "http://www.vogella.com/article.rss";

		try
		{
			RssFeed actual = client.getFeed(url);
			assertNotNull(actual);
		}
		catch(MalformedURLException m)
		{
			assertTrue("bad URL", false);
		}
	}

}
