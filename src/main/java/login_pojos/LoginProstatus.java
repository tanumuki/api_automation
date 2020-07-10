package login_pojos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "offer_trial", "product", "expiration_timestamp", "slots_used", "vendor" })
public class LoginProstatus {

	@JsonProperty("type")
	private String type;
	@JsonProperty("offer_trial")
	private String offerTrial;
	@JsonProperty("product")
	private String product;
	@JsonProperty("expiration_timestamp")
	private Integer expirationTimestamp;
	@JsonProperty("slots_used")
	private List<SlotsUsed> slotsUsed = null;
	@JsonProperty("vendor")
	private String vendor;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public LoginProstatus() {
	}

	/**
	 *
	 * @param product
	 * @param vendor
	 * @param expirationTimestamp
	 * @param type
	 * @param offerTrial
	 * @param slotsUsed
	 */
	public LoginProstatus(String type, String offerTrial, String product, Integer expirationTimestamp,
			List<SlotsUsed> slotsUsed, String vendor) {
		super();
		this.type = type;
		this.offerTrial = offerTrial;
		this.product = product;
		this.expirationTimestamp = expirationTimestamp;
		this.slotsUsed = slotsUsed;
		this.vendor = vendor;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("offer_trial")
	public String getOfferTrial() {
		return offerTrial;
	}

	@JsonProperty("offer_trial")
	public void setOfferTrial(String offerTrial) {
		this.offerTrial = offerTrial;
	}

	@JsonProperty("product")
	public String getProduct() {
		return product;
	}

	@JsonProperty("product")
	public void setProduct(String product) {
		this.product = product;
	}

	@JsonProperty("expiration_timestamp")
	public Integer getExpirationTimestamp() {
		return expirationTimestamp;
	}

	@JsonProperty("expiration_timestamp")
	public void setExpirationTimestamp(Integer expirationTimestamp) {
		this.expirationTimestamp = expirationTimestamp;
	}

	@JsonProperty("slots_used")
	public List<SlotsUsed> getSlotsUsed() {
		return slotsUsed;
	}

	@JsonProperty("slots_used")
	public void setSlotsUsed(List<SlotsUsed> slotsUsed) {
		this.slotsUsed = slotsUsed;
	}

	@JsonProperty("vendor")
	public String getVendor() {
		return vendor;
	}

	@JsonProperty("vendor")
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}