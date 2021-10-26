package resources;

public class HelperUtil {

    private static HelperUtil helperUtil;
    public static String vCode;

    private HelperUtil(){

    }
    public static HelperUtil getInstance(){
        if(helperUtil==null){
            helperUtil=new HelperUtil();
        }
        return helperUtil;
    }

    public void setVCode(String vCode){
        HelperUtil.vCode =vCode;
    }
    public String getVcode(){
        return vCode;
    }

}
