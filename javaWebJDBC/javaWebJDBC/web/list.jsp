<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@page import="java.util.List"%>
<%@page import="com.form.UserForm"%>
<%@page import="com.service.CommFunc"%>
<%@page import="com.service.UserService"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>��ӭ��½JAVA���ԣ�</title>
<link href="<%=request.getContextPath() %>/images/style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
<%
//�������
UserService userService = new UserService();

//����ɸѡ����
String User_Name = CommFunc.nullToEmpty(request.getParameter("User_Name"));
String Real_Name = CommFunc.nullToEmpty(request.getParameter("Real_Name"));
userService.setUser_Name(User_Name);
userService.setReal_Name(Real_Name);

//����ɸѡ������ȡ�����б�
List<UserForm> dataList = userService.getUserlist();
%>
<table width="100%" height="100%" border="0" cellspacing="0"
	cellpadding="0">
	<tr>
		<td width="4" class="bg_line02">&nbsp;</td>
		<td valign="top" bgcolor="#F5F5F5">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center" bgcolor="#f5f5f5">
				

				<table width="99%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							
							<tr>
								<td align="right" class="tb_blue08">&nbsp;</td>
								<td align="center" bgcolor="#FFFFFF">
								<form name="searchForm" id="searchForm" action="" method="post">
								<table width="100%" border="0" cellspacing="1" cellpadding="0">
									<tr>
										<td>
										�û�����<input name="User_Name" type="text" value="<%=CommFunc.iso2Gbk(User_Name) %>"/> 
										��ʵ������<input name="Real_Name" type="text" value="<%=CommFunc.iso2Gbk(Real_Name) %>"/> 
										<input type="submit" value="��ѯ"/>
										</td>
									</tr>
								</table>
								</form>
								<table width="100%" border="0" cellspacing="1" cellpadding="0">
								
									<tr class="bg_td_blue">
										<td width="6%" height="34" align="center">���</td>
										<td width="28%" align="center">�û���</td>
										<td align="center">����</td>
										<td align="center">��ʵ����</td>
										<td width="12%" align="center">����</td>
									</tr>

									<%
									if(dataList!=null){
										int i=1;
										for(UserForm record :dataList){
									%>
										<tr class="bg_line_green">
											<td height="24" align="center"><%=i %></td>
											<td align="center"><%=record.getF_User_Name() %></td>
											<td align="center"><%=record.getF_User_Pwd() %></td>
											<td align="center"><%=record.getF_Real_Name() %></td>
											<td align="center"><a href="edit.html">�༭</a></td>
										</tr>
									<%
										i++;
										}
									}
									%>
									
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>

</body>
</html>
<%
//���ٶ���
userService = null;
User_Name = null;
Real_Name = null;
dataList = null;
%>