package com.dabai.utils;

import java.io.IOException;

import org.json.JSONObject;

public class OneText {

	String jsonString = null;
	
	public OneText() throws IOException {
		jsonString = HtmlUtils.getHtml("https://v1.hitokoto.cn");
	}
	
	public String getHitokoto() throws IOException {
		JSONObject jo1 = new JSONObject(jsonString);
		return jo1.getString("hitokoto");
	}	
	public int getId() throws IOException {
		JSONObject jo1 = new JSONObject(jsonString);
		return jo1.getInt("id");
	}	
	public String getFrom() throws IOException {
		JSONObject jo1 = new JSONObject(jsonString);
		return jo1.getString("from");
	}	
	public String getType() throws IOException {
		JSONObject jo1 = new JSONObject(jsonString);
		return jo1.getString("type");
	}	
	public String getCreator() throws IOException {
		JSONObject jo1 = new JSONObject(jsonString);
		return jo1.getString("creator");
	}	
	public String getCreated_at() throws IOException {
		JSONObject jo1 = new JSONObject(jsonString);
		return jo1.getString("created_at");
	}
	
	
}
