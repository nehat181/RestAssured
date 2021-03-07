package com.org.apiEngine;

import com.org.apiEngine.model.requests.AddBooksRequest;
import com.org.apiEngine.model.requests.AuthorizationRequest;
import com.org.apiEngine.model.requests.RemoveBookRequest;
import com.org.apiEngine.model.response.Books;
import com.org.apiEngine.model.response.Token;
import com.org.apiEngine.model.response.UserAccount;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Endpoints {
	private static final String BASE_URL="https://bookstore.toolsqa.com";
	public static IRestResponse<Token> authenticateUser(AuthorizationRequest authreq) {
		RestAssured.baseURI=BASE_URL;
		RequestSpecification request = RestAssured.given();
		 
        request.header("Content-Type", "application/json");
        Response response = request.body(authreq).post("/Account/v1/GenerateToken");
       // return response;
	   return new RestResponse(Token.class,response);	
		
	}
	
	public static IRestResponse<Books> getListofAllBooks() {
		RestAssured.baseURI=BASE_URL;
		RequestSpecification request=RestAssured.given();
		
		request.header("Content-Type", "application/json");
		Response response=request.get("/BookStore/v1/Books");
		//return response;
		 return new RestResponse(Books.class,response);	
		
	}
	
	public static IRestResponse<UserAccount> addBooks(AddBooksRequest addbook,String token) {
		RestAssured.baseURI = BASE_URL;
		 RequestSpecification request = RestAssured.given();
		 request.header("Authorization", "Bearer " + token)
		 .header("Content-Type", "application/json");
		 Response response=request.body(addbook).post("/BookStore/v1/Books");
		//return response;
		 return new RestResponse(UserAccount.class,response);	
		
	}
	
	public static Response removeBooks(RemoveBookRequest removebookrequest,String token) {
		 RequestSpecification request = RestAssured.given();
		 
		 request.header("Authorization", "Bearer " + token)
		 .header("Content-Type", "application/json");
		Response response =request.body(removebookrequest).delete("/BookStore/v1/Book");
		return response;
		
		
	}
	
	public static IRestResponse<UserAccount> getUserAccount(String userId, String token) {
		 
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
 
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
 
        Response response = request.get("/Account/v1/User/" + userId);
       // return response;
        return new RestResponse<UserAccount>(UserAccount.class,response);
	}

}
