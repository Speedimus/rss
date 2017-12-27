package org.ownjoo.rss.sc;

import org.ownjoo.rss.model.RssChannel;
import org.ownjoo.rss.model.RssFeed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class RssClient
{
	private static final Logger log = LoggerFactory.getLogger(RssClient.class);

	public RssFeed getFeed(URL url)
	{
		RssFeed result;
		result = new RestTemplate().getForObject(url.toString(), RssFeed.class);
		return result;
	}

	public RssFeed getFeed(String url) throws MalformedURLException
	{
		RssFeed result;

		try
		{
			result = getFeed(new URL(url));
		}
		catch(MalformedURLException m)
		{
			log.debug(m.getMessage());
			throw m;
		}

		return result;
	}

}
