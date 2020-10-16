package validators.genericValidators;

import entities.Modules;
import entities.ModulesData;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class ModulesDataValidator {
    final String className = getClass().getName();
    public void validate(Modules modules, SoftAssert sa) {

    }

    void validateList(Modules modules, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        this.validate(modules.getList(), sa);
    }

    public void validate(ModulesData md, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(md.getSource()))
            sa.assertTrue(Validate.asModulesSource(md.getSource()), AssertionMsg.print(className, methodName, "modules.list.source", md.getSource()));

        if(md.getPosition() != null)
            sa.assertTrue(Validate.asNum(md.getPosition()), AssertionMsg.print(className, methodName, "modules.list.position", String.valueOf(md.getPosition())));

        if(Validate.isNonEmptyString(md.getScrollType()))
            sa.assertTrue(Validate.asModulesScrollType(md.getScrollType()), AssertionMsg.print(className, methodName, "modules.list.scroll_type", md.getScrollType()));

        if(Validate.isNonEmptyString(md.getTitle()))
            sa.assertTrue(Validate.asString(md.getTitle()), AssertionMsg.print(className, methodName, "modules.list.title", md.getTitle()));

        if(Validate.isNonEmptyString(md.getSubtitle()))
            sa.assertTrue(Validate.asString(md.getSubtitle()), AssertionMsg.print(className, methodName, "modules.list.subtitle", md.getSubtitle()));

        if(Validate.isNonEmptyString(md.getHighlight()))
            sa.assertTrue(Validate.asString(md.getHighlight()), AssertionMsg.print(className, methodName, "modules.list.highlight", md.getHighlight()));

        if(md.getSimpleHeader() != null)
            sa.assertTrue(Validate.asBoolean(md.getSimpleHeader()), AssertionMsg.print(className,methodName, "modules.list.simple_header", String.valueOf(md.getSimpleHeader())));

        if(md.getNoHeader() != null)
            sa.assertTrue(Validate.asBoolean(md.getNoHeader()),AssertionMsg.print(className, methodName, "modules.list.noHeader", String.valueOf(md.getNoHeader())));

        if(md.getSourceApi() != null)
            sa.assertTrue(Validate.asBoolean(md.getSourceApi()), AssertionMsg.print(className, methodName, "modules.list.source_api", String.valueOf(md.getSourceApi())));

        if(md.getHideMeta() != null)
            sa.assertTrue(Validate.asBoolean(md.getHideMeta()), AssertionMsg.print(className, methodName, "module.hideMeta", String.valueOf(md.getHideMeta())));

        if(md.getFeatured() != null)
            sa.assertTrue(Validate.asBoolean(md.getFeatured()), AssertionMsg.print(className, methodName, "module.featured", String.valueOf(md.getFeatured())));

        if(Validate.isNonEmptyString(md.getFeaturedText()))
            sa.assertTrue(Validate.asString(md.getFeaturedText()), AssertionMsg.print(className, methodName, "module.hideMeta", md.getFeaturedText()));
    }



}
