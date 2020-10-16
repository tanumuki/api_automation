package validators.PodcastGetAllValidator;

import org.testng.asserts.SoftAssert;
import pojos.libraryOps.SongData;
import pojos.podcastsGetAll.PodcastCategory;
import pojos.podcastsGetAll.PodcastCategoryMoreInfo;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;

public class PodcastCategoryValidator extends EntityValidator {
    final String className = getClass().getName();

    public void validate(PodcastCategory pc, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(pc, sa);
        if(pc != null) {
            if(pc.getTotalCount() != null) {
                sa.assertTrue(Validate.asNum(pc.getTotalCount()), AssertionMsg.print(className, methodName, "category.total_count", String.valueOf(pc.getTotalCount())));
            }

            if(pc.getSeasonNumber() != null) {
                sa.assertTrue(Validate.asNum(pc.getSeasonNumber()), AssertionMsg.print(className, methodName, "category.season_number", String.valueOf(pc.getSeasonNumber())));
            }

            if(Validate.isNonEmptyString(pc.getCategoryType())) {
                sa.assertTrue(Validate.asString(pc.getCategoryType()), AssertionMsg.print(className, methodName, "category.category_type", pc.getCategoryType()));
            }

            validateMoreInfo(pc.getMoreInfo(), sa);
        }
    }

    void validateMoreInfo(PodcastCategoryMoreInfo cm, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(cm != null) {
            if(Validate.isNonEmptyString(cm.getBgColor())) {
                sa.assertTrue(Validate.asString(cm.getBgColor()), AssertionMsg.print(className, methodName, "category.more_info.bg_color", cm.getBgColor()));
            }

            if(Validate.isNonEmptyString(cm.getDescription())) {
                sa.assertTrue(Validate.asString(cm.getDescription()), AssertionMsg.print(className, methodName, "category.more_info.description", cm.getDescription()));
            }

            if(Validate.isNonEmptyString(cm.getSquareImage())) {
                sa.assertTrue(Validate.asCDNURL(cm.getSquareImage()), AssertionMsg.print(className, methodName, "category.more_info.square_image", cm.getSquareImage()));
            }
        }
    }
}
