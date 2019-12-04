package com.dabai.utils;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 条形码 工具栏
 * @API https://www.mxnzp.com/
 * @author 故事与猫
 *
 */
public class GoodsBarCodeUtils {

	static String hostapi = "https://www.mxnzp.com/api/barcode/goods/details?barcode=";
    String barcode;
	
    /**
     * 根据 barcode 初始化
     * @param barcode
     */
	public GoodsBarCodeUtils(String barcode) {
		this.barcode = barcode;
	}
	
	/**
	 * 拿到 json
	 * @return
	 * @throws Exception
	 */
	public String getJsonString() throws Exception {
		String jsonString = HtmlUtils.getHtml(hostapi+this.barcode);
		return jsonString;
	}
	
	
	/**
	 * 能够 使用的 keys  [standard, price, supplier, goodsName, barcode, brand]
	 * @param key
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public String getValue(String key) throws JSONException, Exception {
		
		String goodlink = hostapi + this.barcode;
		
		String jsonString = HtmlUtils.getHtml(goodlink);
		
		jsonString = jsonString.substring(jsonString.indexOf("\"data\":")+7,jsonString.indexOf("}")+1);
		System.out.println(jsonString);
		JSONObject jo1 = new JSONObject(jsonString);
		
		return jo1.getString(key);
	}
	

	/**
	 * 获得全部 value
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public ArrayList<String> getAllValue() throws JSONException, Exception {
		
		ArrayList<String> list = new ArrayList<>();
		String goodlink = hostapi + this.barcode;
		
		String jsonString = HtmlUtils.getHtml(goodlink);
		
		jsonString = jsonString.substring(jsonString.indexOf("\"data\":")+7,jsonString.indexOf("}")+1);
		JSONObject jo1 = new JSONObject(jsonString);
		
		for (String str : jo1.keySet()) {
			list.add(jo1.getString(str));
		}
		
		return list;
	}
	

	
	/**
	 * 获得全部 key
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public  ArrayList<String> getAllKey() throws JSONException, Exception {
		
		ArrayList<String> list = new ArrayList<>();
		String goodlink = hostapi + this.barcode;
		
		String jsonString = HtmlUtils.getHtml(goodlink);
		
		jsonString = jsonString.substring(jsonString.indexOf("\"data\":")+7,jsonString.indexOf("}")+1);
		JSONObject jo1 = new JSONObject(jsonString);
		
		for (String str : jo1.keySet()) {
			list.add(str);
		}
		
		return list;
	}
	



}
