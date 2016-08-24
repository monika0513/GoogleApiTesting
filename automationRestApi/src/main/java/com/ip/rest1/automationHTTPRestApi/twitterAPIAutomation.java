package com.ip.rest1.automationHTTPRestApi;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

 public class twitterAPIAutomation {

	   String AccessToken = "395485820-sipu8cds0ieHFzgVCep4UtYrWDCoCvuKtgXE0Jas";
	   String AccessSecret = "nGUJXLwZHVjnF54N6TN2MzmbuWgJqPCqThZ7kvsazmcqz";
	   		
	   String ConsumerKey = "bM1TGbUmHCDXvy4g6ZPxs9URb";
	   String ConsumerSecret = "HPVehCtPodidXjg0lpbZQQbV6b3L9KTpLbyQHVyQCGh59EVjDx";
        
	   String json;

		HttpClient client;
		  HttpResponse response;
		  HttpGet request;
		  @BeforeTest
	public void  setup() throws Exception {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
		                ConsumerKey,
		                ConsumerSecret);
       
 consumer.setTokenWithSecret(AccessToken, AccessSecret);
      request = new HttpGet("https://api.twitter.com/1.1/followers/list.json");


      consumer.sign(request);

		client = HttpClientBuilder.create().build();		
       response = client.execute(request);

      int statusCode = response.getStatusLine().getStatusCode();
      System.out.println(statusCode + ":" + response.getStatusLine().getReasonPhrase());
      System.out.println(IOUtils.toString(response.getEntity().getContent()));
      System.out.println(response.getEntity());

		  }
     
      @Test
  	public void testHeader()throws Exception{
    	
  		Header[] headers= response.getAllHeaders();
  		for(Header h1: headers){
  			System.out.println(h1.getName()+ ""+h1.getValue());
  			if(h1.getName().equals("content-type"))
  				assertTrue(h1.getValue().equals("application/json;"));
  			if(h1.getValue().equals("Content-Length"));
            equals(h1.getValue().equals("1253"));}
  		}
  	
  		
   	@Test
   	public void  testJson()throws ParseException,IOException, JSONException{
   		json=EntityUtils.toString(response.getEntity(),"UTF-8");    		
   		JSONObject jsonResponse;
			jsonResponse = new JSONObject(json);
			
		

         System.out.println("\n"+jsonResponse.toString());    	
          assertTrue(jsonResponse.toString().contains("Amit Deshpande"));
          JSONArray jsonResponseArray= jsonResponse.getJSONArray("results");
          JSONObject results =(JSONObject)jsonResponseArray.get(0);
          System.out.println(results.get("id"));
          System.out.println(results.get("types"));
          JSONArray address_components = results.getJSONArray("address_components");
          System.out.println(address_components.length());
    	String short_name_country=(String)address_components.getJSONObject(3).get("short_name");
    	System.out.println(short_name_country);
   	}}
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
           
           

  		  
 
	
    
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
	


