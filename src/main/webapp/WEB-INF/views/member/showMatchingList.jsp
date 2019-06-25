<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title></title>

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
			<h1></h1>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">매칭 정보</div>
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
					</form>


					<table class="table">
						<thead>
							<tr>
								<th>MATCH_ID</th>
								<th>CONTRACT_ID</th>
								<th>START_TIME</th>
								<th>END_TIME</th>
								<th>STATUS</th>
								<th>CREATE_TIME</th>
								<th>UPDATE_TIME</th>
								<th>ACCEPT</th>
								<th>REJECT</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td><a>1</a></td>
								<td>0000-00-00 00:00</td>
								<td>0000-00-00 00:00</td>
								<td>대기</td>
								<td>2016-07-01 09:22</td>
								<td>2016-07-01 09:22</td>
								<td><button type="button" class="btn btn-default btn-success btn-xs">O</button></td>
								<td><button type="button" class="btn btn-default btn-danger btn-xs">X</button></td>
							</tr>
						</tbody>
					</table>
					<form class="form-inline" role="form" method="post">
						<a href="" class="btn btn-default" >Previous </a>
						<a href="" class="btn btn-default">Next</a>
					</form>

				</div>
			</div>
		</div>


	</div>

</body>
</html>