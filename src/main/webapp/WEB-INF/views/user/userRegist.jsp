<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="submenu" content="user" />
<title>사용자 등록</title>

</head>
<body>
	<div class="container">
		<form class="form-horizontal" action="${ctx}/user/" method="post">
			<div class="form-group">
		    	<label for="id" class="col-md-2 control-label">ID</label>
		    	<div class="col-md-10">
		    		<input type="text" class="form-control" placeholder="Id(email)" id="id" name="uid" />
				</div>
			</div>
			<div class="form-group">
		    	<label for="password" class="col-md-2 control-label">PASSWORD</label>
		    	<div class="col-md-10">
		    		<input type="password" class="form-control" placeholder="Password" id="password" name="password" />
				</div>
			</div>
			<div class="form-group">
		    	<label for="nickname" class="col-md-2 control-label">별명</label>
		    	<div class="col-md-10">
		    		<input type="text" class="form-control" placeholder="Nickname" id="nickname" name="nickname" />
				</div>
			</div>
			<div class="form-group">
		    	<label for="cellPhoneNo" class="col-md-2 control-label">전화번호</label>
		    	<div class="col-md-10">
		    		<input type="text" class="form-control" placeholder="전화번호" id="cellPhoneNo" name="cellPhoneNo" />
				</div>
			</div>
			<div class="form-group">
		    	<label for="birthDate" class="col-md-2 control-label">생년월일</label>
		    	<div class="col-md-10">
		    		<input type="text" class="form-control" placeholder="YYYYMMDD" id="birthDate" name="birthDate" />
				</div>
			</div>
			<div class="form-group">
		    	<label for="school" class="col-md-2 control-label">학교</label>
		    	<div class="col-md-10">
		    		<input type="text" class="form-control" placeholder="학교" id="school" name="school" />
				</div>
			</div>
			<div class="form-group">
				<label for="type" class="col-md-2 control-label">UserType</label>
				<input type="radio" name="type" value="student">학생
				<input type="radio" name="type" value="parent">학부모
				<input type="radio" name="type" value="admin">관리자
			</div>
			<div class="form-group">
	    	<div class="col-sm-offset-2 col-sm-10">
	      		<button type="submit" class="btn btn-default">등록</button>
	   		</div>
	  		</div>
		</form>
	</div>
</body>
</html>