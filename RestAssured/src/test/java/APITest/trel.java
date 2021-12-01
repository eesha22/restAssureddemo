package APITest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
public class trel{
	//i am teaching you the get method works
	//https://api.trello.com/1/boards/{id}
	
	public static String baseurl ="https://api.trello.com";
	
	@Test
	public void testcase1()
	{
		
		//anytime you have to work with rest assured first you have to load the baseurl
		
		RestAssured.baseURI= baseurl;
		
		//pre-requiste//parameter//header//cookies
		given().param("key", "8fbfa9d2370227cbeab133b66d5aef77")
		.param("token", "74c94b4cabcf0445575b4ff8b1063e88b735712d3261d6bb7b13448f9041ab89")
		
		//condition//differetn HTTP methds
		.when()
		.get("/1/boards/jitj3PSP")
		//basically checking response //applying assertion //assertion and response
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).and()
		.body("name", equalTo("Afreen")).and()
		.body("id", equalTo("619e17f54cc8c586213619e5"));
	}
	//create board in trello
	@Test(priority = 1)
	public void createboard()
	{
		RestAssured.baseURI= baseurl;
		//pre-requiste//parameter//header//cookies
			given().queryParam("key", "b4f28fde93f0edf0336a94b014a42a62")
			.queryParam("token", "15303465c48ec10489909f5cce6ec12c183ef49348d4506a6299a07ef99a62cb")
			.queryParam("name", "Afreen").header("content-Type","application/json")
			//condition//differetn HTTP methds
			.when()
			.post("/1/boards/")
			//basically checking response //applying assertion //assertion and response
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON);
		}
	public void getBoard() 
	{
		RestAssured.baseURI= baseurl;
		//pre-requiste//parameter//header//cookies
			given().queryParam("key", "b4f28fde93f0edf0336a94b014a42a62")
			.queryParam("token", "15303465c48ec10489909f5cce6ec12c183ef49348d4506a6299a07ef99a62cb")
			
			//condition//differetn HTTP methds
			.when()
			.get("/1/boards/")
			//basically checking response //applying assertion //assertion and response
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON);
		
	}
}