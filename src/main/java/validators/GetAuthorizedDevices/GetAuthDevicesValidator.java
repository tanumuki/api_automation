package validators.GetAuthorizedDevices;

import org.testng.asserts.SoftAssert;
import pojos.GetAuthorizedDevices.Device;
import pojos.GetAuthorizedDevices.SubsGetAuthorizedDevices;
import validators.AssertionMsg;
import validators.Validate;

public class GetAuthDevicesValidator {
    final String className = getClass().getName();

    public void validate(SubsGetAuthorizedDevices ad, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(ad.getStatus())){
            sa.assertTrue(Validate.asBoolean(ad.getStatus()), AssertionMsg.print(className, methodName, "device_status", ad.getStatus()));
        }else{
            sa.fail("status is null or empty!");
        }

        if(ad.getDevicesLimit() != null){
            sa.assertTrue(Validate.asNum(ad.getDevicesLimit()), AssertionMsg.print(className, methodName, "devices_limit", String.valueOf(ad.getDevicesLimit())));
            sa.assertTrue(ad.getDevicesLimit() == 1 || ad.getDevicesLimit() == 5, "Device limit is not within the range 1 and 5" );
        }else{
            sa.fail("Device limit is null");
        }

        sa.assertTrue(ad.getDevices().size() >= 1 && ad.getDevices().size() <= 5, "Actual number of devices objects are not within the range 1 & 5 ");

        for(Device dev : ad.getDevices()) {
            if(Validate.isNonEmptyString(dev.getId())){
                sa.assertTrue(Validate.asString(dev.getId()), AssertionMsg.print(className, methodName, "device.id", dev.getId()));
            }else{
                sa.fail("Device ID is null or empty");
            }

            if(Validate.isNonEmptyString(dev.getName())){
                sa.assertTrue(Validate.asString(dev.getName()), AssertionMsg.print(className, methodName, "device.name", dev.getName()));
            }else {
                sa.fail("Device name is null or empty");
            }

            if(dev.getLastActiveAt() != null){
                sa.assertTrue(Validate.asNum(dev.getLastActiveAt()), AssertionMsg.print(className, methodName, "device.last_active_at", String.valueOf(dev.getLastActiveAt())));
            } else {
                sa.fail("Last active at is null");
            }
        }
    }
}
