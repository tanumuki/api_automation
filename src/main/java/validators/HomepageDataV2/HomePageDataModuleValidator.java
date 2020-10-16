package validators.HomepageDataV2;

import org.testng.asserts.SoftAssert;
import pojos.getHomePageDataV2.HomePageDataModules;
import validators.genericValidators.ModulesDataValidator;

public class HomePageDataModuleValidator {
    final String className = getClass().getName();

    public void validate(HomePageDataModules hm, SoftAssert sa) {
        //Validate history
        new ModulesDataValidator().validate(hm.getHistory(), sa);

        //Validate charts
        new ModulesDataValidator().validate(hm.getCharts(), sa);

        //Validate new_trending
        new ModulesDataValidator().validate(hm.getNewTrending(), sa);

        //Validate radio
        new ModulesDataValidator().validate(hm.getRadio(), sa);

        //Validate artist_recos
        new ModulesDataValidator().validate(hm.getArtistRecos(), sa);

        //Validate new albums
        new ModulesDataValidator().validate(hm.getNewAlbums(), sa);

        //Validate city_mod
        new ModulesDataValidator().validate(hm.getCityMod(), sa);

        //Validate top_playlists
        new ModulesDataValidator().validate(hm.getTopPlaylists(), sa);

        //Validate tag_mixes
        new ModulesDataValidator().validate(hm.getTagMixes(), sa);

        //Validate top_shows
        new ModulesDataValidator().validate(hm.getTopShows(), sa);

    }

}
