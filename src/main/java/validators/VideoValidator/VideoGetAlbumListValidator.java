package validators.VideoValidator;

import org.testng.asserts.SoftAssert;
import pojos.videoGetAlbumVideoList.GetAlbumVideoList;
import pojos.videoGetDetails.VideoData;

public class VideoGetAlbumListValidator {


    public void validate(GetAlbumVideoList videoList, SoftAssert softAssert){

            for(VideoData videoData :  videoList.getData()){
                new VideoGetDetailsValidator().validate(videoData,softAssert);
            }


    }
}
