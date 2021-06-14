/**
 * 
 */
package entities;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aswingokulachandran
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class Webradio extends Entity {

	public Webradio(){}

//	private Map<String, Song> songEntity = new HashMap<>();
//	@JsonAnySetter
//	public void setProviders(String key, Song val){
//		songEntity.put(key, val);
//	}

	@JsonProperty("song")
	public Song song;


}
