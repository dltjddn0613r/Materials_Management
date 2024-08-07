<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>삭제 성공</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
견적서 삭제 성공
<br>
${ctxPath = pageContext.request.contextPath ; ''}

<a href="${ctxPath}/quoteList.do">[견적서 목록보기]</a>



</body>
</html>
