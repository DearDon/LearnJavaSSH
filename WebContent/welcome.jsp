<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Loign Success,welcome</title>
</head>
<body>
	<%@taglib uri="/struts-tags" prefix="s" %>
	<s:text name="welcome.info"></s:text>,${param.custname}</br>
	<a href="ViewAll.do"><s:text name="show.url"></s:text></a>
</body>
</html>