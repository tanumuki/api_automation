package validators.ReceiptList;

import org.testng.asserts.SoftAssert;
import pojos.receiptsList.Receipt;
import pojos.receiptsList.ReceiptList;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.ReceiptValidator;

public class ReceiptListValidator {
    final String className = getClass().getName();

    public void validateReceiptList(ReceiptList rl, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(rl != null) {
            if(Validate.isNonEmptyString(rl.getStatus())){
                sa.assertTrue(Validate.asBoolean(rl.getStatus()), AssertionMsg.print(className, methodName, "status", rl.getStatus()));
            }

            if(rl.getReceipts() != null && rl.getReceipts().size() > 0) {
                for(Receipt receipt : rl.getReceipts()) {
                    new ReceiptValidator().validate(receipt, sa);
                }
            }

        }
    }
}
