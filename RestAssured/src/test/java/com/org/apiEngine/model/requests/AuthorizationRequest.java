package com.org.apiEngine.model.requests;

import java.io.Serializable;

public class AuthorizationRequest {
public String userName;
public String password;
	 
 public AuthorizationRequest(String userName, String password) {
 this.userName = userName;
 this.password = password;
	    }
}
