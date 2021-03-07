package com.org.apiEngine;

import io.restassured.response.Response;

public class RestResponse<T> implements IRestResponse<T> {
	 private Response response;
	 private Exception e;
	 private T data;
	 
	 public RestResponse(Class<T> t,Response response) {
		 this.response=response;
		 try{
				this.data = t.newInstance();
			}catch (Exception e){
				throw new RuntimeException("There should be a default constructor in the Response POJO");
			}
		 
		 
	 }
	@Override
	public T getBody() {
		// TODO Auto-generated method stub
		try {
			data=(T) response.getBody().as(data.getClass());
		}
		catch(Exception e) {
			this.e=e;
		}
		return data;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return response.getBody().asString();
	}

	@Override
	public int getStatusCode() {
		// TODO Auto-generated method stub
		return response.getStatusCode();
	}

	@Override
	public boolean isSuccessful() {
		// TODO Auto-generated method stub
		int code=getStatusCode();
		if(code==200||code==201||code==202||code==203||code==204||code==205) return true;
		return false;
	}

	@Override
	public String getStatusDescription() {
		// TODO Auto-generated method stub
		return response.getStatusLine();
	}

	@Override
	public Response getResponse() {
		// TODO Auto-generated method stub
		return response;
	}

	@Override
	public Exception getException() {
		// TODO Auto-generated method stub
		return e;
	}

}
