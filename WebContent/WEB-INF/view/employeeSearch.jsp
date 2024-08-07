<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 검색</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script>
	function selectEmployee(employeeCode) {
		window.opener.document.getElementById('employeeCode').value = employeeCode; // 담당자 코드 입력란에 반영
		window.close();
	}
</script>
</head>
<body>
	<div class="container mt-5">
		<h2 class="mb-4 text-center">
			<b>사원검색</b>
		</h2>
		<form action="employeeSearch.do" method="get"
			class="d-flex justify-content-center mb-4">
			<input type="text" class="form-control me-2" name="searchQuery"
				placeholder="검색창" aria-label="Search"
				value="${searchQuery != null ? searchQuery : ''}"
				style="max-width: 300px;">
			<button type="submit" class="btn btn-primary">검색</button>
		</form>

		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>사원코드</th>
						<th>사원명</th>

					</tr>
				</thead>
				<c:if test="${employeePage.hasNoArticles()}">
					<tr>
						<td colspan="7" class="text-center">검색 결과가 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach var="employee" items="${employeePage.content}">
					<tr>
						<td><a href="#"
							onclick="selectEmployee('${employee.employeeCode}')">${employee.employeeCode}</a></td>
						<td>${employee.employeeName}</td>

					</tr>
				</c:forEach>
			
					<tr>
						<td colspan="7" class="text-center"><c:if
								test="${employeePage.startPage > 5}">
								<a href="employeeSearch.do?pageNo=${employeePage.startPage - 5}">[이전]</a>
							</c:if> <c:forEach var="pNo" begin="${employeePage.startPage}"
								end="${employeePage.endPage}">
								<a href="employeeSearch.do?pageNo=${pNo}">[${pNo}]</a>
							</c:forEach> <c:if test="${employeePage.endPage < employeePage.totalPages}">
								<a href="employeeSearch.do?pageNo=${employeePage.startPage + 5}">[다음]</a>
							</c:if></td>
					</tr>
				
			</table>
		</div>
		<div class="text-start">
			<a href="${pageContext.request.contextPath}/addEmployee.do"
				class="btn btn-success">신규</a>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
