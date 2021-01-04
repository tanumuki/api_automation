package validators.genericValidators;

import entities.Modules;
import entities.ModulesData;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class ModulesDataValidator {
    final static String className = ModulesDataValidator.class.getName();
    public void validate(Modules modules, SoftAssert sa) {

    }

    void validateList(Modules modules, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        this.validate(modules.getList(), sa);
    }

    public static void validate(ModulesData md, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(md != null) {
            if(Validate.isNonEmptyString(md.getSource())){
                System.out.println("source: " + md.getSource());
                sa.assertTrue(Validate.asModulesSource(md.getSource()), AssertionMsg.print(className, methodName, "modules.list.source", md.getSource()));
            }


            if(md.getPosition() != null){
                System.out.println("position: " + md.getPosition());
                sa.assertTrue(Validate.asNum(md.getPosition()), AssertionMsg.print(className, methodName, "modules.list.position", String.valueOf(md.getPosition())));
            }


            if(Validate.isNonEmptyString(md.getScrollType())){
                System.out.println(md.getScrollType());
                sa.assertTrue(Validate.asModulesScrollType(md.getScrollType()), AssertionMsg.print(className, methodName, "modules.list.scroll_type", md.getScrollType()));
            }


            if(Validate.isNonEmptyString(md.getTitle())) {
                System.out.println("title: " + md.getTitle());
                sa.assertTrue(Validate.asString(md.getTitle()), AssertionMsg.print(className, methodName, "modules.list.title", md.getTitle()));
            }


            if(Validate.isNonEmptyString(md.getSubtitle())) {
                System.out.println("subtitle: " + md.getSubtitle());
                sa.assertTrue(Validate.asString(md.getSubtitle()), AssertionMsg.print(className, methodName, "modules.list.subtitle", md.getSubtitle()));
            }


            if(Validate.isNonEmptyString(md.getHighlight())) {
                System.out.println("highlight: " + md.getHighlight());
                sa.assertTrue(Validate.asString(md.getHighlight()), AssertionMsg.print(className, methodName, "modules.list.highlight", md.getHighlight()));
            }


            if(md.getSimpleHeader() != null) {
                System.out.println("simple header: " + md.getSimpleHeader());
                sa.assertTrue(Validate.asBoolean(md.getSimpleHeader()), AssertionMsg.print(className,methodName, "modules.list.simple_header", String.valueOf(md.getSimpleHeader())));
            }


            if(md.getNoHeader() != null) {
                System.out.println("no header: " + md.getNoHeader());
                sa.assertTrue(Validate.asBoolean(md.getNoHeader()),AssertionMsg.print(className, methodName, "modules.list.noHeader", String.valueOf(md.getNoHeader())));
            }


            if(md.getSourceApi() != null) {
                System.out.println("source api: " + md.getSourceApi());
                sa.assertTrue(Validate.asBoolean(md.getSourceApi()), AssertionMsg.print(className, methodName, "modules.list.source_api", String.valueOf(md.getSourceApi())));
            }


            if(md.getHideMeta() != null) {
                System.out.println("hide meta: " + md.getHideMeta());
                sa.assertTrue(Validate.asBoolean(md.getHideMeta()), AssertionMsg.print(className, methodName, "module.hideMeta", String.valueOf(md.getHideMeta())));
            }


            if(md.getFeatured() != null) {
                System.out.println("featured: " + md.getFeatured());
                sa.assertTrue(Validate.asBoolean(md.getFeatured()), AssertionMsg.print(className, methodName, "module.featured", String.valueOf(md.getFeatured())));
            }


            if(Validate.isNonEmptyString(md.getFeaturedText())) {
                System.out.println("featured text: " + md.getFeaturedText());
                sa.assertTrue(Validate.asString(md.getFeaturedText()), AssertionMsg.print(className, methodName, "module.hideMeta", md.getFeaturedText()));
            }

            if(Validate.isNonEmptyString(md.getImage_url())) {
                System.out.println("image url: " + md.getImage_url());
                sa.assertTrue(Validate.asCDNURL(md.getImage_url()), AssertionMsg.print(className, methodName, "module.image_url", md.getImage_url()));
            }

            if(Validate.isNonEmptyString(md.getImage_type())) {
                System.out.println("image type: " + md.getImage_type());
                sa.assertTrue(Validate.asImageType(md.getImage_type()), AssertionMsg.print(className, methodName, "module.image_type", md.getImage_type()));
            }
        }

    }



}
