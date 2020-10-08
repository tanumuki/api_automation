package validators.HomepageDataV2;

import org.testng.asserts.SoftAssert;
import pojos.getHomePageDataV2.HomePageDataModules;
import pojos.libraryOps.SongData;
import validators.genericValidators.ModulesValidator;

public class HomePageDataModuleValidator {
    final String className = getClass().getName();

    void validate(HomePageDataModules hm, SoftAssert sa) {
        //Validate history
        new ModulesValidator().validate(hm.getHistory(), sa);

        //Validate charts
        new ModulesValidator().validate(hm.getCharts(), sa);

        //Validate new_trending
        new ModulesValidator().validate(hm.getNewTrending(), sa);

        //Validate radio
        new ModulesValidator().validate(hm.getRadio(), sa);

        //Validate artist_recos
        new ModulesValidator().validate(hm.getArtistRecos(), sa);

        //Validate new albums
        new ModulesValidator().validate(hm.getNewAlbums(), sa);

        //Validate city_mod
        new ModulesValidator().validate(hm.getCityMod(), sa);

        //Validate top_playlists
        new ModulesValidator().validate(hm.getTopPlaylists(), sa);

        //Validate tag_mixes
        new ModulesValidator().validate(hm.getTagMixes(), sa);

        //Validate top_shows
        new ModulesValidator().validate(hm.getTopShows(), sa);

    }

}
