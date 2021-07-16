package validators.VideoValidator;

import org.testng.asserts.SoftAssert;
import pojos.videoGetDetails.VideoData;
import pojos.videoGetHomePage.VideoGetHomePage;
import pojos.videoGetHomePage.VideoStation;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VideoGetHomePageValidator extends EntityValidator {

    final String className = getClass().getName();


    public void validate(VideoGetHomePage videoGetHomePage, SoftAssert softAssert) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();


        validateVideoStations(videoGetHomePage.getVideoStations(), softAssert);
        validateVideoObject(videoGetHomePage, softAssert);
        if(videoGetHomePage.getVideoHomePageData()!=null){
           for( Map.Entry<String , List<VideoData>> entrySet :  videoGetHomePage.getVideoHomePageData().entrySet()){
                   if(Validate.asVideoPromosField(entrySet.getKey())){
                      List<VideoData> val= entrySet.getValue();
                      if(val!=null && val.size()!=0){
                                for(VideoData videoObject:val){
                                   new VideoObjectValidator().validate(videoObject,softAssert);
                                }
                      }
                   }

            }
        }

       // validateModules(videoGetHomePage, softAssert);

    }

    public void validateVideoObject(VideoGetHomePage videoGetHomePage, SoftAssert softAssert) {


    }


    public void validateVideoStations(List<VideoStation> videoStation, SoftAssert softAssert) {

        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
//        List<VideoStation> videoStation = videoGetHomePage.getVideoStations();

       /*
       Verifying if the list of videoStation is not empty
        */
        if (videoStation.size() == 0) {
            AssertionMsg.print(className, methodName, videoStation.toString(), "VideoStation List is empty");
            softAssert.fail("Video Station List is empty");
        } else {
            for (VideoStation station : videoStation) {
                System.out.println("video station: " + station);
            }
        }


    }

}

