package APITest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class E_Commerse {
	
	public static String accessToken;
	public static String id;
	
	public static String baseurl = "https://ecommerceservice.herokuapp.com/";
	
	@Test(priority = 0, enabled = false)
	public void signup() {
		
		RestAssured.baseURI=baseurl;
		
		String requestbody = "{\n"
				+ "	\"email\": \"eesha123@gmail.com\",\n"
				+ "	\"password\": \"eesha123@123\"\n"
				+ "}\n";
		
		//This itme i want to know what my responce is in my concole
		Response response = given()
				.header("content-type","application/json")
				.body(requestbody)
				
				.when()
				.post("/user/signup")
				
				.then()
				.assertThat().statusCode(201).and().contentType(ContentType.JSON)
				.extract().response();
				//System.out.println(response.asString());
				String jsonresponse = response.asString();
				JsonPath responcebody = new JsonPath(jsonresponse);
				System.out.println(responcebody.get("message"));
		
	}
	@Test(priority = 1)
	public void login() {
		
		RestAssured.baseURI=baseurl;
		
		String requestbody = "{\n"
				+ "	\"email\": \"eesha123@gmail.com\",\n"
				+ "	\"password\": \"eesha123@123\"\n"
				+ "}\n";
		Response response = given()
				.header("content-type","application/json")
				.body(requestbody)
				
				.when()
				.post("/user/login")
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
				//System.out.println(response.asString());
				String jsonresponse = response.asString();
				JsonPath responcebody = new JsonPath(jsonresponse);
				System.out.println(responcebody.get("accessToken"));
				accessToken = responcebody.get("accessToken");
		
	}
	@Test(priority = 2)
	public void allusers() {
		
		RestAssured.baseURI=baseurl;
		
		Response response = given()
				.header("content-type","application/json")
				.header("Authorization","bearer "+accessToken)
				
				.when()
				.get("/user")
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
				//System.out.println(response.asString());
				String jsonresponse = response.asString();
				JsonPath responcebody = new JsonPath(jsonresponse);
				System.out.println(responcebody.get("users[200]._id"));
				id = responcebody.get("users[200]._id");
		
	}
	@Test(priority = 3)
	public void del() {
		
		RestAssured.baseURI=baseurl;
		
		Response response = given()
				.header("content-type","application/json")
				.header("Authorization","bearer "+accessToken)
				
				.when()
				.delete("/user/"+id)
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
				//System.out.println(response.asString());
		String jsonresponse = response.asString();
		JsonPath responcebody = new JsonPath(jsonresponse);
		System.out.println(responcebody.get("message"));
		//id = responcebody.get("users[200]._id");
		
	}
}
