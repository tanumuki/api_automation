package validators.genericValidators;

import entities.Modules;
import entities.ModulesData;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class ModulesValidator {
    final String className = getClass().getName();
    public void validate(Modules modules, SoftAssert sa) {

    }

    void validateList(Modules modules, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        ModulesData list = modules.getList();

        if(Validate.isNonEmptyString(list.getSource()))
            sa.assertTrue(Validate.asModulesSource(list.getSource()), AssertionMsg.print(className, methodName, "modules.list.source", list.getSource()));

        if(list.getPosition() != null)
            sa.assertTrue(Validate.asModulesPosition(list.getPosition()), AssertionMsg.print(className, methodName, "modules.list.position", String.valueOf(list.getPosition())));

        if(Validate.isNonEmptyString(list.getScrollType()))
            sa.assertTrue(Validate.asModulesScrollType(list.getScrollType()), AssertionMsg.print(className, methodName, "modules.list.scroll_type", list.getScrollType()));

        if(Validate.isNonEmptyString(list.getTitle()))
            sa.assertTrue(Validate.asString(list.getTitle()), AssertionMsg.print(className, methodName, "modules.list.title", list.getTitle()));

        if(Validate.isNonEmptyString(list.getSubtitle()))
            sa.assertTrue(Validate.asString(list.getSubtitle()), AssertionMsg.print(className, methodName, "modules.list.subtitle", list.getSubtitle()));

        if(Validate.isNonEmptyString(list.getHighlight()))
            sa.assertTrue(Validate.asString(list.getHighlight()), AssertionMsg.print(className, methodName, "modules.list.highlight", list.getHighlight()));

        if(list.getSimpleHeader() != null)
            sa.assertTrue(Validate.asBoolean(list.getSimpleHeader()), AssertionMsg.print(className,methodName, "modules.list.simple_header", String.valueOf(list.getSimpleHeader())));

        if(list.getNoHeader() != null)
            sa.assertTrue(Validate.asBoolean(list.getNoHeader()),AssertionMsg.print(className, methodName, "modules.list.noHeader", String.valueOf(list.getNoHeader())));

        if(list.getSourceApi() != null)
            sa.assertTrue(Validate.asBoolean(list.getSourceApi()), AssertionMsg.print(className, methodName, "modules.list.source_api", String.valueOf(list.getSourceApi())));


    }



}
