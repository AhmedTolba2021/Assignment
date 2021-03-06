package StepDefinition;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;

import org.junit.BeforeClass;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDef_API {
	
	@Before
	public static  void postdata() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";	
		RestAssured.basePath="/posts";
	}

	@Given("^send and test the post request$")
	public void send_and_test_the_post_request(){
		HashMap PostUser = new HashMap();
		PostUser.put("title", "TestTitle");
		PostUser.put("body", "This is a sample test for API");
		PostUser.put("userId", "10");
		Response response = given().
		contentType("application/json").
		body(PostUser ).
		when().
		post().
		then().
		assertThat().
      statusCode(201).extract().response();
		String responseInString = response.asString();
        System.out.println(responseInString);	
	}

	@Given("^send and test the get request$")
	public void send_and_test_the_get_request(){
		Response response = given().when().get(RestAssured.baseURI+RestAssured.basePath).
				then().
				assertThat().
				statusCode(200).
				and()
				.body("id", everyItem(allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(101))))
		        .extract().response();
				String responseInString = response.asString();
		        System.out.println(responseInString);
	}

	@Given("^get specific user details request$")
	public void get_specific_user_details_request(){
		Response response = given().
				when().
				get(RestAssured.baseURI+RestAssured.basePath+"/"+"35").
				then().
				assertThat().
				statusCode(200).and().
				body("title",equalTo("id nihil consequatur molestias animi provident")).extract().response() ;
				String responseInString = response.asString();
		        System.out.println(responseInString);
	}
	@Given("^get invaid user details request$")
	public void get_invaid_user_details_request(){
		Response response = given().
				when().
				get(RestAssured.baseURI+RestAssured.basePath+"/"+"500").
				then().
				assertThat().
				statusCode(404).extract().response() ;
				String responseInString = response.asString();
		        System.out.println(responseInString);
	}
}