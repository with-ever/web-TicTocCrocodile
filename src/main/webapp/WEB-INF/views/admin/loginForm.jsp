<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>째깍악어 관리자</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="padding: 35px 50px;">
				<h4>
					<span class="glyphicon glyphicon-lock"></span> 로그인
				</h4>
				<label>정상적인 서비스 사용을 위해서 로그인해야 합니다.</label>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form role="form" method="post" action="${ctx}/login/process">
					<div class="form-group">
						<label for="id">
							ID :</label> <input type="text" class="form-control" id="id" name="loginId"
							placeholder="Enter ID" required="required">
					</div>
					<div class="form-group">
						<label for="pw">
							Password :</label> <input type="password" class="form-control" id="password"
							name="password" placeholder="Enter Password" required="required">
					</div>
					<button type="submit" class="btn btn-default btn-block">
						Login</button>
					<a href="croc/signup" class="btn btn-default btn-block">악어 등록</a>
				</form>
			</div>
			<div class="modal-footer"></div>
		</div>

	</div>
</body>
</html>
