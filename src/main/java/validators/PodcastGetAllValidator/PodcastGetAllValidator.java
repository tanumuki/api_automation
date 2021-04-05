package validators.PodcastGetAllValidator;

import entities.Episode;
import org.testng.asserts.SoftAssert;
import pojos.podcastsGetAll.*;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EpisodeValidator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PodcastGetAllValidator {
    final String className = getClass().getName();

    public void validate(PodcastGetAllPojo pg, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        //validate modules
        new ModuleValidator().validateModules(pg.getModules(), sa);

        //Validate base_menu
        for (PodcastsMenu pb : pg.getBaseMenu()) {
            validatePodcastMenu(pb, sa);
        }

        //Validate new and trending
        if (pg.getNewAndTrending() != null) {
            for (Episode episode : pg.getNewAndTrending()) {
                new EpisodeValidator().validate(episode, sa);
            }
        }

        //Validate podcast home modules
        for (Map.Entry<String, List<LinkedHashMap>> entry : pg.getPodcastHomeModule().entrySet()) {
            String key = entry.getKey();
            sa.assertTrue(Validate.asString(key), AssertionMsg.print(className, methodName, "podcast_home_modules", key));

            Validate.asAssortedEntity(entry.getValue(), sa);
        }

    }

    public void validatePodcastMenu(PodcastsMenu pbm, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if (pbm != null) {
            if (Validate.isNonEmptyString(pbm.getSearchApi())) {
                sa.assertTrue(Validate.asString(pbm.getSearchApi()), AssertionMsg.print(className, methodName, "base_menu.search_api", pbm.getSearchApi()));
            }

            if (Validate.isNonEmptyString(pbm.getTitle())) {
                sa.assertTrue(Validate.asString(pbm.getTitle()), AssertionMsg.print(className, methodName, "base_menu.title", pbm.getTitle()));
            }

            if (Validate.isNonEmptyString(pbm.getImage())) {
                sa.assertTrue(Validate.asExternalURL(pbm.getImage()), AssertionMsg.print(className, methodName, "base_menu.image", pbm.getImage()));
            }

            if (Validate.isNonEmptyString(pbm.getType())) {
                sa.assertTrue(Validate.asString(pbm.getType()), AssertionMsg.print(className, methodName, "base_menu.type", pbm.getType()));
            }

            if (pbm.getSourceApi() != null) {
                sa.assertTrue(Validate.asBoolean(pbm.getSourceApi()), AssertionMsg.print(className, methodName, "base_menu.source_api", String.valueOf(pbm.getSourceApi())));
            }

            if (Validate.isNonEmptyString(pbm.getSource())) {
                sa.assertTrue(Validate.asString(pbm.getSource()), AssertionMsg.print(className, methodName, "base_menu.source", pbm.getSource()));
            }

            if (Validate.isNonEmptyString(pbm.getSourceView())) {
                sa.assertTrue(Validate.asString(pbm.getSourceView()), AssertionMsg.print(className, methodName, "base_menu.source_view", pbm.getSourceView()));
            }

            if (Validate.isNonEmptyString(pbm.getSearchApi())) {
                sa.assertTrue(Validate.asString(pbm.getSearchApi()), AssertionMsg.print(className, methodName, "base_menu.search_api", pbm.getSearchApi()));
            }

            if (pbm.getSearchParam() != null && Validate.isNonEmptyString(pbm.getSearchParam().getType())) {
                sa.assertTrue(Validate.asString(pbm.getSearchParam().getType()), AssertionMsg.print(className, methodName, "search_param.type", pbm.getSearchParam().getType()));
            }

            PodcastsSourceParams sp = pbm.getSourceParams();
            if (Validate.isNonEmptyString(sp.getPageParam())) {
                sa.assertTrue(Validate.asString(sp.getPageParam()), AssertionMsg.print(className, methodName, "source_params.page_param", sp.getPageParam()));
            }

            if (Validate.isNonEmptyString(sp.getSizeParam())) {
                sa.assertTrue(Validate.asString(sp.getSizeParam()), AssertionMsg.print(className, methodName, "source_params.size_param", sp.getSizeParam()));
            }

            if (Validate.isNonEmptyString(sp.getTypeParam())) {
                sa.assertTrue(Validate.asString(sp.getTypeParam()), AssertionMsg.print(className, methodName, "source_params.type_param", sp.getTypeParam()));
            }

            List<PodcastsTag> tags = pbm.getTags();
            if (tags != null && tags.size() > 0) {
                for (PodcastsTag tag : tags) {
                    if (tag != null) {
                        if (Validate.isNonEmptyString(tag.getName())) {
                            sa.assertTrue(Validate.asString(tag.getName()), AssertionMsg.print(className, methodName, "tag.name", tag.getName()));
                        }

                        if (Validate.isNonEmptyString(tag.getTypeParamValue())) {
                            sa.assertTrue(Validate.asString(tag.getTypeParamValue()), AssertionMsg.print(className, methodName, "tag.type_param_value", tag.getTypeParamValue()));
                        }

                        if (Validate.isNonEmptyString(tag.getSourceView())) {
                            sa.assertTrue(Validate.asModulesScrollType(tag.getSourceView()), AssertionMsg.print(className, methodName, "tag.source_view", tag.getSourceView()));
                        }
                    }
                }
            }

        }
    }


}
