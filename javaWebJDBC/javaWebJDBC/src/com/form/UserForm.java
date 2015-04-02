package com.form;

/**
 * 封装了T_UserInfo表中的数据
 * @author Administrator
 *
 */
public class UserForm {
	
	private String f_id="";				//PKID
	private String f_User_Name="";		//用户名
	private String f_User_Pwd="";		//密码
	private String f_Real_Name="";		//真实姓名 
	
	
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public String getF_User_Name() {
		return f_User_Name;
	}
	public void setF_User_Name(String user_Name)  {
	
		f_User_Name = user_Name;
	}
	public String getF_User_Pwd() {
		return f_User_Pwd;
	}
	public void setF_User_Pwd(String user_Pwd) {
	
		f_User_Pwd = user_Pwd;
	}
	public String getF_Real_Name() {
		return f_Real_Name;
	}
	public void setF_Real_Name(String real_Name) {
	
		f_Real_Name = real_Name;
	}
}
