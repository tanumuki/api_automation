/**
 * 
 */
package validators;

import org.testng.asserts.SoftAssert;

import search.DataMini;
import search.SearchResponse;
import search.SearchResultEntity;

/**
 * @author aswingokulachandran
 *
 */
public class SearchResponseValidator {
	String className = SearchResponse.class.getName();
	public void validate(SearchResponse response, SoftAssert sa) {
		SearchResultEntity albums = response.getAlbums();
		this.validateAlbums(albums, sa);
	}
	
	String assertionMsg(String methodName, String entityType, String fieldName, String value) {
		return className + " " + methodName + " - " + entityType + " " + fieldName +" failed assertion -- value: \""+ value + "\"";
	}
	
	public void validateAlbums(SearchResultEntity albums, SoftAssert sa) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();		
		System.out.println(className + " " + methodName + " - position: " + albums.getPosition());
		for(DataMini data : albums.getData()) {
			this.validateData(data, sa, "album");
		}
	}
	
	public void validateData(DataMini data, SoftAssert sa, String entityType) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();	
		System.out.println();
		sa.assertTrue(Validate.asId(data.getId()), assertionMsg(methodName, entityType, "id", data.getId()));
		
		sa.assertTrue(Validate.asString(data.getTitle()), assertionMsg(methodName, entityType, "title", data.getTitle()));
		
		sa.assertTrue(Validate.asString(data.getSubtitle()), assertionMsg(methodName, entityType, "subtitle", data.getSubtitle()));
		
		sa.assertTrue(Validate.asString(data.getType()), assertionMsg(methodName, entityType, "type", data.getType()));
		
		sa.assertTrue(Validate.asUrl(data.getImage()), assertionMsg(methodName, entityType, "image", data.getImage()));
		
		sa.assertTrue(Validate.asUrl(data.getPermaUrl()), assertionMsg(methodName, entityType, "perma_url", data.getPermaUrl()));
		
		sa.assertTrue(Validate.asString(data.getExplicitContent()), assertionMsg(methodName, entityType, "explicit_content", data.getExplicitContent()));
		
//		sa.assertTrue(Validate.asBoolean(data.getMiniObj()), assertionMsg(methodName, entityType, "mini_obj", data.getExplicitContent()));
		
		sa.assertTrue(Validate.asString(data.getDescription()), assertionMsg(methodName, entityType, "description", data.getDescription()));
		
		sa.assertTrue(Validate.asString(data.getExtra()), assertionMsg(methodName, entityType, "extra", data.getExtra()));
		
//		sa.assertTrue(Validate.asString(data.getIsRadioPresent()), assertionMsg(methodName, entityType, "isRadioPresent", data.getIsRadioPresent()));
		
		
	}

}
