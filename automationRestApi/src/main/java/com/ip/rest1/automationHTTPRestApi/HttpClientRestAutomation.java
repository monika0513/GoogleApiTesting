package com.ip.rest1.automationHTTPRestApi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HttpClientRestAutomation<JSONObject> 
{
   String json;
	HttpGet request;
	HttpClient client;
	HttpResponse response;
	      @BeforeTest
	     public void setup()throws ClientProtocolException,IOException{
	     
		client = HttpClientBuilder.create().build();		
    	request = new HttpGet("http://maps.googleapis.com/maps/api/"
    			+ "geocode/json?address=Dublin&key=AIzaSyAjPkhQMPZs2G1Iwx5FAe69KVoDKpoURoQ");
    	request.addHeader("accept", "application/json");
    response = client.execute(request);}
    	
    	
    	@Test
    	public void testStatuscode() {
          System.out.println(response.getStatusLine());
            assertEquals(response.getStatusLine().getStatusCode(),200);

    	}
    	@Test
    	public void testHeaderContentType(){
    		Header[] headers= response.getAllHeaders();
    		for(Header h: headers){
    			System.out.println(h.getName()+ ""+h.getValue());
    			if(h.getName().equals("content-type"))
    				assertTrue(h.getValue().equals("application/json;"));
    		}
    	}
       
        
    	}
    	
 


    	

	
	

    

