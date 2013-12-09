package com.patel;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class TweetTest {

	private static String ACCESSTOKEN = "85029829-MdQbcWCkPijXpZ49fQixTLwbcbKUVRICVMJJBpGEX";
	private static String ACCSSSECRET = "oRnf7S4lOJnMBtrP1ilChyD9iKTPp5THT2LEVL85o";
	private static String CONSUMERKEY = "18fLgqnhWFe3HHlR6j0t4A";
	private static String CONSUMERSECRET = "at2jqAbeYhliyFinxEni6iFO4fWubH2fNCcEUmjtgdM";

	public static void main(String[] args) throws Exception {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMERKEY,CONSUMERSECRET);

		consumer.setTokenWithSecret(ACCESSTOKEN, ACCSSSECRET);
		HttpGet request = new HttpGet("http://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=acunsolo");
		consumer.sign(request);

		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(request);

		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode + ":" + response.getStatusLine().getReasonPhrase());
		System.out.println(IOUtils.toString(response.getEntity().getContent()));
	}

}
