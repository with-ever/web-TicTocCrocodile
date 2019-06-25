<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li class="active"><a href="../../croc">악어관리</a></li>
					<li><a href="../../matching">매칭관리</a></li>
					<li><a href="../../parent">학부모관리</a></li>
					<li><a href="">관리</a></li>
					<li><a href="logout" style="color: red"><%=session.getAttribute("login")%> 로그아웃</a></li>
				</ul>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">기본 정보 수정</div>
				<div class="panel-body">
					<form role="form" action="" method="post">
						<div class="form-group">
							<label for="memberId">회원번호:</label> <input type="text"
								class="form-control" id="memberId" name="memberId"
								placeholder="아이디 (30자 이내)" maxlength="30" required="required" disabled="disabled" value="${searchModel.memberId}"> 
						</div>
						
						<div class="form-group">
							<label for="id">아이디:</label> <input type="text"
								class="form-control" id="id" name="id"
								placeholder="아이디 (30자 이내)" maxlength="30" required="required" disabled="disabled" value="${searchModel.id}">
						</div>
						
						<div class="form-group">
							<input type="hidden" class="form-control" id="password" name="password"
								placeholder="비밀번호" maxlength="30" required="required" value="${searchModel.password}">
						</div>
						
						<div class="form-group">
							<label for="name">이름:</label> <input type="text"
								class="form-control" id="name" name="crocMemberInfo.name"
								placeholder="이름 (30자 이내)" maxlength="30" required="required" value="${searchModel.crocMemberInfo.name}">
						</div>
						
						<div class="form-group">
							<label for="level">레벨:</label> <input type="text"
								class="form-control" id="level" name="crocMemberInfo.level"
								placeholder="악어 레벨" maxlength="30" required="required" value="${searchModel.crocMemberInfo.level}">
						</div>
						<div class="form-group">
							<label for="gender">성별:</label> 
								<select class="form-control" id="gender" name="crocMemberInfo.gender">
									<option value="1" ${(searchModel.crocMemberInfo.gender==1)?"selected":""}>남자</option>
									<option value="2" ${(searchModel.crocMemberInfo.gender==2)?"selected":""}>여자</option>
								</select>
						</div>
						
						<div class="form-group">
							<label for="univ">대학교:</label> <input type="text"
								class="form-control" id="univ" name="crocMemberInfo.univ"
								placeholder="대학교" maxlength="30" required="required" value="${searchModel.crocMemberInfo.univ}">
						</div>
						
						<div class="form-group">
							<label for="major">전공:</label> <input type="text"
								class="form-control" id="major" name="crocMemberInfo.major"
								placeholder="전공" maxlength="30" required="required" value="${searchModel.crocMemberInfo.major}">
						</div>
						
						<div class="form-group">
							<label for="tel">전화번호:</label> <input type="text"
								class="form-control" id="tel" name="crocMemberInfo.tel"
								placeholder="전화번호 (30자 이내)" maxlength="30" required="required" value="${searchModel.crocMemberInfo.tel}">
						</div>
						
						<div class="form-group">
							<label for="email">이메일:</label> <input type="text"
								class="form-control" id="email" name="crocMemberInfo.email"
								placeholder="이메일 (50자 이내)" maxlength="50" required="required" value="${searchModel.crocMemberInfo.email}">
						</div>
						
						<!-- 
						<div class="form-group">
							<label for="crocAvailableRegion">가능지역:</label>
							<div class="checkbox">
								<label><input type="checkbox" value="">전체</label>
							</div>
							<div class="checkbox-inline">
								<label><input type="checkbox" value="">강남구</label>
							</div>
							<div class="checkbox-inline">
								<label><input type="checkbox" value="">서초구</label>
							</div>
							<div class="checkbox-inline">
								<label><input type="checkbox" value="">송파구</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="crocAvailableDay">가능요일:</label>
							<div class="checkbox">
								<label><input type="checkbox" value="">전체</label>
							</div>
							<div class="checkbox-inline">
								<label><input type="checkbox" value="">일</label>
							</div>
							<div class="checkbox-inline">
								<label><input type="checkbox" value="">월</label>
							</div>
							<div class="checkbox-inline">
								<label><input type="checkbox" value="">화</label>
							</div>
							<div class="checkbox-inline">
								<label><input type="checkbox" value="">수</label>
							</div>
							<div class="checkbox-inline">
								<label><input type="checkbox" value="">목</label>
							</div>
							<div class="checkbox-inline">
								<label><input type="checkbox" value="">금</label>
							</div>
							<div class="checkbox-inline">
								<label><input type="checkbox" value="">토</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="crocAvailableTime">가능시간:</label> 
							<select class="" name="startTime" id="startTime">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
							</select>시 ~ 
							<select class="" name="endTime" id="endTime">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
							</select>시  
						</div>
						 -->
						
						<div class="form-group">
							<label for="description">소개글:</label> 
								<textarea class="form-control" id="description" name="crocMemberInfo.description" rows="5"
								placeholder="소개글(255자 이내)" maxlength="255" required="required">${searchModel.crocMemberInfo.description}</textarea>
						</div>
					
						<button type="submit" class="btn btn-default">Save</button>
						<button type="button" id="backBtn" class="btn btn-default">Cancel</button>
					</form>

				</div>
			</div>
		</div>
	</div>

</body>
</html>