package com.ilwllc.sgerke.jackson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import com.ilwllc.sgerke.jackson.Query;

import org.codehaus.jackson.map.DeserializationConfig;

public class WeatherGet {
	public static void main(String[] args) throws ClientProtocolException, IOException {

		//Arguments must be passed for sleep time, city, and state, 
		if(args.length == 0){
			System.out.println("***** Missing arguments *****");
			return;
		}
		
		int timeout = 5;
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(timeout * 1000)
				.setConnectionRequestTimeout(timeout * 1000)
				.setSocketTimeout(timeout * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		String url = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" + args[0] + "%2C%20" + args[1] + "%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
		HttpGet httpgeturl = new HttpGet(url);
		
	    try {
			HttpResponse httpresponse = client.execute(httpgeturl);
			System.out.println("***** HttpResponse status: " + httpresponse.getStatusLine().getStatusCode() + " *****");
			
			BufferedReader br = new BufferedReader (new InputStreamReader(httpresponse.getEntity().getContent()));
			
			ObjectMapper mapper = new ObjectMapper();
			
			//configuring the ObjectMapper to not FAIL_ON_UNKNOWN_PROPERTIES
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			WeatherResponse response = (WeatherResponse)mapper.readValue(br,WeatherResponse.class);
			
			Query query = response.getQuery();
			
			System.out.println("City: "  + args[0]);
			System.out.println("State: "  + args[1]);
			System.out.println("Count: "  + query.getCount());
			System.out.println("Created: "  + query.getCreated());
			System.out.println("Language: "  + query.getLang());
			System.out.println("Code: "  + query.getResults().getChannel().getItem().getCondition().getCode());
			System.out.println("Date: "  + query.getResults().getChannel().getItem().getCondition().getDate());
			System.out.println("Temp: "  + query.getResults().getChannel().getItem().getCondition().getTemp());
			System.out.println("Text: "  + query.getResults().getChannel().getItem().getCondition().getText());
			
		} catch(Exception exception) {
			System.out.println("***** HttpResponse exception *****");
			System.out.println(exception);
	    }
	}
}
