package validators.JiotuneHomepageData;

import entities.ModulesData;
import entities.ModulesDataShowMore;
import entities.ModulesWithViewMoreObj;
import entities.Song;
import org.testng.asserts.SoftAssert;
import pojos.JiotuneHomePageData.JiotuneHomePageData;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.ModulesDataValidator;
import validators.genericValidators.SongValidator;

import java.util.ArrayList;
import java.util.List;

public class JTHomePageDataValidator {
    final String className = getClass().getName();

    public void validate(JiotuneHomePageData hd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        //validate data_0
        for(Song song : hd.getData_0()){
            new SongValidator().validate(song, sa, song.getId(), "Trending Jiotunes");
        }

        //validate data_1
        Validate.asAssortedEntity(hd.getData_1(), sa);

        //validate data_2
        Validate.asAssortedEntity(hd.getData_2(), sa);

        //Validate data_3
        Validate.asAssortedEntity(hd.getData_3(), sa);


        //Validate data_4
        Validate.asAssortedEntity(hd.getData_4(), sa);

        //Validate data_5
        Validate.asAssortedEntity(hd.getData_5(), sa);

        //Validate data_6
        if (hd.getData_6()!=null)
        Validate.asAssortedEntity(hd.getData_6(), sa);

        //Validate modules
        List<ModulesWithViewMoreObj> mdo = new ArrayList<>();

//        There should be atleast one module always
        sa.assertNotNull(hd.getModules().getData_0(), "Test failed: There should be atleast one module.");
        mdo.add(hd.getModules().getData_0());

        if(hd.getModules().getData_1() != null)
            mdo.add(hd.getModules().getData_0());
        if(hd.getModules().getData_2() != null)
            mdo.add(hd.getModules().getData_0());
        if(hd.getModules().getData_3() != null)
            mdo.add(hd.getModules().getData_0());
        if(hd.getModules().getData_4() != null)
            mdo.add(hd.getModules().getData_0());
        if(hd.getModules().getData_5() != null)
            mdo.add(hd.getModules().getData_0());
        if(hd.getModules().getData_6() != null)
            mdo.add(hd.getModules().getData_0());

        for(ModulesWithViewMoreObj md : mdo){
            new ModulesDataValidator().validate(md, sa);

            ModulesDataShowMore sm = md.getShowMore();
            if(sm != null) {
                if(Validate.isNonEmptyString(sm.getSource())){
                    sa.assertTrue(Validate.asString(sm.getSource()), AssertionMsg.print(className, methodName, "module.show_more.source", sm.getSource()));
                }

                if(Validate.isNonEmptyString(sm.getTitle())){
                    sa.assertTrue(Validate.asString(sm.getTitle()), AssertionMsg.print(className, methodName, "module.show_more.title", sm.getTitle()));
                }

                if(Validate.isNonEmptyString(sm.getType())){
                    sa.assertTrue(Validate.asString(sm.getType()), AssertionMsg.print(className, methodName, "module.show_more.type", sm.getType()));
                }

                if(sm.getParams() != null && Validate.isNonEmptyString(sm.getParams().getType())){
                    sa.assertTrue(Validate.asString(sm.getParams().getType()), AssertionMsg.print(className, methodName, "module.show_more.params.type", sm.getParams().getType()));
                }
            }

        }

    }


}
