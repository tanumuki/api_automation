package validators.genericValidators;

import org.testng.asserts.SoftAssert;
import pojos.receiptsList.Receipt;
import validators.AssertionMsg;
import validators.Validate;

public class ReceiptValidator {
    final String className = getClass().getName();

    public void validate(Receipt receipt, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(receipt != null) {
            if(Validate.isNonEmptyString(receipt.getInvoiceId())) {
                sa.assertTrue(Validate.asReceiptInvoiceId(receipt.getInvoiceId()), AssertionMsg.print(className, methodName, "receipt.invoice_id", receipt.getInvoiceId()));
            }

            if(Validate.isNonEmptyString(receipt.getInvoiceEncId())) {
                sa.assertTrue(Validate.asString(receipt.getInvoiceEncId()), AssertionMsg.print(className, methodName, "receipt.invoice_enc_id", receipt.getInvoiceEncId()));
            }

            if(Validate.isNonEmptyString(receipt.getVendor())) {
                sa.assertTrue(Validate.asString(receipt.getVendor()), AssertionMsg.print(className, methodName, "receipt.vendor", receipt.getVendor()));
            }

            if(Validate.isNonEmptyString(receipt.getProductDuration())) {
                sa.assertTrue(Validate.asString(receipt.getProductDuration()), AssertionMsg.print(className, methodName, "receipt.product_duration", receipt.getProductDuration()));
            }

            if(Validate.isNonEmptyString(receipt.getPurchaseDate())) {
                sa.assertTrue(Validate.asDate(receipt.getPurchaseDate()), AssertionMsg.print(className, methodName, "receipt.purchase_date", receipt.getPurchaseDate()));
            }

            if(Validate.isNonEmptyString(receipt.getProductPeriodUnit())) {
                sa.assertTrue(Validate.asString(receipt.getProductPeriodUnit()), AssertionMsg.print(className, methodName, "receipt.product_period_unit", receipt.getProductPeriodUnit()));
            }

            if(Validate.isNonEmptyString(receipt.getProduct_price_per_unit())) {
                sa.assertTrue(Validate.asString(receipt.getProduct_price_per_unit()), AssertionMsg.print(className, methodName, "receipt.product_price_per_unit", receipt.getProduct_price_per_unit()));
            }

            if(receipt.getAuto_renewal()) {
                sa.assertTrue(Validate.asBoolean(receipt.getAuto_renewal()), AssertionMsg.print(className, methodName, "receipt.auto_renewal", String.valueOf(receipt.getAuto_renewal())));
            }

            if(Validate.isNonEmptyString(receipt.getInvoice_creation_time())) {
                sa.assertTrue(Validate.asDateTime(receipt.getInvoice_creation_time()), AssertionMsg.print(className, methodName, "receipt.invoice_creation_time", receipt.getInvoice_creation_time()));
            }

            if(Validate.isNonEmptyString(receipt.getTotal_amount())) {
                sa.assertTrue(Validate.asString(receipt.getTotal_amount()), AssertionMsg.print(className, methodName, "receipt.total_amount", receipt.getTotal_amount()));
            }
        }
    }
}
