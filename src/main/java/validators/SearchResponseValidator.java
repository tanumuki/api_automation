/**
 * 
 */
package validators;

import entities.ModulesData;
import org.testng.asserts.SoftAssert;

import pojos.search.DataMini;
import pojos.search.MoreInfo;
import pojos.search.SearchResponse;
import pojos.search.SearchResultEntity;
import validators.genericValidators.ModulesDataValidator;

/**
 * @author aswingokulachandran
 *
 */
public class SearchResponseValidator {
	final String className = getClass().getName();

	public void validate(SearchResponse response, SoftAssert sa) {
		Validate.asAssortedEntity(response.getData_0(), sa);
		Validate.asAssortedEntity(response.getData_1(), sa);
		Validate.asAssortedEntity(response.getData_2(), sa);
		Validate.asAssortedEntity(response.getData_3(), sa);
		Validate.asAssortedEntity(response.getData_4(), sa);
		Validate.asAssortedEntity(response.getData_5(), sa);
		Validate.asAssortedEntity(response.getData_6(), sa);
		Validate.asAssortedEntity(response.getData_7(), sa);
		Validate.asAssortedEntity(response.getData_8(), sa);

		for(ModulesData md : response.getModules()){
			new ModulesDataValidator().validate(md, sa);
		}
	}

	String assertionMsg(String methodName, String entityType, String fieldName, String value) {
		return className + " " + methodName + " - " + entityType + " " + fieldName + " failed assertion -- value: \""
				+ value + "\"";
	}

	public void validateEntity(SearchResultEntity entity, SoftAssert sa) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(className + " " + methodName + " - position: " + entity.getPosition());
		for (DataMini data : entity.getData()) {
			this.validateData(data, sa, data.getType());
		}
	}

	public void validateData(DataMini data, SoftAssert sa, String entityType) {
		try {
			String methodName = new Throwable().getStackTrace()[0].getMethodName();
			System.out.println("methodName: " + methodName);
			sa.assertTrue(Validate.asId(data.getId()), assertionMsg(methodName, entityType, "id", data.getId()));

			sa.assertTrue(Validate.asString(data.getTitle(), sa),
					assertionMsg(methodName, entityType, "title", data.getTitle()));

			if (data.getSubtitle() != null)
				sa.assertTrue(Validate.asString(data.getSubtitle(), sa),
						assertionMsg(methodName, entityType, "subtitle", data.getSubtitle()));

			sa.assertTrue(Validate.asString(data.getType(), sa),
					assertionMsg(methodName, entityType, "type", data.getType()));

			sa.assertTrue(Validate.asCDNURL(data.getImage()),
					assertionMsg(methodName, entityType, "image", data.getImage()));
			
			if(!entityType.equals("artist")) {
				sa.assertTrue(Validate.asString(data.getPermaUrl(), sa),
						assertionMsg(methodName, entityType, "perma_url", data.getPermaUrl()));
				
				sa.assertTrue(Validate.asString(data.getExplicitContent(), sa),
						assertionMsg(methodName, entityType, "explicit_content", data.getExplicitContent()));
			}
				
			

			

			sa.assertTrue(Validate.asString(data.getDescription(), sa),
					assertionMsg(methodName, entityType, "description", data.getDescription()));

			if (data.getExtra() != null)
				sa.assertTrue(Validate.asString(data.getExtra(), sa),
						assertionMsg(methodName, entityType, "extra", data.getExtra()));

			validateMoreInfo(data.getMoreInfo(), sa, entityType);
		} catch (Exception e) {
			System.err.println("Exception for the entityType - " + entityType);
			e.printStackTrace();
		}

	}

	public void validateMoreInfo(MoreInfo moreInfoObj, SoftAssert sa, String entityType) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println("methodName: " + methodName);

		if (entityType.equalsIgnoreCase("album")) {
			sa.assertTrue(Validate.asString(moreInfoObj.getMusic(), sa),
					assertionMsg(methodName, entityType, "music", moreInfoObj.getMusic()));

			sa.assertTrue(Validate.asString(moreInfoObj.getYear(), sa),
					assertionMsg(methodName, entityType, "Year", moreInfoObj.getYear()));

			sa.assertTrue(Validate.asString(moreInfoObj.getIs_movie(), sa),
					assertionMsg(methodName, entityType, "is_movie", moreInfoObj.getIs_movie()));

			sa.assertTrue(Validate.asString(moreInfoObj.getSong_pids(), sa),
					assertionMsg(methodName, entityType, "song_pids", moreInfoObj.getSong_pids()));
		}

		if (entityType.equalsIgnoreCase("song")) {
			sa.assertTrue(Validate.asString(moreInfoObj.getAlbum(), sa),
					assertionMsg(methodName, entityType, "album", moreInfoObj.getAlbum()));

			sa.assertTrue(Validate.asString(moreInfoObj.getScore(), sa),
					assertionMsg(methodName, entityType, "score", moreInfoObj.getScore()));

			if (moreInfoObj.getVcode() != null)
				sa.assertTrue(Validate.asString(moreInfoObj.getVcode(), sa),
						assertionMsg(methodName, entityType, "vcode", moreInfoObj.getVcode()));

			if (moreInfoObj.getVlink() != null)
				sa.assertTrue(Validate.asVlinkURL(moreInfoObj.getVlink()),
						assertionMsg(methodName, entityType, "vlink", moreInfoObj.getVlink()));

			sa.assertTrue(Validate.asString(moreInfoObj.getPrimaryArtists(), sa),
					assertionMsg(methodName, entityType, "primary_artists", moreInfoObj.getPrimaryArtists()));

			sa.assertTrue(Validate.asString(moreInfoObj.getSingers(), sa),
					assertionMsg(methodName, entityType, "singers", moreInfoObj.getSingers()));
		}

		if (entityType.equalsIgnoreCase("radio station")) {
			sa.assertTrue(Validate.asString(moreInfoObj.getUsername(), sa),
					assertionMsg(methodName, entityType, "username", moreInfoObj.getUsername()));

			sa.assertTrue(Validate.asMusicLanguage(moreInfoObj.getLanguage()),
					assertionMsg(methodName, entityType, "language", moreInfoObj.getLanguage()));

			if (moreInfoObj.getUid() != null)
				sa.assertTrue(Validate.asId(moreInfoObj.getUid()),
						assertionMsg(methodName, entityType, "uid", moreInfoObj.getUid()));

			if (moreInfoObj.getSeed() != null)
				sa.assertTrue(Validate.asString(moreInfoObj.getSeed(), sa),
						assertionMsg(methodName, entityType, "seed", moreInfoObj.getSeed()));

			if (moreInfoObj.getCreationDate() != null)
				sa.assertTrue(Validate.asTimeStamp(moreInfoObj.getCreationDate()),
						assertionMsg(methodName, entityType, "creation_date", moreInfoObj.getCreationDate()));

			sa.assertTrue(Validate.asString(moreInfoObj.getFeaturedStationType(), sa), assertionMsg(methodName, entityType,
					"featured_station_type", moreInfoObj.getFeaturedStationType()));

		}

		if (entityType.equalsIgnoreCase("playlist")) {
			sa.assertTrue(Validate.asString(moreInfoObj.getFirstname(), sa),
					assertionMsg(methodName, entityType, "firstname", moreInfoObj.getFirstname()));
			if (moreInfoObj.getArtistName() != null) {
				for (String name : moreInfoObj.getArtistName()) {
					sa.assertTrue(Validate.asString(name, sa), assertionMsg(methodName, entityType, "artist_name", name));
				}

				sa.assertTrue(Validate.asString(moreInfoObj.getLastname(), sa),
						assertionMsg(methodName, entityType, "lastname", moreInfoObj.getLastname()));
			}

		}

		if (entityType.equalsIgnoreCase("playlist") || entityType.equalsIgnoreCase("album")) {
			sa.assertTrue(Validate.asMusicLanguage(moreInfoObj.getLanguage()),
					assertionMsg(methodName, entityType, "language", moreInfoObj.getLanguage()));
		}
	}

}
