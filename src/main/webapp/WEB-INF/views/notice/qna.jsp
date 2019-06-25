<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>고객센터</title>
		<link rel="stylesheet" href="../resources/css/crocdile.css" />
             
		<style>

		</style>
	</head>
	<body>
		<div class="wrap">
			
			<h2>Q1. 선생님 신청 후 연락까지 얼마나 기다려야 하나요?</h2>
			<p>1) 선생님 신청 → 2)선생님 수락 → 3)예약금 입금 → 4)선생님 연락처 공개 및 선생님의 연락 의 절차로 이뤄집니다. 보통 예약금 입금 후 24시간 이내 선생님 연락이 이뤄집니다. </p>
			<br />
			<h2>Q2. 선생님 취소신청을 하려면 어떻게 해야 하나요?</h2>
			<p>고객센터를 통해 취소 신청을 해주세요! </p>
			<br />
			<h2>Q3. 예약한 시간보다 초과 돌봄의 경우 어떻게 하나요?</h2>
			<p>부득이한 사정으로 이용시간을 연장해야 할 경우 15분 단위로 정산되며, 우선 선생님과 돌봄 가능 여부를 협의 하신 후 고객센터로 연락 주시면 추가 요금 안내해 드리겠습니다. </p>
			<br />
			<h2>Q4. 선생님들의 신원은 어떻게 확인 되나요?</h2>
			<p>(성)범죄경력조회서, 재학증명서, 주민등록 등본을 통해 신원을 확인 합니다. </p>
			<br />
			<h2>[고 &nbsp; 객 &nbsp; 센 &nbsp; 터]</h2>
			<p>더 궁굼하신 부분은 아래 고객 센터로 연락주세요. </p>
		    <h4>고객센터 (평일 10시-18시)</h4>
			<h4><strong> 카카오톡 :</strong> &nbsp; 째깍악어</h4>
			<h4><strong> 전화 : </strong><a href="" class="sms">02-512-0709</a> &nbsp;</h4>
		
		</div><!--wrap end-->
		
		
		
		

		<script src="../js/jquery.js"></script>
		<script>
		function intentSMS() {
		  var getSMS = $(".sms").text();
        		
			App.intentSMS(getSMS);
			
		}
		
		$(".sms").click(function(){
			intentSNS();
		});
		
		</script>
	</body>
</html>
		