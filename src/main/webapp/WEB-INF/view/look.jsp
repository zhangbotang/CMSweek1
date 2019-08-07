<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/My97DatePicker/WdatePicker.js"></script>
<link href="${pageContext.request.contextPath }/resource/css/css.css" rel="stylesheet">
<script type="text/javascript">
function fh() {
	pageNum = "${pageNum}";
	location = "list?pageNum="+pageNum;
}

</script>
</head>
<body>
	<h1 align="center" style="color: blue; font-size: 26px;">查看页面</h1>
	<table>
		<tr>
			<td>植物名称</td>
			<td>${f.fname }</td>
		</tr>
		<tr>
			<td>描述</td>
			<td>${f.intro }</td>
		</tr>
		<tr>
			<td>类别</td>
			<td>${f.tname }</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="返回"  onclick="fh()">
			</td>
		</tr>
	</table>
</body>
</html>