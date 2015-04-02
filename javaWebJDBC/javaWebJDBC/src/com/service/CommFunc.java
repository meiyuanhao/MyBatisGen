package com.service;

/**
 * 公共方法类 
 * @author Administrator
 *
 */
public class CommFunc {
	
	/**
	 * 将ISO编码格式的字符转换成GBK编码格式
	 * @param strConvert
	 * @return
	 */
	public static String iso2Gbk(String strConvert) {
		if ((strConvert != null) && (strConvert.length() > 0)) {
			try {
				return new String(strConvert.getBytes("iso8859-1"), "gbk");
			} catch (Exception ex) {
				System.err.println("iso2Gbk错误");
				return strConvert;
			}
		} else {
			strConvert = "";
		}
		return strConvert;
	}
	
	/**
	 * 将空值转换成空字符串
	 * @param str
	 * @return
	 */
	public static String nullToEmpty(String str){
		if(str==null){
			return "";
		}
		return str;
	}
}
