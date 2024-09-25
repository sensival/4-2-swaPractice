<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 샘플 예제</title>
</head>

<body>
	<h2>JSP 샘플 예제</h2>
	<hr>
	<h3>
		1. JSP 주석
		<!-- HTML 주석 : 화면에서는 안 보이고 소스 보기에는 보임 -->
		<%-- JSP 주석 : 화면과 소스 보기에서 보이지 않음 --%>
	</h3>
	<h3>
	<%!String[] members = { "김길동", "홍길동", "김영희", "홍영희" };
	int num = 10;

	int calc(int num1) {
		return num + num1;
	}%>
	</h3>
	<h3>
		2. calc(10) 메서드(method) 실행 결과
		<%=calc(10)%>
	</h3>
	<hr>
	<h3>3. include : hello.jsp</h3>
	<%@ include file="../hello.jsp"%>
	
	<h3>4. 스크립트(배열 데이터 출력)</h3>
	<ul>
		<%
		for (String name : members) {
		%>
		<li><%=name%></li>
		<%
		}
		%>
	</ul>
</body>
</html>