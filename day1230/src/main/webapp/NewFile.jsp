<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//script 실행후 body안을 실행하기때문에 btnOK를 찾을 수 없음
	//document.getElementById("btnOK");
		
	//body가 동작한 후에 동작하게 해주는 이벤트 window.onload = function(){}
	window.onload = function(){
			
	}
	
	function cumulated () {
		const num = document.getElementById("num").value;
		let re = 0;
		
		for(let i = 1; i <= num; i++){
			re += i;
		}
		
		document.getElementById("re").innerHTML=re;
	}
</script>
</head>
<body>
	1 ~ <input type="text" id="num"> 더하기
	<button onclick="cumulated()">실행</button>
	<hr>
	누적합: <span id="re"></span>
	<hr>
	1 ~ <input type="text" id="num"> 더하기
	<button id="btnOK">실행</button>
	<hr>
	누적합: <span id="re"></span>
	<hr>
</body>
</html>