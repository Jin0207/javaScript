<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function calcAdd() {
		let a = document.getElementById("num1").value;
		let b = document.getElementById("num2").value;
		let result = Number(a) + Number(b);		
		document.getElementById("add").innerHTML=result;
	}
	function calcSub() {
		let a = document.getElementById("num1").value;
		let b = document.getElementById("num2").value;
		let result = Number(a) - Number(b);		
		document.getElementById("sub").innerHTML=result;
	}
	function calcMulti() {
		let a = document.getElementById("num1").value;
		let b = document.getElementById("num2").value;
		let result = Number(a) * Number(b);		
		document.getElementById("multi").innerHTML=result;
	}
	function calcDiv() {
		let a = document.getElementById("num1").value;
		let b = document.getElementById("num2").value;
		let result = Number(a) / Number(b);		
		document.getElementById("div").innerHTML=result;
	}
</script>

</head>
<body>
	<!-- 서버로 갈 필요가 없다면 form태그 필요x id 나 class 만으로 가능 -->
	수1: <input type="text" id="num1"> <br>
	수2: <input type="text" id="num2"> <br>
	<button onclick="calcAdd()">더하기</button><span id="add"></span>
	<button onclick="calcSub()">빼기</button><span id="sub"></span>
	<button onclick="calcMulti()">곱하기</button><span id="multi"></span>
	<button onclick="calcDiv()">나누기</button><span id="div"></span>
</body>
</html>