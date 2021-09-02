package validators.JiotuneHomepageData;

import entities.JTMenu;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;

/**
 * @author snigdhamajee
 *
 */

@Slf4j
public class JTMenuValidator extends EntityValidator {
    final String className = getClass().getName();

    public void validate(JTMenu jtMenu, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(jtMenu.getTitle())){
            sa.assertTrue(Validate.asString(jtMenu.getTitle()),
                    AssertionMsg.print(className, methodName, "data_0.title", jtMenu.getTitle()));
        }

        if(Validate.isNonEmptyString(jtMenu.getSubtitle())){
            sa.assertTrue(Validate.asString(jtMenu.getSubtitle()),
                    AssertionMsg.print(className, methodName, "data_0.source", jtMenu.getSubtitle()));
        }

        if(Validate.isNonEmptyString(jtMenu.getImage())){
            sa.assertTrue(Validate.asCDNURL(jtMenu.getImage()),
                    AssertionMsg.print(className, methodName, "data_0.source_view", jtMenu.getImage()));
        }

        if(Validate.isNonEmptyString(jtMenu.getType())){
            sa.assertTrue(Validate.asEntityType(jtMenu.getType()),
                    AssertionMsg.print(className, methodName, "data_0.type", jtMenu.getType()));
        }

        if(jtMenu.getSourceAPI()!=null){
            sa.assertTrue(Validate.asBoolean(jtMenu.getSourceAPI()),
                    AssertionMsg.print(className, methodName, "data_0.source_api", String.valueOf(jtMenu.getSourceAPI())));
        }

        if(Validate.isNonEmptyString(jtMenu.getSource())){
            sa.assertTrue(Validate.asString(jtMenu.getSource()),
                    AssertionMsg.print(className, methodName, "data_0.source", jtMenu.getSource()));
        }

        if(Validate.isNonEmptyString(jtMenu.getSource_view())){
            sa.assertTrue(Validate.asModulesScrollType(jtMenu.getSource_view()),
                    AssertionMsg.print(className, methodName, "data_0.source_view", jtMenu.getSource_view()));
        }

        if(Validate.isNonEmptyString(jtMenu.getSearch_api())){
            sa.assertTrue(Validate.asString(jtMenu.getSearch_api()),
                    AssertionMsg.print(className, methodName, "data_0.search_api", jtMenu.getSearch_api()));
        }

        if(Validate.isNonEmptyString(jtMenu.getSearch_placeholder())){
            sa.assertTrue(Validate.asString(jtMenu.getSearch_placeholder()),
                    AssertionMsg.print(className, methodName, "data_0.search_placeholder", jtMenu.getSearch_placeholder()));
        }

        if(jtMenu.getSource_params() != null){
            sa.assertTrue(Validate.asString(jtMenu.getSource_params().getSize_param()),
                    AssertionMsg.print(className, methodName, "data_0.source_params.size_param", jtMenu.getSource_params().getSize_param()));

            sa.assertTrue(Validate.asString(jtMenu.getSource_params().getSize_param()),
                    AssertionMsg.print(className, methodName, "data_0.source_params.size_param", jtMenu.getSource_params().getSize_param()));

        }
        else if(jtMenu.getTitle().matches("Top JioTunes")){
            log.info("Top Jiotunes doesn't have source params");
        }
    }
}
