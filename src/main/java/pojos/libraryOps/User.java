package pojos.libraryOps;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class User {

@JsonProperty("fbid")
public String fbid;
@JsonProperty("firstname")
public String firstname;
@JsonProperty("lastname")
public String lastname;
@JsonProperty("uid")
public String uid;
@JsonProperty("username")
public String username;
@JsonProperty("follower_count")
public String followerCount;
@JsonProperty("following_count")
public String followingCount;
@JsonProperty("image")
public String image;



}