package org.ownjoo.rss.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionTests
{
	private Subscription subscription;

	@Before
	public void setup()
	{
		subscription = new Subscription();
	}

	@Test
	public void shouldInstantiateSubscription()
	{
		assertNotNull(subscription);
	}

	@Test
	public void shouldInstantiateSubscriptionWith1Arg()
	{
		String link = "http://localhost:8080/";

		Subscription actual = new Subscription(link);

		assertNotNull(actual);
		assertEquals(link, actual.getUrl());
	}

	@Test
	public void shouldInstantiateSubscriptionWith2Args()
	{
		String link = "http://localhost:8080/";
		String title = "title";

		Subscription actual = new Subscription(link, title);

		assertNotNull(actual);
		assertEquals(link, actual.getUrl());
		assertEquals(title, actual.getLabel());
	}

	@Test
	public void shouldInstantiateSubscriptionWith3Args()
	{
		String link = "http://localhost:8080/";
		String title = "title";
		String description = "description";

		Subscription actual = new Subscription(link, title, description);

		assertNotNull(actual);
		assertEquals(link, actual.getUrl());
		assertEquals(title, actual.getLabel());
		assertEquals(description, actual.getDescription());
	}

}
