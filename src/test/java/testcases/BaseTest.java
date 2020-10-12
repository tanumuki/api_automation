package testcases;


import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cucumber.Options.TestRunner;


public class BaseTest {


    @Test
    public void start() throws JsonMappingException, JsonProcessingException {

        new TestRunner();

    }


}
