<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login again</title>
</head>
<body>
	Your password is wrong, try again!
	<%@taglib uri="/struts-tags" prefix="s" %>
	<s:form action="Login">
		<s:textfield name="custname" label="Input your custname"></s:textfield>
		<s:password name="pwd" label="Input your password"></s:password>
		<s:submit value="Login"></s:submit>
	</s:form>
</body>
</html>