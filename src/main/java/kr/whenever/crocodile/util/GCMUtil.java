package kr.whenever.crocodile.util;

import java.io.IOException;
import java.util.List;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class GCMUtil {
	
	private static String apiKey = "AIzaSyBp1sDDjaUaj5WHqM9VAvxu8fICiMZVTbE";
	
	private static String testGCMId = "f1ypTmc_M2Q:APA91bESBrJyE0SM_lcKAK1_UZCJ-LJD2_buipN6OhOhOy4n7IlEtbDa82EDVJ5KdW7y13vjU5DpMzfqfJZOzue3F4nPQh4v1VglAeOUr6_imEk1jGxmEb3t9Il7JFjjfVvAudZ_ojkh";
	
	public static void sendMessage(String key, String value, String gcmId) throws IOException {
		Sender sender = new Sender(apiKey);
		Message pushMessage = new Message.Builder().addData(key, value).build();
		Result result = sender.send(pushMessage, gcmId, 5);

		if (result != null) {
			if (result.getMessageId() != null) {
				// success
			} else {
				// fail
			}
		} 
	}
	
	public static void sendMessages(String title, String message, List<String> gcmIds) throws IOException {
		Sender sender = new Sender(apiKey);
		Message pushMessage = new Message.Builder().addData(title, message).build();
		MulticastResult multicastResults = sender.send(pushMessage, gcmIds, 5);
		
		List<Result> results = multicastResults.getResults();
		
		for (Result result : results) {
			if (result != null) {
				if (result.getMessageId() != null) {
					// success
				} else {
					// fail
				}
			} 
		}
	}

}
