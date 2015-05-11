<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%@taglib uri="/struts-tags" prefix="s" %> 
    <s:form action="Register">
    	<s:textfield name="custname" label="Input your custname"></s:textfield>
    	<s:password name="pwd" label="Input your password"></s:password>
    	<s:textfield name="age" label="Input your age"></s:textfield>
    	<s:textfield name="address" label="Input your address"></s:textfield>
    	<s:submit value="Register"></s:submit> 	
    </s:form>
  </body>
</html>
