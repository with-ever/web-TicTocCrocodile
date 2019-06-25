<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>악어 정보</title>

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
				<div class="panel-heading">악어 정보</div>
				<div class="panel-body">
					<form role="form" action="" method="post">
						<div class="form-group">
							<label for="id">회원번호:</label>${member.memberId}
						</div>
						
						<div class="form-group">
							<label for="id">아이디:</label>${member.id}
						</div>
						
						<div class="form-group">
							<label for="name">이름:</label>${member.crocMemberInfo.name}
						</div>
						
						<div class="form-group">
							<label for="level">레벨:</label>${member.crocMemberInfo.level}
						</div>
						
						<div class="form-group">
							<label for="gender">성별:</label>${(member.crocMemberInfo.gender==1)?"남자":"여자"}
						</div>
						
						<div class="form-group">
							<label for="univ">대학교:</label>${member.crocMemberInfo.univ}
						</div>
						
						<div class="form-group">
							<label for="major">전공:</label>${member.crocMemberInfo.major}
						</div>
						
						<div class="form-group">
							<label for="tel">전화번호:</label>${member.crocMemberInfo.tel}
						</div>
						
						<div class="form-group">
							<label for="tel">이메일:</label>${member.crocMemberInfo.email}
						</div>
						
						
						<div class="form-group">
							<label for="crocAvailableService">가능서비스:</label>
							<table class="table">
								<tbody>
									<c:forEach var="service" items="${member.crocMemberInfo.crocAvailableServices}">
										<tr>
											<c:if test="${service.serviceId==1}"><td>등하교</td></c:if>
											<c:if test="${service.serviceId==2}"><td>학습,놀이 돌봄</td></c:if>
											<c:if test="${service.serviceId==3}"><td>체험</td></c:if>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<div class="form-group">
							<label for="crocAvailableRegion">가능지역:</label>
							<table class="table">
								<tbody>
									<c:forEach var="region" items="${member.crocMemberInfo.crocAvailableRegions}">
										<tr>
											<c:if test="${region.regionId==1}"><td>강남구</td></c:if>
											<c:if test="${region.regionId==2}"><td>서초구</td></c:if>
											<c:if test="${region.regionId==3}"><td>송파구</td></c:if>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						 
						<div class="form-group">
							<label for="crocAvailableDay">가능요일 및 시간:</label>
							<table class="table">
								<thead>
									<tr>
										<th>요일</th>
										<th>시간</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="time" items="${member.crocMemberInfo.crocAvailableTimes}">
										<tr>
											<c:if test="${time.day==1}"><td>일</td></c:if>
											<c:if test="${time.day==2}"><td>월</td></c:if>
											<c:if test="${time.day==3}"><td>화</td></c:if>
											<c:if test="${time.day==4}"><td>수</td></c:if>
											<c:if test="${time.day==5}"><td>목</td></c:if>
											<c:if test="${time.day==6}"><td>금</td></c:if>
											<c:if test="${time.day==7}"><td>토</td></c:if>
											<td>${time.startTime} 시 ~ ${time.endTime} 시</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="form-group">
							<label for="description">소개글:</label> 
								<textarea class="form-control" id="description" name="description" rows="5"
								placeholder="소개글(255자 이내)" maxlength="255" disabled="disabled">${member.crocMemberInfo.description}</textarea>
						</div>
						
						<div class="form-group">
							<label for="createTime">가입일:</label> 
								<input type="text" class="form-control" id="createTime" name="createTime" 
								required="required" disabled="disabled" value="${member.crocMemberInfo.createTime}">
						</div>
						
						<div class="form-group">
							<label for="updateTime">수정일:</label> 
								<input type="text" class="form-control" id="updateTime" name="updateTime" 
								required="required" disabled="disabled" value="${member.crocMemberInfo.updateTime}">
						</div>
						<a href="/member/${member.id}/edit" class="btn btn-default">Edit</a>
					</form>

				</div>
			</div>
		</div>
	</div>

</body>
</html>