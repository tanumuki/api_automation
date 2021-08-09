package pojos.jioTuneLogin.ssoPojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.hu.De;

public class SsoObjectToJson {


    public static String  parseSso() throws JsonProcessingException {
        SsoPojo pojo = new SsoPojo();
       pojo = getSsoPojo(pojo);
       //creating object mapper
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString= objectMapper.writeValueAsString(pojo);
        return jsonString;

    }


    public static SsoPojo getSsoPojo(SsoPojo pojo){

        DeviceInfo deviceInfo = new DeviceInfo();
        Platform platform=new Platform();
        platform.setName("RMX2001");
        Info info = new Info();
        info.setAndroidId("54a18c4b9c8cb694");
        deviceInfo.setConsumptionDeviceName("realme RMX2001");
        deviceInfo.setJToken("1d42f57092c109ca85936c6bf150b8a2.2c4445f35b2a3a1dfa3f9de629d0cbc79efdb4c6d1c7ba83054e450301ff1ba2caabd57867778c1f91aab1e8c47ff3f049c0e93af2c0218acb9b45e52cd717816250bca26268a41b9a7a89dc61de6301f1481b7f063182ce8aa8e7e872f513417138a6cd7e530816b281ff65f83f0d435164d9666cd56241a906f20ddceaf187e0df1a62e9c76c6dd19538b281664b65812ca5c4d5b1f33acde6c132ccbb66d21bf36f2066864d81f36d632ceed0e4ed377bce586c8995fcbc2c72e568889f87b3ac458b2a797bc4f88fb5442e085884d5282587dddc3b4895cb44b3ba9dde9707cd3fa09bd11bfd17da25886ab75a857946dec2c85af2e0c2391153bc41d416fb503d7007cbf331105ec91485657d00c92259441cc2b8eab00162c18e4a4a3eec19ce62a620b5a783002472ac05e38f23681366531ac50aa56e4174a188f28aef18945b16f529a49593b29c7f9c736d5e41004845b1d38fab07fcbaa9d38241f82e57866634e2300dbc14ca14fc193d");
        deviceInfo.setInfo(info);
        info.setPlatform(platform);
        info.setType("android");
        pojo.setDeviceInfo(deviceInfo);

        return pojo;

    }



}