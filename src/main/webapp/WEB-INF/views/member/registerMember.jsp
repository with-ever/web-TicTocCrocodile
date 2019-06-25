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
<script>
$(document).ready(function() {
	
	$("#allDayBtn").click(function(){
		$(".day").prop("checked",true);
	});
	
	$("#allRegionBtn").click(function(){
		$(".region").prop("checked",true);
	});
	
	$("#allServiceBtn").click(function (event) {
		console.log($(this));
		$(".service").prop("checked",true);
	});
	
	$("#addBtn").click(function(){
		var day = ["","일","월","화","수","목","금","토"];
		var dayValue = Number($("#day").val());
		var startTimeValue = Number($("#startTime").val());
		var endTimeValue = Number($("#endTime").val()); 
		
		if(isNaN(dayValue)) {
			alert("요일 선택이 올바르지 않습니다.")
		} else if(startTimeValue >= endTimeValue){
			alert("시간 입력이 올바르지 않습니다.(시작시간 > 종료시간)")
		} else {
			$("tbody").append("<tr><td><input type='hidden' name='day' value='"+dayValue+"'/>"+day[dayValue]+"</td><td><input type='hidden' name='startTime' value='"+startTimeValue+"'/>"+startTimeValue+"</td><td><input type='hidden' name='endTime' value='"+endTimeValue+"'/>"+endTimeValue+"</td><td><button type=\"button\" class=\"btn btn-default btn-danger btn-xs delBtn\">-</button></td></tr>");
		}
		
		$(".delBtn").click(function(){		
			$(this).parents("tr").remove();
		});
	});
	
	$(".submitBtn").click(function(){	
		$('form').submit();
	});
	
	$(".cancelBtn").click(function(){	
		parent.history.back();
	});
	
	/* id 중복확인 */
	$("#idCheckBtn").on("click", function() {
		var idValue = $("#id").val();
		$.getJSON("http://52.78.4.22/api/v1/members/"+idValue+"/check", function(data){
			$.each(data, function(result, val) {
				if(val==1) {
					alert("중복된 아이디 입니다.");
					$("#id").val(""); // 중복된 아이디이니 input value를 없애줌
				} else {
					alert("사용가능한 아이디 입니다.");
				}
			});
		});
	});
	
	/* 
	$(":file").filestyle({icon: false});
	 */
	
	jQuery.validator.addMethod("alphanumeric", function(value, element) {
		return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
	}); 
	
	$("form").validate({
		// submit 직전 추가 작업할 내용
		submitHandler: function() {
			if(confirm("회원가입을 완료하시겠습니까?")) {
				return true;
			} else {
				return false;
			}
		},
		// 규칙
		rules: {
			id: {
				required: true,
				minlength: 4,
				alphanumeric: true
			},
			password: {
				required: true,
				minlength: 6
			},
			repassword: {
				required: true,
				minlength: 6,
				equalTo: password
			},
			name: {
				required: true,
				minlength: 2
			},
			gender: {
				required: true
			},
			univ: {
				required: true
			},
			major: {
				required: true
			},
			tel: {
				required: true,
				minlength: 9
			},
			email: {
				required: true,
				email: true
			},
			description: {
				required: true,
				maxlength: 255
			}
		},
		// 규칙 실패시 출력 메세지
		messages: {
			id: {
				required: "필수 정보입니다.",
				minlength: "최소 {0}글자 이상입니다.",
				alphanumeric: "영문과 숫자만 사용가능합니다."
				/* 
				remote: "존재하는 아이디 입니다."
				 */
			},
			password: {
				required: "필수 정보입니다.",
				minlength: "최소 {0}글자 이상입니다.",
			},
			repassword: {
				required: "필수 정보입니다.",
				minlength: "최소{0}글자 이상이어야합니다.",
				equalTo: "비밀번호가 일치하지 않습니다."
			},
			"crocMemberInfo.name": {
				required: "필수 정보입니다.",
				minlength: "최소 {0}글자 이상입니다."
			},
			"crocMemberInfo.gender": {
				required: "필수 정보입니다."
			},
			"crocMemberInfo.univ": {
				required: "필수 정보입니다."
			},
			"crocMemberInfo.major": {
				required: "필수 정보입니다."
			},
			"crocMemberInfo.tel": {
				required: "필수 정보입니다.",
				minlength: "최소{0}글자 이상입니다."
			},
			"crocMemberInfo.email": {
				required: "필수 정보입니다.",
				email: "잘못된 이메일 형식입니다."
			},
			"crocMemberInfo.description": {
				maxlength: "최대 {0}글자 이하입니다."
			}
		}
	});
});
</script>
</head>
<body>
	<div class="container">
		<div style="margin-bottom: 1%;">
			<h1>회원 가입</h1>
			<div>
				
			</div>
		</div>
		<form role="form" action="${ctx}/member/signup" method="post" enctype="multipart/form-data">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">로그인 정보</div>
				<div class="panel-body">
					<div class="form-group">
						<label for="id">아이디:</label>
						<div class="form-inline">
							<input type="text"
								class="form-control" id="id" name="id"
								placeholder="아이디 " maxlength="30" required="required">
						 </div>
						 <div class="form-group">
						 <button type="button" id="idCheckBtn" class="btn btn-default">중복 확인</button>
						 </div>						
					</div>
					<div class="form-group">
						<label for="id">비밀번호:</label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="비밀번호" maxlength="30" required="required">
					</div>
					<div class="form-group">
						<label for="id">비밀번호 확인:</label> <input type="password"
							class="form-control" id="repassword" name="repassword"
							placeholder="비밀번호 확인" maxlength="30" required="required">
					</div>
				</div>
			</div>
		</div>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">개인 정보</div>
				<div class="panel-body">
					<div class="form-group">
						<label for="name">이름:</label> <input type="text"
							class="form-control" id="name" name="crocMemberInfo.name"
							placeholder="이름 (30자 이내)" maxlength="30" required="required">
					</div>
					<div class="form-group">
						<label for="picture">사진:</label>
						<input type="file" class="filestyle" data-icon="false" name="image">
					</div>
					<div class="form-group">
						<label for="gender">성별:</label>
							<div class="radio">
								<label class="radio-inline"><input type="radio" id="gender" value="1" name="crocMemberInfo.gender" required="required">남</label>
								<label class="radio-inline"><input type="radio" id="gender" value="2" name="crocMemberInfo.gender" required="required">여</label>
							</div>
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
						<label for="email">이메일:</label> <input type="text"
							class="form-control" id="email" name="crocMemberInfo.email"
							placeholder="이메일 (50자 이내)" maxlength="50" required="required">
					</div>
					
					<div class="form-group">
						<label for="description">소개글:</label> 
							<textarea class="form-control" id="description" name="crocMemberInfo.description" rows="5"
							placeholder="소개글(255자 이내)" maxlength="255"></textarea>
					</div>
				</div>
			</div>
		</div>
		
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">부가 정보</div>
				<div class="panel-body">
						<div class="form-group">
							<label for="crocAvailableService">가능한 서비스 :</label>
							<div class="form-group">
								<button type="button" id="allServiceBtn" class="btn btn-default btn-xs">전체 선택</button>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" class="service" name="serviceId" value="1">등하교</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" class="service" name="serviceId" value="2">학습,놀이 돌봄</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" class="" name="serivceId" value="3" disabled="disabled">체험</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="crocAvailableRegion">가능한 지역 :</label>
							<div class="form-group">
								<button type="button" id="allRegionBtn" class="btn btn-default btn-xs">전체 선택</button>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" class="region" name="regionId" value="1">강남구</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" class="region" name="regionId" value="2">서초구</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" class="region" name="regionId" value="3">송파구</label>
							</div>
						</div>
												
						<div class="form-group">
							<label for="crocAvailableDay">가능한 시간 :</label>
							<select class="form-control" id="day">
								<option>요일 선택</option>
								<option value="1">일</option>
								<option value="2">월</option>
								<option value="3">화</option>
								<option value="4">수</option>
								<option value="5">목</option>
								<option value="6">금</option>
								<option value="7">토</option>
							</select>
						</div>
						
						<div class="form-group">
							<input type="number" id="startTime" min="8" max="22"> 시 ~ 
							<input type="number" id="endTime" min="8" max="22"> 시 (24시 기준)
							<button type="button" id="addBtn" class="btn btn-default btn-sm">ADD</button>
						</div>
						
						
						<div class="panel panel-default">
							<div class="panel-body">
								<table class="table">
									<thead>
										<tr>
											<th>day</th>
											<th>startTime</th>
											<th>endTime</th>
											<th>delete</th>
										</tr>
									</thead>
									<tbody>
										<!-- 
										<tr>
											<td>월</td>
											<td>09:00</td>
											<td>21:00</td>
											<td><button type="button" class="btn btn-default btn-danger delBtn">-</button></td>
										</tr>
										 -->
									</tbody>
								</table>
							</div>
						</div>
						
						

				</div>
			</div>
		</div>
		<div class="form-group">
			<button type="button" class="btn btn-default submitBtn">Submit</button>
			<button type="button" class="btn btn-default cancelBtn">Cancel</button>
		</div>
		</form>
		
	</div>

</body>
</html>