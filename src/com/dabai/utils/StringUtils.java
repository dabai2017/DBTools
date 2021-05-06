package com.dabai.utils;

import java.util.Random;
import java.util.regex.Matcher;

/**
 * 字符串工具类
 * 
 * @author 故事与猫
 *
 */
public class StringUtils {

	/**
	 * 用户要求产生字符串的长度
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		String sb = "";
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(36);
			sb += str.charAt(number);
		}
		return sb;
	}

	/**
	 * 截取字符串中的 链接
	 * @param str
	 * @return
	 */
	public static String strSubLink(String str) {

		String link = null;
		Matcher matcher = Patterns.WEB_URL.matcher(str);
		if (matcher.find()) {
			link = matcher.group();
		}
		return link;
	}

}
