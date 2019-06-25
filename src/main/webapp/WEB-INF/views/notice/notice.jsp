<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>공지사항</title>
<link rel="stylesheet" href="../resources/css/crocdile.css" />
             
		<style>
		
		</style>
	</head>
	<body>
		<div class="wrap">
			
			<h2>공지사항을 확인해 보시고 최고의 돌봄서비스를 <br>체험해 보세요!</h2>
			<br />
			<h2>1. 클로즈 베타서비스 Open</h2>
			<p>째깍악어 돌봄서비스는 현재 소수의 비공식 고객을 대상으로 클로즈 베타 서비스를 진행 중입니다. 클로즈 베타 서비스 중에도 돌봄서비스를 안전하고 쉽게 경험해 보실 수 있습니다.</p>
			<br />
			<h2>2. 째깍악어 돌봄서비스 소개</h2>
			<p>분명 필요한 서비스인데 신청하시는 방법이 헷갈리고 생소하시죠? 이럴경우 "서비스 이용방법"을 확인해 주세요.</p>
			<br />
			<h2>3. 째깍악어 운영본부 연락처</h2>
			<p>저희는 항상 여러분의 연락을 기다리고 있습니다. 서비스에 대한 문의사항이 있으신가요? 혹은, 정기적인 돌봄 서비스를 원하시거나 2명이상의 아이 돌봄 서비스 신청을 원하실 경우 아래로 연락주세요.</p>
			<br />
		    <h4>고객센터 (평일 10시-18시)</h4>
			<h4><strong> 카카오톡 :</strong> &nbsp; 째깍악어</h4>
			<h4><strong> 전화 : </strong><a href="" class="sms">025120709</a> &nbsp;</h4>
			
		
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
