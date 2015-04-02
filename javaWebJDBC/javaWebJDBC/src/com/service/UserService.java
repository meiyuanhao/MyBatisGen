package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.form.UserForm;

/**
 * 封装了对用户表T_UserInfo及其相关子表的各种操作
 * @author Administrator
 *
 */
public class UserService {

	//筛选条件-真实名
	private String Real_Name = "";
	
	//筛选条件-用户名
	private String User_Name = "";

	/**
	 * 根据筛选条件获取满足条件的用户列表
	 * @return
	 * @throws SQLException
	 */
	public List<UserForm> getUserlist() throws SQLException {
		//数据库链接
		Connection conn = null;
		//会话
		PreparedStatement stm=null; 
		//结果集
		ResultSet rs = null;
		
		//用户数据列表
		List<UserForm> list = new ArrayList<UserForm>();
		
		try {
			//注册驱动
			Class.forName(Constants.driver);
			
			//获得链接
			conn=DriverManager.getConnection(Constants.URL, Constants.user, Constants.password);

			//构造预处理SQL
			String sql = "select * From T_UserInfo where 1=1 ";
			
			
			//添加筛选条件-用户名
			if(User_Name!=null && !"".equals(User_Name)){
				sql +=" and User_Name = ? ";
			}
			
			//添加筛选条件-真实名
			if(Real_Name!=null && !"".equals(Real_Name)){
				sql +=" and Real_Name like ? ";
			}

			stm=conn.prepareStatement(sql);	
			
			//设置筛选条件-用户名
			int i = 0;
			if(User_Name!=null && !"".equals(User_Name)){
				i++;
				stm.setString(i, User_Name);
			}
			
			//设置筛选条件-真实名
			if(Real_Name!=null && !"".equals(Real_Name)){
				i++;
				stm.setString(i, "%"+Real_Name+"%");
			}
			
			//获得结果记录集 
			rs = stm.executeQuery();
			
			//封装数据至对象
			while (rs.next()) {
				UserForm userform = new UserForm();
				userform.setF_id(rs.getString("id"));
				userform.setF_User_Name(CommFunc.iso2Gbk(rs.getString("User_Name")));
				userform.setF_User_Pwd(CommFunc.iso2Gbk(rs.getString("User_Pwd")));
				userform.setF_Real_Name(CommFunc.iso2Gbk(rs.getString("Real_Name")));
				list.add(userform);
			}

		} catch (Exception e) {
			
			//捕捉异常，打印堆栈信息
			e.getStackTrace();
			
		} finally {
			
			//关闭结果集
			if(rs!=null){
				rs.close();
			}
			
			//关闭会话
			if(stm!=null){
				stm.close();
			}
			
			//关闭连接
			if(conn!=null){
				conn.close();
			}
			
		}
		
		//返回结果
		return list;
	}
	//=============================setter & getter========================================
	
	public String getReal_Name() {
		return Real_Name;
	}
	public void setReal_Name(String real_Name) {
		Real_Name = real_Name;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	
}