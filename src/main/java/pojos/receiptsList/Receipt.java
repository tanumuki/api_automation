package pojos.receiptsList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class Receipt {
    @JsonProperty("invoice_id")
    private String invoiceId;
    @JsonProperty("invoice_enc_id")
    private String invoiceEncId;
    @JsonProperty("vendor")
    private String vendor;
    @JsonProperty("product_duration")
    private String productDuration;
    @JsonProperty("purchase_date")
    private String purchaseDate;
    @JsonProperty("product_period_unit")
    private String productPeriodUnit;
    @JsonProperty("product_price_per_unit")
    private String product_price_per_unit;
    @JsonProperty("auto_renewal")
    private Boolean auto_renewal;
    @JsonProperty("invoice_creation_time")
    private String invoice_creation_time;
    @JsonProperty("total_amount")
    private String total_amount;

}
