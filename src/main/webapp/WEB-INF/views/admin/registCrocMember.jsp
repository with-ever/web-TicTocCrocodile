<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>악어 관리</title>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


</head>
<body>
	<div class="container">
		<div style="margin-bottom: 1%;">
			<h1>악어 회원가입 PAGE</h1>
			<div>
				
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">악어 정보</div>
				<div class="panel-body">
					<form role="form" action="${ctx}/admin/croc/signup" method="post">
						<div class="form-group">
							<label for="id">아이디:</label> <input type="text"
								class="form-control" id="id" name="id"
								placeholder="아이디 (30자 이내)" maxlength="30" required="required">
						</div>
						<div class="form-group">
							<label for="id">비밀번호:</label> <input type="password"
								class="form-control" id="pwd" name="password"
								placeholder="비밀번호 (4~9자)" maxlength="30" required="required">
						</div>
						<div class="form-group">
							<label for="name">이름:</label> <input type="text"
								class="form-control" id="name" name="crocMemberInfo.name"
								placeholder="이름 (30자 이내)" maxlength="30" required="required">
						</div>
						
						<div class="form-group">
							<label for="gender">성별:</label> <input type="number"
								class="form-control" id="gender" name="crocMemberInfo.gender"
								placeholder="성별" maxlength="2" required="required">
						</div>
						
						<div class="form-group">
							<label for="univ">대학교:</label> <input type="text"
								class="form-control" id="univ" name="crocMemberInfo.univ"
								placeholder="대학교" maxlength="30" required="required">
						</div>
						
						<div class="form-group">
							<label for="major">전공:</label> <input type="text"
								class="form-control" id="major" name="crocMemberInfo.major"
								placeholder="전공" maxlength="30" required="required">
						</div>
						
						<div class="form-group">
							<label for="tel">전화번호:</label> <input type="text"
								class="form-control" id="tel" name="crocMemberInfo.tel"
								placeholder="전화번호 (30자 이내)" maxlength="30" required="required">
						</div>
						
						<div class="form-group">
							<label for="description">소개글:</label> 
								<textarea class="form-control" id="description" name="crocMemberInfo.description" rows="5"
								placeholder="소개글(255자 이내)" maxlength="255" required="required"></textarea>
						</div>
						
						<button type="submit" class="btn btn-default">Submit</button>
					</form>

				</div>
			</div>
		</div>
	</div>

</body>
</html>