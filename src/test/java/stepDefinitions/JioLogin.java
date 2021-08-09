package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JioLogin {


    @When("I make the {string} request with the following query parameter")
    public void i_make_the_request_with_the_following_query_parameter(String string, io.cucumber.datatable.DataTable dataTable) {

    }

    @Then("^The Jio Login API returns \"([^\"]*)\" with status code 200 and response message is validated$")
    public void the_jio_login_api_returns_something_with_status_code_200_and_response_message_is_validated(String strArg1) throws Throwable {


    }
}
