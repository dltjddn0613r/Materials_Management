<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거래처 검색</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script>
       
        function selectCustomer(customerCode) {
            window.opener.document.getElementById('customerCode').value = customerCode; // 거래처 코드 입력란에 반영
            window.close();
        }
    </script>
</head>
<body>
	<div class="container mt-5">
		<h2 class="mb-4 text-center">
			<b>거래처 검색</b>
		</h2>
		<form action="customerSearch.do" method="get"
			class="d-flex justify-content-center mb-4">
			<input type="text" class="form-control me-2" name="searchQuery"
				placeholder="검색창" aria-label="Search"
				value="${searchQuery}"
				style="max-width: 300px;">
			<button type="submit" class="btn btn-primary">검색</button>
		</form>

		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>고객 코드</th>
						<th>고객 명</th>
						<th>검색창내용</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="customer" items="${customerPage.content}">
						<tr onclick="selectCustomer('${customer.customerCode}')">
							<td><a href="#"
								onclick="selectCustomer('${customer.customerCode})">${customer.customerCode}</a></td>
							<td><span class="customer-name">${customer.customerName}</span></td>
							<td><span class="searchContent">${customer.searchContent}</span></td>

						</tr>
					</c:forEach>
					<c:if test="${customerPage.hasNoArticles()}">
						<tr>
							<td colspan="7" class="text-center">검색 결과가 없습니다.</td>
						</tr>
					</c:if>


					<tr>
						<td colspan="7" class="text-center"><c:if
								test="${customerPage.startPage > 5}">
								<a href="customerSearch.do?pageNo=${customerPage.startPage - 5}">[이전]</a>
							</c:if> <c:forEach var="pNo" begin="${customerPage.startPage}"
								end="${customerPage.endPage}">
								<a href="customerSearch.do?pageNo=${pNo}">[${pNo}]</a>
							</c:forEach> <c:if test="${customerPage.endPage < customerPage.totalPages}">
								<a href="customerSearch.do?pageNo=${customerPage.startPage + 5}">[다음]</a>
							</c:if></td>
					</tr>
			</table>
		</div>
		<div class="text-start">
			<a href="${pageContext.request.contextPath}/addCustomer.do"
				class="btn btn-success">신규</a>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
