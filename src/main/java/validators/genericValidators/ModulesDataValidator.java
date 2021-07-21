package validators.genericValidators;

import entities.Modules;
import entities.ModulesData;
import entities.ModulesDataShowMore;
import entities.ModulesSourceParams;
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

//          noHeader (uppercase H)
            if(md.getNoHeader() != null) {
                System.out.println("no header: " + md.getNoHeader());
                sa.assertTrue(Validate.asBoolean(md.getNoHeader()),AssertionMsg.print(className, methodName, "modules.list.noHeader", String.valueOf(md.getNoHeader())));
            }

//          noheader (lowercase h; used in JT Homepage for the THREETILE_MENU entity - ashwin)
            if(md.getNo_header() != null) {
                System.out.println("no header: " + md.getNo_header());
                sa.assertTrue(Validate.asBoolean(md.getNo_header()),AssertionMsg.print(className, methodName, "modules.list.noheader", String.valueOf(md.getNo_header())));
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

            System.out.println("is_jt_module: " + md.getIs_JT_module());
            sa.assertTrue(Validate.asBoolean(md.getIs_JT_module()), AssertionMsg.print(className, methodName, "module.is_JT_module", String.valueOf(md.getIs_JT_module())));

            if(md.getShowMore() != null){
                ModulesDataShowMore mds = md.getShowMore();

                if(Validate.isNonEmptyString(mds.getType()))
                    sa.assertTrue(Validate.asString(mds.getType()), AssertionMsg.print(className, methodName, "module.show_more.type", mds.getType()));

                if(Validate.isNonEmptyString(mds.getSource()))
                    sa.assertTrue(Validate.asModulesSource(mds.getSource()), AssertionMsg.print(className, methodName, "module.show_more.source", mds.getSource()));

                if(Validate.isNonEmptyString(mds.getTitle()))
                    sa.assertTrue(Validate.asString(mds.getTitle()), AssertionMsg.print(className, methodName, "module.show_more.title", mds.getTitle()));

                if(Validate.isNonEmptyString(mds.getPage_param()))
                    sa.assertTrue(Validate.asString(mds.getPage_param()), AssertionMsg.print(className, methodName, "module.show_more.page_param", mds.getPage_param()));

                if(Validate.isNonEmptyString(mds.getSize_param()))
                    sa.assertTrue(Validate.asString(mds.getSize_param()), AssertionMsg.print(className, methodName, "module.show_more.size_param", mds.getSize_param()));

                if(mds.getDefault_size() != null)
                    sa.assertTrue(Validate.asNum(mds.getDefault_size()), AssertionMsg.print(className, methodName, "module.show_more.default_size", String.valueOf(mds.getDefault_size())));

                if(Validate.isNonEmptyString(mds.getScroll_type()))
                    sa.assertTrue(Validate.asModulesScrollType(mds.getScroll_type()), AssertionMsg.print(className, methodName, "module.show_more.scroll_type", mds.getScroll_type()));

                if(mds.getParams() != null) {
                    if(Validate.isNonEmptyString(mds.getParams().getType()))
                        sa.assertTrue(Validate.asString(mds.getParams().getType()), AssertionMsg.print(className, methodName, "module.show_more.param.type", mds.getParams().getType()));
                }
            }

            if(md.getSourceParams() != null){
                ModulesSourceParams msp = md.getSourceParams();
                if(Validate.isNonEmptyString(msp.getAlbumid()))
                    sa.assertTrue(Validate.asString(msp.getAlbumid()), AssertionMsg.print(className, methodName, "module.source_param.albumid", msp.getAlbumid()));

                if(msp.getPage() != null)
                    sa.assertTrue(Validate.asNum(msp.getPage()), AssertionMsg.print(className, methodName, "module.source_param.p", String.valueOf(msp.getPage())));

                if(msp.getNumItems() != null)
                    sa.assertTrue(Validate.asNum(msp.getNumItems()), AssertionMsg.print(className, methodName, "module.source_param.n", String.valueOf(msp.getNumItems())));

            }
        }

    }



}
