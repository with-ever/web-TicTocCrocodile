<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="dateObject" class="java.util.Date" />
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
<script>
$(document).ready(function(){
	$(".btn-link").click(function(){
		var contractId = $(this).parents("td").find("input").val();
		var contractInfo = "<table class=\"table\"><thead><tr><th></th><th></th></tr></thead>";
		$.getJSON("http://52.78.4.22/api/v1/contracts/"+contractId, function(data){
		//$.getJSON("http://localhost:8080/web/api/v1/contracts/"+contractId, function(data){
			contractInfo += "<tbody>";
			contractInfo += "<tr><td>계약서번호</td><td>"+data.contractId+"</td></tr>";
			contractInfo += "<tr><td>제목</td><td>"+data.title+"</td></tr>";
			contractInfo += "<tr><td>내용</td><td>"+data.content+"</td></tr>";
			contractInfo += "<tr><td>위치</td><td>"+data.location+"</td></tr>";
			contractInfo += "<tr><td>상태</td><td>"+data.status+"</td></tr>";
			contractInfo += "<tr><td>시작시간</td><td>"+new Date(data.startTime*1000)+"</td></tr>";
			contractInfo += "<tr><td>종료시간</td><td>"+new Date(data.endTime*1000)+"</td></tr>";
			contractInfo += "</tbody>";
			contractInfo += "</table>";
			$(".modal-body").html(contractInfo);
		});
	});
	
	$(".finishBtn").click(function(){
		var matchId = $(this).parents("td").find("input").val();
		var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action","http://52.78.4.22/admin/matching/"+matchId);
		
		var contractId = $(this).parents("tr").find("td:eq(2)").find("input").val();
		var contractIdInput = document.createElement("input");
		contractIdInput.setAttribute("type", "hidden");
		contractIdInput.setAttribute("name", "contractId");
		contractIdInput.setAttribute("value", contractId);
		form.appendChild(contractIdInput);
		
		var status = Number($(this).parents("tr").find("td:eq(4)").find("input").val()) + 1;
		var statusInput = document.createElement("input");
		statusInput.setAttribute("type", "hidden");
		statusInput.setAttribute("name", "status");
		statusInput.setAttribute("value", status);
		form.appendChild(statusInput);
		
		form.submit();
		
		/* 
		$.ajax({
		    type: "PUT",
		    url: "http://localhost:8080/web/api/v1/matchings/"+matchId+"/status",
		    contentType: "application/json",
		    data: '{"contractId":"'+contractId+'"'+',"status":"'+status+'"'+'}',
		    dataType: "json"
		}).done(function(){
			
		});
		 */
	});
	
	$(".cancelBtn").click(function(){
		var matchId = $(this).parents("td").find("input").val();
		var cancelForm = document.createElement("form");
		cancelForm.setAttribute("method", "post");
		cancelForm.setAttribute("action","http://52.78.4.22/admin/matching/"+matchId);
		/* cancelForm.setAttribute("action","http://127.0.0.1:8080/admin/matching/"+matchId); */
		
		var contractId = $(this).parents("tr").find("td:eq(2)").find("input").val();
		var contractIdInput = document.createElement("input");
		contractIdInput.setAttribute("type", "hidden");
		contractIdInput.setAttribute("name", "contractId");
		contractIdInput.setAttribute("value", contractId);
		cancelForm.appendChild(contractIdInput);
		
		var statusInput = document.createElement("input");
		statusInput.setAttribute("type", "hidden");
		statusInput.setAttribute("name", "status");
		statusInput.setAttribute("value", "3");
		cancelForm.appendChild(statusInput);
		
		if(confirm("강제로 취소시키겠습니까?")) {
			cancelForm.submit();
		}
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
					<li><a href="croc">악어관리</a></li>
					<li class="active"><a href="matching">매칭관리</a></li>
					<li><a href="parent">학부모관리</a></li>
					<li><a href="">관리</a></li>
					<li><a href="logout" style="color: red">로그아웃</a></li>
				</ul>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">매칭 목록</div>
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
						<span class="label label-default">총 ${searchModel.totalCount}건</span>
					</form>


					<table class="table">
						<thead>
							<tr>
								<th>회원</th>
								<th>악어</th>
								<th>계약서정보</th>
								<th>서비스시작시간</th>
								<th>상태</th>
								<th>계약금완료</th>
								<th>서비스완료</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="result" items="${searchModel.results}">
								<tr>
									<td><a href="parent/${result.contract.parentMember.id}">${result.contract.parentMember.memberInfo.name} (${result.contract.parentMember.id})</a></td>
									<td><a href="croc/${result.crocMember.id}">${result.crocMember.crocMemberInfo.name} (${result.crocMember.id})</a></td>
									<td>
										<button type="button" class="btn btn-link btn-xs" data-toggle="modal" data-target="#contractInfoModal">${result.contract.title}</button>
										<input type="hidden" value="${result.contractId}">
									</td>
									<td>
										<jsp:setProperty name="dateObject" property="time" value="${result.contract.startTime * 1000}" />
										<fmt:timeZone value="GMT+9">
											<fmt:formatDate value="${dateObject}" pattern="yyyy-MM-dd H:mm" />
										</fmt:timeZone>
									</td>
									<td>
										<c:if test="${result.status==1}">대기</c:if>
										<c:if test="${result.status==2}">거절</c:if>
										<c:if test="${result.status==3}">취소</c:if>
										<c:if test="${result.status==4}">진행</c:if>
										<c:if test="${result.status==5}">결제완료</c:if>
										<c:if test="${result.status==6}">서비스완료</c:if>
										<input type="hidden" value="${result.status}">
									</td>
									<td>
										<button type="button" class="btn ${(result.status==4)?"btn-success":"btn-danger"} btn-xs finishBtn" ${(result.status==4)?"":"disabled"}>계약금완료</button>
										<input type="hidden" value="${result.matchId}">
									</td>
									<td>
										<button type="button" class="btn ${(result.status==5)?"btn-success":"btn-danger"} btn-xs finishBtn" ${(result.status==5)?"":"disabled"}>서비스완료</button>
										<input type="hidden" value="${result.matchId}">
									</td>
									<td>
										<c:if test="${result.status==1}">
											<button type="button" class="btn btn-default btn-xs cancelBtn">강제취소</button>
										</c:if>
										<c:if test="${result.status==4}">
											<button type="button" class="btn btn-default btn-xs cancelBtn">강제취소</button>
										</c:if>
										
										<input type="hidden" value="${result.matchId}">
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<form class="form-inline" role="form" method="post">
						<a href="matching?pageNo=${(searchModel.pageNo-1==0)?"1":(searchModel.pageNo-1)}" class="btn btn-default" >Previous </a>
						<a href="matching?pageNo=${searchModel.pageNo+1}" class="btn btn-default" class="btn btn-default" ${((searchModel.totalCount)>(pageNo*10))?"":"disabled"}>Next</a>
					</form>

				</div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="contractInfoModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">계약서 정보</h4>
					</div>
					<div class="modal-body">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>