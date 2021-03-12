package validators.genericValidators;

import org.testng.asserts.SoftAssert;
import pojos.login_pojos.LoginProstatus;
import pojos.login_pojos.ProductDetails;
import pojos.login_pojos.SlotsUsed;
import validators.AssertionMsg;
import validators.Validate;

public class LoginProStatusValidator {
    final String className = getClass().getName();
    public void validate(LoginProstatus lp, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(lp.getType()))
            sa.assertTrue(Validate.asProStatusType(lp.getType()), AssertionMsg.print(className, methodName, "user_state.prostatus.type", lp.getType()));

        if(Validate.isNonEmptyString(lp.getOfferTrial()))
            sa.assertTrue(Validate.asBoolean(lp.getOfferTrial()), AssertionMsg.print(className, methodName, "user_state.prostatus.offer_trial", lp.getOfferTrial()));

        if(Validate.isNonEmptyString(lp.getProduct()))
            sa.assertTrue(Validate.asString(lp.getProduct()), AssertionMsg.print(className, methodName, "user_state.prostatus.product", lp.getProduct()));

        if(lp.getExpirationTimestamp() != null)
            sa.assertTrue(Validate.asTimeStamp(String.valueOf(lp.getExpirationTimestamp())),
                    AssertionMsg.print(className, methodName, "user_state.prostatus.expiration_timestamp", String.valueOf(lp.getExpirationTimestamp())));

        if(Validate.isNonEmptyString(lp.getVendor()))
            sa.assertTrue(Validate.asString(lp.getVendor()), AssertionMsg.print(className, methodName, "user_state.prostatus.vendor", lp.getVendor()));

        if(lp.getSlotsUsed() != null){
            for(SlotsUsed slot : lp.getSlotsUsed()){
                new SlotsUsedValidator().validate(slot, sa);
            }
        }

        if(lp.getPro_features() != null){
            for(int i=0; i<lp.getPro_features().size(); i++){
                sa.assertTrue(Validate.asProFeatures(lp.getPro_features().get(i)), AssertionMsg.print(className, methodName, "user_state.prostatus.pro_features", lp.getPro_features().toString()));
            }
        }

        if(Validate.isNonEmptyString(lp.getTier_id())){
            sa.assertTrue(Validate.asProStatusTierId(lp.getTier_id()), AssertionMsg.print(className, methodName, "user_state.prostatus.tier_id", lp.getTier_id()));
        }

        if(Validate.isNonEmptyString(lp.getTitle())){
            sa.assertTrue(Validate.asString(lp.getTitle()), AssertionMsg.print(className, methodName, "user_state.prostatus.title", lp.getTitle()));
        }

        if(Validate.isNonEmptyString(lp.getSubtitle())){
            sa.assertTrue(Validate.asString(lp.getSubtitle()), AssertionMsg.print(className, methodName, "user_state.prostatus.subtitle", lp.getSubtitle()));
        }

        if(lp.getProduct_details() != null)
            validateProductDetails(lp.getProduct_details(), sa);
    }

    void validateProductDetails(ProductDetails pd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(pd.getName())){
            sa.assertTrue(Validate.asString(pd.getName()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.name", pd.getName()));
        }

        if(Validate.isNonEmptyString(pd.getCat())){
            sa.assertTrue(Validate.asProType(pd.getCat()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.cat", pd.getCat()));
        }

        if(Validate.isNonEmptyString(pd.getId())){
            sa.assertTrue(Validate.asString(pd.getName()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.id", pd.getId()));
        }

        if(Validate.isNonEmptyString(pd.getDormant_period())){
            sa.assertTrue(Validate.asNum(pd.getDormant_period()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.dormant_period", pd.getDormant_period()));
        }

        if(Validate.isNonEmptyString(pd.getGrace_period())){
            sa.assertTrue(Validate.asNum(pd.getGrace_period()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.grace_period", pd.getGrace_period()));
        }

        if(Validate.isNonEmptyString(pd.getStorage_limit())){
            sa.assertTrue(Validate.asFloat(pd.getStorage_limit()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.storage_limit", pd.getStorage_limit()));
        }

        if(Validate.isNonEmptyString(pd.getDevice_limit())){
            sa.assertTrue(Validate.asNum(pd.getDevice_limit()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.device_limit", pd.getDevice_limit()));
        }

        if(Validate.isNonEmptyString(pd.getPeriod())){
            sa.assertTrue(Validate.asNum(pd.getPeriod()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.period", pd.getPeriod()));
        }

        if(Validate.isNonEmptyString(pd.getPeriod_unit())){
            sa.assertTrue(Validate.asProPeriodUnit(pd.getPeriod_unit()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.period_unit", pd.getPeriod_unit()));
        }

        if(Validate.isNonEmptyString(pd.getDescription())){
            sa.assertTrue(Validate.asString(pd.getDescription()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.description", pd.getDescription()));
        }

        if(Validate.isNonEmptyString(pd.getTier_id())){
            sa.assertTrue(Validate.asProStatusTierId(pd.getTier_id()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.tier_id", pd.getTier_id()));
        }

        if(Validate.isNonEmptyString(pd.getPrice_display_per_unit())){
            sa.assertTrue(Validate.asString(pd.getPrice_display_per_unit()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.price_display_per_unit", pd.getPrice_display_per_unit()));
        }

        if(Validate.isNonEmptyString(pd.getPrice())){
            sa.assertTrue(Validate.asNum(pd.getPrice()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.price", pd.getPrice()));
        }

        if(Validate.isNonEmptyString(pd.getPrice_display())){
            sa.assertTrue(Validate.asString(pd.getPrice_display()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.price_display", pd.getPrice_display()));
        }

        if(Validate.isNonEmptyString(pd.getHighlight())){
            sa.assertTrue(Validate.asString(pd.getHighlight()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.highlight", pd.getHighlight()));
        }

        if(Validate.isNonEmptyString(pd.getDuration())){
            sa.assertTrue(Validate.asString(pd.getDuration()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.duration", pd.getDuration()));
        }

        if(Validate.isNonEmptyString(pd.getPrice_text())){
            sa.assertTrue(Validate.asString(pd.getPrice_text()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.price_text", pd.getPrice_text()));
        }

        if(pd.getVendor() != null){
            for(String vendor : pd.getVendor())
                sa.assertTrue(Validate.asProVendors(vendor), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.vendor", pd.getVendor().toString()));
        }

        if(Validate.isNonEmptyString(pd.getCurrency())){
            sa.assertTrue(Validate.asString(pd.getCurrency()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.currency", pd.getCurrency()));
        }

        if(Validate.isNonEmptyString(pd.getAutorenew_text())){
            sa.assertTrue(Validate.asString(pd.getAutorenew_text()), AssertionMsg.print(className, methodName, "user_state.prostatus.product_details.autorenew_text", pd.getAutorenew_text()));
        }
    }
}
