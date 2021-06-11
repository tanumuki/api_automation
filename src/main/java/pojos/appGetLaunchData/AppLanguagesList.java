package pojos.appGetLaunchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppLanguagesList {

    @JsonProperty("English")
    private String english;
    @JsonProperty("हिंदी")
    private String hindi;
    @JsonProperty("বাংলা")
    private String bengali;
    @JsonProperty("தமிழ்")
    private String tamil;
    @JsonProperty("తెలుగు")
    private String telugu;
    @JsonProperty("ಕನ್ನಡ")
    private String kannada;
    @JsonProperty("ਪੰਜਾਬੀ")
    private String punjabi;
    @JsonProperty("मराठी")
    private String marathi;
    @JsonProperty("ગુજરાતી")
    private String gujarati;
    @JsonProperty("മലയാളം")
    private String malyalam;
    @JsonProperty("हरियाणवी")
    private String haryanvi;
    @JsonProperty("भोजपुरी")
    private String bhojpuri;
}
