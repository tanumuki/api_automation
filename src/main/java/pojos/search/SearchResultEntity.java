/**
 * 
 */
package pojos.search;

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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data", "position" })
public class SearchResultEntity {

	@JsonProperty("data")
	private List<DataMini> data = null;
	@JsonProperty("position")
	private Integer position;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("data")
	public List<DataMini> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<DataMini> data) {
		this.data = data;
	}

	public SearchResultEntity withData(List<DataMini> data) {
		this.data = data;
		return this;
	}

	@JsonProperty("position")
	public Integer getPosition() {
		return position;
	}

	@JsonProperty("position")
	public void setPosition(Integer position) {
		this.position = position;
	}

	public SearchResultEntity withPosition(Integer position) {
		this.position = position;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public SearchResultEntity withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}