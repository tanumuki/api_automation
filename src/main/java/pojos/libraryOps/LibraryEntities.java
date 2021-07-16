package pojos.libraryOps;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class LibraryEntities extends Entity {

    public LibraryEntities(){}

    @JsonProperty("list")
    private Object list;
    @JsonProperty("more_info")
    private LibraryMoreInfo libraryMoreInfo;

}
