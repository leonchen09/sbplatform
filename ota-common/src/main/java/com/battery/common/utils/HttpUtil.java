package com.battery.common.utils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

/**
 * HttpServletRequest帮助类
 * 
 * @author Joey
 * @Email 2434387555@qq.com
 *
 */
public class HttpUtil {

	/**
	 * 获取当前用户浏览器信息
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 当前用户浏览器信息
	 */
	public static String getHeader(HttpServletRequest request) {
		return request.getHeader("User-Agent");
	}

	/**
	 * 获取当前用户浏览器型号
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 当前用户浏览器型号
	 */
	public static String getUserBrowser(HttpServletRequest request) {
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		Browser browser = userAgent.getBrowser();
		return browser.toString();
	}

	/**
	 * 获取当前用户系统型号
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 当前用户系统型号
	 */
	public static String getUserOperatingSystem(HttpServletRequest request) {
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		OperatingSystem operatingSystem = userAgent.getOperatingSystem();
		return operatingSystem.toString();
	}
	
	/**
	 * 配置下载的response 表头信息
	 * @param fileName 下载文件名称
	 * @param request 请求
	 * @param response 返回信息
	 */
	public static void configDownloadResponse(String fileName,HttpServletRequest request,HttpServletResponse response) {
		String browse = getUserBrowser(request).toString();
        if (browse.contains("MSIE") || browse.contains("TRIDENT") || browse.contains("EDGE")) {
        	try {
				fileName = URLEncoder.encode(fileName, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
        	fileName = fileName.replace("+", "%20");    //IE下载文件名空格变+号问题
        } else {
				try {
					fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
        }
		response.setContentType("application/x-msdownload; charset=UTF-8");
		response.addHeader("content-type", "application/x-msdownload;");
		response.addHeader("content-disposition", "attachment; filename=" + fileName);
	}
}