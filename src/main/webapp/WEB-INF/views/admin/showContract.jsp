<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>CMS PAGE</title>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script>
$(document).ready(function(){
	$("backBtn").click(function(){
		parent.history.back();
		return false;
	});
});
</script>
</head>
<body>
	<div class="container">
		<div style="margin-bottom: 1%;">
			<h1>CMS PAGE</h1>
			<div>
				<ul class="nav nav-pills nav-justified ">
					<li><a href="../croc">악어관리</a></li>
					<li class="active"><a href="../matching">매칭관리</a></li>
					<li><a href="../parent">학부모관리</a></li>
					<li><a href="">관리</a></li>
					<li><a href="logout" style="color: red"><%=session.getAttribute("login")%> 로그아웃</a></li>
				</ul>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">학부모 정보</div>
				<div class="panel-body">
					<form role="form" action="" method="post">
						<div class="form-group">
							<label for="id">회원번호:</label>${searchModel.memberId}
						</div>
						
						<div class="form-group">
							<label for="id">아이디:</label>${searchModel.id}
						</div>
						
						<div class="form-group">
							<label for="name">이름:</label>${searchModel.memberInfo.name}
						</div>
						
						<div class="form-group">
							<label for="gender">성별:</label>${(searchModel.memberInfo.gender==1)?"남자":"여자"}
						</div>
						
						<div class="form-group">
							<label for="tel">전화번호:</label>${searchModel.memberInfo.tel}
						</div>
						
						<div class="form-group">
							<label for="addr">주소:</label>${searchModel.memberInfo.addr}
						</div>

						<div class="form-group">
							<label for="babyInfos">아기정보:</label>
							<table class="table">
								<thead>
									<tr>
										<th>이름</th>
										<th>나이</th>
										<th>성별</th>
									</tr>
								</thead>
								<tbody>	
									<c:forEach var="babyInfo" items="${searchModel.memberInfo.babyInfo}">
										<tr>
											<td>${babyInfo.name}</td>
											<td>${babyInfo.age}</td>
											<td>${(babyInfo.gender==1)?"남":"여"}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<div class="form-group">
							<label for="createTime">가입일:</label> 
							<fmt:timeZone value="GMT+9">
								<fmt:formatDate value="${searchModel.createTime}" pattern="yyyy-MM-dd HH:mm"/>
							</fmt:timeZone>
						</div>
						
						<div class="form-group">
							<label for="updateTime">수정일:</label> 
							<fmt:timeZone value="GMT+9">	
								<fmt:formatDate value="${searchModel.updateTime}" pattern="yyyy-MM-dd HH:mm"/>
							</fmt:timeZone> 
						</div>
						<button type="button" id="backBtn" class="btn btn-default">back</button>
					</form>

				</div>
			</div>
		</div>
	</div>

</body>
</html>