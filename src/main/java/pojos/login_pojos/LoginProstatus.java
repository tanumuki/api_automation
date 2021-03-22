package pojos.login_pojos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "type", "offer_trial", "product", "expiration_timestamp", "slots_used", "vendor" })


@Data
@Getter
@Setter
public class LoginProstatus {


//	public LoginProstatus() {
//		super();
//	}
	
	
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
	@JsonProperty("pro_features")
	private List<String> pro_features;
	@JsonProperty("tier_id")
	private String tier_id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("subtitle")
	private String subtitle;
	@JsonProperty("product_details")
	private ProductDetails product_details;
}