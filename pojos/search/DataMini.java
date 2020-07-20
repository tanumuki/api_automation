/**
 * 
 */
package search;

/**
 * @author aswingokulachandran
 *
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@Data
public class DataMini {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("subtitle")
	private String subtitle;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("perma_url")
	private String permaUrl;
	
	@JsonProperty("more_info")
	private MoreInfo moreInfo;
	
	@JsonProperty("explicit_content")
	private String explicitContent;
	
	@JsonProperty("mini_obj")
	private Boolean miniObj;
	
	@JsonProperty("description")
	private String description;

	@JsonProperty("extra")
	private String extra;

	@JsonProperty("isRadioPresent")
	private Boolean isRadioPresent;
	
	@JsonProperty("ctr")
	private Integer ctr;
	
	@JsonProperty("entity")
	private Integer entity;

	@JsonProperty("position")
	private Integer position;

}
