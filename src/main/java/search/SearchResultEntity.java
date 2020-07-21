/**
 * 
 */
package search;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)


@ToString
@Data
public class SearchResultEntity {

	@JsonProperty("data")
	private List<DataMini> data = null;
	
	@JsonProperty("position")
	private Integer position;

}