<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function oddEven() {
		const num = document.getElementById("num1").value;
		let re = "홀수";
		
		if(num % 2 == 0){
			re = "짝수";
		}
		
		document.getElementById("re").innerHTML=re;
		
	}
	
</script>
</head>
<body>
	판별할 수: <input type="text" id="num1"> 
	<button onclick="oddEven()">홀/짝 판별</button>
	<p id="re"></p>	
</body>
</html>