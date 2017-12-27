package org.ownjoo.rss.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="rss")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RssFeed
{
	private static final Logger log = LoggerFactory.getLogger(RssFeed.class);

	@Id
	@GeneratedValue
	private Long id;

	@XmlElement
	@JacksonXmlProperty(localName = "channel")
	@JacksonXmlElementWrapper(useWrapping = false)
	private final List<RssChannel> channels;

	@Override
	public String toString()
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);
		}
		catch(JsonProcessingException j)
		{
			log.debug(j.getMessage(), j);
			return super.toString();
		}
	}

}
