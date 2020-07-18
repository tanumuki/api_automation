package login_pojos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "offer_trial", "product", "expiration_timestamp", "slots_used", "vendor" })


@Data
@Builder
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


}