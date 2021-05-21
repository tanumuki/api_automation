package validators;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.benefits.BenefitsCarouselCTAMatrix;
import pojos.benefits.BenefitsCount;
import pojos.benefits.BenefitsList;
import pojos.benefits.BenefitsUserProType;

import java.util.Arrays;

@Slf4j
public class BenefitsValidator {
    String className = getClass().getName();

    public void validateCount(BenefitsCount benefitsCount, SoftAssert sa) {
        String benefits_count = benefitsCount.getCount();
        sa.assertTrue(Validate.asNum(benefits_count), className + "." + "validate benefits count failed - ");
        log.info(("LOG response benefits count is " + benefits_count));
    }

    public void validateList(BenefitsList benefitsList, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        for (int i = 0; i < benefitsList.getData().length; i++) {
            String benefits_id = benefitsList.getData()[i].getId();
            sa.assertTrue(Validate.asNum(benefits_id), className + "." + "validate benefits id failed for benefit id - "+(benefits_id));
            log.info(("LOG response id in benefits list for benefit " + (benefits_id) + " is " + benefits_id));

            boolean show_raw_code = benefitsList.getData()[i].isShow_raw_code();
            sa.assertTrue(Validate.asBoolean(show_raw_code), className + "." + "validate show raw code failed for benefit id - "+(benefits_id));
            log.info(("LOG response show raw code in benefits list for benefit " + (benefits_id) + " is " + benefits_id));

            String title = benefitsList.getData()[i].getTitle();
            sa.assertTrue(Validate.asString(title), className + "." + "validate title failed for benefit id - "+(benefits_id));
            log.info(("LOG response title in benefits list for benefit " + (benefits_id) + " is " + title));

            String subTitle = benefitsList.getData()[i].getSubtitle();
            sa.assertTrue(Validate.asString(subTitle), className + "." + "validate subtitle failed for benefit id - "+(benefits_id));
            log.info(("LOG response subtitle in benefits list for benefit " + (benefits_id) + " is " + subTitle));

            String event_date = benefitsList.getData()[i].getEvent_date();
            sa.assertTrue(Validate.asDate(event_date), className + "." + "validate event date failed for benefit id - "+(benefits_id));
            log.info(("LOG response event date in benefits list for benefit " + (benefits_id) + " is " + event_date));

            String desc = benefitsList.getData()[i].getDesc();
            sa.assertTrue(Validate.asString(desc), className + "." + "validate desc failed - ");
            log.info(("LOG response desc in benefits list for benefit " + (benefits_id) + " is " + desc));

            String cover_art = benefitsList.getData()[i].getCover_art();
            sa.assertTrue(Validate.asExternalURL(cover_art), className + "." + "validate cover art URL failed for benefit id - "+(benefits_id));
            log.info(("LOG response cover art in benefits list for benefit " + (benefits_id) + " is " + cover_art));

            for (int j = 0; j < benefitsList.getData()[i].getTerms().length; j++) {
                String terms = benefitsList.getData()[i].getTerms()[j];
                sa.assertTrue(Validate.asString(terms), className + "." + "validate terms failed for benefit id - "+(benefits_id));
            }
            log.info(("LOG response terms in benefits list for benefit " + (benefits_id) + " is " + Arrays.toString(benefitsList.getData()[i].getTerms())));

            String codes_info = benefitsList.getData()[i].getCodes_info();
            sa.assertTrue(Validate.asString(codes_info), className + "." + "validate codes info failed for benefit id - "+(benefits_id));
            log.info(("LOG response codes info in benefits list for benefit " + (benefits_id) + " is " + codes_info));

            String ticket_info = benefitsList.getData()[i].getTicket_info();
            sa.assertTrue(Validate.asString(ticket_info), className + "." + "validate ticket info failed for benefit id - "+(benefits_id));
            log.info(("LOG response ticket info in benefits list for benefit " + (benefits_id) + " is " + ticket_info));

            String expiry = benefitsList.getData()[i].getExpiry();
            sa.assertTrue(Validate.asDateTime(expiry), className + "." + "validate expiry failed for benefit id - "+(benefits_id));
            log.info(("LOG response expiry in benefits list for benefit " + (benefits_id) + " is " + expiry));

            String used_count = benefitsList.getData()[i].getUsed_count();
            sa.assertTrue(Validate.asNum(used_count), className + "." + "validate used count failed for benefit id - "+(benefits_id));
            log.info(("LOG response used count in benefits list for benefit " + (benefits_id) + " is " + used_count));

            for (int j = 0; j < benefitsList.getData()[i].getAccess().length; j++) {
                String access = benefitsList.getData()[i].getAccess()[j];
                sa.assertTrue(Validate.asBenefitsAccess(access), className + "." + "validate access failed for benefit id - "+(benefits_id));
            }
            log.info(("LOG response access in benefits list for benefit " + (benefits_id) + " is " + Arrays.toString(benefitsList.getData()[i].getAccess())));

            if (Validate.isNonEmptyString(benefitsList.getData()[i].getPriority())) {
                String priority = benefitsList.getData()[i].getPriority();
                sa.assertTrue(Validate.asNum(priority), className + "." + "validate priority failed for benefit id - "+(benefits_id));
                log.info(("LOG response priority in benefits list for benefit " + (benefits_id) + " is " + priority));

            } else {
                log.info(("LOG response priority in benefits list for benefit " + (benefits_id) + " is NULL or empty"));
            }

            if (Validate.isNonEmptyString(benefitsList.getData()[i].getCreated_at())) {
                String created_at = benefitsList.getData()[i].getCreated_at();
                sa.assertTrue(Validate.asDate(created_at), className + "." + "validate created at failed for benefit id - "+(benefits_id));
                log.info(("LOG response priority in benefits list for benefit " + (benefits_id) + " is " + created_at));

            } else {
                log.info(("LOG response created date in benefits list for benefit " + (benefits_id) + " is NULL or empty"));
            }

            String status = benefitsList.getData()[i].getStatus();
            sa.assertTrue(Validate.asBenefitStatus(status), className + "." + "validate status failed for benefit id - "+(benefits_id));
            log.info(("LOG response status in benefits list for benefit " + (benefits_id) + " is " + status));

            String section = benefitsList.getData()[i].getSection();
            sa.assertTrue(Validate.asBenefitSection(section), className + "." + "validate section failed for benefit id - "+(benefits_id));
            log.info(("LOG response section in benefits list for benefit " + (benefits_id) + " is " + section));

//            Only the redeemed rewards will have the code
            if(benefitsList.getData()[i].getCode()!=null) {
                String code = benefitsList.getData()[i].getCode();
                sa.assertTrue(Validate.asString(code), className + "." + "validate code failed for benefit id - "+(benefits_id));
                log.info(("LOG response code in benefits list for benefit " + (benefits_id) + " is " + code));
            }

            String category = benefitsList.getData()[i].getCategory();
            sa.assertTrue(Validate.asString(category), className + "." + "validate category failed for benefit id - "+(benefits_id));
            log.info(("LOG response category in benefits list for benefit " + (benefits_id) + " is " + category));

            String category_id = benefitsList.getData()[i].getCategory_id();
            sa.assertTrue(Validate.asString(category_id), className + "." + "validate category_id failed for benefit id - "+(benefits_id));
            log.info(("LOG response category_id in benefits list for benefit " + (benefits_id) + " is " + category_id));

            String top_reward = benefitsList.getData()[i].getTop_reward();
            sa.assertTrue(Validate.asBoolean(top_reward), className + "." + "validate top_reward failed for benefit id - "+(benefits_id));
            log.info(("LOG response top_reward in benefits list for benefit " + (benefits_id) + " is " + top_reward));

            String highligter_tag = benefitsList.getData()[i].getHighligter_tag();
            sa.assertTrue(Validate.asString(highligter_tag), className + "." + "validate highligter_tag failed for benefit id - "+(benefits_id));
            log.info(("LOG response highligter_tag in benefits list for benefit " + (benefits_id) + " is " + highligter_tag));

            String monetary_value = benefitsList.getData()[i].getMonetary_value();
            sa.assertTrue(Validate.asNum(monetary_value), className + "." + "validate monetary_value failed for benefit id - "+(benefits_id));
            log.info(("LOG response monetary_value in benefits list for benefit " + (benefits_id) + " is " + monetary_value));
        }

//        VALIDATE METADATA - FREE
        sa.assertTrue(Validate.asBenefitMetadataTitle(benefitsList.getMetadata().getFree().getTitle()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.free.title", benefitsList.getMetadata().getFree().getTitle()));
        sa.assertTrue(Validate.asHexColour(benefitsList.getMetadata().getFree().getColor()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.free.color", benefitsList.getMetadata().getFree().getColor()));
        sa.assertTrue(Validate.asDeeplink(benefitsList.getMetadata().getFree().getDeeplink()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.free.deeplink", benefitsList.getMetadata().getFree().getDeeplink()));

//        VALIDATE METADATA - EXPIRED
        sa.assertTrue(Validate.asBenefitMetadataTitle(benefitsList.getMetadata().getExpired().getTitle()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.expired.title", benefitsList.getMetadata().getExpired().getTitle()));
        sa.assertTrue(Validate.asHexColour(benefitsList.getMetadata().getExpired().getColor()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.expired.color", benefitsList.getMetadata().getExpired().getColor()));
        sa.assertTrue(Validate.asDeeplink(benefitsList.getMetadata().getExpired().getDeeplink()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.expired.deeplink", benefitsList.getMetadata().getExpired().getDeeplink()));

//        VALIDATE METADATA - TRIAL
        sa.assertTrue(Validate.asBenefitMetadataTitle(benefitsList.getMetadata().getTrial().getTitle()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.trial.title", benefitsList.getMetadata().getTrial().getTitle()));
        sa.assertTrue(Validate.asHexColour(benefitsList.getMetadata().getTrial().getColor()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.trial.color", benefitsList.getMetadata().getTrial().getColor()));
        sa.assertTrue(Validate.asDeeplink(benefitsList.getMetadata().getTrial().getDeeplink()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.trial.deeplink", benefitsList.getMetadata().getTrial().getDeeplink()));

//        VALIDATE METADATA - PLUS
        sa.assertTrue(Validate.asBenefitMetadataTitle(benefitsList.getMetadata().getPlus().getTitle()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.plus.title", benefitsList.getMetadata().getPlus().getTitle()));
        sa.assertTrue(Validate.asHexColour(benefitsList.getMetadata().getPlus().getColor()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.plus.color", benefitsList.getMetadata().getPlus().getColor()));
        sa.assertTrue(Validate.asDeeplink(benefitsList.getMetadata().getPlus().getDeeplink()),
                AssertionMsg.print(className, methodName,"metadata.carousel_cta_matrix.plus.deeplink", benefitsList.getMetadata().getPlus().getDeeplink()));

    }
}