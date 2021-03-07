Feature: End to End test of BookStore API
Description: The purpose of the test case is cover happy flow

Background: User generates token for Authorisation
 Given I am an authorized user
 Scenario: Authorised user is able to add or remove a book
 Given A list of books are available
 When I add a book to my reading list
 Then The book is added
 When I remove a book from my reading list
 Then The book is removed
 Scenario: Able to fetch book details
 Given A bookId is available
 When I try to fetch the details of a specific book
 Then  The details of the book is retreived