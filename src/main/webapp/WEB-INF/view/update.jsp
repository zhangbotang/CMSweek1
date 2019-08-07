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
		location = "list"
	}

	$(function(){
		
		$.post("hx",function(arr){
			for (var i = 0; i < arr.length; i++) {
				if(arr[i].tid=="${f.tid}"){
					
				$("select").append("<option value='"+arr[i].tid+"' selected>"+arr[i].tname+"</option>")
				}else{
				$("select").append("<option value='"+arr[i].tid+"' >"+arr[i].tname+"</option>")
					
				}
			}
		},"json")
	})
	
	function update() {
		$.post("update",$("form").serialize(),function(flag){
			if(flag){
				alert("修改成功!")
				pageNum = "${pageNum}";
				location = "list?pageNum="+pageNum;
			}else{
				alert("修改失败")
			}
		},"json")
	}
	
	
</script>
</head>
<body>
<h1 align="center" style="color: blue; font-size: 26px;">添加</h1>

<form >
<table>
	<tr>
		<td>名称</td>
		<td>
			<input type="hidden" value="${f.fid }" name="fid">
			<input type="text" name="fname" value="${f.fname }">
		</td>
	</tr>
	<tr>
		<td>
			描述
		</td>
		<td>
			<input type="text" name="intro" value="${f.intro }">
		</td>
	</tr>
	<tr>
		<td>
			类别
		</td>
		<td>
			<select name="tid">
				<option value="0">请选择</option>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<input type="button" value="保存" onclick="update()">
			<input type="button" value="返回"  onclick="fh()">
		</td>
		
	</tr>
</table>
</form>
</body>
</html>