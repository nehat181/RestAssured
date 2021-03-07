package com.org.apiEngine.model.requests;

import java.util.ArrayList;
import java.util.List;

public class AddBooksRequest {
	
	public String userId;
	public List<CollectionOfIsbn> collectionOfIsbns;
	
	
	public AddBooksRequest(String userId,CollectionOfIsbn collectionOfIsbn){
	this.userId=userId;
	this.collectionOfIsbns = new ArrayList<CollectionOfIsbn>();
    collectionOfIsbns.add(collectionOfIsbn);

	}
	
	

}


