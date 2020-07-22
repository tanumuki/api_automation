/**
 * 
 */
package pojos.search;

/**
 * @author aswingokulachandran
 *
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class DataMini {

	@JsonProperty("id")
	private String id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("subtitle")
	private String subtitle;
	@JsonProperty("type")
	private String type;
	@JsonProperty("image")
	private String image;
	@JsonProperty("perma_url")
	private String permaUrl;
	@JsonProperty("more_info")
	private MoreInfo moreInfo;
	@JsonProperty("explicit_content")
	private String explicitContent;
	@JsonProperty("mini_obj")
	private Boolean miniObj;
	@JsonProperty("description")
	private String description;

	@JsonProperty("extra")
	private String extra;

	@JsonProperty("isRadioPresent")
	private Boolean isRadioPresent;
	@JsonProperty("ctr")
	private Integer ctr;
	@JsonProperty("entity")
	private Integer entity;

	@JsonProperty("position")
	private Integer position;
	

	@JsonProperty("extra")
	public String getExtra() {
		return extra;
	}

	@JsonProperty("extra")
	public void setExtra(String extra) {
		this.extra = extra;
	}

	@JsonProperty("isRadioPresent")
	public Boolean getIsRadioPresent() {
		return isRadioPresent;
	}

	@JsonProperty("isRadioPresent")
	public void setIsRadioPresent(Boolean isRadioPresent) {
		this.isRadioPresent = isRadioPresent;
	}

	@JsonProperty("ctr")
	public Integer getCtr() {
		return ctr;
	}

	@JsonProperty("ctr")
	public void setCtr(Integer ctr) {
		this.ctr = ctr;
	}

	@JsonProperty("entity")
	public Integer getEntity() {
		return entity;
	}

	@JsonProperty("entity")
	public void setEntity(Integer entity) {
		this.entity = entity;
	}

	@JsonProperty("position")
	public Integer getPosition() {
		return position;
	}

	@JsonProperty("position")
	public void setPosition(Integer position) {
		this.position = position;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	public DataMini withId(String id) {
		this.id = id;
		return this;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	public DataMini withTitle(String title) {
		this.title = title;
		return this;
	}

	@JsonProperty("subtitle")
	public String getSubtitle() {
		return subtitle;
	}

	@JsonProperty("subtitle")
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public DataMini withSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	public DataMini withType(String type) {
		this.type = type;
		return this;
	}

	@JsonProperty("image")
	public String getImage() {
		return image;
	}

	@JsonProperty("image")
	public void setImage(String image) {
		this.image = image;
	}

	public DataMini withImage(String image) {
		this.image = image;
		return this;
	}

	@JsonProperty("perma_url")
	public String getPermaUrl() {
		return permaUrl;
	}

	@JsonProperty("perma_url")
	public void setPermaUrl(String permaUrl) {
		this.permaUrl = permaUrl;
	}

	public DataMini withPermaUrl(String permaUrl) {
		this.permaUrl = permaUrl;
		return this;
	}

	@JsonProperty("more_info")
	public MoreInfo getMoreInfo() {
		return moreInfo;
	}

	@JsonProperty("more_info")
	public void setMoreInfo(MoreInfo moreInfo) {
		this.moreInfo = moreInfo;
	}

	public DataMini withMoreInfo(MoreInfo moreInfo) {
		this.moreInfo = moreInfo;
		return this;
	}

	@JsonProperty("explicit_content")
	public String getExplicitContent() {
		return explicitContent;
	}

	@JsonProperty("explicit_content")
	public void setExplicitContent(String explicitContent) {
		this.explicitContent = explicitContent;
	}

	public DataMini withExplicitContent(String explicitContent) {
		this.explicitContent = explicitContent;
		return this;
	}

	@JsonProperty("mini_obj")
	public Boolean getMiniObj() {
		return miniObj;
	}

	@JsonProperty("mini_obj")
	public void setMiniObj(Boolean miniObj) {
		this.miniObj = miniObj;
	}

	public DataMini withMiniObj(Boolean miniObj) {
		this.miniObj = miniObj;
		return this;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	public DataMini withDescription(String description) {
		this.description = description;
		return this;
	}

}
