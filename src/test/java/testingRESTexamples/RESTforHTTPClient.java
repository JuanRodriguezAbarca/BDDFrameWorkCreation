package testingRESTexamples;

import cucumber.api.java.en.Given;

/**
 * Created by Juan_Rodriguez on 8/5/2015.
 */
public class RESTforHTTPClient {

    HTTPClientPorcuilo httpClientMethods = new HTTPClientPorcuilo();

    @Given("^I am testing using HTTPClient first example$")
    public void iAmTestingUsingHttpClientFirstExample(){

        httpClientMethods.testingHttpClient();

    }


}
