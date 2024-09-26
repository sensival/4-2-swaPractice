<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="calc" class="wk05.Calculator"></jsp:useBean>
<jsp:setProperty property="*" name="calc" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 실습 결과</title>
</head>
<body>
	<h2>계산기 결과</h2>
	<hr>
	결과:
	<%=calc.calc()%>
</body>
</html>