package pojos.libraryOps;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {

	@JsonProperty("id")
	public int id;
	@JsonProperty("ts")
	public String ts;


}