<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="submenu" content="user" />
<title>사용자 수정</title>

<script type="text/javascript">
	$(document).ready(function(){
		$('#btnDelete').click(function(){
			$('#deleteForm').submit();
		});
	});
	
</script>
</head>
<body>
	<div class="container">
	<form class="form-horizontal" action="${ctx}/user/${user.pid}" method="post">
		<div class="form-group">
	    	<label for="password" class="col-md-2 control-label">PASSWORD</label>
	    	<div class="col-md-10">
	    		<input type="password" class="form-control" placeholder="password" id="password" name="password" value="${user.password}"/>
			</div>
		</div>
		<div class="form-group">
	    	<label for="nickname" class="col-md-2 control-label">NICKNAME</label>
	    	<div class="col-md-10">
	    		<input type="text" class="form-control" placeholder="nickname" id="nickname" name="nickname" value="${user.nickname}"/>
			</div>
		</div>
		<div class="form-group">
	    	<label for="cellPhoneNo" class="col-md-2 control-label">전화번호</label>
	    	<div class="col-md-10">
	    		<input type="text" class="form-control" placeholder="전화번호" id="cellPhoneNo" name="cellPhoneNo" value="${user.cellPhoneNo}"/>
			</div>
		</div>
		<div class="form-group">
	    	<label for="birthDate" class="col-md-2 control-label">생년월일</label>
	    	<div class="col-md-10">
	    		<input type="text" class="form-control" placeholder="생년월일" id="birthDate" name="birthDate" value="${user.birthDate}"/>
			</div>
		</div>
		<div class="form-group">
	    	<label for="school" class="col-md-2 control-label">학교</label>
	    	<div class="col-md-10">
	    		<input type="text" class="form-control" placeholder="학교" id="school" name="school" value="${user.school}"/>
			</div>
		</div>
		<div class="form-group">
			<label for="type" class="col-md-2 control-label">UserType</label>
			<input type="radio" name="type" value="student" <c:if test="${user.type eq 'student'}">checked = "checked"</c:if>>학생
			<input type="radio" name="type" value="parent" <c:if test="${user.type eq 'parent'}">checked = "checked"</c:if>>학부모
			<input type="radio" name="type" value="admin" <c:if test="${user.type eq 'admin'}">checked = "checked"</c:if>>관리자
		</div>
		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-default">저장</button>
				<button id="btnDelete" type="button" class="btn btn-default">삭제</button>
    		</div>
  		</div>
	</form>
	<form id="deleteForm" action="${ctx}/user/${user.pid}/remove" method="post"></form>
	</div>
</body>
</html>