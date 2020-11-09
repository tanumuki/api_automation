package validators;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.benefits.BenefitsCount;
import pojos.benefits.BenefitsList;

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
        for (int i = 0; i < benefitsList.getData().length; i++) {
            String benefits_id = benefitsList.getData()[i].getId();
            sa.assertTrue(Validate.asNum(benefits_id), className + "." + "validate benefits id failed for benefit number - "+(i+1));
            log.info(("LOG response id in benefits list for benefit " + (i + 1) + " is " + benefits_id));

            boolean show_raw_code = benefitsList.getData()[i].isShow_raw_code();
            sa.assertTrue(Validate.asBoolean(show_raw_code), className + "." + "validate show raw code failed for benefit number - "+(i+1));
            log.info(("LOG response show raw code in benefits list for benefit " + (i + 1) + " is " + benefits_id));

            String title = benefitsList.getData()[i].getTitle();
            sa.assertTrue(Validate.asString(title), className + "." + "validate title failed for benefit number - "+(i+1));
            log.info(("LOG response title in benefits list for benefit " + (i + 1) + " is " + title));

            String subTitle = benefitsList.getData()[i].getSubtitle();
            sa.assertTrue(Validate.asString(subTitle), className + "." + "validate subtitle failed for benefit number - "+(i+1));
            log.info(("LOG response subtitle in benefits list for benefit " + (i + 1) + " is " + subTitle));

            String event_date = benefitsList.getData()[i].getEvent_date();
            sa.assertTrue(Validate.asDate(event_date), className + "." + "validate event date failed for benefit number - "+(i+1));
            log.info(("LOG response event date in benefits list for benefit " + (i + 1) + " is " + event_date));

            String desc = benefitsList.getData()[i].getDesc();
            sa.assertTrue(Validate.asString(desc), className + "." + "validate desc failed - ");
            log.info(("LOG response desc in benefits list for benefit " + (i + 1) + " is " + desc));

            String cover_art = benefitsList.getData()[i].getCover_art();
            sa.assertTrue(Validate.asExternalURL(cover_art), className + "." + "validate cover art URL failed for benefit number - "+(i+1));
            log.info(("LOG response cover art in benefits list for benefit " + (i + 1) + " is " + cover_art));

            for (int j = 0; j < benefitsList.getData()[i].getTerms().length; j++) {
                String terms = benefitsList.getData()[i].getTerms()[j];
                sa.assertTrue(Validate.asString(terms), className + "." + "validate terms failed for benefit number - "+(i+1));
            }
            log.info(("LOG response terms in benefits list for benefit " + (i + 1) + " is " + Arrays.toString(benefitsList.getData()[i].getTerms())));

            String codes_info = benefitsList.getData()[i].getCodes_info();
            sa.assertTrue(Validate.asString(codes_info), className + "." + "validate codes info failed for benefit number - "+(i+1));
            log.info(("LOG response codes info in benefits list for benefit " + (i + 1) + " is " + codes_info));

            String ticket_info = benefitsList.getData()[i].getTicket_info();
            sa.assertTrue(Validate.asString(ticket_info), className + "." + "validate ticket info failed for benefit number - "+(i+1));
            log.info(("LOG response ticket info in benefits list for benefit " + (i + 1) + " is " + ticket_info));

            String expiry = benefitsList.getData()[i].getExpiry();
            sa.assertTrue(Validate.asDateTime(expiry), className + "." + "validate expiry failed for benefit number - "+(i+1));
            log.info(("LOG response expiry in benefits list for benefit " + (i + 1) + " is " + expiry));

            String used_count = benefitsList.getData()[i].getUsed_count();
            sa.assertTrue(Validate.asNum(used_count), className + "." + "validate used count failed for benefit number - "+(i+1));
            log.info(("LOG response used count in benefits list for benefit " + (i + 1) + " is " + used_count));

            for (int j = 0; j < benefitsList.getData()[i].getAccess().length; j++) {
                String access = benefitsList.getData()[i].getAccess()[j];
                sa.assertTrue(Validate.asAccess(access), className + "." + "validate access failed for benefit number - "+(i+1));
            }
            log.info(("LOG response access in benefits list for benefit " + (i + 1) + " is " + Arrays.toString(benefitsList.getData()[i].getAccess())));

            if (Validate.isNonEmptyString(benefitsList.getData()[i].getPriority())) {
                String priority = benefitsList.getData()[i].getPriority();
                sa.assertTrue(Validate.asNum(priority), className + "." + "validate priority failed for benefit number - "+(i+1));
                log.info(("LOG response priority in benefits list for benefit " + (i + 1) + " is " + priority));

            } else {
                log.info(("LOG response priority in benefits list for benefit " + (i + 1) + " is NULL or empty"));
            }

            if (Validate.isNonEmptyString(benefitsList.getData()[i].getCreated_at())) {
                String created_at = benefitsList.getData()[i].getCreated_at();
                sa.assertTrue(Validate.asDate(created_at), className + "." + "validate created at failed for benefit number - "+(i+1));
                log.info(("LOG response priority in benefits list for benefit " + (i + 1) + " is " + created_at));

            } else {
                log.info(("LOG response created date in benefits list for benefit " + (i + 1) + " is NULL or empty"));
            }

            String status = benefitsList.getData()[i].getStatus();
            sa.assertTrue(Validate.asString(status), className + "." + "validate status failed for benefit number - "+(i+1));
            log.info(("LOG response status in benefits list for benefit " + (i + 1) + " is " + status));

            String section = benefitsList.getData()[i].getSection();
            sa.assertTrue(Validate.asString(section), className + "." + "validate section failed for benefit number - "+(i+1));
            log.info(("LOG response section in benefits list for benefit " + (i + 1) + " is " + section));
        }
    }
}