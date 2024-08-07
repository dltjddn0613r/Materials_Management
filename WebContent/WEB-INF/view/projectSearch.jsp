<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 검색</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<script>
	function selectProject(projectCode, projectName, projectGroup) {
		window.opener.document.getElementById('projectCode').value = projectCode;
		window.close();
	}
</script>
</head>
<body>
	<div class="container mt-5">
		<h2 class="mb-4 text-center">
			<b>프로젝트 검색</b>
		</h2>
		<form action="projectSearch.do" method="get"
			class="d-flex justify-content-center mb-4">
			<input type="text" class="form-control me-2" name="searchQuery"
				placeholder="검색창" aria-label="Search"
				value="${searchQuery != null ? searchQuery : ''}"
				style="max-width: 300px;">
				<button  type="submit" class="btn btn-primary">검색</button>			
		</form>
		<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>프로젝트 코드</th>
					<th>프로젝트명</th>
					<th>프로젝트 그룹</th>
				</tr>
			</thead>
				<c:if test="${projectPage.hasNoArticles()}">
					<tr>
						<td colspan="7" class="text-center">검색 결과가 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach var="project" items="${projectPage.content}">
				<tr>
				<td><a href ="#" onclick="selectProject('${project.projectCode}')">${project.projectCode}</a></td>						
						<td>${project.projectName}</td>
						<td>${project.projectGroup}</td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="7" class="text-center"><c:if test="${projectPage.startPage > 5}">
							<a href="projectSearch.do?pageNo=${projectPage.startPage - 5}">[이전]</a>
						</c:if> <c:forEach var="pNo" begin="${projectPage.startPage}"
							end="${projectPage.endPage}">
							<a href="projectSearch.do?pageNo=${pNo}">[${pNo}]</a>
						</c:forEach> <c:if test="${projectPage.endPage < projectPage.totalPages}">
							<a href="projectSearch.do?pageNo=${projectPage.startPage + 5}">[다음]</a>
						</c:if></td>
				</tr>
			</tbody>
		</table>
		</div>
		<div class="text-start">
			<a href="${pageContext.request.contextPath}/addproject.do"
				class="btn btn-success">신규</a>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
