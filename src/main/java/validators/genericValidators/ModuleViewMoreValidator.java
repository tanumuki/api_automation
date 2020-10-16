package validators.genericValidators;

import entities.ModuleViewMore;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class ModuleViewMoreValidator extends ModulesDataValidator{
    final String className = getClass().getName();

    public void validate(ModuleViewMore mvm, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(mvm.getApi()))
            sa.assertTrue(Validate.asString(mvm.getApi()), AssertionMsg.print(className, methodName, "module.view_more.api", mvm.getApi()));

        if(Validate.isNonEmptyString(mvm.getPageParam()))
            sa.assertTrue(Validate.asString(mvm.getPageParam()), AssertionMsg.print(className, methodName, "module.view_more.page_param", mvm.getApi()));

        if(Validate.isNonEmptyString(mvm.getSizeParam()))
            sa.assertTrue(Validate.asString(mvm.getSizeParam()), AssertionMsg.print(className, methodName, "module.view_more.size_param", mvm.getApi()));

        if(Validate.isNonEmptyString(mvm.getScrollType()))
            sa.assertTrue(Validate.asModulesScrollType(mvm.getScrollType()), AssertionMsg.print(className, methodName, "module.view_more.scroll_type", mvm.getScrollType()));

        if(Validate.isNonEmptyString(mvm.getType()))
            sa.assertTrue(Validate.asString(mvm.getType()), AssertionMsg.print(className, methodName, "module.view_more.type", mvm.getType()));

        if(Validate.isNonEmptyString(mvm.getDeeplink()))
            sa.assertTrue(Validate.asString(mvm.getDeeplink()), AssertionMsg.print(className, methodName, "module.view_more.deeplink", mvm.getDeeplink()));

        if(Validate.isNonEmptyString(mvm.getSource()))
            sa.assertTrue(Validate.asModulesSource(mvm.getSource()), AssertionMsg.print(className, methodName, "module.view_more.source", mvm.getSource()));

        if(mvm.getDefaultSize() != null)
            sa.assertTrue(Validate.asNum(mvm.getDefaultSize()), AssertionMsg.print(className, methodName, "module.view_more.default_size", String.valueOf(mvm.getDefaultSize())));
    }
}
