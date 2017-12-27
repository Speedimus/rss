package org.ownjoo.rss.service;

import org.ownjoo.rss.domain.Subscription;
import org.ownjoo.rss.model.RssFeed;
import org.ownjoo.rss.sc.RssClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class Service
{
	private static final Logger log = LoggerFactory.getLogger(Service.class);

	RssClient client;
	List<Subscription> rssSubscriptions;
	List<RssFeed> feeds;

	public Service()
	{
		init(new LinkedList<>(), new RssClient(), new LinkedList<>());
	}

	public Service(String url)
	{
		List<Subscription> subscriptions = new LinkedList<>();
		subscriptions.add(new Subscription(url));

		init(subscriptions, new RssClient(), new LinkedList<>());
	}

	public Service(List<Subscription> subscriptions)
	{
		init(subscriptions, new RssClient(), new LinkedList<>());
	}

	private void init(List<Subscription> subscriptions, RssClient client, List<RssFeed> feeds)
	{
		this.rssSubscriptions = subscriptions;
		this.client = client;
		this.feeds = feeds;

		poll();
	}

	public List<Subscription> getRssSubscriptions()
	{
		return this.rssSubscriptions;
	}

	public List<RssFeed> getFeeds()
	{
		return this.feeds;
	}

	public void poll()
	{
		for(Subscription sub : this.rssSubscriptions)
		{
			try
			{
				feeds.add(client.getFeed(sub.getUrl()));
			}
			catch(MalformedURLException m)
			{
				log.debug(m.getMessage(), m);
			}
		}
	}
}
