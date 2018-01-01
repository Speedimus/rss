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
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="rss")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RssChannel
{
	private static final Logger log = LoggerFactory.getLogger(RssChannel.class);

	private final static String NORMAL = "(|^[\\w+-_+.#].*)";
	private final static String URL = "(^[\\w:/.-_?&=+].*)";

    @Id
    @GeneratedValue
    private Long id;

    @XmlElement
    @JacksonXmlProperty(localName = "title")
	@Pattern(regexp=NORMAL)
	private String title;

	@XmlElement
	@JacksonXmlProperty(localName = "link")
	//@org.hibernate.validator.constraints.URL
	@Pattern(regexp=NORMAL)
	private String link;

	@XmlElement
	@JacksonXmlProperty(localName = "description")
	@Pattern(regexp=NORMAL)
	private String description;

	@XmlElement
	@JacksonXmlProperty(localName = "language")
	@Pattern(regexp=NORMAL)
	private String language;

	@XmlElement
	@JacksonXmlProperty(localName = "copyright")
	@Pattern(regexp=NORMAL)
	private String copyright;

	@XmlElement
	@JacksonXmlProperty(localName = "pubDate")
	//@DateTimeFormat("[some date format]")
	@Pattern(regexp=NORMAL)
	private String pubDate;

	@XmlElement
	@JacksonXmlProperty(localName = "item")
	@JacksonXmlElementWrapper(useWrapping = false)
	private final List<RssItem> rssItems = new ArrayList<>();

	public RssChannel(){}
    public RssChannel(String title, String link, String description, String language, String copyright, String pubDate)
    {
    	this.title = title;
	    this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
    }

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
