package com.dabai.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/*
 网络Html工具类
 大白2017
 */
public class HtmlUtils
{

	/**
	 * 获取 html内容
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getHtml(String url) throws IOException {
		
		URL url2 = new URL(url);
		StringBuffer sBuffer = new StringBuffer();
		HttpURLConnection huc = (HttpURLConnection) url2.openConnection();
		InputStream is = null;
		
		byte[] data = new byte[1024];
		int len=0;
		
		is = huc.getInputStream();
		
		while ((len = is.read(data))>0) {
			sBuffer.append(new String(data,0,len));
		}
		
		return sBuffer.toString();
	}
	
	
	/**
	 * 获取网站指定 前文本和后文本 批量中间的string
	 * @param url
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 */
    public static ArrayList<String> getHtmlSubText(String url,String start,String end) throws Exception{
        ArrayList<String> list = new ArrayList<>();
      
        String htmlString = getHtml(url);

        Pattern p = Pattern.compile(start+"(.*?)"+end);
        Matcher m = p.matcher(htmlString);
        
        while(m.find()) {
            String subt = m.group(1);//m.group(1)不包括这两个字符
            list.add(subt.replace("<br>","\n"));
        }
        return list;
    }

    
    /**
     * 获取网站title 
     * @param url
     * @return
     * @throws Exception
     */
    public static String getHtmlTitle(String url) throws Exception
    {
        
    	String htmlString = getHtml(url);
    	String titleString = null;
    	if (htmlString.contains("<title>")) {
			titleString = htmlString.substring(htmlString.indexOf("<title>") + 7, htmlString.indexOf("</title>"));
		}
        
        return titleString;
    }
	
	
	
	
	
}