package validators.showGetHome;

import entities.Artist;
import entities.ArtistMap;
import entities.Season;
import entities.SeasonMoreInfo;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.genericValidators.ArtistMapValidator;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.SongValidator;
import validators.Validate;

public class SeasonValidator extends EntityValidator {
    final String className = getClass().getName();

    public void validate(Season season, SoftAssert sa, String sourceEntity, String sourceType) {
        super.validate(season, sa, sourceEntity, sourceType);
    }

    public void validateMoreInfo(SeasonMoreInfo mi, SoftAssert sa, String seasonid) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(Validate.asString(mi.getDescription()), AssertionMsg.print(className, methodName, "season", "season.more_info.description", mi.getDescription(), seasonid));

        sa.assertTrue(Validate.asString(mi.getSongInfo()), AssertionMsg.print(className, methodName, "season", "season.more_info.song_info", mi.getSongInfo(), seasonid));

        sa.assertTrue(Validate.asNum(mi.getShowId()), AssertionMsg.print(className, methodName, "season", "season.more_info.showId", mi.getShowId(), seasonid));

        sa.assertTrue(Validate.asString(mi.getShowTitle()), AssertionMsg.print(className, methodName, "season", "season.more_info.show_title", mi.getShowTitle(), seasonid));

        sa.assertTrue(Validate.asString(mi.getNumEpisodes()), AssertionMsg.print(className, methodName, "season", "season.more_info.numEpisodes", mi.getNumEpisodes(), seasonid));

        sa.assertTrue(Validate.asString(mi.getEncryptedMediaUrl()), AssertionMsg.print(className, methodName, "season", "season.more_info.encrypted_media_url", mi.getEncryptedMediaUrl(), seasonid));

        sa.assertTrue(Validate.asString(mi.getSeasonNumber()), AssertionMsg.print(className, methodName, "season", "season.more_info.season_number", mi.getSeasonNumber(), seasonid));

        sa.assertTrue(Validate.asString(mi.getSongInfo()), AssertionMsg.print(className, methodName, "season", "season.more_info.song_info", mi.getSongInfo(), seasonid));

        ArtistMap artistMap = mi.getArtistMap();

        new ArtistMapValidator().validate(artistMap, sa, "season", seasonid);
    }
}

