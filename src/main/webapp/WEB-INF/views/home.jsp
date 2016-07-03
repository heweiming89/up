<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="${pageContext.request.contextPath }/upload/03"
		enctype="multipart/form-data">
		<input type="file" name="doraemon" id="" accept="image/png,image/jpeg,image/gif" /> <br />
		<input type="submit" value="提交表单" />
	</form>
	<hr />
	<form method="post" action="${pageContext.request.contextPath }/upload/02"
		enctype="multipart/form-data">
		<input type="file" name="doraemon" id="" accept="image/png,image/jpeg,image/gif" /> <br />
		<input type="submit" value="提交表单" />
	</form>
	<hr />
	<form method="post">
		<input type="file" name="doraemon" id="" accept="image/png,image/jpeg,image/gif" /> <br />
		<input type="button" value="提交表单" />
	</form>

	<h1>Welcome Home</h1>
	<img alt="" src="${pageContext.request.contextPath }/common/img/Doraemon.jpg">
	<hr />
	<img alt="" src="${pageContext.request.contextPath }/demo01/04">
	<hr />
	<img alt="" src="${pageContext.request.contextPath }/demo01/05">
	<hr />

</body>
</html>