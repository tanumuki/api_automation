/**
 * 
 */
package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aswingokulachandran
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class Artist {

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("role")
	private String role;
	@JsonProperty("image")
	private String image;
	@JsonProperty("type")
	private String type;
	@JsonProperty("perma_url")
	private String permaUrl;
	@JsonProperty("ctr")
	private Integer ctr;
	@JsonProperty("entity")
	private Integer entity;
	@JsonProperty("mini_obj")
	private Boolean mini_obj;
	@JsonProperty("isRadioPresent")
	private Boolean isRadioPresent;
	@JsonProperty("is_followed")
	private Boolean is_followed;



}
