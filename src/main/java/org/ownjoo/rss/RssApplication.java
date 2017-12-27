package org.ownjoo.rss;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RssApplication
{
	private static final Logger log = LoggerFactory.getLogger(RssApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(RssApplication.class, args);

	}

}
