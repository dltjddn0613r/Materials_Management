<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Materials Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 50px;
        }
        .container {
            max-width: 800px;
        }
    </style>
</head>
<body>
   
    <div class="container">
        <div class="jumbotron mt-5">
            <h1 class="display-4">Materials Management 시작 화면(로그인기능 구현 예정)</h1>
             
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/quoteView"  role="button">화이팅 합시다(클릭)</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
