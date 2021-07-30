package validators.VideoValidator;

import entities.ModuleWithViewMoreArray;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.videoGetHomePage.VideoGetHomePage;
import pojos.videoGetHomePage.VideoStation;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.ModulesDataValidator;
import validators.genericValidators.RadioStationValidator;

import java.util.*;

@Slf4j
public class VideoGetHomePageValidator extends EntityValidator {

    final String className = getClass().getName();


    public void validate(VideoGetHomePage videoGetHomePage, SoftAssert softAssert) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        /*
            Validation of videoStations
         */
        validateVideoStations(videoGetHomePage.getVideoStations(), softAssert);

        /*
            validation of modules
         */

        validateModules(videoGetHomePage, softAssert);

        /*
            Validation of videohomepage:vx:data module
         */

        validateVideoHomePageData(videoGetHomePage,softAssert);

       // softAssert.assertAll();
        }



        public void validateModules(VideoGetHomePage videoGetHomePage,SoftAssert softAssert){

            final String methodName = new Throwable().getStackTrace()[0].getMethodName();

            if(videoGetHomePage.getModules().getViewMoreArrayDataModule()!=null && videoGetHomePage.getModules().getViewMoreArrayDataModule().size()>0){

              /*
                Validating videoHomePageData dynamic module. Here the key of the json object(key=video_stations)
                is validated against the child json object's value(source=video_stations)
            */
                for( Map.Entry<String, ModuleWithViewMoreArray> entry : videoGetHomePage.getModules().getViewMoreArrayDataModule().entrySet()){
                    log.info("key json" +entry.getKey());
                    log.info("Nested json's value "+entry.getValue().getSource());
                    softAssert.assertTrue(entry.getKey().equals(entry.getValue().getSource()));
                    log.info("VideoHomePage Validator: The key of the module and source is same");
                    new ModulesDataValidator().validate(entry.getValue(),softAssert);
                }
            }
            else {
                AssertionMsg.print(className, methodName, videoGetHomePage.getModules().getViewMoreArrayDataModule().toString(), "Video module list is empty");
                softAssert.fail("Video module List is empty");
            }
            softAssert.assertAll();
        }


        public void  validateVideoHomePageData(VideoGetHomePage videoGetHomePage,SoftAssert softAssert){

            final String methodName = new Throwable().getStackTrace()[0].getMethodName();
            //Checking the size of the map.If it's greater than 0 then the set is validated as an entrySet
            if(videoGetHomePage.getVideoHomePageData()!=null && videoGetHomePage.getVideoHomePageData().size()>0){
                for( Map.Entry<String , List<LinkedHashMap>> entrySet :  videoGetHomePage.getVideoHomePageData().entrySet()){
                    if(Validate.asVideoPromosField(entrySet.getKey())){
                        List<LinkedHashMap> val= entrySet.getValue();
                        Validate.asAssortedEntity(val,softAssert);
                    }
                }

            }
            else {
                AssertionMsg.print(className, methodName, videoGetHomePage.getVideoHomePageData().toString(), "VideoGetHomepageData is empty");
                softAssert.fail("Video Station List is empty");
            }
            softAssert.assertAll();
        }


    public void validateVideoStations(List<VideoStation> videoStations, SoftAssert softAssert) {

        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

       /*
       Verifying if the list of videoStation is not empty
        */

        System.out.println("vid s "+videoStations.size());
        if(videoStations!=null && videoStations.size()>0  ){
            for (VideoStation station : videoStations) {
                log.info("video station name: " + station);
                new RadioStationValidator().validate(station,softAssert);
            }

        } else {
            AssertionMsg.print(className, methodName, videoStations.toString(), "VideoStation List is empty");
            softAssert.fail("Video Station List is empty");
        }


        softAssert.assertAll();
    }



}

