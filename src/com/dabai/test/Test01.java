package com.dabai.test;

import java.io.File;

import com.dabai.utils.DownloadUtils;
import com.dabai.utils.DownloadUtils.DownloadListener;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		DownloadUtils.downloadFile("https://download.dcloud.net.cn/HBuilder.9.1.29.windows.zip", "D:/123/test.zip", new DownloadListener() {
			
			@Override
			public void onResult(String state, String filePath, File tagFile) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgress(String progress, long downed, long length) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		
	}

}
