package validators.JiotuneHomepageData;

import entities.ModulesData;
import entities.ModulesDataShowMore;
import entities.Song;
import org.testng.asserts.SoftAssert;
import pojos.JiotuneHomePageData.JiotuneHomePageData;
import pojos.JiotuneHomePageData.JiotunePlaylistObj;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.ModulesDataValidator;
import validators.genericValidators.SongValidator;

public class JTHomePageDataValidator {
    final String className = getClass().getName();

    public void validate(JiotuneHomePageData hd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        //validate data_0
        for(Song song : hd.getData_0()){
            new SongValidator().validate(song, sa, song.getId(), "Trending Jiotunes");
        }

        //validate data_2
        for(JiotunePlaylistObj pl : hd.getData_2()) {
            new JiotunePlaylistObjValidator().validate(pl, sa);
        }

        for(JiotunePlaylistObj pl : hd.getData_3()) {
            new JiotunePlaylistObjValidator().validate(pl, sa);
        }

        for(JiotunePlaylistObj pl : hd.getData_4()) {
            new JiotunePlaylistObjValidator().validate(pl, sa);
        }

        //Validate modules
        for(ModulesData md : hd.getModules()){
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
