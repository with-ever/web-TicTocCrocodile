<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>회원 가입</title>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.js"></script>

</head>
<body>
	<div class="container">
		<div style="margin-bottom: 1%;">
			<h1></h1>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					공지사항
					<button type="button" class="btn btn-default btn-xs"
						id="NoticeBoardInsert">공지사항 쓰기</button>
				</div>
				<div class="panel-body">
					<table class="table">
						<thead>
							<tr>
								<th>번호</th>
								<th style="width: 50%;">제목</th>
								<th>작성일</th>
								<th>블라인드</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>113</td>
								<td><a>공지사항 1</a></td>
								<td>2016-07-01 10:32</td>
								<td><input type="checkbox" value="" class="blind"></td>
							</tr>
						</tbody>
					</table>
					<ul class="pager">
						<li><button type="button" class="btn btn-default btn-sm">Previous</button></li>
						<li><button type="button" class="btn btn-default btn-sm">Next</button></li>
					</ul>

				</div>
			</div>


		</div>
	</div>
</body>
</html>