package org.ownjoo.rss.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.*;

@Data
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="item")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class RssItem
{
	private static final Logger log = LoggerFactory.getLogger(RssItem.class);

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
	@JacksonXmlProperty(localName = "description")
	@Pattern(regexp=NORMAL)
	private String description;

	@XmlElement
	@JacksonXmlProperty(localName = "author")
	@Pattern(regexp=NORMAL)
	private String author;

	@XmlElement
	@JacksonXmlProperty(localName = "guid")
	@Pattern(regexp=NORMAL)
	private String guid;

	@XmlElement
	@JacksonXmlProperty(localName = "link")
	//@org.hibernate.validator.constraints.URL
	@Pattern(regexp=NORMAL)
    private String link;

	public RssItem(){}
    public RssItem(String title, String description, String author, String guid, String link)
    {
    	this.title = title;
        this.description = description;
        this.author = author;
        this.guid = guid;
        this.link = link;
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
