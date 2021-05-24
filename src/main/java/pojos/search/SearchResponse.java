/**
 * 
 */
package pojos.search;

/**
 * @author aswingokulachandran
 *
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import entities.ModulesData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class SearchResponse {

	@JsonProperty("data_0")
	private List<LinkedHashMap> data_0;
	@JsonProperty("data_1")
	private List<LinkedHashMap> data_1;
	@JsonProperty("data_2")
	private List<LinkedHashMap> data_2;
	@JsonProperty("data_3")
	private List<LinkedHashMap> data_3;
	@JsonProperty("data_4")
	private List<LinkedHashMap> data_4;
	@JsonProperty("data_5")
	private List<LinkedHashMap> data_5;
	@JsonProperty("data_6")
	private List<LinkedHashMap> data_6;
	@JsonProperty("data_7")
	private List<LinkedHashMap> data_7;
	@JsonProperty("data_8")
	private List<LinkedHashMap> data_8;


	@JsonProperty("modules")
	private List<ModulesData> modules;

}