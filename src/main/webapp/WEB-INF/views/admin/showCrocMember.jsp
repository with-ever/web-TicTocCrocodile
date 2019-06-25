<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
<jsp:useBean id="dateObject" class="java.util.Date" />
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
	$("#backBtn").click(function(){
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
					<li class="active"><a href="../croc">악어관리</a></li>
					<li><a href="../matching">매칭관리</a></li>
					<li><a href="../parent">학부모관리</a></li>
					<li><a href="">관리</a></li>
					<li><a href="logout" style="color: red"><%=session.getAttribute("login")%> 로그아웃</a></li>
				</ul>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">악어 정보</div>
				<div class="panel-body">
					<form role="form" action="" method="post">
						<div class="form-group">
							<c:choose>
								<c:when test="${searchModel.crocMemberInfo.imageUrl!=null}">
									<img src="${searchModel.crocMemberInfo.imageUrl}" class="img-thumbnail" width="160px" height="160px">								
								</c:when>
								<c:otherwise>
									<img src="${ctx}/resources/img/default.png" class="img-thumbnail" width="160px" height="160px">
								</c:otherwise>
							</c:choose>
						</div>
						
						<div class="form-group">
							<label for="id">회원번호:</label>${searchModel.memberId}
						</div>
						
						<div class="form-group">
							<label for="id">아이디:</label>${searchModel.id}
						</div>
						
						<div class="form-group">
							<label for="name">이름:</label>${searchModel.crocMemberInfo.name}
						</div>
						
						<div class="form-group">
							<label for="level">레벨:</label>${searchModel.crocMemberInfo.level}
						</div>
						
						<div class="form-group">
							<label for="gender">성별:</label>${(searchModel.crocMemberInfo.gender==1)?"남자":"여자"}
						</div>
						
						<div class="form-group">
							<label for="univ">대학교:</label>${searchModel.crocMemberInfo.univ}
						</div>
						
						<div class="form-group">
							<label for="major">전공:</label>${searchModel.crocMemberInfo.major}
						</div>
						
						<div class="form-group">
							<label for="tel">전화번호:</label>${searchModel.crocMemberInfo.tel}
						</div>
						
						<div class="form-group">
							<label for="email">이메일:</label>${searchModel.crocMemberInfo.email}
						</div>
						
						<div class="form-group">
							<label for="crocAvailableService">가능서비스:</label>
							<c:forEach var="service" items="${searchModel.crocMemberInfo.crocAvailableServices}">
									<label>${(service.serviceId==1)?"돌봄 ":((service.serviceId==2)?"등하교":"")}</label>
							</c:forEach>
						</div>
						
						<div class="form-group">
							<label for="crocAvailableRegion">가능지역:</label>
							<c:forEach var="region" items="${searchModel.crocMemberInfo.crocAvailableRegions}">
									<label>${(region.regionId==1)?"강남구 ":((region.regionId==2)?"서초구 ":"송파구 ")}</label>
							</c:forEach>
						</div>
						
						<div class="form-group">
							<label for="crocAvailableDay">가능요일 및 시간:</label>
							<table class="table">
								<thead>
									<tr>
										<th>요일</th>
										<th>시작시간</th>
										<th>종료시간</th>
									</tr>
								</thead>
								<tbody>	
									<c:forEach var="day" items="${searchModel.crocMemberInfo.crocAvailableTimes}">
										<tr>
											<td>
												<c:if test="${day.day==1}">일</c:if>
												<c:if test="${day.day==2}">월</c:if>
												<c:if test="${day.day==3}">화</c:if>
												<c:if test="${day.day==4}">수</c:if>
												<c:if test="${day.day==5}">목</c:if>
												<c:if test="${day.day==6}">금</c:if>
												<c:if test="${day.day==7}">토</c:if>
											</td>
											<td>${day.startTime}</td>
											<td>${day.endTime}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<div class="form-group">
							<label for="description">소개글:</label> 
								<textarea class="form-control" id="description" name="description" rows="5"
								placeholder="소개글(255자 이내)" maxlength="255" disabled="disabled">${searchModel.crocMemberInfo.description}</textarea>
						</div>
						
						<div class="form-group">
							<label for="createTime">가입일:</label> 
							<jsp:setProperty name="dateObject" property="time" value="${searchModel.memberInfo.createTime * 1000}" />
							<fmt:timeZone value="GMT+9">
								<fmt:formatDate value="${dateObject}" pattern="yyyy-MM-dd H:mm"/>
							</fmt:timeZone>
						</div>
						
						<div class="form-group">
							<label for="updateTime">수정일:</label> 
							<jsp:setProperty name="dateObject" property="time" value="${searchModel.memberInfo.updateTime * 1000}" />
							<fmt:timeZone value="GMT+9">
								<fmt:formatDate value="${dateObject}" pattern="yyyy-MM-dd H:mm"/>
							</fmt:timeZone>
						</div>
						<a href="../croc/${searchModel.id}/edit" class="btn btn-default">Edit</a>
						<button type="button" id="backBtn" class="btn btn-default">Back</button>
					</form>

				</div>
			</div>
		</div>
	</div>

</body>
</html>