/**
 *
 */
package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aswingokulachandran
 *
 */
@Data
@Getter
@Setter
public class Entity {

    @JsonProperty("id")
    protected String id;
    @JsonProperty("title")
    protected String title;
    @JsonProperty("subtitle")
    protected String subtitle;
    @JsonProperty("type")
    protected String type;
    @JsonProperty("perma_url")
    protected String permaUrl;
    @JsonProperty("image")
    protected String image;
    @JsonProperty("language")
    protected String language;
    @JsonProperty("year")
    protected String year;
    @JsonProperty("play_count")
    protected String playCount;
    @JsonProperty("explicit_content")
    protected String explicitContent;
    @JsonProperty("list_count")
    protected String listCount;
    @JsonProperty("list_type")
    protected String listType;
    @JsonProperty("header_desc")
    private String headerDesc;

}
