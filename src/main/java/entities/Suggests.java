package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Suggests {
    @JsonProperty("headline")
    private String headline;
    @JsonProperty("badge")
    private String badge;
    @JsonProperty("items")
    private List<PlaylistMini> items = null;
}
