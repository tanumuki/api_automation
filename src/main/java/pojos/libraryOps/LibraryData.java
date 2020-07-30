package pojos.libraryOps;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class LibraryData {

@JsonProperty("playlist")
public List<Playlist> playlist = null;
@JsonProperty("show")
public List<Object> show = null;
@JsonProperty("artist")
public List<Object> artist = null;
@JsonProperty("user")
public User user;


}
