package validators.VideoValidator;

import com.fasterxml.jackson.databind.JsonNode;
import entities.ModuleWithViewMoreArray;
import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;
import io.cucumber.messages.internal.com.google.gson.JsonArray;
import io.cucumber.messages.internal.com.google.gson.JsonElement;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.videoGetDetails.VideoData;
import pojos.videoGetHomePage.Modules;
import pojos.videoGetHomePage.ModulesVideoStations;
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

        //Validation of videoStations
        validateVideoStations(videoGetHomePage.getVideoStations(), softAssert);
        /*
            validation of modules (issue)
         */

       // validateVideoModule(videoGetHomePage.getModules(), softAssert);

        if(videoGetHomePage.getModules()!=null){

           for( Map.Entry<String, ModuleWithViewMoreArray> entry : videoGetHomePage.getModules().getVideoHomePageDataModule().entrySet()){

               System.out.println("meow key" +entry.getKey());
               System.out.println("meow val "+entry.getValue());
               System.out.println("meow val source "+entry.getValue().getSource());
               Assert.assertTrue(entry.getKey().equals(entry.getValue().getSource()));
               System.out.println("its same");
               new ModulesDataValidator().validate(entry.getValue(),softAssert);
               System.out.println("done validation for "+entry.getKey());
           }

          ModuleWithViewMoreArray videoStationModule= videoGetHomePage.getModules().getVideoStations();


        }

        /*
            Validation of videohomepage:vx:data module
         */
        if(videoGetHomePage.getVideoHomePageData()!=null){
           for( Map.Entry<String , List<LinkedHashMap>> entrySet :  videoGetHomePage.getVideoHomePageData().entrySet()){
                   if(Validate.asVideoPromosField(entrySet.getKey())){
                      List<LinkedHashMap> val= entrySet.getValue();
                      Validate.asAssortedEntity(val,softAssert);
                      }
                   }

            }
        }

//
//        public void validateModule(JsonNode jsonNode, SoftAssert softAssert) {
//
//
//
//            System.out.println("My Node1 "+jsonNode);
//
//            System.out.println("My Node2 "+jsonNode.get("video_stations"));
//            System.out.println("My Node3 "+jsonNode.get("modules"));
//
//            System.out.println("mod1 " +jsonNode.get("modules").get("video_stations").get("source"));
//            System.out.println("mod2 " +jsonNode.get("modules").get("video_stations").get("position"));
//
//
//
//
//        }








//    public void validateVideoModule(Modules modules, SoftAssert softAssert) {
//
//                if(modules!=null ){
//                    for(VideoStation station : videoStations){
//                        new RadioStationValidator().validate(station,softAssert);
//                    }
//                }
//    }


    //Validate videoStation

    public void validateVideoStations(List<VideoStation> videoStations, SoftAssert softAssert) {

        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

       /*
       Verifying if the list of videoStation is not empty
        */
        if(videoStations!=null && videoStations.size()!=0  ){
            AssertionMsg.print(className, methodName, videoStations.toString(), "VideoStation List is empty");
            softAssert.fail("Video Station List is empty");
        } else {
            for (VideoStation station : videoStations) {
                log.info("video station name: " + station);
                new RadioStationValidator().validate(station,softAssert);
            }
        }


    }

}

