/**
 *
 */
package pojos.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ashwinsriv
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class ListeningHistoryMedia {

    @JsonProperty("media")
    private Object media;
    @JsonProperty("playcount")
    private int playCount;
    @JsonProperty ("ts")
    private Long ts;
}