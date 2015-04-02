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
 * ��װ�˶��û���T_UserInfo��������ӱ�ĸ��ֲ���
 * @author Administrator
 *
 */
public class UserService {

	//ɸѡ����-��ʵ��
	private String Real_Name = "";
	
	//ɸѡ����-�û���
	private String User_Name = "";

	/**
	 * ����ɸѡ������ȡ�����������û��б�
	 * @return
	 * @throws SQLException
	 */
	public List<UserForm> getUserlist() throws SQLException {
		//���ݿ�����
		Connection conn = null;
		//�Ự
		PreparedStatement stm=null; 
		//�����
		ResultSet rs = null;
		
		//�û������б�
		List<UserForm> list = new ArrayList<UserForm>();
		
		try {
			//ע������
			Class.forName(Constants.driver);
			
			//�������
			conn=DriverManager.getConnection(Constants.URL, Constants.user, Constants.password);

			//����Ԥ����SQL
			String sql = "select * From T_UserInfo where 1=1 ";
			
			
			//���ɸѡ����-�û���
			if(User_Name!=null && !"".equals(User_Name)){
				sql +=" and User_Name = ? ";
			}
			
			//���ɸѡ����-��ʵ��
			if(Real_Name!=null && !"".equals(Real_Name)){
				sql +=" and Real_Name like ? ";
			}

			stm=conn.prepareStatement(sql);	
			
			//����ɸѡ����-�û���
			int i = 0;
			if(User_Name!=null && !"".equals(User_Name)){
				i++;
				stm.setString(i, User_Name);
			}
			
			//����ɸѡ����-��ʵ��
			if(Real_Name!=null && !"".equals(Real_Name)){
				i++;
				stm.setString(i, "%"+Real_Name+"%");
			}
			
			//��ý����¼�� 
			rs = stm.executeQuery();
			
			//��װ����������
			while (rs.next()) {
				UserForm userform = new UserForm();
				userform.setF_id(rs.getString("id"));
				userform.setF_User_Name(CommFunc.iso2Gbk(rs.getString("User_Name")));
				userform.setF_User_Pwd(CommFunc.iso2Gbk(rs.getString("User_Pwd")));
				userform.setF_Real_Name(CommFunc.iso2Gbk(rs.getString("Real_Name")));
				list.add(userform);
			}

		} catch (Exception e) {
			
			//��׽�쳣����ӡ��ջ��Ϣ
			e.getStackTrace();
			
		} finally {
			
			//�رս����
			if(rs!=null){
				rs.close();
			}
			
			//�رջỰ
			if(stm!=null){
				stm.close();
			}
			
			//�ر�����
			if(conn!=null){
				conn.close();
			}
			
		}
		
		//���ؽ��
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