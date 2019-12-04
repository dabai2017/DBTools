package com.dabai.utils;

import java.util.Random;


/**
 * 颜色工具类
 * 2019-11-29	上午10:43:05
 * @author 故事与猫
 *
 */
public class ColorUtils {
	 
		/**
		 * 把 int 型 颜色值 转化为 #ffffff这种格式
		 * @param color
		 * @return
		 */
	    public static String getHexString(int color) {
	        String s = "#";
	        int colorStr = (color & 0xff000000) | (color & 0x00ff0000) | (color & 0x0000ff00) | (color & 0x000000ff);
	        s = s + Integer.toHexString(colorStr);
	        return s;
	    }
	    
	    /**
	     * 获取随机颜色值
	     *
	     * @return
	     */
	    public static String getRandColorCode() {
	        String r, g, b;
	        Random random = new Random();
	        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
	        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
	        b = Integer.toHexString(random.nextInt(256)).toUpperCase();

	        r = r.length() == 1 ? "0" + r : r;
	        g = g.length() == 1 ? "0" + g : g;
	        b = b.length() == 1 ? "0" + b : b;

	        return "#" + r + g + b;
	    }
}
