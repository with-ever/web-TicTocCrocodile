<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="submenu" content="user" />
<title>사용자 목록</title>

<script type="text/javascript">
	function ajax(){
		$.ajax({
			url: '${ctx}/ws/user/list',
			type: 'GET',
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
			data: {
				pageNo: '1'
			},
			success : function(data){
				alert(JSON.stringify(data));
			}
		});
	}
	
	function registerUser(){
		$.ajax({
			url: '${ctx}/ws/user',
			type: 'POST',
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
			data: {
				uid: 'jin@madsq.net',
				password: '123',
				nickname: 'jin',
				cellPhoneNo: '0123',
				birthDate: '111231',
				type: 'admin'
			},
			success: function(data) {
				alert(JSON.stringify(data));
			}
		});
	}
	
	function removeUser(){
		$.ajax({
			url: '${ctx}/ws/user',
			type: 'DELETE',
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
			data: JSON.stringify({
				pid: '7',
				uid: 'jin@madsq.net'
			}),
			success: function(data) {
				alert(JSON.stringify(data));
			}
		});
	}
</script>
</head>
<body>
	<div class="container">
	<table class="table table-bordered">
	
		<tr>
			<td>PID</td>
			<td>아이디</td>
			<td>별명</td>
			<td>핸드폰번호</td>
			<td>생년월일</td>
			<td>유저등급</td>
		</tr>	
		<c:forEach var="user" items="${users}">
			<tr>
				<td><a href="${ctx}/user/${user.pid}">${user.pid}</a></td>
				<td>${user.uid}</a></td>
				<td>${user.nickname}</td>
				<td>${user.cellPhoneNo}</td>
				<td>${user.birthDate}</td>
				<td>${user.type}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a class="btn btn-default" role="button" href="${ctx}/user/new">등록</a>
	<a class="btn btn-default" role="button" href="javascript:ajax();">ajax json call</a>
	<a class="btn btn-default" role="button" href="javascript:registerUser();">register rest api</a>
	<a class="btn btn-default" role="button" href="javascript:removeUser();">remove rest api</a>
	</div>
</body>
</html>
