/**
 * 
 */
package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import validators.PlaylistMiniValidator;
import validators.Validate;
import validators.genericValidators.AlbumMiniValidator;
import validators.genericValidators.EpisodeValidator;
import validators.genericValidators.SongValidator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author ashwinsriv
 *
 * Use this class when the response has an assortment of entities like playlist, album, song, episode, etc.
 * Add another handler to the method below for the type you are looking for (in case it's not already present),
 * and just pass the JSON Response as an argument from the step definition.
 * The JSON Deserialization will be done here instead of in the step definition file.
 *
 * Contact [ashwinsriv] for any other queries
 */

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AssortedEntities {

    public static void readAndValidateAssortedEntity(Response response, SoftAssert sa) {
        Validate.asAssortedEntity(response, sa);
    }

    /**
     * This method will return all the values of the requested `key` from the JSON Array.
     * See sample implementation in ContentGetTrending pagination step
     * @param response
     * @param key
     * @return
     */
    public static List<String> getValuesForAllKeys(Response response, String key) {
        List<LinkedHashMap> entityList = response.jsonPath().getJsonObject("$");
        List<String> valueList = new ArrayList<String>();
        String keyValue;

        for (LinkedHashMap item : entityList) {
            keyValue = item.get(key).toString();
//            System.out.println("Adding: " + key + " Value: " + keyValue);
            valueList.add(keyValue);
        }

        return valueList;
    }
}
