<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@page import="java.util.List"%>
<%@page import="com.form.UserForm"%>
<%@page import="com.service.CommFunc"%>
<%@page import="com.service.UserService"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>欢迎登陆JAVA机试！</title>
<link href="<%=request.getContextPath() %>/images/style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
<%
//构造对象
UserService userService = new UserService();

//设置筛选条件
String User_Name = CommFunc.nullToEmpty(request.getParameter("User_Name"));
String Real_Name = CommFunc.nullToEmpty(request.getParameter("Real_Name"));
userService.setUser_Name(User_Name);
userService.setReal_Name(Real_Name);

//根据筛选条件获取数据列表
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
										用户名：<input name="User_Name" type="text" value="<%=CommFunc.iso2Gbk(User_Name) %>"/> 
										真实姓名：<input name="Real_Name" type="text" value="<%=CommFunc.iso2Gbk(Real_Name) %>"/> 
										<input type="submit" value="查询"/>
										</td>
									</tr>
								</table>
								</form>
								<table width="100%" border="0" cellspacing="1" cellpadding="0">
								
									<tr class="bg_td_blue">
										<td width="6%" height="34" align="center">序号</td>
										<td width="28%" align="center">用户名</td>
										<td align="center">密码</td>
										<td align="center">真实姓名</td>
										<td width="12%" align="center">操作</td>
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
											<td align="center"><a href="edit.html">编辑</a></td>
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
//销毁对象
userService = null;
User_Name = null;
Real_Name = null;
dataList = null;
%>