package com.dabai.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 下载工具类
 * @author 故事与猫
 *
 */
public class DownloadUtils {

	public interface DownloadListener {
		/**
		 * 下载成功
		 * @param state
		 * @param filePath
		 * @param tagFile
		 */
		void onResult(final String state,final String filePath,final File tagFile);
		/**
		 * 下载进度
		 * @param progress
		 * @param downed
		 * @param length
		 */
		void onProgress(final String progress,final long downed,final long length);
		
	}
	


	/**
	 * 从指定地址下载文件
	 * @param netUrl 网络直链地址
	 * @param pathname 本地文件真实路径
	 * @param listener 监听进度和结果
	 */
	public static void downloadFile(final String netUrl, final String pathname, final DownloadListener listener) {

		final File file = new File(pathname);
		
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					
					long totaldown = 0;
					
					URL url = new URL(netUrl);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();

					con.setReadTimeout(5000);
					con.setConnectTimeout(5000);
					con.setRequestProperty("Charset", "UTF-8");
					con.setRequestMethod("GET");
					if (con.getResponseCode() == 200) {
						InputStream is = con.getInputStream();// 获取输入流
						FileOutputStream fileOutputStream = null;// 文件输出流
						if (is != null) {
							fileOutputStream = new FileOutputStream(file);// 指定文件保存路径，代码看下一步
							byte[] buf = new byte[1024];
							int ch;
							while ((ch = is.read(buf)) != -1) {
								fileOutputStream.write(buf, 0, ch);// 将获取到的流写入文件中
								totaldown += ch;
								listener.onProgress(""+(totaldown*100/con.getContentLengthLong()),totaldown,con.getContentLengthLong());
							}
						}
						if (fileOutputStream != null) {
							fileOutputStream.flush();
							fileOutputStream.close();
						}
						listener.onResult("ok",file.getAbsolutePath(),file);
					}
				} catch (Exception e) {
					listener.onResult("error:" + e.getMessage(),file.getAbsolutePath(),file);
				}

			}
		}).start();
	}

}
