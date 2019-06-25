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
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div style="margin-bottom: 1%;">
			<h1>CMS PAGE</h1>
			<div>
				<ul class="nav nav-pills nav-justified ">
					<li class="active"><a href="croc">악어관리</a></li>
					<li><a href="matching">매칭관리</a></li>
					<li><a href="parent">학부모관리</a></li>
					<li><a href="">관리</a></li>
					<li><a href="logout" style="color: red">로그아웃</a></li>
				</ul>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">악어 출력</div>
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
								<!-- 
								<th>회원레벨</th>
								<th>등급관리</th>
								 -->
								<th>ID</th>
								<th>이름</th>
								<th>성별</th>
								<th>전화번호</th>
								<th>대학교</th>
								<th>학과</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="result" items="${searchModel.results}">
							<tr>
								<%-- 
								<td>${result.crocMemberInfo.level}</td>
								<td>
									<button type="button" class="btn btn-success btn-xs">△</button>
									<button type="button" class="btn btn-danger btn-xs">▽</button>
								</td>
								 --%>
								<td><a href="croc/${result.id}">${result.id}</a></td>
								<td>${result.crocMemberInfo.name}</td>
								<td>${(result.crocMemberInfo.gender==1)?"남":"여"}</td>
								<td>${result.crocMemberInfo.tel}</td>
								<td>${result.crocMemberInfo.univ}</td>
								<td>${result.crocMemberInfo.major}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<form class="form-inline" role="form" method="post">
						<a href="croc?pageNo=${(searchModel.pageNo-1==0)?"1":(searchModel.pageNo-1)}" class="btn btn-default" >Previous </a>
						<a href="croc?pageNo=${searchModel.pageNo+1}" class="btn btn-default">Next</a>
					</form>

				</div>
			</div>
		</div>


	</div>

</body>
</html>