<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resource/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resource/My97DatePicker/WdatePicker.js"></script>
<link href="${pageContext.request.contextPath }/resource/css/css.css"
	rel="stylesheet">
	
<script type="text/javascript">
	function fy(pageNum) {
		$("[name=pageNum]").val(pageNum);
		$("form").submit();
	}
	
	function look(fid,pageNum) {
		location = "look?fid="+fid+"&pageNum="+pageNum;
	}
	
	function add() {
		location = "toAdd";
	}
	
	function update(fid,pageNum) {
		location = "toUpdate?fid="+fid+"&pageNum="+pageNum;
	}

	function qx() {
		$(".xx").each(function(){
			this.checked = $("#qx").get(0).checked;
		})
	}
	
	function del(fid) {
		if(confirm("确定要删除吗?")){
		$.post("del",{fid:fid},function(flag){
			if(flag){
				alert("删除成功!")
				location.reload();
			}else{
				alert("删除失败!")
			}
		},"json")
		}
	}

	function ps() {
		var fids = new Array();
		$(".xx:checked").each(function(i){
			fids[i] = this.value;
		})
		if(fids.length == 0){
			alert("请选择要删除的数据!");
			return;
		}
		if(confirm("确定要删除吗?")){
			$.post("dela",{fids:fids},function(flag){
				if(flag){
					alert("删除成功!")
					location.reload();
				}else{
					alert("删除失败!")
				}
			},"json")
			
		}
	}
</script>
</head>
<body>
	<h1 align="center" style="color: blue; font-size: 26px;">展示页面</h1>

	<table>
	
	<tr>
		<td>
			<input type="button" value="添加" onclick="add()">
		</td>
		<td colspan="10">
			<form action="list" method="post">
				<input type="hidden" value="1" name="pageNum">
			查询内容:	<input type="text" name="fname" value="${f.fname }">
			<button>搜索</button>
			</form>
		</td>
	</tr>
		<tr>
			<td>
			
			<input type="checkbox" id="qx" onclick="qx()">全选
			
			</td>
			<td>序号</td>
			<td>植物名称</td>
			<td>描述</td>
			<td>类别</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${pg.list }" var="l" varStatus="a">
			<tr>
				<td>
				<input type="checkbox" class="xx" value="${l.fid }">
				</td>
				<td>${a.index+1 + (pg.pageNum - 1)*4 }</td>
				<td>${l.fname }</td>
				<td>${l.intro }</td>
				<td>${l.tname }</td>
				<td>
					<input type="button" value="查看"  onclick="look(${l.fid},${pg.pageNum })">
					<input type="button" value="修改"  onclick="update(${l.fid},${pg.pageNum })">
					<input type="button" value="删除"  onclick="del(${l.fid})">
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td>
			<input type="button" value="批量删除" onclick="ps()">
			</td>
			<td colspan="10">
				<input type="button" value="首页"     onclick="fy(1)">
				<input type="button" value="上一页"   onclick="fy(${pg.prePage==0?1:pg.prePage})">
				<input type="button" value="下一页"   onclick="fy(${pg.nextPage==0?pg.pages:pg.nextPage})">
				<input type="button" value="尾页"     onclick="fy(${pg.pages})">
				当前是第${pg.pageNum }页 / 共计${pg.pages }页
			</td>
		</tr>
	</table>

</body>
</html>