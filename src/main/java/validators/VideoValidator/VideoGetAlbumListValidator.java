package validators.VideoValidator;

import org.testng.asserts.SoftAssert;
import pojos.videoGetAlbumVideoList.GetAlbumVideoList;
import pojos.videoGetDetails.VideoData;
import validators.AssertionMsg;




public class VideoGetAlbumListValidator {

    final String className = getClass().getName();



    public void validate(GetAlbumVideoList videoList, SoftAssert softAssert){

        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(videoList.data.size()==0){
                AssertionMsg.print(className,methodName, videoList.data.toString(),"Video List is empty");
            }
        else{
            for(VideoData videoData :  videoList.getData()){
                new VideoGetDetailsValidator().validate(videoData,softAssert);
            }
        }




    }
}
