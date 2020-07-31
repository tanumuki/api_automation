package pojos.libraryOps;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter

public class SongData extends LibraryData{
	
	


	@JsonProperty("song")
	public List<String> song = null;
	

}
