package com.org.stepDefinitions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.junit.Assert;

import com.org.apiEngine.Endpoints;
import com.org.apiEngine.IRestResponse;
import com.org.apiEngine.RestResponse;
import com.org.apiEngine.model.requests.AddBooksRequest;
import com.org.apiEngine.model.requests.AuthorizationRequest;
import com.org.apiEngine.model.requests.CollectionOfIsbn;
import com.org.apiEngine.model.requests.GetBookDetailsRequest;
import com.org.apiEngine.model.requests.RemoveBookRequest;
import com.org.apiEngine.model.response.Book;
import com.org.apiEngine.model.response.Books;
import com.org.apiEngine.model.response.Token;
import com.org.apiEngine.model.response.UserAccount;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {
	private static final String USER_ID = "51482080-bebd-4179-923b-223e49652399";
	 private static final String USERNAME = "test01";
	 private static final String PASSWORD = "Test@001";
	 private static final String BASE_URL = "https://bookstore.toolsqa.com";
	 
	 private static String token;
	 private static IRestResponse<Token> tokenresponse;
	 private static Book book;
	 private static Books books;
	 private static Response response;
	 private static String jsonString;
	 private static String bookId;
	 
		 
	 @Given("^I am an authorized user$")
    public void iAmAnAuthorizedUser() {
	AuthorizationRequest authRequest=new AuthorizationRequest("test01", "Test@001");
////	RestAssured.baseURI = BASE_URL;
	//RequestSpecification request = RestAssured.given();
////	request.header("Content-Type", "application/json");
////	 JSONObject requestParams = new JSONObject();
////	 requestParams.put("userName", USERNAME); 
////	 requestParams.put("password", PASSWORD);
////	 response = request.body(requestParams.toString())
////	 .post("/Account/v1/GenerateToken");
//	
	
    //   response=request.body(authRequest).post("/Account/v1/GenerateToken");
//	 //String jsonString = response.asString();
//	 //token = JsonPath.from(jsonString).get("token");
	tokenresponse =Endpoints.authenticateUser(authRequest);
////	 tokenresponse=response.getBody().as(Token.class);
	 Assert.assertEquals(200, tokenresponse.getStatusCode());
//	 //Assert.assertEquals(200,response.getStatusCode());
//	 System.out.println(tokenresponse.getStatusCode());
//	 
 }
//	 
	 @Given("A list of books are available")
	 public void listOfBooksAreAvailable() {
//	 //RestAssured.baseURI = BASE_URL;
//	 //RequestSpecification request = RestAssured.given();
//	 //response = request.get("/BookStore/v1/Books");
     IRestResponse<Books> bookresponse=Endpoints.getListofAllBooks();
//	// jsonString = response.asString();
   //  List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
//	 //Assert.assertTrue(books.size() > 0);
////	  
////	 for(int i=0;i<books.size();i++) {
////	 bookId = books.get(i).get("isbn"); 
////	 System.out.println("BookId "+bookId);
////}
//    //  books=response.getBody().as(Books.class);
         books=bookresponse.getBody();
         for(int i=0;i<books.books.size();i++) {
    	  book=books.books.get(i);
    	  System.out.println(book.author);
    	  System.out.println(book.description);
     	  System.out.println(book.isbn);
    	  System.out.println(book.pages);
    	  System.out.println(book.publish_date);
    	  System.out.println(book.publisher);
    	  System.out.println(book.subTitle);
    	  System.out.println(book.website);
    	 
     }
	 }
//      
//
//	 }
//	 
	 @When("I add a book to my reading list")
	 public void addBookInList() throws JSONException {
		
	 AddBooksRequest addbookrequest=new AddBooksRequest(USER_ID, new CollectionOfIsbn("9781593275846"));
	 IRestResponse<UserAccount> response=Endpoints.addBooks(addbookrequest, tokenresponse.getBody().token);
////	 RestAssured.baseURI = BASE_URL;
////	 RequestSpecification request = RestAssured.given();
////	 request.header("Authorization", "Bearer " + tokenresponse.token)
////	 .header("Content-Type", "application/json");
////	 JSONObject requestparam=new JSONObject();
////	 requestparam.put("userId", USER_ID);
////	 requestparam.put("userId", USER_ID);
///0/	 
//	 
////	 response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
////	 "\"collectionOfIsbns\": [ { \"isbn\": \"" + "9781593275846" + "\" } ]}")
////	 .post("/BookStore/v1/Books");
////	 
       // response=request.body(addbookrequest).post("/BookStore/v1/Books");
	System.out.println(response.getResponse().asString());
	
	 }
	 
	 @Then("The book is added")
	 public void bookIsAdded() {
////		 
    Assert.assertEquals(201, response.getStatusCode());
//   
	 }
//	 
	 @When("I remove a book from my reading list")
	 public void removeBookFromList() {
		 
	 RemoveBookRequest removebookrequest=new RemoveBookRequest(USER_ID,"9781593275846");
     response=Endpoints.removeBooks(removebookrequest, tokenresponse.getBody().token);
	// RestAssured.baseURI = BASE_URL;
////	 RequestSpecification request = RestAssured.given();
////	 
////	 request.header("Authorization", "Bearer " + tokenresponse.token)
////	 .header("Content-Type", "application/json");
////	 response =request.body(removebookrequest).delete("/BookStore/v1/Book");
//	 
////	 response = request.body("{ \"isbn\": \"" + "9781449361589" + "\", \"userId\": \"" + USER_ID + "\"}")
////	 .delete("/BookStore/v1/Book");
//	 
//	 
	 }
	 
	 @Then("The book is removed")
	 public void bookIsRemoved() {
//	
//	 
//	 RestAssured.baseURI = BASE_URL;
//	 RequestSpecification request = RestAssured.given();
//	 
//	 request.header("Authorization", "Bearer " + tokenresponse.getBody().token)
//	 .header("Content-Type", "application/json");
//	 
//	 response = request.get("/Account/v1/User/" + USER_ID);
//	 Assert.assertEquals(200, response.getStatusCode());
//	 System.out.println(response.getStatusCode());
//	 
//	 jsonString = response.asString();
//
//	 List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
//	 //Assert.assertEquals(0, booksOfUser.size());
//	 }
//	 
//	 
//	 
//	 @Given("A bookId is available")
//	 public void a_book_id_is_available() {
//	     // Write code here that turns the phrase above into concrete actions
//	    RestAssured.baseURI=BASE_URL;
//	    RequestSpecification request=RestAssured.given();
//	    GetBookDetailsRequest getbookdetails=new GetBookDetailsRequest("9781449325862");
//	    request.header("Authorization","Bearer "+tokenresponse.getBody().token).header("Content-Type","application/json");
//	    response=request.get("/BookStore/v1/Book");
//	 }
//
//
//	 
//
//	 @When("I try to fetch the details of a book")
//	 public void i_try_to_fetch_the_details_of_a_book() {
//	     // Write code here that turns the phrase above into concrete actions
//	     throw new io.cucumber.java.PendingException();
//	 }
//	 @Then("Details of the book is retreived")
//	 public void details_of_the_book_is_retreived() {
//	     // Write code here that turns the phrase above into concrete actions
//	     throw new io.cucumber.java.PendingException();
//	 }
//

	}
	 }


