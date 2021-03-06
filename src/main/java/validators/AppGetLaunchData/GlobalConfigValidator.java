package validators.AppGetLaunchData;

import org.testng.asserts.SoftAssert;
import pojos.appGetLaunchData.*;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.DeeplinkValidator;

import java.util.Map;

public class GlobalConfigValidator {
    final String className = getClass().getName();

    public void validate(AppGetLaunchData data, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        AppGetLaunchDataGlobalConfig gc = data.getGlobal_config();
        sa.assertTrue(Validate.asBoolean(gc.getShowDemographicModal()), AssertionMsg.print(className, methodName, "global_config.show_demographic_modal", String.valueOf(gc.getShowDemographicModal())));

        sa.assertTrue(Validate.asBoolean(gc.getShowLanguageSelectionScreen()), AssertionMsg.print(className, methodName, "global_config.show_language_selection_screen_modal", String.valueOf(gc.getShowLanguageSelectionScreen())));

        sa.assertTrue(Validate.asBoolean(gc.getShow_app_language_modal()), AssertionMsg.print(className, methodName, "global_config.show_demoapp_language_modal", String.valueOf(gc.getShow_app_language_modal())));

        sa.assertTrue(Validate.asBoolean(gc.getForceHttps()), AssertionMsg.print(className, methodName, "global_config.force_https", String.valueOf(gc.getShowDemographicModal())));

        sa.assertTrue(Validate.asNum(gc.getSpotlight_image_width()), AssertionMsg.print(className, methodName, "global_config.spotlight_image_width", gc.getSpotlight_image_width()));

        sa.assertTrue(Validate.asNum(gc.getSpotlight_image_height()), AssertionMsg.print(className, methodName, "global_config.spotlight_image_height", gc.getSpotlight_image_height()));

        sa.assertTrue(Validate.asNum(gc.getSpotlight_image_expiry()), AssertionMsg.print(className, methodName, "global_config.spotlight_image_expiry", gc.getSpotlight_image_expiry()));

        sa.assertTrue(Validate.asNum(gc.getSpotlight_view_image_width()), AssertionMsg.print(className, methodName, "global_config.spotlight_view_image_width", gc.getSpotlight_view_image_width()));

        sa.assertTrue(Validate.asNum(gc.getSpotlight_view_image_height()), AssertionMsg.print(className, methodName, "global_config.spotlight_view_image_height", gc.getSpotlight_view_image_height()));

        sa.assertTrue(Validate.asNum(gc.getSpotlight_view_image_expiry()), AssertionMsg.print(className, methodName, "global_config.spotlight_view_image_expiry", gc.getSpotlight_view_image_expiry()));

        sa.assertTrue(Validate.asNum(gc.getSpotlight_view_image_width()), AssertionMsg.print(className, methodName, "global_config.spotlight_view_image_width", gc.getSpotlight_view_image_width()));

        sa.assertTrue(Validate.asCDNURL(gc.getSpotlight_image()), AssertionMsg.print(className, methodName, "global_config.spotlight_image", gc.getSpotlight_image()));

        sa.assertTrue(Validate.asCDNURL(gc.getSpotlight_view_image()), AssertionMsg.print(className, methodName, "global_config.spotlight_view_image", gc.getSpotlight_view_image()));

        sa.assertTrue(Validate.asString(gc.getSpotlight_movie_acronym()), AssertionMsg.print(className, methodName, "global_config.spotlight_movie_acronym", gc.getSpotlight_movie_acronym()));

        sa.assertTrue(Validate.asString(gc.getSpotlight_action()), AssertionMsg.print(className, methodName, "global_config.spotlight_action", gc.getSpotlight_action()));

        sa.assertTrue(Validate.asNum(gc.getSpotlight_content()), AssertionMsg.print(className, methodName, "global_config.spotlight_content", gc.getSpotlight_content()));

        sa.assertTrue(Validate.asString(gc.getSpotlight_content_name()), AssertionMsg.print(className, methodName, "global_config.spotlight_content_name", gc.getSpotlight_content_name()));

        sa.assertTrue(Validate.asString(gc.getSpotlight_view_action()), AssertionMsg.print(className, methodName, "global_config.spotlight_view_action", gc.getSpotlight_view_action()));

        sa.assertTrue(Validate.asNum(gc.getSpotlight_view_content()), AssertionMsg.print(className, methodName, "global_config.spotlight_view_content", gc.getSpotlight_view_content()));

        sa.assertTrue(Validate.asNum(gc.getConnection_timeout()), AssertionMsg.print(className, methodName, "global_config.connection_timeout", String.valueOf(gc.getConnection_timeout())));

        sa.assertTrue(Validate.asNum(gc.getSocket_timeout()), AssertionMsg.print(className, methodName, "global_config.socket_timeout", String.valueOf(gc.getSocket_timeout())));

        sa.assertTrue(Validate.asFloat(gc.getSong_object_version()), AssertionMsg.print(className, methodName, "global_config.song_object_version", String.valueOf(gc.getSong_object_version())));

        //TODO: Validate Stream config

        sa.assertTrue(Validate.asNum(gc.getNotification_duration()), AssertionMsg.print(className, methodName, "global_config.notification_duration", String.valueOf(gc.getNotification_duration())));

        String appVersion = System.getProperty("app_version");
        sa.assertTrue(appVersion.equals(gc.getApp_version()), AssertionMsg.print(className, methodName, "global_config.app_version", String.valueOf(gc.getApp_version())));

        if (System.getProperty("ctx").equalsIgnoreCase("Android"))
            sa.assertTrue(Validate.asString(gc.getRadio_spotlight_action()), AssertionMsg.print(className, methodName, "global_config.radio_spotlight_action", gc.getRadio_spotlight_action()));

        if (System.getProperty("ctx").equalsIgnoreCase("Android"))
            sa.assertTrue(Validate.asBoolean(gc.getShow_radio_roadblock()), AssertionMsg.print(className, methodName, "global_config.show_radio_roadblock", String.valueOf(gc.getShow_radio_roadblock())));

        //Validate ad_config
        for (String str : gc.getAdConfig().getNetworks()) {
            sa.assertTrue(Validate.asString(str), AssertionMsg.print(className, methodName, "global_config.ad_config.networks", str));
        }

        //Validate supported languages
        for (String lang : gc.getSupportedLanguages()) {
            sa.assertTrue(Validate.asMusicLanguages(lang), AssertionMsg.print(className, methodName, "global_config.supported_languages", lang));
        }

        //Validate radio supported languages
        for (String lang : gc.getRadioSupportedLanguages()) {
            sa.assertTrue(Validate.asMusicLanguages(lang), AssertionMsg.print(className, methodName, "global_config.radio_supported_languages", lang));
        }

        sa.assertTrue(Validate.asBoolean(gc.getAf_enabled()), AssertionMsg.print(className, methodName, "global_config.af_enabled", String.valueOf(gc.getAf_enabled())));

        sa.assertTrue(Validate.asBoolean(gc.getCf_enabled()), AssertionMsg.print(className, methodName, "global_config.cf_enabled", String.valueOf(gc.getCf_enabled())));

        sa.assertTrue(Validate.asNum(gc.getUser_inbox_limit()), AssertionMsg.print(className, methodName, "global_config.user_inbox_limit", String.valueOf(gc.getUser_inbox_limit())));

        sa.assertTrue(Validate.asBoolean(gc.getAf_enabled()), AssertionMsg.print(className, methodName, "global_config.af_enabled", String.valueOf(gc.getAf_enabled())));

        //Validate labelInfo
        validateLabelInfo(gc.getLabelInfo(), sa);

        sa.assertTrue(Validate.asBoolean(gc.getCarriers_available()), AssertionMsg.print(className, methodName, "global_config.carriers_available", gc.getCarriers_available()));

        sa.assertTrue(Validate.asNum(gc.getFreemium_skip_limit()), AssertionMsg.print(className, methodName, "global_config.freemium_skip_limit", String.valueOf(gc.getFreemium_skip_limit())));

        sa.assertTrue(Validate.asNum(gc.getFreemium_skip_interval()), AssertionMsg.print(className, methodName, "global_config.freemium_skip_interval", String.valueOf(gc.getFreemium_skip_interval())));

        sa.assertTrue(Validate.asNum(gc.getFreemium_skip_limit()), AssertionMsg.print(className, methodName, "global_config.freemium_skip_limit", String.valueOf(gc.getFreemium_skip_limit())));

        //TODO: weekly_top_songs_list
        //TODO: random_songs_list

        sa.assertTrue(Validate.asNum(gc.getIdleScreenTime()), AssertionMsg.print(className, methodName, "global_config.idle_screen_time", String.valueOf(gc.getIdleScreenTime())));

        sa.assertTrue(Validate.asNum(gc.getFreemium_skip_limit()), AssertionMsg.print(className, methodName, "global_config.freemium_skip_limit", String.valueOf(gc.getFreemium_skip_limit())));

        //Validate cache config
        validateCacheConfig(gc.getCacheConfig(), sa);

        sa.assertTrue(Validate.asBoolean(gc.getMigration()), AssertionMsg.print(className, methodName, "global_config.migration", gc.getMigration()));

        sa.assertTrue(Validate.asBoolean(gc.getJioanalytics()), AssertionMsg.print(className, methodName, "global_config.jio_analytics", gc.getJioanalytics()));

        sa.assertTrue(Validate.asNum(gc.getJiotunes_last_updated_at()), AssertionMsg.print(className, methodName, "global_config.jio_tunes_last_updated_at", String.valueOf(gc.getJiotunes_last_updated_at())));

        sa.assertTrue(Validate.asNum(gc.getVideo_data_update()), AssertionMsg.print(className, methodName, "global_config.video_data_update", String.valueOf(gc.getVideo_data_update())));

        sa.assertTrue(Validate.asBoolean(gc.getComscore()), AssertionMsg.print(className, methodName, "global_config.comscore", gc.getComscore()));

        sa.assertTrue(Validate.asBoolean(gc.getGive_jio_trial()), AssertionMsg.print(className, methodName, "global_config.give_jio_trial", gc.getGive_jio_trial()));

        sa.assertTrue(Validate.asBoolean(gc.getMadme()), AssertionMsg.print(className, methodName, "global_config.madme", gc.getMadme()));

        sa.assertTrue(Validate.asBoolean(gc.getClevertap()), AssertionMsg.print(className, methodName, "global_config.clevertap", gc.getClevertap()));

        validateOtpProviders(gc.getPhn_otp_providers(), sa);

        //product details
        if (gc.getProduct_details() != null)
            validateProductDetails(gc.getProduct_details(), sa);

        // trial
        validateTrial(gc.getTrial(), sa);

        // upi providers
        for (String up : gc.getUpiProviders()) {
            sa.assertTrue(Validate.asString(up), AssertionMsg.print(className, methodName, "global_config.upi_providers", up));
        }

        sa.assertTrue(Validate.asBoolean(gc.getBenefits_enabled()), AssertionMsg.print(className, methodName, "global_config.benefits_enabled", gc.getBenefits_enabled()));

        sa.assertTrue(Validate.asBoolean(gc.getDevice_mgmt_enabled()), AssertionMsg.print(className, methodName, "global_config.device_mgmt_enabled", gc.getDevice_mgmt_enabled()));

        sa.assertTrue(Validate.asBoolean(gc.getRead_only_mode()), AssertionMsg.print(className, methodName, "global_config.read_only_mode", String.valueOf(gc.getRead_only_mode())));

        sa.assertTrue(Validate.asNum(gc.getServer_ts()), AssertionMsg.print(className, methodName, "global_config.server_ts", String.valueOf(gc.getServer_ts())));

        sa.assertTrue(Validate.asBoolean(gc.getLib_img_cache()), AssertionMsg.print(className, methodName, "global_config.lib_img_cache", String.valueOf(gc.getLib_img_cache())));

        if (data.getUserState().getUserLoggedIn() == 1)
            sa.assertTrue(Validate.asBoolean(gc.getFirst_time_user_ad()), AssertionMsg.print(className, methodName, "global_config.first_time_user_ad", String.valueOf(gc.getFirst_time_user_ad())));

        if (System.getProperty("ctx").equalsIgnoreCase("Android"))
            sa.assertTrue(Validate.asBoolean(gc.getJuspayPaymentFlow()), AssertionMsg.print(className, methodName, "global_config.juspay_payment_flow", String.valueOf(gc.getJuspayPaymentFlow())));

        //Validate pro_cta
        new DeeplinkValidator().validate(gc.getPro_cta(), sa);


        //Validate juspay_paypal_flow
        if (System.getProperty("ctx").equalsIgnoreCase("Android"))
            sa.assertTrue(Validate.asBoolean(gc.getJuspay_paypal_flow()), AssertionMsg.print(className, methodName, "global_config.juspay_paypal_flow", String.valueOf(gc.getJuspay_paypal_flow())));


        //Web Release 4-Mar-2021
        if (Validate.isNonEmptyString(gc.getQuick_action()))
            sa.assertTrue(Validate.asQuickActions(gc.getQuick_action()), AssertionMsg.print(className, methodName, "global_config.quick_action", gc.getQuick_action()));
        if (gc.getHomepage_tab_order() != null)
            sa.assertTrue(Validate.asHomepageTabOrder(gc.getHomepage_tab_order()), AssertionMsg.print(className, methodName, "global_config.homepage_tab_order", gc.getHomepage_tab_order().toString()));

        //Web Release 11-Mar-2021
        if (Validate.isNonEmptyString(gc.getDolby_enabled())) {
            sa.assertTrue(Validate.asBoolean(gc.getDolby_enabled()), AssertionMsg.print(className, methodName, "global_config.dolby_enabled", gc.getDolby_enabled()));
        } else {
            sa.fail("global_config.dolby_enabled is empty/null");
        }

        //Web release 08-April-2020
        if(!(System.getProperty("ctx").equalsIgnoreCase("iphoneapp"))) {
            if (gc.getZero_streamer() != null) {
                sa.assertTrue(Validate.asBoolean(gc.getZero_streamer()), AssertionMsg.print(className, methodName, "global_config.zero_streamer", gc.getZero_streamer().toString()));
            } else {
                sa.fail("global_config.zero_streamer is empty/null");
            }
        }

        sa.assertTrue(Validate.asNum(gc.getVideo_mapping_data_update()), AssertionMsg.print(className, methodName, "global_config.getVideo_mapping_data_update", String.valueOf(gc.getVideo_mapping_data_update())));
        if (gc.getAuto_play_exp() != null)
            validateAutoPlayExp(gc.getAuto_play_exp(), sa);
        sa.assertTrue(Validate.asBoolean(gc.getRateCap_Applicable()), AssertionMsg.print(className, methodName, "global_config.getRateCap_Applicable", String.valueOf(gc.getRateCap_Applicable())));
        sa.assertTrue(Validate.asNum(gc.getVideo_Remaining()), AssertionMsg.print(className, methodName, "global_config.getVideo_Remaining", String.valueOf(gc.getVideo_Remaining())));
        sa.assertTrue(Validate.asNum(gc.getMax_Video_Limit()), AssertionMsg.print(className, methodName, "global_config.getMax_Video_Limit", String.valueOf(gc.getMax_Video_Limit())));
        sa.assertTrue(Validate.asNum(gc.getFeatureViewSpan()), AssertionMsg.print(className, methodName, "global_config.getFeatureViewSpan", String.valueOf(gc.getFeatureViewSpan())));
        sa.assertTrue(Validate.asNum(gc.getWatchVideoSpan()), AssertionMsg.print(className, methodName, "global_config.getWatchVideoSpan", String.valueOf(gc.getWatchVideoSpan())));
        sa.assertTrue(Validate.asNum(gc.getIn_app_review_stream_count()), AssertionMsg.print(className, methodName, "global_config.getIn_app_review_stream_count", String.valueOf(gc.getIn_app_review_stream_count())));
        validateAppLanguages(gc.getApp_languages(), sa);
        sa.assertTrue(Validate.asNum(gc.getModule_limit()), AssertionMsg.print(className, methodName, "global_config.module_limit", String.valueOf(gc.getModule_limit())));
        sa.assertTrue(Validate.asNum(gc.getModule_content_limit()), AssertionMsg.print(className, methodName, "global_config.module_content_limit", String.valueOf(gc.getModule_content_limit())));
        sa.assertTrue(Validate.asNum(gc.getAd_config_ref_time()), AssertionMsg.print(className, methodName, "global_config.getAd_config_ref_time", String.valueOf(gc.getAd_config_ref_time())));
        if(System.getProperty("ctx").equalsIgnoreCase("iphoneapp")) {
            sa.assertTrue(Validate.asBoolean(gc.getIs_homepod_enabled()), AssertionMsg.print(className, methodName, "global_config.is_homepod_enabled", String.valueOf(gc.getIs_homepod_enabled())));
        }
        if(gc.getHomepageExpEnabled() != null) {
            sa.assertTrue(Validate.asBoolean(gc.getHomepageExpEnabled()), AssertionMsg.print(className, methodName, "global_config.homepageExpEnabled", String.valueOf(gc.getHomepageExpEnabled())));
        }
        if(gc.getHomepageExpGraphicEnabled() != 0) {
            sa.assertTrue(Validate.asNum(gc.getHomepageExpGraphicEnabled()), AssertionMsg.print(className, methodName, "global_config.homepageExpGraphicEnabled", String.valueOf(gc.getHomepageExpGraphicEnabled())));
        }

        if(gc.getStripe_payment_flow() != null){
            sa.assertTrue(Validate.asBoolean(gc.getStripe_payment_flow()), AssertionMsg.print(className, methodName, "stripe_payment_flow", String.valueOf(gc.getStripe_payment_flow())));
        }
    }


    void validateOtpProviders(OTPProviders op, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        for (Map.Entry<String, String> entry : op.getProviders().entrySet()) {
            sa.assertTrue(Validate.asCountryCode(entry.getKey()), AssertionMsg.print(className, methodName, "global_config.phn_otp_providers", entry.getKey()));
            sa.assertTrue(Validate.asProvider(entry.getValue()), AssertionMsg.print(className, methodName, "global_config.phn_otp_providers", entry.getValue()));
        }
    }

    void validateProductDetails(ProductDetails pd, SoftAssert sa) {

        //Validate products
        for (Product prod : pd.getProducts()) {
            validateProduct(prod, sa);
        }

        validateMapping(pd.getMapping(), sa);

        validateProviders(pd.getProviders(), sa);

    }

    void validateProviders(Providers pro, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(Validate.asString(pro.getPaytmProviders().getMERC_UNQ_REF()), AssertionMsg.print(className, methodName, "global_config.product_details.providers.paytm.MERC_UNQ_REF", pro.getPaytmProviders().getMERC_UNQ_REF()));
    }

    void validateMapping(ProductMapping pm, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        //Validate prime 1 year prod
        validateProductCycle(pm.getPrime_1year().getGoogle(), sa);

        validateProductCycle(pm.getPrime_1year().getPaytm(), sa);

        validateProductCycle(pm.getPrime().getPaytm(), sa);

        validateProductCycle(pm.getPrime().getGoogle(), sa);

        validateProductCycle(pm.getSaavn_30day().getPaytm(), sa);

        validateProductCycle(pm.getSaavn_1year().getPaytm(), sa);
    }

    void validateProductCycle(ProductCycle pc, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if (Validate.isNonEmptyString(pc.getId()))
            sa.assertTrue(Validate.asString(pc.getId()), AssertionMsg.print(className, methodName, "global_config.product_details.mapping.prodType.prodCycle.id", pc.getId()));

        if (Validate.isNonEmptyString(pc.getRenewal_cycle()))
            sa.assertTrue(Validate.asNum(pc.getRenewal_cycle()), AssertionMsg.print(className, methodName, "global_config.product_details.mapping.prodType.prodCycle.renewal_cycle", pc.getRenewal_cycle()));

        if (Validate.isNonEmptyString(pc.getPrice_display()))
            sa.assertTrue(Validate.asString(pc.getPrice_display()), AssertionMsg.print(className, methodName, "global_config.product_details.mapping.prodType.prodCycle.price_display", pc.getPrice_display()));

        if (Validate.isNonEmptyString(pc.getPrice_display_per_unit()))
            sa.assertTrue(Validate.asString(pc.getPrice_display_per_unit()), AssertionMsg.print(className, methodName, "global_config.product_details.mapping.prodType.prodCycle.price_display_per_unit", pc.getPrice_display_per_unit()));

        if (Validate.isNonEmptyString(pc.getPrice()))
            sa.assertTrue(Validate.asString(pc.getPrice()), AssertionMsg.print(className, methodName, "global_config.product_details.mapping.prodType.prodCycle.price", pc.getPrice()));
    }

    void validateProduct(Product prod, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(Validate.asString(prod.getName()), AssertionMsg.print(className, methodName, "global_config.product_details.product.name", prod.getName()));

        sa.assertTrue(Validate.asString(prod.getCat()), AssertionMsg.print(className, methodName, "global_config.product_details.product.cat", prod.getCat()));

        sa.assertTrue(Validate.asNum(prod.getDormant_period()), AssertionMsg.print(className, methodName, "global_config.product_details.product.dormant_period", prod.getDormant_period()));

        sa.assertTrue(Validate.asNum(prod.getGrace_period()), AssertionMsg.print(className, methodName, "global_config.product_details.product.grace_period", prod.getGrace_period()));

        sa.assertTrue(Validate.asFloat(prod.getStorage_limit()), AssertionMsg.print(className, methodName, "global_config.product_details.product.storage_limit", prod.getStorage_limit()));

        sa.assertTrue(Validate.asNum(prod.getDevice_limit()), AssertionMsg.print(className, methodName, "global_config.product_details.product.device_limit", prod.getDevice_limit()));

        sa.assertTrue(Validate.asNum(prod.getPeriod()), AssertionMsg.print(className, methodName, "global_config.product_details.product.period", prod.getPeriod()));

        sa.assertTrue(Validate.asString(prod.getPeriod_unit()), AssertionMsg.print(className, methodName, "global_config.product_details.product.period_unit", prod.getPeriod_unit()));

        sa.assertTrue(Validate.asNum(prod.getDiscount()), AssertionMsg.print(className, methodName, "global_config.product_details.product.discount", prod.getDiscount()));
    }

    void validateTrial(Trial trial, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(Validate.asNum(trial.getPeriod()), AssertionMsg.print(className, methodName, "global_config.trial.period", trial.getPeriod()));

        sa.assertTrue(Validate.asNum(trial.getDormantPeriod()), AssertionMsg.print(className, methodName, "global_config.trial.dormant_period", trial.getDormantPeriod()));

        sa.assertTrue(Validate.asFloat(trial.getStorageLimit()), AssertionMsg.print(className, methodName, "global_config.trial.storage_limit", trial.getStorageLimit()));

        sa.assertTrue(Validate.asNum(trial.getDeviceLimit()), AssertionMsg.print(className, methodName, "global_config.trial.device_limit", trial.getDeviceLimit()));
    }

    void validateCacheConfig(CacheConfig cc, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(Validate.asBoolean(cc.getEnabled()), AssertionMsg.print(className, methodName, "global_config.cache_config.enabled", cc.getEnabled()));

        sa.assertTrue(Validate.asNum(cc.getMaxContentSize()), AssertionMsg.print(className, methodName, "global_config.cache_config.max_content_size", cc.getMaxContentSize()));

        sa.assertTrue(Validate.asNum(cc.getMin_free_storage_pct()), AssertionMsg.print(className, methodName, "global_config.cache_config.min_free_storage_pct", cc.getMin_free_storage_pct()));

    }

    void validateLabelInfo(LabelInfo li, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        for (Overrides o : li.getOverridesList()) {
            sa.assertTrue(Validate.asString(o.getName()), AssertionMsg.print(className, methodName, "global_config.labelInfo.overrides.name", o.getName()));

            sa.assertTrue(Validate.asFloat(o.getLimit()), AssertionMsg.print(className, methodName, "global_config.labelInfo.overrides.limit", o.getLimit()));

            sa.assertTrue(Validate.asString(o.getError()), AssertionMsg.print(className, methodName, "global_config.labelInfo.overrides.error", o.getError()));
        }
    }

    void validateAutoPlayExp(AutoPlayExp autoPlayExp, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(Validate.asNum(autoPlayExp.getId()), AssertionMsg.print(className, methodName, "global_config.autoPlayExp.getId", autoPlayExp.getId()));
        sa.assertTrue(Validate.asString(autoPlayExp.getTitle()), AssertionMsg.print(className, methodName, "global_config.autoPlayExp.getTitle", autoPlayExp.getTitle()));
        sa.assertTrue(Validate.asEntityType(autoPlayExp.getType()), AssertionMsg.print(className, methodName, "global_config.autoPlayExp.getType", autoPlayExp.getType()));
        sa.assertTrue(Validate.asNum(autoPlayExp.getTime()), AssertionMsg.print(className, methodName, "global_config.autoPlayExp.getTime", String.valueOf(autoPlayExp.getTime())));
        sa.assertTrue(Validate.asCDNURL(autoPlayExp.getImage()), AssertionMsg.print(className, methodName, "global_config.autoPlayExp.getImage", autoPlayExp.getImage()));

    }

    private void validateAppLanguages(AppLanguages app_languages, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asDefaultSelection(app_languages.getDefault_selection()), AssertionMsg.print(className, methodName, "global_config.app_languages.getDefault_selection()", app_languages.getDefault_selection()));
        if (app_languages.getAppLanguagesList().getBengali()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getBengali(), "bengali", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getBengali()", app_languages.getAppLanguagesList().getBengali()));
        if (app_languages.getAppLanguagesList().getBhojpuri()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getBhojpuri(), "bhojpuri", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getBhojpuri()", app_languages.getAppLanguagesList().getBhojpuri()));
        if (app_languages.getAppLanguagesList().getEnglish()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getEnglish(), "english", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getEnglish()", app_languages.getAppLanguagesList().getEnglish()));
        if (app_languages.getAppLanguagesList().getGujarati()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getGujarati(), "gujarati", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getGujarati()", app_languages.getAppLanguagesList().getGujarati()));
        if (app_languages.getAppLanguagesList().getHaryanvi()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getHaryanvi(), "haryanvi", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getHaryanvi()", app_languages.getAppLanguagesList().getHaryanvi()));
        if (app_languages.getAppLanguagesList().getHindi()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getHindi(), "hindi", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getHindi()", app_languages.getAppLanguagesList().getHindi()));
        if (app_languages.getAppLanguagesList().getMalyalam()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getMalyalam(), "malayalam", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getMalyalam()", app_languages.getAppLanguagesList().getMalyalam()));
        if (app_languages.getAppLanguagesList().getTamil()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getTamil(), "tamil", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getTamil()", app_languages.getAppLanguagesList().getTamil()));
        if (app_languages.getAppLanguagesList().getTelugu()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getTelugu(), "telugu", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getTelugu()", app_languages.getAppLanguagesList().getTelugu()));
        if (app_languages.getAppLanguagesList().getMarathi()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getMarathi(), "marathi", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getMarathi()", app_languages.getAppLanguagesList().getMarathi()));
        if (app_languages.getAppLanguagesList().getPunjabi()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getPunjabi(), "punjabi", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getPunjabi()", app_languages.getAppLanguagesList().getPunjabi()));
        if (app_languages.getAppLanguagesList().getKannada()!=null)
            sa.assertEquals(app_languages.getAppLanguagesList().getKannada(), "kannada", AssertionMsg.print(className, methodName, "global_config.app_languages.getAppLanguagesList().getKannada()", app_languages.getAppLanguagesList().getKannada()));
    }

}
