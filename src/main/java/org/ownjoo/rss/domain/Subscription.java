package org.ownjoo.rss.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class Subscription
{
	private static final Logger log = LoggerFactory.getLogger(Subscription.class);

	private final static String NORMAL = "(|^[\\w+-_+.#].*)";
	private final static String URL = "(^[\\w:/.-_?&=+].*)";

    @Id
    @GeneratedValue
    private Long id;

	@Pattern(regexp=NORMAL)
	private String label;

	@Pattern(regexp=NORMAL)
	private String description;

	@org.hibernate.validator.constraints.URL
	@Pattern(regexp=NORMAL)
    private String url;

	public Subscription(){}

	public Subscription(String url)
	{
		init(url, "", "");
	}

	public Subscription(String url, String label)
	{
		init(url, label, "");
	}

	public Subscription(String url, String label, String description)
    {
    	init(url, label, description);
    }

	private void init(String url, String label, String description)
	{
		this.label = label;
		this.description = description;
		this.url = url;
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
