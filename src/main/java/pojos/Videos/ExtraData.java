package pojos.Videos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExtraData {
    @JsonProperty("partner_id")
    private String partnerId;
    @JsonProperty("logo_image_type")
    private String logoImageType;
    @JsonProperty("bg_color")
    private String bgColor;
    @JsonProperty("logo_url")
    private String logoUrl;
    @JsonProperty("partner_watermark")
    private String partnerWatermark;
    @JsonProperty("logo_text")
    private String logoText;
    @JsonProperty("logo_subtext")
    private String logoSubtext;
    @JsonProperty("partner_android_package")
    private String partnerAndroidPackage;
    @JsonProperty("image_type")
    private String imageType;
    @JsonProperty("image_url")
    private String imageUrl;
}
