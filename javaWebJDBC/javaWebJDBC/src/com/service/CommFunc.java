package com.service;

/**
 * ���������� 
 * @author Administrator
 *
 */
public class CommFunc {
	
	/**
	 * ��ISO�����ʽ���ַ�ת����GBK�����ʽ
	 * @param strConvert
	 * @return
	 */
	public static String iso2Gbk(String strConvert) {
		if ((strConvert != null) && (strConvert.length() > 0)) {
			try {
				return new String(strConvert.getBytes("iso8859-1"), "gbk");
			} catch (Exception ex) {
				System.err.println("iso2Gbk����");
				return strConvert;
			}
		} else {
			strConvert = "";
		}
		return strConvert;
	}
	
	/**
	 * ����ֵת���ɿ��ַ���
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
