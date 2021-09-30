package validators.JiotuneHomepageData;

import entities.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.JiotuneHomePageData.JiotuneHomePageData;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.ModulesDataValidator;
import validators.genericValidators.SongValidator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
public class JTHomePageDataValidator {
    final String className = getClass().getName();

    public void validate(JiotuneHomePageData hd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        // Validate data_0
        for(JTMenu jtMenu : hd.getData_0()) {
            new JTMenuValidator().validate(jtMenu, sa);
            log.info("Validation done for: "+jtMenu.getTitle());
        }

        // Validate data_1
        for(Song song : hd.getJiotune_reco()){
            new SongValidator().validate(song, sa, song.getId(), "Recommended JioTunes");
            log.info("Validation done for entity type: "+song.getType()+" and title: "+song.getTitle());
        }

        //validate trending_jiotunes
        for(Song song : hd.getTrending_jiotunes()){
            new SongValidator().validate(song, sa, song.getId(), "Trending JioTunes");
            log.info("Validation done for entity type: "+song.getType()+" and title: "+song.getTitle());
        }

        //Validate data_3
        Validate.asAssortedEntity(hd.getData_3(), sa);
        log.info("Validation done for data_3(Top JioTunes)");

        //Validate data_4
        Validate.asAssortedEntity(hd.getData_4(), sa);
        log.info("Validation done for data_4(Artists)");

        //Validate data_5
        Validate.asAssortedEntity(hd.getData_5(), sa);
        log.info("Validation done for data_5(Decades)");

        //Validate data_6
        if (!(hd.getData_6().isEmpty())) {
            Validate.asAssortedEntity(hd.getData_6(), sa);
            log.info("Validation done for data_6(Moods&Genres)");
        }

        // Validate data_7
        if (!(hd.getData_7().isEmpty())) {
            Validate.asAssortedEntity(hd.getData_7(), sa);
        }
        else{
            log.info("data_7(Requested JTs) is empty array of objects for the user.");
        }

        //Validate modules
        List<ModulesWithViewMoreObj> mdo = new ArrayList<>();


        // There should be atleast one module always
        sa.assertNotNull(hd.getModules().getData_0(), "Test failed: There should be atleast one module.");
        mdo.add(hd.getModules().getData_0());

        if(hd.getModules().getData_1() != null)
            mdo.add(hd.getModules().getData_1());
        if(hd.getModules().getData_3() != null)
            mdo.add(hd.getModules().getData_3());
        if(hd.getModules().getData_4() != null)
            mdo.add(hd.getModules().getData_4());
        if(hd.getModules().getData_5() != null)
            mdo.add(hd.getModules().getData_5());
        if(hd.getModules().getData_6() != null)
            mdo.add(hd.getModules().getData_6());
        if (hd.getModules().getData_7() != null)
            mdo.add(hd.getModules().getData_7());
        if(hd.getModules().getTrending_jiotunes() != null)
            mdo.add(hd.getModules().getTrending_jiotunes());
        if(hd.getModules().getJiotune_reco() != null)
            mdo.add(hd.getModules().getJiotune_reco());

        for(ModulesWithViewMoreObj md : mdo){
            ModulesDataValidator.validate(md, sa);

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
