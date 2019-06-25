<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
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


</head>
<body>
	<div class="container">
		<div style="margin-bottom: 1%;">
			<h1>CMS PAGE</h1>
			<div>
				<ul class="nav nav-pills nav-justified ">
					<li><a href="croc">악어관리</a></li>
					<li><a href="matching">매칭관리</a></li>
					<li class="active"><a href="">학부모관리</a></li>
					<li><a href="">관리</a></li>
					<li><a href="logout" style="color: red">로그아웃</a></li>
				</ul>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">학부모 목록</div>
				<div class="panel-body">
					<form class="form-inline" role="form" method="post">
						<select class="form-control" id="key" name="key">
							<option value=""></option>
						</select> <label for="name"></label> <input type="text"
							class="form-control" id="value" name="value"
							required="required" value="">
						<button type="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
						<span class="label label-default">총 ${searchModel.totalCount}명</span>
					</form>


					<table class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th>이름</th>
								<th>성별</th>
								<th>전화번호</th>
								<th>주소</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="result" items="${searchModel.results}">							
								<tr>
									<td><a href="parent/${result.id}">${result.id}</a></td>
									<td>${result.memberInfo.name}</td>
									<td>${(result.memberInfo.gender==1?"남":"여")}</td>
									<td>${result.memberInfo.tel}</td>
									<td>${result.memberInfo.addr}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<form class="form-inline" role="form" method="post">
						<a href="parent?pageNo=${(searchModel.pageNo-1==0)?"1":(searchModel.pageNo-1)}" class="btn btn-default" >Previous </a>
						<a href="parent?pageNo=${searchModel.pageNo+1}" class="btn btn-default">Next</a>
					</form>

				</div>
			</div>
		</div>


	</div>

</body>
</html>