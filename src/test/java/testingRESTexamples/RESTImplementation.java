package testingRESTexamples;

import cucumber.api.java.en.Given;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Juan_Rodriguez on 7/31/2015.
 */
public class RESTImplementation {

    protected static final Logger LOG = LoggerFactory.getLogger(RESTImplementation.class);

    public final String URL = "http://localhost:8080/lotto";

    @Given("^I am testing using REST assured$")
    public void iAmTestingUsingRestAssured() {
//TODO have a view on this site: https://github.com/jayway/rest-assured/wiki/Usage#example-1---json


    }

    @Given("^I am testing products-schema using REST tools$")
    public void iAmTestingProductsSchemaUsingRESTtools() {


        Response resp = get("http://restcountries.eu/rest/v1/name/Spain");

        JSONArray jsonResponse = new JSONArray(resp.asString());

        String capital = jsonResponse.getJSONObject(0).getString("capital");

        LOG.info("First REST test, string form jsonResponse: " + capital);

        Assert.assertTrue(capital + " and Oslo are not matching", "Madrid".contentEquals(capital));


    }

    @Given("^I am testing the second part of the REST tutorial$")
    public void iAmTestingTheSecondPartOfTheRESTtutorial() throws JSONException, InterruptedException {

        String APIUrl = "http://restcountries.eu/rest/v1/name/Spain/";
//        String APIUrl = "http://google.com/";

//        String APIBody = "{[{\"name\":\"Mindas\",\"capital\":\"Carajo\",\"altSpellings\":[\"Mi\",\"Kingdom of Mindation\",\"Reino de La Minda\"],\"relevance\":\"2\",\"region\":\"Europe\",\"subregion\":\"Southern Europe\",\"translations\":{\"de\":\"Spanien\",\"es\":\"España\",\"fr\":\"Espagne\",\"ja\":\"スペイン\",\"it\":\"Spagna\"},\"population\":46507760,\"latlng\":[40.0,-4.0],\"demonym\":\"Spanish\",\"area\":505992.0,\"gini\":34.7,\"timezones\":[\"UTC\",\"UTC+01:00\"],\"borders\":[\"AND\",\"FRA\",\"GIB\",\"PRT\",\"MAR\"],\"nativeName\":\"España\",\"callingCodes\":[\"34\"],\"topLevelDomain\":[\".es\"],\"alpha2Code\":\"Mi\",\"alpha3Code\":\"ESP\",\"currencies\":[\"EUR\"],\"languages\":[\"es\"]}]}";

        String APIBody = "[\"name\" : \"Mindas\",\"capital\":\"Carajo\"]";

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBody(APIBody);
        builder.setContent("application/json; Charset.defaultCharset() = UTF-8");

        RequestSpecification requestSpecification = builder.build();

//        LOG.info(requestSpecification.request().body(builder).toString());//TODO research on it


//        .authentication().preemptive().basic("","")
        Response response = given().spec(requestSpecification).when().post(APIUrl);

        LOG.info(response.print());

        JSONArray JSONResponseBody = new JSONArray(response.body().asString()); //TODO something fails on this construction

        String result = JSONResponseBody.getJSONObject(0).getString("capital");

        LOG.info("Printing parameter 'Capital': " + result);

        Assert.assertTrue(result + "was not expected result", "Carajo".contentEquals(result));

    }

    @Given("^I am using REST assured for test a JSON file$")
    public void iAmUsingRESTAssuredForTestAJsonFile() {
        expect().statusCode(200).body("email", equalTo("test@hascode.com"),
                "firstName", equalTo("Juan"),
                "lastName", equalTo("Tester"),
                "id", equalTo("1")).
                when().get("D:/ClonningProjectFromGit/BDDFrameWork/BDDFrameWorkCreation/src/test/resources/jsonViaGet.json/jsonViaGet.json");
    }

    @Given("^I am using REST assured instead of HTTPclient to test google.com$")
    public void iAmUsingRESTAssuredInsteadOfHttpClientToTestGoogle(){
        //http://www.mkyong.com/java/java-https-client-httpsurlconnection-example/

        expect().statusCode(200).get("https://www.google.com/");
    }


}
