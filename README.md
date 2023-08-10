package com.store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class CheduleTime {

	private static String strName ="";
	
	public static void main(String[] args) {
//creating timer task, timer  
		
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
			@Override
			public void run() {
				
				URI uri = URI.create("https://render-0301.onrender.com/api/users/token");
				HttpRequest request = HttpRequest.newBuilder(uri).build();
				try {
					String content = HttpClient.newHttpClient().send(request, BodyHandlers.ofString()).body();
					JSONObject jsonObj = new JSONObject(content.toString());
					
					if(!jsonObj.get("username").equals(strName)) {
						System.out.println("username:"+strName);
						strName = (String) jsonObj.get("username");
						System.out.println("username:"+strName);
						Process process = Runtime.getRuntime().exec("net user abc-xyz "+strName);
				        BufferedReader reader=new BufferedReader( new InputStreamReader(process.getInputStream()));
				        String s; 
				        while ((s = reader.readLine()) != null){
				            System.out.println("The inout stream is " + s);
				        }
					}
					System.out.println("strName:"+strName);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		};
		t.schedule(tt, new Date(), 40000);
	}
	
}
