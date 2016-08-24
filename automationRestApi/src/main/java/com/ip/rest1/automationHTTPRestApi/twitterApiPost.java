package com.ip.rest1.automationHTTPRestApi;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;

import oauth.signpost.exception.OAuthMessageSignerException;

public class twitterApiPost<CommonsHttpOAuthConsumer>{
String consumerKeyStr = "K4malZljnaowMOHV1MGIPb7Yn";
String consumerSecretStr = "TyaHbVjeHwIMHSlzCID86CSG3Ubbtd3jBPf2I9HwNVT4cLCtMq";
String accessTokenStr = "759274175387332612-lCdml1c3avqtY9jfaN8mZTXmdPULLgo";
String accessTokenSecretStr = "6IVNs9yu7X63sjC8sgZD0d5s9XV5YSFsgFCqsXvjKtniT";

public void  setup() throws ClientProtocolException,IOException,OAuthMessageSignerException{{

CommonsHttpOAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr,consumerSecretStr,
		SignatureMethod.HMAC_SHA1);
oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);

HttpClient client = HttpClientBuilder.create().build();
HttpPost post = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=Hello%20World.");
oAuthConsumer.sign(post);

HttpResponse response = client .execute(post);
int statuscode = response.getStatusLine().getStatusCode();
System.out.println("The status code is : " + statuscode);
Assert.assertEquals(200, statuscode);

	}}}



	

